/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package part1.revaluation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class Part1RevaluationTest {
    AccValidate myObj = new AccValidate();
   
    
    
   
    
    public Part1RevaluationTest() {
        
    }
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myObj.setCount(0); // Initialize task count
        myObj.setTaskName(new String[5]); // Set a size for task names
        myObj.setTaskDesc(new String[5]); // Set a size for task descriptions
        myObj.setDeveloperName(new String[5]); // Set a size for developer names
        myObj.setTaskDuration(new int[5]); // Set a size for task durations
        
        //Part 3 test unit
        myObj.setSize(4);
        myObj.setDeveloperName(new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"});
        myObj.setTaskName(new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"});
        myObj.setTaskDuration(new int[]{2, 5, 3, 11});
        myObj.setStatus(new int[]{0, 1, 2, 0});  // To Do, Doing, Done, To Do
        myObj.setTaskDesc(new String[]{"Description for Create Login", "Description for Add Features", "Description for Reports", "Description for Add Arrays"});
        
        
    }
    
    
    
    
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestvalidUsername() {
        assertTrue("Usernsme should be valid",myObj.checkusername("Ky1_1"));
       
    }
    
    @Test
    public void TestvInvalidUsername() {
        assertFalse("Usernsme should be invalid",myObj.checkusername("Kyle!!!"));
       
    }
    
    @Test
    public void TestValidPassword() {
        assertTrue("Password should be valid",myObj.checkpassword("Chsec@k9"));
       
    }
    
    @Test
    public void TestInValidPassword() {
        assertFalse("Password should be invalid",myObj.checkpassword("Password"));
       
    }
    
    @Test
    public void TestLoginSucessful(){
        String user_nameLog = "Ky1_1";
        String pass_wordLog = "Chsec@k9";
    }
    
    @Test
    public void TestLoginUnsucessful(){
        String user_nameLog = "Kyle!!";
        String pass_wordLog = "Password";
    }
    
    @Test
    public void testCheckTaskDesc_Success() {
        String validDesc = "Create Login to authenticate users";
        assertTrue(myObj.checkTaskDesc(validDesc));
    }
    
    
    @Test
    public void testCreateTaskId() {
        myObj.getTaskName()[0] = "Login Feature";
        myObj.getDeveloperName()[0] = "Robyn Harrison";
        myObj.setCount(0);
        String expectedTaskId = "LO:0:SON"; // Expected based on logic from method
        assertEquals(expectedTaskId, myObj.createTaskId());
    }
    
    @Test
    public void testCreateId2() {
        myObj.getTaskName()[1] = "Adding tasks";
        myObj.getDeveloperName()[1] = "Mike Smith";
        myObj.setCount(1);
        String expectedTaskId2 = "AD:1:ITH";
        assertEquals(expectedTaskId2,myObj.createTaskId());
    }
    
    

    @Test
    public void testTotalHoursAccumulated() {
        myObj.setTaskDuration(new int[]{10, 12, 55, 11, 1});
        int total = 0;
        for (int duration : myObj.getTaskDuration()) {
            total += duration;
        }
        assertEquals(89, total);
    }

    @Test
    public void testTaskDescriptionLength() {
        myObj.getTaskDesc()[0] = "Short desc";
        myObj.getTaskDesc()[1] = "This description is long enough to fail the test because it exceeds the maximum allowed length of fifty characters";
        
        assertTrue(myObj.checkTaskDesc(myObj.getTaskDesc()[0]));
        assertFalse(myObj.checkTaskDesc(myObj.getTaskDesc()[1]));
    }
    
    
    @Test
    public void testDeveloperArrayPopulated() {
        String[] DeveloperNames = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        assertArrayEquals(DeveloperNames, myObj.getDeveloperName());
        
    }
    
//    @Test
//    public void testDisplayLongestDurationTask(int[] task_dur) {
//        String Output = "Glenda Oberholzer, 11";
//        assertEquals(Output, myObj.LongestDuration(task_dur));
//    }
//    
       
    @Test
    public void testTaskLongestDuration() {
       
        int longestDuration = myObj.LongestDuration(myObj.getTaskDuration());
        String developer = myObj.getDeveloperName()[3]; // Developer for the longest duration (Glenda Oberholzer)
        
        assertEquals(11, longestDuration);
        assertEquals("Glenda Oberholzer", developer);
    }
    
    @Test
    public void testSearchTaskName() {
        String taskName = "Create Login";
        int taskIndex = -1;
        for (int i = 0; i < myObj.getTaskName().length; i++) {
            if (myObj.getTaskName()[i].equals(taskName)) {
                taskIndex = i;
                break;
            }
        }
        
        assertEquals("Mike Smith", myObj.getDeveloperName()[taskIndex]);
        assertEquals("Create Login", myObj.getTaskName()[taskIndex]);
    }
    
    
    @Test
    public void testSearchDeveloperTask() {
        String developer = "Samantha Paulson";
        String[] developerTasks = new String[myObj.getTaskName().length];
        int taskCount = 0;
        
        for (int i = 0; i < myObj.getDeveloperName().length; i++) {
            if (myObj.getDeveloperName()[i].equals(developer)) {
                developerTasks[taskCount] = myObj.getTaskName()[i];
                taskCount++;
            }
        }
        
        assertEquals("Create Reports", developerTasks[0]);
    }
    
    @Test
    public void testDeleteTask() {
        String taskToDelete = "Create Reports";
        
        // Search and delete task
        int taskIndex = -1;
        for (int i = 0; i < myObj.getTaskName().length; i++) {
            if (myObj.getTaskName()[i].equals(taskToDelete)) {
                taskIndex = i;
                break;
            }
        } 
        // task delete
        myObj.getTaskName()[taskIndex] = null;
        assertNull(myObj.getTaskName()[taskIndex]);
    }
    
    @Test
    public void testDisplayReport() {
        String taskDetails = myObj.printTaskDetails();
        
        assertTrue(taskDetails.contains("Status:"));
        assertTrue(taskDetails.contains("Developer:"));
        assertTrue(taskDetails.contains("TaskName"));
        assertTrue(taskDetails.contains("Task Id:"));
        assertTrue(taskDetails.contains("Duration"));
    }
    
}
    
    
    
    
    
    
    
    
    
    

    
    

    
    




    
    
    
    
    
    
    
    

