package ToDoList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    ArrayList<Task> tasks = new ArrayList<>();
    ToDoList toDoList = new ToDoList();


    @Test
    public void addTaskTest() {
        toDoList.addTask("Megha", "10-10-2019", "Kadu", "done");
        toDoList.addTask("Anaisha", "30-10-2019", "Thakare", "done");
        toDoList.addTask("Abhi", "20-10-2019", "Thakare", "done");
        toDoList.addTask("Baby", "20-10-2021", "Thakare", "undone");
        int noOfAddedTasks = toDoList.size();
        assertEquals(4,noOfAddedTasks);
        System.out.println("Tasks are successfully added to the todo list");
    }
    @Test
    public void getNoOfDoneTaskTest(){
        toDoList.addTask("Megha", "10-10-2019", "Kadu", "done");
        toDoList.addTask("Anaisha", "30-10-2019", "Thakare", "done");
        toDoList.addTask("Abhi", "20-10-2019", "Thakare", "done");
        toDoList.addTask("Baby", "20-10-2021", "Thakare", "undone");
        int noOfDoneTasks = toDoList.getNoOfDonetasks();
        assertEquals(3,noOfDoneTasks);
    }
    @Test
    public void getNoOfUndoneTaskTest(){
        toDoList.addTask("Megha", "10-10-2019", "Kadu", "done");
        toDoList.addTask("Anaisha", "30-10-2019", "Thakare", "done");
        toDoList.addTask("Abhi", "20-10-2019", "Thakare", "done");
        toDoList.addTask("Baby", "20-10-2021", "Thakare", "undone");
        int noOfUndoneTasks = toDoList.getNoOfUndonetasks();
        assertEquals(1,noOfUndoneTasks);
    }
    @Test
    public void removeTaskTest(){
        toDoList.addTask("Megha", "10-10-2019", "Kadu", "done");
        toDoList.addTask("Anaisha", "30-10-2019", "Thakare", "done");
        toDoList.addTask("Abhi", "20-10-2019", "Thakare", "done");
        toDoList.addTask("Baby", "20-10-2021", "Thakare", "undone");
        toDoList.removeTask(1);
        assertEquals(3,toDoList.size());
    }
}
