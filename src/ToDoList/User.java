package ToDoList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* User class
 A user class to display all the options in the ToDoList and to take the user inputs
 @author Megha Thakare
 @version 0.1 2019-10-10
*/

public class User {
    ToDoList toDoList = new ToDoList();

    public void input() {
        boolean result = true;
        System.out.println("\nWelcome to ToDoList");
        System.out.println("You have" + " " + toDoList.getNoOfUndonetasks() + " " + "tasks todo and" + " " + toDoList.getNoOfDonetasks() + " " + "tasks are done");
        while (result) {
            System.out.println("Pick an Option:");
            System.out.println("\t(1) Show Task List(by date or project)");
            System.out.println("\t(2) Add New Task");
            System.out.println("\t(3) Remove Task");
            System.out.println("\t(4) Edit Task");
            System.out.println("\t(5) Save and Quit");
            Scanner input = new Scanner(System.in);
            String in = input.next();
            if (in.contains("1")) {
                toDoList.showTask();
            } else if (in.contains("2")) {
                System.out.println("Please enter the task details:");
                Scanner in1 = new Scanner(System.in);
                System.out.println("\t1. Enter title:");
                String title = in1.next();
                System.out.println("\t2. Enter due date in the format DD-MM-YYYY:");
                String dueDate = in1.next();
                boolean checkFormat = true;
                while (checkFormat) {
                    if (dueDate.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
                        checkFormat = false;
                    } else {
                        System.out.println("Please enter the valid date");
                        dueDate = in1.next();
                    }
                }
                System.out.println("\t3. Enter project:");
                String project = in1.next();
                System.out.println("\t Status of the task:" + " \n \t done" + " " + "or" + " " + "undone");
                String status = in1.next();
                boolean response = true;
                while (response) {
                    if ((status.toLowerCase().equals("done") || status.toLowerCase().equals("undone"))) {
                        response = false;
                    } else {
                        System.out.println("Please enter the task status as done or undone");
                        status = in1.next();
                    }
                }
                toDoList.addTask(title, dueDate, project, status);
            } else if (in.contains("3")) {
                toDoList.showAllTasks();
                int taskId = taskId();
                toDoList.removeTask(taskId);
            } else if (in.contains("4")) {
                int taskId = taskId();
                toDoList.editTask(taskId);
            } else if (in.contains("5")) {
                toDoList.saveTask();
                result = false;
            } else {
                System.out.println("Please enter the valid option");
            }
        }
    }

    /* Called from ToDoList class to take the user input to edit the task details */
    public String editDetails() {
        System.out.println("What details do you want change : Title or DueDate or Project or Status?");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        return result;
    }

    /* Called from ToDoList class to take the user input to edit the details of a task */
    public String newdetails() {
        System.out.println("Please enter the new details for the task :");
        Scanner in1 = new Scanner(System.in);
        String result = in1.next();
        return result;
    }

    /* Returns the taskId to TodoList class to remove or edit a particular task */
    private int taskId() {
        System.out.println("\nPlease enter the taskId to edit or delete a task :");
        Scanner in1 = new Scanner(System.in);
        int taskId = in1.nextInt();
        return taskId;
    }

}

