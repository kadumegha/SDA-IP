import java.io.IOException;
import java.util.Scanner;

/*********************************** Task class ******************************************************
 A main class to display all the options in the ToDoList
 @author Megha Thakare
 @version 0.1 2019-10-10
 ******************************************************************************************************/

public class Main
{
    public static void main(String args[]) throws IOException
    {
        ToDoList toDoList = new ToDoList();
        boolean status = true;
        System.out.println("Welcome to ToDoList");
        System.out.println("You have X tasks todo and Y tasks are done");
        while (status)
        {
            System.out.println("Pick an Option:");
            System.out.println("\t(1) Show Task List(by date or project)");
            System.out.println("\t(2) Add New Task");
            System.out.println("\t(3) Remove Task");
            System.out.println("\t(4) Edit Task");
            System.out.println("\t(5) Save and Quit");
            Scanner input = new Scanner(System.in);
            String in = input.next();
            if (in.contains("1"))
            {
                toDoList.showTask();
            }
            else if (in.contains("2"))
            {
                toDoList.addTask();
            }
            else if (in.contains("3"))
            {
                toDoList.removeTask();
            }
            else if (in.contains("4"))
            {
                toDoList.editTask();
            }
            else if (in.contains("5"))
            {
                toDoList.saveTask();
                status = false;
            }
        }
    }
}

