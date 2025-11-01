/**
 * Points to Note
 * 1. Check-out Application: It is necessary to check that there are successfully completed accommodation applications before processing the check-out application.
 * 2. Accommodation Transfer Application: It is necessary to check whether there are successfully completed accommodation applications and unsuccessful check-out applications.
 * 3. Item Borrowing Application: Check if the previous item borrowing application was successfully completed.
 * 4. Activity Room Borrowing Application: Check if the previous activity room borrowing application was successfully completed.
 */


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {


    ArrayList<StudentApartment> studentStore = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println(" Student Apartment System Version 2.0 ");
        System.out.println("--------------------------------------\n");

        Driver driver = new Driver();

    }


    Driver() {

        runMenu();

    }


    // Validation for Name
    public boolean judgeName(String name) {
        boolean flag = true;
        if (name.length() < 2 || name.trim().isEmpty()) {
            flag = false;
        }
        return flag;
    }


    // Validation for Phone Number
    public boolean judgeID(String studentID) {
        boolean flag = true;
        if (studentID.length() != 12) {
            flag = false;
        }
        try {
            Long.parseLong(studentID);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }


    // Validation for Phone Number
    public boolean judgePhoneNumber(String telephoneNumber) {
        boolean flag = true;
        if (telephoneNumber.length() != 11) {
            flag = false;
        }
        try {
            Long.parseLong(telephoneNumber);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }




    public void addAndStart() {

        System.out.println("\033[33m\n---------------\033[0m");
        System.out.println("\033[33m Start Project \033[0m");
        System.out.println("\033[33m---------------\033[0m");


        System.out.print("\033[33m[Enter name]         \033[0m");
        String name = input.nextLine();
        while (!(judgeName(name))) {
            System.out.print("\033[33m[Please enter a valid student name] \033[0m");
            name = input.nextLine();
        }

        System.out.print("\033[33m[Enter student ID]   \033[0m");
        String studentID = input.nextLine();
        while (!(judgeID(studentID))) {
            System.out.print("\033[33m[Please enter a valid student ID]   \033[0m");
            studentID = input.nextLine();
        }

        System.out.print("\033[33m[Enter phone number] \033[0m");
        String phoneNumber = input.nextLine();
        while (!(judgePhoneNumber(phoneNumber))) {
            System.out.print("\033[33m[Please enter a valid phone number] \033[0m");
            phoneNumber = input.nextLine();
        }

        StudentApartment newStudent = new StudentApartment(name, studentID, phoneNumber);
        studentStore.add(newStudent);

        System.out.print("""
                \033[33m-----------------------
                 Choose Iterm to Start
                -----------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice\033[0m
                """);
        System.out.print("\033[33m[Enter your iterm number to start] \033[0m");
        int startProjectNumber = input.nextInt();
        input.nextLine();


        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.get(i).iterms.set(startProjectNumber - 1, 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[33m<Please enter a valid student ID!>\033[0m");
        }





        /* 注意点
        1. 退宿申请：检查，有成功办结的住宿申请，才能办理退宿申请。
        2. 调宿申请：检查，有成功办结的住宿申请，且没有成功办结的退宿申请。
        3. 物品借用申请：检查，上一次的物品借用申请是否成功办结。
        4. 活动室借用申请：检查，上一次的活动室借用申请是否成功办结。
         */

    }


    // "\033[31m这是红色文字\033[0m"
    // "\033[34m<You have not been added to the student list yet!>\033[0m"


    public void startIterm() {

        System.out.println("\033[32m\n-------------\033[0m");
        System.out.println("\033[32m Start Iterm \033[0m");
        System.out.println("\033[32m-------------\033[0m");

        System.out.print("\033[32m[Enter student ID to start iterm] \033[0m");
        String studentID = input.nextLine();

        System.out.print("""
                \033[32m
                -----------------------
                 Choose Iterm to Start
                -----------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice
                \033[0m""");
        System.out.print("\033[32m[Enter your iterm number] \033[0m");
        int option = input.nextInt();
        input.nextLine();

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++ ) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.get(i).iterms.set(option - 1, 1);
                flag = true;
                break;
            }
        }
        if  (!flag) {
            System.out.println("\033[32m<You have not been added to the student list yet!>\033[0m");
        }
    }


    public void updateStatus() {

        System.out.println("\033[35m\n---------------\033[0m");
        System.out.println("\033[35m Update Status \033[0m");
        System.out.println("\033[35m---------------\033[0m");

        System.out.print("\033[35m[Enter your studentID] \033[0m");
        String studentID = input.nextLine();
        while (!(judgeID(studentID))) {
            System.out.println("\033[35m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        System.out.print("""
                \033[35m------------------------
                 Choose Iterm to Update
                ------------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice\033[0m
                """);
        System.out.print("\033[35m[Enter your iterm number to update] \033[0m");
        int itermNumber = input.nextInt();
        input.nextLine();

        System.out.print("""
                \033[35m\n----------------
                 Update Options
                ----------------
                1) Cancel the Application
                2) Application Succeeded
                3) Application Failed\033[0m
                """);
        System.out.print("\033[35mEnter your update option: \033[0m");
        int option = input.nextInt();
        input.nextLine();


        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                switch (option) {
                    case 1:
                        studentStore.get(i).cancelTerm(itermNumber - 1);
                        flag = true;
                        break;
                    case 2:
                        studentStore.get(i).applicationSuccess(itermNumber - 1);
                        flag = true;
                        break;
                    case 3:
                        studentStore.get(i).applicationFailed(itermNumber - 1);
                        flag = true;
                        break;
                    default:
                        System.out.println("\033[35m<Please enter a valid option!>\033[0m");
                        break;
                }
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[35m<Please enter a valid term number!>\033[0m");
        }


    }





    public void displayPersonalProject() {

        System.out.println("\033[36m\n--------------------------\033[0m");
        System.out.println("\033[36m Display Personal Project \033[0m");
        System.out.println("\033[36m--------------------------\033[0m");

        System.out.print("\033[36m[Enter your studentID] \033[0m");
        String studentID = input.nextLine();
        while (studentID.length() != 12) {
            System.out.println("\033[36m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                System.out.println(studentStore.get(i));
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[36m<Student ID does not exist!>\033[0m");
        }

    }


    public void displayAllProject() {

        System.out.println("\033[94m\n---------------------\033[0m");
        System.out.println("\033[94m Display All Project \033[0m");
        System.out.println("\033[94m---------------------\033[0m");

        for (int i = 0; i < studentStore.size(); i++) {
            System.out.println(studentStore.get(i));
        }

    }


    public void accommodationNotice() {
        System.out.println(
                """
                               \033[96m\n-----------------------
                                 Accommodation Notice
                               -----------------------
                               1. Keep Quiet: Do not make loud noises after 23:30, open and close doors softly.
                               2. Shared Hygiene: take turns cleaning, clean up garbage daily, and arrange items neatly.
                               3. Save Resources: Turn off the lights and water at will, and use electrical appliances reasonably.
                               4. Friendship and Mutual Assistance: Respect differences, get along harmoniously, and communicate minor conflicts in a timely manner.
                               5. Safety First: Do not use illegal electrical appliances and lock doors and windows when leaving the dormitory.\033[0m
                               """
        );
    }


    public int getOption0() {

        System.out.print("""
                \033[34m\n--------------------
                 Operation Choosing
                --------------------
                0) Exit
                1) Add New Student and Start Iterm
                2) Start Iterm
                3) Update Iterm Status
                4) Display Your Projects
                5) Display Everyone's Projects
                6) Accommodation Notice\033[0m
                """);
        System.out.print("\033[34m[Enter the number of option to handle] \033[0m");
        int getOperationNumber = input.nextInt();
        input.nextLine();
        return getOperationNumber;

    }

    public void runMenu() {

        int option = getOption0();
        while (option != 0) {
            switch (option) {
                case 1  ->  addAndStart();
                case 2  ->  startIterm();
                case 3  ->  updateStatus();
                case 4  ->  displayPersonalProject();
                case 5  ->  displayAllProject();
                case 6  ->  accommodationNotice();
                default ->  System.out.println("\033[34m<Invalid option. Try again.>\033[0m");
            }
            System.out.println("\033[34m\n<Press Enter to continue...>\033[0m");
            input.nextLine();
            option = getOption0();

        }


    }



} // End of Driver Class