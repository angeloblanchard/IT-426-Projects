package gui;

import io.exporting.IExporter;
import io.exporting.JSONExporter;
import io.exporting.JavaExporter;
import io.exporting.XMLExporter;
import io.importing.IImporter;
import io.importing.JSONImporter;
import io.importing.JavaImporter;
import io.importing.XMLImporter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Generates a new user interface for a Parts Database
 *
 * @author Josh Archer
 * @author Angelo Blanchard
 * @version 1.1
 */
public class PartsDatabaseUI extends Application
{
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HEIGHT = 220;

    //model classes
    private PartsDatabase data;

    //entry fields
    private TextField partId;
    private TextField manufacturer;
    private TextField listPrice;
    private TextField categories;

    private ToggleGroup exportToggle;
    private ToggleGroup importToggle;

    private IExporter exporter;
    private IImporter importer;

    /**
     * Creates a new user interface object.
     */
    public PartsDatabaseUI()
    {
        data = new PartsDatabase();
    }

    /**
     * Called when the Java FX application is about to launch.
     *
     * @param stage the stage to display screens upon
     */
    public void start(Stage stage)
    {
        stage.setTitle("Parts Database");

        try
        {
            stage.setScene(getScene());
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Something went wrong: " + ex.getMessage());
        }

        stage.show();
    }

    //retrieves the primary scene for the parts database
    private Scene getScene() throws MalformedURLException
    {
        //two primary panes on the left and right
        GridPane left = getLeftPane();
        VBox right = getRightPane();

        //arrange the panes using a parent grid pane
        GridPane parent = new GridPane();
        parent.setHgap(10);
        parent.setVgap(10);
        parent.setPadding(new Insets(10,10,10,10));

        //set the width of each side
        ColumnConstraints columnLeft = new ColumnConstraints();
        ColumnConstraints columnRight = new ColumnConstraints();
        columnLeft.setPercentWidth(50);
        columnRight.setPercentWidth(50);

        parent.getColumnConstraints().add(columnLeft);
        parent.getColumnConstraints().add(columnRight);

        //add the child controls
        parent.add(left, 0, 1);
        parent.add(right, 1, 1);

        //prepare the scenes to run and return
        Scene scene = new Scene(parent, SCENE_WIDTH, SCENE_HEIGHT);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(new File("src/styles/styles.css").toURI().toURL().toExternalForm());

        return scene;
    }

    //generates the left side of the user interface
    private GridPane getLeftPane()
    {
        //organize elements with a grid pane
        GridPane left = new GridPane();
        left.setVgap(4);
        left.setHgap(4);
        left.setPadding(new Insets(4, 4, 4,4));

        //enforce certain widths on the columns
        ColumnConstraints columnLeft = new ColumnConstraints();
        ColumnConstraints columnRight = new ColumnConstraints();
        columnLeft.setPercentWidth(40);
        columnRight.setPercentWidth(60);

        left.getColumnConstraints().add(columnLeft);
        left.getColumnConstraints().add(columnRight);

        //add text entry fields
        partId = addTextControl("Part Id #", "partId", 0, left);
        manufacturer = addTextControl("Manufacturer", "manufacturer", 1, left);
        listPrice = addTextControl("List Price", "listPrice", 2, left);
        categories = addTextControl("Categories", "categories", 3, left);

        //button for adding a new part record
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);

        Button add = new Button("Add Part");
        add.setPadding(new Insets(4,30,4,30));
        hbox.getChildren().add(add);
        hbox.getStyleClass().add("border-top");

        //adds a new part record
        add.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                String partIdString = partId.getText();
                String manufacturerString = manufacturer.getText();
                double listPriceDouble = Double.parseDouble(listPrice.getText());
                String[] categoriesString = categories.getText().split(", ");

                CarPart part = new CarPart(partIdString, manufacturerString, listPriceDouble, categoriesString);

                data.addPart(part);
                System.out.println("Part added!");
            }
        });

        //add the controls
        left.add(hbox, 0, 5, 2, 1);
        left.getStyleClass().add("panel");

        return left;
    }

    //generates a new label/textfield combination for form entries
    private TextField addTextControl(String labelText, String controlName, int row, GridPane parent)
    {
        //create the controls
        Label label = new Label(labelText);
        TextField textField = new TextField();

        //set a style
        textField.getStyleClass().add("text");

        //add to the parent element
        parent.add(label, 0, row);
        parent.add(textField, 1, row);

        return textField;
    }

    //generate the right pane of controls
    private VBox getRightPane()
    {
        VBox right = new VBox();

        //prepare export elements
        HBox exportHeader = new HBox();
        exportHeader.setAlignment(Pos.CENTER);
        exportHeader.setPadding(new Insets(6,0,0,0));

        Button exportButton = new Button("Export");
        exportHeader.getChildren().add(exportButton);

        String[] options = {"Java", "JSON", "XML"};

        ToggleButton javaExport = new ToggleButton("Java");
        ToggleButton jsonExport = new ToggleButton("JSON");
        ToggleButton xmlExport = new ToggleButton("XML");

        exportToggle = new ToggleGroup();
        javaExport.setToggleGroup(exportToggle);
        jsonExport.setToggleGroup(exportToggle);
        xmlExport.setToggleGroup(exportToggle);
        javaExport.setSelected(true);


        HBox exportRButtons = getRadioButtons(exportToggle, options);

        //export all CarPart objects from the application
        exportButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                RadioButton selectedButton =(RadioButton)(exportToggle.getSelectedToggle());
                String selectedText = selectedButton.getText();

                if (selectedText.equals("Java"))
                {
                    exporter = new JavaExporter(data);
                }
                else if ((selectedText.equals("JSON")))
                {
                    exporter = new JSONExporter(data);
                }
                else if ((selectedText.equals("XML")))
                {
                    exporter = new XMLExporter(data);
                }

                System.out.println("Part(s) exported!");
                exporter.exportParts();
            }
        });

        //prepare import elements
        HBox importHeader = new HBox();
        importHeader.setAlignment(Pos.CENTER);
        importHeader.setPadding(new Insets(6,0,0,0));

        Button importButton = new Button("Import");
        importHeader.getChildren().add(importButton);

        ToggleButton javaImport = new ToggleButton("Java");
        ToggleButton jsonImport = new ToggleButton("JSON");
        ToggleButton xmlImport = new ToggleButton("XML");

        importToggle = new ToggleGroup();
        javaImport.setToggleGroup(importToggle);
        jsonImport.setToggleGroup(importToggle);
        xmlImport.setToggleGroup(importToggle);

        HBox importRButtons = getRadioButtons(importToggle, options);

        //imports all CarPart objects into the application
        importButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                RadioButton selectedButton = (RadioButton)(importToggle.getSelectedToggle());
                String selectedText = selectedButton.getText();

                if (selectedText.equals("Java"))
                {
                    importer = new JavaImporter();
                }
                else if (selectedText.equals("JSON"))
                {
                    importer = new JSONImporter();
                }
                else if (selectedText.equals("XML"))
                {
                    importer = new XMLImporter();
                }

                importer.importParts();
            }
        });

        //force a few style considerations
        exportButton.setMaxWidth(Double.MAX_VALUE);
        exportRButtons.setMaxWidth(Double.MAX_VALUE);
        importButton.setMaxWidth(Double.MAX_VALUE);
        importRButtons.setMaxWidth(Double.MAX_VALUE);

        //add our controls together
        right.getStyleClass().add("panel");
        right.getChildren().addAll(exportHeader, exportRButtons, importHeader, importRButtons);

        return right;
    }

    //generates a simple button with a style
    private Button getButton(String text)
    {
        Button button = new Button(text);
        button.getStyleClass().add("button");
        return button;
    }

    //generates a horizontal box of radio buttons with the associated group
    private HBox getRadioButtons(ToggleGroup group, String[] options)
    {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        //add each option individually
        for (int i = 0; i < options.length; i++)
        {
            RadioButton rButton = new RadioButton();
            rButton.setText(options[i]);
            rButton.setPadding(new Insets(10, 10, 10,10));
            rButton.setToggleGroup(group);

            //select the first option
            if (i == 0)
            {
                rButton.setSelected(true);
            }

            hbox.getChildren().add(rButton);
        }

        return hbox;
    }
}
