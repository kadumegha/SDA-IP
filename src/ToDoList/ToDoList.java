package ToDoList;

import java.io.*;
import java.util.*;

/* ToDoList class
 A class to add new tasks,display all tasks,edit or remove tasks and save the tasks to the file.
 @author Megha Thakare
 @version 0.1 2019-10-10
*/

public class ToDoList
{
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private String fileName;
    private static int noOfDonetasks = 0;
    private static int noOfUndonetasks = 0;
    private int taskId;

    /* Constructor for the class ToDoList */
    public ToDoList()
    {
        /* Read the contents of the text file and display all the tasks to the user */
        fileName = "ToDoList.txt";
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
                if(file.length() != 0) {
                    FileInputStream istream = new FileInputStream(file);
                    ObjectInputStream reader = new ObjectInputStream(istream);
                    while (istream.available() > 0) {
                        tasks = (ArrayList<Task>) reader.readObject();
                        showAllTasks();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /* Add a new task to the todolist */
    public void addTask(String title,String dueDate,String project,String status)
    {
        Task newTask = new Task(taskId,title,dueDate,project,status);
        tasks.add(newTask);
        ListIterator<Task> it = tasks.listIterator();
        while (it.hasNext())
        {
            System.out.println("\n" + it.next());
        }
    }

    /* Save the added task to file */
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
    }

    /* Show the tasks added in the list filtered by duDate or project */
    public void showTask()
    {
        System.out.println("Please enter the dueDate in the format DD-MM-YYYY or project to show a task :");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        for(Task task : tasks)
        {
            if (result.toLowerCase().equals(task.getProject().toLowerCase()) || result.equals(task.getDueDate()))
            {
                System.out.println("Task details are:");
                System.out.println("\n" + task);
            }
        }
    }
    /* Show the all tasks added in the file */
    public void showAllTasks()
    {
        for (Task task : tasks)
        {
            System.out.println("Task details are:");
            System.out.println("\n" +task);
            taskId = task.getTaskId();
        }
    }
    /* Remove task */
    public void removeTask(int taskId)
    {
        Iterator it = tasks.iterator();
        while (it.hasNext())
        {
            Task t = (Task)it.next();
            if(taskId == t.getTaskId())
            {
                it.remove();
            }
        }
    }

    /* Edit or update the status of a task */
    public void editTask(int taskId)
    {
        User user = new User();
        Iterator it = tasks.iterator();
        while (it.hasNext()) {
            Task task = (Task) it.next();
            if (taskId == task.getTaskId()) {
                String result = user.editDetails();
                if (result.toLowerCase().equals("title")) {
                    String title = user.newdetails();
                    task.setTitle(title);
                } else if (result.equals("duedate")) {
                    String dueDate = user.newdetails();
                    task.setDueDate(dueDate);
                } else if (result.toLowerCase().equals("project")){
                    String project = user.newdetails();
                    task.setProject(project);
                } else if (result.toLowerCase().equals("status")) {
                    String status = user.newdetails();
                    task.setStatus(status);
                }
            }
        }
    }

    /* Return the size of an tasks array */
    public int size() {
        return tasks.size();
    }

    /* Return the number of an tasks with status as done */
    public int getNoOfDonetasks(){
        String taskDone = "done";
        for (Task task : tasks)
        {
            if (task.getStatus().toLowerCase().equals(taskDone))
            {
                noOfDonetasks += 1;
            }
        }
        return noOfDonetasks;
    }

    /* Return the number of an tasks with status as undone */
    public int getNoOfUndonetasks(){
        String taskUndone = "undone";
        for (Task task : tasks)
        {
            if (task.getStatus().toLowerCase().equals(taskUndone))
            {
                noOfUndonetasks += 1;
            }
        }
        return noOfUndonetasks;
    }
}




