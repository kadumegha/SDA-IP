import java.io.Serializable;

/*********************************** Task class ******************************************************
  A class to store all the details of the tasks as title,dueDate,project and status
 @author Megha Thakare
 @version 0.1 2019-10-10
 ******************************************************************************************************/

public class Task implements Serializable
{

    public String title;
    public String dueDate;
    public String project;
    public String status;
        //public static int noOfTasks = 0;

    /********************** Constructor*****************
      Constructor for objects of class task
      Set details of the task
    ***************************************************/
    public Task(String title, String dueDate, String project, String status)
    {
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
        this.status = status;
    }

    /********************** Getter and setter for title *****************/
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /********************** Getter and setter for dueDate *****************/
    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /********************** Getter and setter for project *****************/
    public String getProject()
    {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    /********************** Getter and setter for status *****************/
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**********************Return details of the task: title, dueDate,project and status*****************/
    @Override
    public String toString()
    {
        return "Title:" + title + "\ndueDate: " + dueDate + "\nproject: " + project + "\nstatus:" + status;
    }
}




