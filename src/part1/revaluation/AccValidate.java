/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part1.revaluation;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



/**
 *
 * @author RC_Student_lab
 */
class AccValidate {
    private String Firstname;
    private String Lastname;
    private String usernameReg;
    private String passwordReg;
    private String usernameLog;
    private String passwordLog;
    boolean flag;
    boolean flag1;
    boolean flag2;
    boolean flag3;
    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,}$";
    private final Pattern pattern = Pattern.compile(regex);
    
    Scanner sc = new Scanner(System.in);
    
    public String getFirstname() {
        return Firstname;
    }
    
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }
    
    public String getLastname() {
        return Lastname;
    }
     
    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
    
    public String getusernameReg() {
        return usernameReg;
    }
    
    public void setusernameReg(String usernameReg) {
        this.usernameReg = usernameReg;
    }
    
    public String getpasswordReg(){
        return passwordReg;
    }
    
    public void setpasswordReg(String passwordReg) {
        this.passwordReg = passwordReg;
    }
    
    public String getusernameLog() {
        return usernameLog;
    }
    
    public void setusernameLog(String usernameLog) {
        this.usernameLog = usernameLog;
    }
    
    public String getpasswordLog() {
        return passwordLog;
    }
    
    public void setpasswordLog(String passwordLog) {
        this.passwordLog = passwordLog;
    }
    
    //First method
    
    public boolean checkusername(String usernameReg){
        flag = (usernameReg.contains("_")) && (usernameReg.length()< 6);
        return flag;
        
    }
    
    //Second method
    public boolean checkpassword(String passwordReg) {
        Matcher matcher = pattern.matcher(passwordReg);
        
        flag1 = matcher.matches();
        
        return flag1;
    }
    
    //third method
    
    public void registerUser() {
        label1: {
            while (passwordReg !=null){
                break label1;
            }
        }
        
        if(usernameReg !=null){
            while (!checkusername(usernameReg)){
                System.out.println("Username is not correctly formatted," + 
                        "please make sure that username is 5 characters long and contains an underscore.");
                
                System.out.print("Please enter required username:");
                usernameReg = sc.nextLine();
             
            }//end while
            
            if (checkusername(usernameReg)){
                System.out.print("Username successfully captured.");
            }
        }
        if(passwordReg == null) {
            return;
        }
        
        //pasword section
        
        Matcher matcher = pattern.matcher(passwordReg);
        
        while (!checkpassword(passwordReg)){
            System.out.println("Password is not corectly formatted," +
                    "please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            System.out.print("please enter a pasword that meets these conditions: ");
            passwordReg = sc.nextLine();
            matcher = pattern.matcher(passwordReg);//infinite loop for variable
            
            
        }//endwhile
        
        if(checkpassword(passwordReg)){
            System.out.println("Password captured sucessfuly");
            System.out.println("\nCongratulations! You have sucessfully registered your account");
        }
        
        
        
    }
    //End of registeruser method
    
    //fourth method
    
    public boolean loginuser(){
        flag2 = passwordLog.equals(passwordReg) && usernameLog.equals(usernameReg);
        return flag2;
        
    }
    
   //end Loginuser method
    
    //firth method
    
    public void returnLogin(){
        
        while (!loginuser()){
            System.out.print("\nUsername or password incorrect, please try again.");
            System.out.print("Please re-enter username:");
            usernameLog = sc.nextLine();
            System.out.print("Please re-enter your paswword:");
            passwordLog = sc.nextLine();
        }
        //endwhile
        
        if(loginuser()){
            System.out.print("\nWelcome " + Firstname + " " + Lastname + "! It is great to see you again");
        }//endif
    }
    
    //Beginning of Part 2
    
    private int Size;
    private String TaskDesc[] = new String[Size];
    private String TaskName[] = new String[Size];
    private String DeveloperName[] = new String[Size];
    private int  TaskDuration [] = new int[Size];
    private int Status [] = new int [Size];
    private int Total;
    private int Count_;
    private String [] Options = {"To do","Done", "Doing"};
    private String Choice;
    
    //get and set variables
    
    public int getSize(){
        return Size;
    }
    
    public void setSize(int Size) {
        this.Size = Size;
    }
    
    public String[] getTaskName(){
        return TaskName;
    }
    
    public void setTaskName(String[] TaskName){
        this.TaskName = TaskName;
    }
    
    public String getChoice() {
        return Choice;
    }
    
    public void setChoice(String Choice){
        this.Choice = Choice;
       
    }
    
    public String[] getOptions() {
        return Options;
    }
    
    public void setOptions(String[] Options) {
        this.Options = Options;
    }
    
    public int getTotal() {
        return Total;
    }
    
    public void setTotal(int Total) {
        this.Total = Total ;
    }
    
    public int[] getStatus() {
        return Status;
    }
    
    public void setStatus(int[] Status) {
        this.Status = Status;
    }
    
    public int[] getTaskDuration() {
        return TaskDuration;
    }
    
    public void setTaskDuration(int[] TaskDuration) {
        this.TaskDuration = TaskDuration;
    }
    
    public String[] getDeveloperName() {
        return DeveloperName;
    }
    
    public void setDeveloperName(String[] DeveloperName) {
        this.DeveloperName = DeveloperName;
    }
    
    public int getCount() {
        return Count_;
    }
    
    public void setCount(int Count_) {
        this.Count_ = Count_;
    }
    
    public String[] getTaskDesc() {
        return TaskDesc;
    }
    
    public void setTaskDesc(String[] TaskDesc) {
        this.TaskDesc= TaskDesc;
    }
    
    
    //First Method
    public boolean checkTaskDesc(String desc) {
        boolean flag3 = desc.length() < 51 && desc.length() > 0;
        
        return flag3;
    }
    // end of check TaskDescription
    
    //Second Method 
    public String createTaskId(){
        String a = Character.toString(TaskName[getCount()].charAt(0));
        String b = Character.toString(TaskName[getCount()].charAt(1));
        String c = Character.toString(DeveloperName[getCount()].charAt(DeveloperName[getCount()].length()-3));
        String d = Character.toString(DeveloperName[getCount()].charAt(DeveloperName[getCount()].length()-2));
        String e = Character.toString(DeveloperName[getCount()].charAt(DeveloperName[getCount()].length()-1));
        
        String taskId = a.toUpperCase() + b.toUpperCase() + ":" + Count_ + ":" + c.toUpperCase() + d.toUpperCase() + e.toUpperCase();
        
        return taskId;
        
    }
    
    //End of cearing task ID method
    
    //third method 
    
    public String printTaskDetails() {
        String taskDets = "Status: " + Options[Status[getCount()]]
                + "\nDeveloper: " + DeveloperName[getCount()]
                + "\nTaskNumber: " + getCount() 
                + "\nTaskName" + TaskName[getCount()] 
                + "\nDescription: " + TaskDesc[getCount()]
                + "\nTask Id: " + createTaskId() 
                + "\nDuration: " + TaskDuration[getCount()] + "hours";
        
        return taskDets;
    
    }
    //end of TaskDetails method
    
    //fourth method
    public int returnTotal () {
        return Total;
    }
    
    //end of return totalHours
    
    //own methods for verifying the users input in Part 2
    
    //method verifying user's input
    
    public String verifyChoice() {
        while (Choice == null || !(Choice.equals("1")) && !(Choice.equals("2")) && !(Choice.equals("3")) && !(Choice.equals("4")) && !(Choice.equals("5")) && !(Choice.equals("6")) && !(Choice.equals("7")) && !(Choice.equals("0")))
        {
            Choice = JOptionPane.showInputDialog(null, "\nSelect an action to proceed with:" 
                    + "\n1. Add tasks" 
                    + "\n2. Show report"
                    + "\n3. View all completed tasks"
                    +"\n4. Display task with longest duration"
                    + "\n5. Search for task"
                    + "\n6. Search tasks by developer"
                    + "\n7. Delete a task"
                    + "\n\n0. Quit"
                    + "\n*Please enter only the number that correponds to your action", "INVALID ENTRY",JOptionPane.ERROR_MESSAGE);
        }
        return Choice;
    }//end  of verifying choice
    
    public String verifyTaskName() {
        while(TaskName[getCount()].equals("") || TaskName[getCount()].length() < 2) {
            TaskName[getCount()] = JOptionPane.showInputDialog(null, "Please ensure that your task name is at least 2 characters long",
                    "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }//endwhile
        return TaskName[getCount()];
        
    }//end of verifying taskname
    
    public String verifyDeveloperName() {
        while(DeveloperName[getCount()].equals("") || DeveloperName[getCount()].length() < 3) {
            DeveloperName[getCount()] = JOptionPane.showInputDialog(null, "Please ensure that your developer's name is at least 3 letters long",
                    "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }//endwhile
        return DeveloperName[getCount()];
        
    }// end of Developer name method
    
//    public String verifyTaskDuration(){
//        while(true) {
//            try{
//                Integer.parseInt(TaskDuration[getCount()]);
//                break;
//            }
//            
//            catch (NumberFormatException e ) {
//                TaskDuration[getCount()] = JOptionPane.showInputDialog(null, "Enter the estimated task duration in hours" 
//                        + "\n*Ensure that it is a numeric value","INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
//            }
//            
//        }//endwhile
//        return TaskDuration[getCount()];
//    }
    
    public int LongestDuration(int[] task_dur){
        int i; 
        
        // Initialize maximum element 
        int max = task_dur[0]; 
        
        // Traverse array elements from second and 
        // compare every element with current max 
        for (i = 1; i < task_dur.length; i++) 
            if (task_dur[i] > max) 
                max = task_dur[i]; 
        
        return max; 
    }
    
    
    
    
    
    
    
    
    
   
    
       
    
}
    
    
    
    
    

