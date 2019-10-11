import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*********************************** ToDoList class **************************************************
 A class to add new tasks,display all tasks,edit or remove tasks and save the tasks to the file.
 @author Megha Thakare
 @version 0.1 2019-10-10
******************************************************************************************************/

public class ToDoList
{
    private ArrayList<Task> tasks = new ArrayList<Task>();;
    private String fileName;

    /********************** Constructor *****************/
    public ToDoList()
    {
        fileName = "ToDoList2.txt";
        String directory = System.getProperty("user.home");
        String absolutePath = directory + File.separator + fileName;
        try{
                File file = new File(absolutePath);
                if(file.createNewFile())
                {
                    System.out.println(absolutePath+" File Created");
                }
                else
                {
                    System.out.println("File " + absolutePath + " already exists");
                    FileInputStream istream = new FileInputStream(file);
                    ObjectInputStream reader = new ObjectInputStream(istream);
                    while (istream.available() > 0)
                    {
                        tasks = (ArrayList<Task>) reader.readObject();
                        for (Task task : tasks)
                        {
                            System.out.println("Task details are:");
                            System.out.println("\n" + task);
                        }
                    }
                }
            }
        catch (Exception e)
            {
            e.printStackTrace();
            }
    }

    /********************** Add a task *****************/
    public void addTask()
    {
        System.out.println("Please enter the task details:");
        Scanner in1 = new Scanner(System.in);
        System.out.println("\t1. Enter title:");
        String title = in1.next();
        System.out.println ("\t2. Enter due date in the format DD-MM-YYYY:");
        String dueDate = in1.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        Date convertDate = new Date();
        try
        {
            convertDate = dateFormat.parse(dueDate);

        }
        catch (Exception ex)
        {
            System.out.println("\t Please enter the valid date");
            System.exit(1);
        }
        System.out.println("\t3. Enter project:");
        String project = in1.next();
        System.out.println("\t Status of the task:");
        String status = in1.next();
        Task newTask = new Task(title, dueDate, project, status);
        tasks.add(newTask);
        ListIterator<Task> it = tasks.listIterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    /********************** Save a task to file *****************/
    public void saveTask()
    {
        String directory = System.getProperty("user.home");
        String absolutePath = directory + File.separator + fileName;
        try
        {
            FileOutputStream stream = new FileOutputStream(new File(absolutePath));
            ObjectOutputStream out = new ObjectOutputStream(stream);
            out.writeObject(tasks);
            stream.close();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       // System.out.println("Task added");
    }

    /********************** Show all tasks *********************/
    public void showTask()
    {
        System.out.println("Please enter the dueDate or project to show a task :");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        for (Task t : tasks)
        {
            if (result.equals(t.getProject()) || result.equals(t.getDueDate()))
            {
                System.out.println("Task details are:");
                System.out.println("\n" + t);
            }
        }
    }

    /********************** Remove task *********************/
    public void removeTask()
    {
        System.out.println("Please enter the title or dueDate or project or status to delete a task :");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        Iterator it = tasks.iterator();
        while (it.hasNext())
        {
            Task t = (Task)it.next();
            if (result.equals(t.getTitle()) || result.equals(t.getDueDate()) || result.equals(t.getProject()) || result.equals(t.getStatus()))
            {
                it.remove();
            }
        }
    }

    /********************** Edit task *********************/
    public void editTask()
    {
        System.out.println("Please enter the details of a task to edit :");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        Iterator it = tasks.iterator();
        while (it.hasNext())
        {
            Task t = (Task)it.next();
            if (result.equals(t.getTitle()) || result.equals(t.getDueDate()) || result.equals(t.getProject()) || result.equals(t.getStatus()))
            {
                System.out.println("Please enter the new details for a task :");
                t.setTitle(in1.next());
            }
        }
    }
}




