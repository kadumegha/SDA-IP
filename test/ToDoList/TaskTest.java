package ToDoList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void ewTask_instantiatesCorrectlyTest() {
        Task testTask = new Task(1,"Megha","10-10-2019","Kadu","done");
        assertEquals(true, testTask instanceof Task);
    }

    @Test
    public void getTitleTest() {
        Task testTask = new Task(1,"Megha","10-10-2019","Kadu","done");
        assertEquals("Megha", testTask.getTitle());
    }
    @Test
    public void getDueDateTest() {
        Task testTask = new Task(1,"Megha","10-10-2019","Kadu","done");
        assertEquals("10-10-2019", testTask.getDueDate());
    }

    @Test
    public void getProjectTest() {
        Task testTask = new Task(1,"Megha","10-10-2019","Kadu","done");
        assertEquals("Kadu", testTask.getProject());
    }

    @Test
    public void getStatusTesr() {
        Task testTask = new Task(1,"Megha","10-10-2019","Kadu","done");
        assertEquals("done", testTask.getStatus());
    }
}
