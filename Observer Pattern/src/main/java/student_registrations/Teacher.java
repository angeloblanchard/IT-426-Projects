package student_registrations;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer
{
    @Override
    public void update(Observable observable, Object args)
    {
        if (observable instanceof Student)
        {
            Object[] parts = (Object[])args;
            Student student = (Student)observable;
            System.out.println(student.getName() + " signed up for " + parts[0].toString() +
                    " at " + parts[1].toString() + "!");
        }
        else if (observable instanceof Classroom)
        {
            System.out.println(args.toString());
        }

    }
}
