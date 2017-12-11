package ui;

import adapters.CircleAdapter;
import adapters.LineAdapter;
import adapters.RectangleAdapter;
import adapters.TriangleAdapter;
import drawing.IShape;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import shapes.Triangle;

public class DoodlePadView extends Application
{
    private IShape iShape;
    private VBox vbox;
    private Slider slider;
    private Color defaultColor = new Color(1, 0, 0, 1);
    private double defaultThickness = 1.0;
    private boolean defaultFilled = false;
    private String selectedShape;
    public static final double SCENE_WIDTH = 650;
    public static final double SCENE_HEIGHT = 500;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Doodle Pad");
        stage.setScene(MainScene());
        stage.show();
    }

    public Scene MainScene()
    {
        vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 15, 15, 5));

        createButtons();


        return new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
    }

    public void createButtons()
    {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 0, 10));
        hbox.setMaxHeight(30);

        ToggleGroup toggleGroup = new ToggleGroup();

        ToggleButton circleButton = new ToggleButton();
        ToggleButton rectButton = new ToggleButton();
        ToggleButton triButton = new ToggleButton();
        ToggleButton lineButton = new ToggleButton();

        circleButton.setToggleGroup(toggleGroup);
        Circle circle = new Circle();
        circle.setCenterX(5);
        circle.setCenterY(5);
        circle.setRadius(10);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.CHARTREUSE);
        circleButton.setGraphic(circle);
        circleButton.setSelected(true);
        if (circleButton.isSelected())
        {
            selectedShape = "circle";
        }


        rectButton.setToggleGroup(toggleGroup);
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(20);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.RED);
        rectButton.setGraphic(rectangle);
        if (rectButton.isSelected())
        {
            selectedShape = "rectangle";
        }

        triButton.setToggleGroup(toggleGroup);
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(9.0, 0.0, 18.0, 18.0, 0.0, 18.0);
        triangle.setFill(Color.BLUEVIOLET);
        triangle.setStroke(Color.BLACK);
        triButton.setGraphic(triangle);
        if (triButton.isSelected())
        {
            selectedShape = "triangle";
        }

        lineButton.setToggleGroup(toggleGroup);
        Line line = new Line();
        line.setStartX(19);
        line.setStartY(0);
        line.setEndX(0);
        line.setEndY(19);
        lineButton.setGraphic(line);
        if (lineButton.isSelected())
        {
            selectedShape = "line";
        }


        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setPrefWidth(60);
        colorPicker.setPrefHeight(30);
        colorPicker.setStyle("-fx-color-label-visible: false ;");
        colorPicker.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                defaultColor = colorPicker.getValue();
            }
        });

        HBox fillBox = new HBox();
        fillBox.setPadding(new Insets(5, 0, 5, 0));
        fillBox.setSpacing(10);
        fillBox.setPrefHeight(30);
        fillBox.setPrefWidth(360);

        CheckBox fillButton = new CheckBox();
        fillButton.setPrefWidth(10);
        fillButton.setPrefHeight(10);
        fillButton.setMinHeight(20);
        fillButton.setMinWidth(20);
        Label fillLabel = new Label("Fill");
        fillLabel.setFont(Font.font(14));
        fillLabel.setAlignment(Pos.BOTTOM_CENTER);
        Label thickLabel = new Label("Thickness");
        thickLabel.setFont(Font.font(14));
        thickLabel.setPadding(new Insets(0, 0, 0, 10));
        fillButton.selectedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                defaultFilled = newValue;
            }
        });

        TextField textField = getTextField();

        slider = new Slider();
        slider.setMin(1);
        slider.setMax(10);
        slider.setValue(5);
        slider.setShowTickLabels(true);
        slider.setMinorTickCount(10);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(10);
        slider.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>()
        {
            @Override
            public void handle(InputMethodEvent event)
            {
                defaultThickness = slider.getValue();
            }
        });

        fillBox.getChildren().addAll(fillButton, fillLabel, thickLabel, textField, slider);

        hbox.getChildren().addAll(circleButton, rectButton, triButton, lineButton, colorPicker, fillBox);

        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT - 100);
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                GraphicsContext graphics = canvas.getGraphicsContext2D();
                double x = event.getX();
                double y = event.getY();

                iShape = implementShape(x, y, selectedShape);

                iShape.drawShape(graphics);
            }
        });

        Pane root = new Pane();

        StackPane holder = new StackPane();

        holder.getChildren().add(canvas);
        root.getChildren().add(holder);

        holder.setStyle("-fx-background-color: gray");

        vbox.getChildren().addAll(hbox, root);
    }

    private TextField getTextField()
    {
        TextField textField = new TextField();
        textField.setPrefWidth(40);
        textField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
            String newText = change.getControlNewText();
            if (newText.length() > 2) {
                return null ;
            } else {
                return change ;
            }
        }));

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {

                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
                else
                {
                    if (newValue.matches("\\d"))
                    {
                        int value = Integer.parseInt(newValue);
                        int text = Integer.parseInt(textField.getText());
                        if (text > 10 || text < 1)
                        {
                            textField.setText(newValue);
                        }
                        slider.setValue(value);
                    }
                }
            }
        });
        return textField;
    }

    private IShape implementShape(double x, double y, String selectedShape)
    {
        switch (selectedShape)
        {
            case "circle":
                shapes.Circle circle = new shapes.Circle(10, x, y, defaultThickness, defaultColor, defaultFilled);
                iShape = new CircleAdapter(circle);
                break;
            case "rectangle":
                shapes.Rectangle rectangle = new shapes.Rectangle(x, y, 10, 10, defaultThickness,
                        defaultColor, defaultFilled);
                iShape = new RectangleAdapter(rectangle);
                break;
            case "triangle":
                shapes.Triangle triangle = new shapes.Triangle(x, y, 10, 10, defaultThickness,
                        defaultColor, defaultFilled);
                iShape = new TriangleAdapter(triangle);
                break;
            case "line":
                shapes.Line line = new shapes.Line(x, y, x + 10, y + 10, defaultThickness, defaultColor,
                        defaultFilled);
                iShape = new LineAdapter(line);
                break;
        }
        return iShape;
    }
}
