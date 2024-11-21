/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part1.revaluation;


import java.util.*;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 *
 * @author RC_Student_lab
 */
public class Part1Revaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JDialog window = new JDialog();
        AccValidate myObj = new AccValidate();

        //Part 1
        Scanner obj = new Scanner(System.in);

        String user_nameLog;
        String pass_wordLog;
        String first_name;
        String last_name;
        String user_nameReg;
        String pass_wordReg;

        System.out.println("Hello and Welcome! " + "In order to register an account with us, please follow the propmpts below");

        //Prompt personal details
        System.out.println("Enter your First name:");
        first_name = obj.nextLine();
        myObj.setFirstname(first_name);

        System.out.print("Enter your Last name:");
        last_name = obj.nextLine();
        myObj.setLastname(last_name);

        System.out.print("\n" + "Create your username:"
                + "\n*Please note that your username:"
                + "\n- must not exceed 5 characters in length and"
                + "\n- must contain an underscore(_)."
                + "\nEnter a username:");

        user_nameReg = obj.nextLine();
        myObj.setusernameReg(user_nameReg);

        myObj.registerUser(); //validate user

        System.out.print("\n" + "Create a password:"
                + "\n*Please note that your password must:"
                + "\n- contain at least 8 characters,"
                + "\n- contain a capital letter,"
                + "\n- contain a digit and"
                + "\n- contain a special character."
                + "Enter your password:");
        pass_wordReg = obj.nextLine();
        myObj.setpasswordReg(pass_wordReg);

        myObj.registerUser(); //Validate the password

        System.out.print("\nPlease enter your username and password:"
                + "\nPlease enter your usrname:");
        user_nameLog = obj.nextLine();
        myObj.setusernameLog(user_nameLog);

        System.out.print("\nPlease enter your password:");
        pass_wordLog = obj.nextLine();
        myObj.setpasswordLog(pass_wordLog);

        myObj.returnLogin();

        //END Of Part1
        //Start Part2
        //Display PART 2
        window.setAlwaysOnTop(true);

        //Declarations
        String choice;
        String task_name[] = null;
        String task_desc[] = null;
        String develop_name[] = null;
        int task_dur[] = null;
        int status[] = null;
        String task_Id[] = null;
        int size = 0;
        int count;
        int total = 0;
        String[] del = {"Delete", "Cancel"};
        String[] options = {"To do", "Done", "Doing"};

        //prompting the user to choose an option
        choice = JOptionPane.showInputDialog(null, "Please select an action to proceed with:"
                + "\n1. Add tasks"
                + "\n2. Show report"
                + "\n3. View all completed tasks"
                + "\n4. Display task with longest duration"
                + "\n5. Search for task"
                + "\n6. Search tasks by developer"
                + "\n7. Delete a task"
                + "\n\n0. Quit", "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);

        myObj.setChoice(choice);

        //verifying choice
        choice = myObj.verifyChoice();

        //beginning of loop after user selects an option
        while (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7")) {
            //adding tasks
            if (choice.equals("1")) {
                size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the ammount of tasks you want to create",
                        null, JOptionPane.PLAIN_MESSAGE));
                myObj.setSize(size);

                task_name = new String[size];
                develop_name = new String[size];
                task_dur = new int[size];
                status = new int[size];
                task_Id = new String[size];
                task_desc = new String[size];

                for (count = 0; count < size; count++) {
                    myObj.setCount(count);

                    //prompting for a task name
                    task_name[count] = JOptionPane.showInputDialog(null, "Enter a name for task" + count,
                            "Task Name", JOptionPane.PLAIN_MESSAGE);
                    myObj.setTaskName(task_name);
                    //verifying input
                    task_name[count] = myObj.verifyTaskName();

                    //prompting for a task description
                    task_desc[count] = JOptionPane.showInputDialog(null, "The description should not exceed 50 characters in length",
                            "Provide a description for the task", JOptionPane.PLAIN_MESSAGE);
                    myObj.setTaskDesc(task_desc);

                    //verifying the task description
                    while (!myObj.checkTaskDesc(task_desc[count])) {
                        task_desc[count] = JOptionPane.showInputDialog(null, "Please enter a task description of 50 characters or less",
                                "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);

                        //updating variable
                        myObj.setTaskDesc(task_desc);
                    }//endwhile

                    if (myObj.checkTaskDesc(task_desc[count])) {
                        JOptionPane.showMessageDialog(null, "Task sucessfully captured");
                    }//endif

                    //asking for developer name
                    develop_name[count] = JOptionPane.showInputDialog(null, "Enter the first and last name of the developer assigned to task",
                            "Developer Details", JOptionPane.PLAIN_MESSAGE);
                    myObj.setDeveloperName(develop_name);

                    //verifying that the input is valid
                    develop_name[count] = myObj.verifyDeveloperName();

                    //asking for task duration
                    task_dur[count] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the estimated task duration in hours",
                            "Task Duration", JOptionPane.PLAIN_MESSAGE));
                    myObj.setTaskDuration(task_dur);

                    //verifying the task duration
                    //myObj.LongestDuration(task_dur);

                    //summing the total hours of tasks 
                    total = total + task_dur[count];
                    myObj.setTotal(total);

                    //prompting for the tasks status
                    status[count] = JOptionPane.showOptionDialog(null, "Please specify the status of this task:",
                            "Task Status", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, myObj.getOptions(), null);
                    myObj.setStatus(status);

                    //displaying task details
                    JOptionPane.showMessageDialog(null, myObj.printTaskDetails(), "Task Details", JOptionPane.PLAIN_MESSAGE);

                    //Part 3 populating the array with an Id for the information  added
                    task_Id[count] = myObj.createTaskId();

                }//endfor

            }//endif

            if (choice.equals("2")) {
                StringBuilder report = new StringBuilder();

                for (int i = 0; i < size; i++) {
                    //ensuring it is not null if we are to delete it
                    //if taskName[i] is null, all arrays are null for[i]
                    if (task_name[i] != null) {

                        report.append("Task name").append(task_name[i])
                                .append("\nDeveloper: ").append(develop_name[i])
                                .append("\nDuration: ").append(task_dur[i] + "hours")
                                .append("\nTask Id: ").append(task_Id[i])
                                .append("\nStatus: ").append(options[status[i]] + "\n\n");

                    }//endif

                }//endfor

                //if the user has not yet entered any tasks
                if (size == 0) {
                    JOptionPane.showMessageDialog(null, "Please add tasks to view a report", "No tasks display", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("3")) {
                StringBuilder completedTasks = new StringBuilder();

                int found = 0;

                if (status != null && task_name != null && task_dur != null) {
                    for (int i = 0; i < size; i++) {
                        if (status[i] == 1) {
                            completedTasks.append("Task name: ").append(task_name[i])
                                    .append("\nDevloper :").append(develop_name[i])
                                    .append("\nTask Duration:").append(task_dur[i]);

                            found++;

                        }//endif
                    }//endfor

                }//endif

                if (found > 0) {
                    JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tasks have beem completed yet", "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                }
            }//endif3

            if (choice.equals("4")) {
                myObj.LongestDuration(task_dur);
            }
//                if (size == 0) {
//                    JOptionPane.showMessageDialog(null, "Please add tasks to proceed with the this action",
//                            "No task to display", JOptionPane.PLAIN_MESSAGE);
//                } else {
//                    int longestDuration = 0;
//                    String longestDur_Develop = null;
//
//                    for (int i = 0; 1 < size; i++) {
//                        if (Integer.parseInt(task_dur[i]) > longestDuration) {
//                            longestDuration = Integer.parseInt(task_dur[i]);
//                            longestDur_Develop = develop_name[i];
//                        }//endif
//                    }//endfor
//
//                    JOptionPane.showMessageDialog(null, "Developer: " + longestDur_Develop
//                            + "\nDuration:" + longestDuration + "hours", "Task with longest duration", JOptionPane.PLAIN_MESSAGE);
//                }//endif
//            }

                
            if (choice.equals("5")) {
                String search = "";
                boolean matchfound = false;

                search = JOptionPane.showInputDialog(null, "Enter task name", "search ny name", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {

                    if (search.equalsIgnoreCase(task_name[i])) {
                        JOptionPane.showMessageDialog(null, "Task name" + task_name[i]
                                + "\nDeveloper: "
                                + develop_name[i] + "Status: " + options[status[i]], "Task found", JOptionPane.PLAIN_MESSAGE);
                        matchfound = true;
                    }//endif
                }//endfor

                if (!matchfound) {
                    JOptionPane.showMessageDialog(null, "Sorry, that you enetreed does not exist", "No match found", JOptionPane.PLAIN_MESSAGE);
                }//endif
            }//endif5

            if (choice.equals("6")) {
                String search = "";
                boolean matchfound = false;
                StringBuilder searchfound = new StringBuilder();

                search = JOptionPane.showInputDialog(null, "Enter a developer's name", "Search by developer's name", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {
                    if (search.equalsIgnoreCase(develop_name[i])) {
                        searchfound.append("Name: ").append(task_name[i])
                                .append("\nStatus: ").append(options[status[i]]).append("\n\n");

                        matchfound = true;

                    }//endif
                }//endfor

                if (matchfound) {
                    JOptionPane.showMessageDialog(null, search.toString(), "Tasks assigned to" + search, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "that developer is not assigned to any tasks", "no match found", JOptionPane.PLAIN_MESSAGE);
                }
            }//endif6

            if (choice.equals("7")) {
                String delete = "";
                boolean taskDeleted = false;
                int approved;

                delete = JOptionPane.showInputDialog(null, "Enter a task name. \nAll tasks with thus name will be deleted",
                        "Delete tasks", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size; i++) {
                    if (delete.equalsIgnoreCase(task_name[i])) {
                        approved = JOptionPane.showOptionDialog(null, "Are you sure you want to delete tasks of the name" + delete + "?",
                                "Confirm task deletion", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                                null, del, null);

                        if (approved == 0) {
                            total = total - (task_dur[i]);
                            myObj.setTotal(total);

                            //deleting all information from arrays at index i
                            task_name[i] = null;
                            develop_name[i] = null;
                            task_desc[i] = null;
//                            task_dur = ArrayUtils.removeElement(task_dur, count);
//                            System.out.println(Arrays.toString(task_dur));
                            task_dur[i] = 0;
                            status[i] = -1;
                            task_Id[i] = null;

                            taskDeleted = true;

                        }//endif
                    }//endif
                }//endfor
                if (taskDeleted) {
                    JOptionPane.showMessageDialog(null, "The task was succesfully deleted", "Task deleted", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No tasks were found", "Task not found", JOptionPane.PLAIN_MESSAGE);
                }
            }//endif7

            //updating the variable
            choice = JOptionPane.showInputDialog(null, "Please select an action to proceed with:"
                    + "\n1. Add tasks"
                    + "\n2. Show report"
                    + "\n3. View all completed tasks"
                    + "\n4. Display task with longest duration"
                    + "\n5. Search for task"
                    + "\n6. Search tasks byb developer"
                    + "\n7. Delete a task"
                    + "\n\n0. Quit", "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);
            myObj.setChoice(choice);
            choice = myObj.verifyChoice();

        }//endwhile

        if (choice.equals("0")) {
            JOptionPane.showMessageDialog(null, "Your tasks will take a total of" + myObj.returnTotal() + "hours", "Total hours", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Goodbye", "See you soon", JOptionPane.PLAIN_MESSAGE);

        }//endif

    }//end of main

}//end of class

