package ToDoList;

import java.io.Serializable;

/*Task class
 A class to store all the details of the tasks as title,dueDate,project and status
 @author Megha Thakare
 @version 0.1 2019-10-10
*/

public class Task implements Serializable
{
    private String title;
    private String dueDate;
    private String project;
    private String status;
    private static int id = 0;
    private int taskId;

    /* Constructor
     Constructor for objects of class task
     Set details of the task
    */

    public Task(int taskId,String title, String dueDate, String project, String status)
    {
        id = id + 1;
        this.taskId = taskId + id;
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
        this.status = status;
    }

    /*Getter and setter for title */
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /* Getter and setter for dueDate */
    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /* Getter and setter for project */
    public String getProject()
    {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    /* Getter and setter for status */
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status) {
        this.project = status;
    }

    /* Getter for TaskId */
    public int getTaskId() {
        return taskId;
    }

    /* Return details of the task: title, dueDate,project and status */
    @Override
    public String toString()
    {
        return  "\nTaskId:" + taskId + "\nTitle:" + title + "\ndueDate: " + dueDate + "\nproject: " + project + "\nstatus:" + status;
    }
}





