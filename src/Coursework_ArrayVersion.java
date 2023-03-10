import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 The Coursework - 4COSC010C.3 Software Development II
 Module Leader : Mr. Deshan Sumanathilake
 @author Name : Tashini Rebeca Samnmalie Weerasooriya
 UOW ID : w1901991
 IIT ID : 20212153
 Date : 2022-07-09
 */

public class Coursework_ArrayVersion
{
    static Scanner input = new Scanner(System.in);

    static String[] queueOne = new String[6];
    static String[] queueTwo = new String[6];
    static String[] queueThree = new String[6];

    static int fuelStock = 6600;

    public static void viewAllQueues()
    {
        /*
            Display All the Fuel Queues
         */

        System.out.print("\nFuel Queue 1: ");
        for (String s : queueOne)
        {
            if (s == null) {System.out.print(" - ");}
            else
                System.out.print(s + "  ");
        }

        System.out.print("\nFuel Queue 2: ");
        for (String s : queueTwo)
        {
            if (s == null) {System.out.print(" - ");}
            else
                System.out.print(s + "  ");
        }

        System.out.print("\nFuel Queue 3: ");
        for (String s : queueThree)
        {
            if (s == null) {System.out.print(" - ");}
            else
                System.out.print(s + "  ");
        }
        System.out.println();
    }

    public static void viewEmptyQueues()
    {
        /*
            Display All the Completely Empty, Partially Empty & Completely Full Queues
         */

        // Queue 1
        if (queueOne[0] == null){System.out.println("\nQueue 1 is Completely Empty");}

        else if (queueOne[queueOne.length-1] != null ) {System.out.println("\nQueue 1 is Completely Full");}

        else {System.out.println("\nQueue 1 is Partially Empty");}

        // Queue 2
        if (queueTwo[0] == null){System.out.println("Queue 2 is Completely Empty");}

        else if (queueTwo[queueTwo.length-1] != null ) {System.out.println("Queue 2 is Completely Full");}

        else {System.out.println("Queue 2 is Partially Empty");}

        // Queue 3
        if (queueThree[0] == null) { System.out.println("Queue 3 is Completely Empty");}

        else if (queueThree[queueThree.length-1] != null ) {System.out.println("Queue 3 is Completely Full");}

        else {System.out.println("Queue 3 is Partially Empty");}
    }

    public static void addCustomer()
    {
        /*
            Adding a New Customer to a particular Queue
         */

        try {
            if (fuelStock <= 500) { viewWarningMessage();}
            System.out.print("\nEnter the queue (from 1 to 3): ");
            int queueNumber = input.nextInt();
            System.out.print("Enter the customer's name: ");
            String name = input.next();
            name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
            switch(queueNumber)
            {
                case 1:
                    for (int i = 0; i<queueOne.length; i++)
                    {
                        if (queueOne[i] == null)
                        {
                            queueOne[i] = name;
                            fuelStock -= 10;
                            System.out.println(name + " added to the queue 1 successfully");
                            break;
                        }
                        else if (queueOne[5] != null)
                        {
                            System.out.println("The Queue 1 is Full!!!");
                            break;
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i<queueTwo.length; i++)
                    {
                        if (queueTwo[i] == null)
                        {
                            queueTwo[i] = name;
                            fuelStock -= 10;
                            System.out.println(name + " added to the queue 2 successfully");
                            break;
                        }
                        else if (queueTwo[5] != null)
                        {
                            System.out.println("The Queue 2 is Full!!!");
                            break;
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i<queueThree.length; i++)
                    {
                        if (queueThree[i] == null)
                        {
                            queueThree[i] = name;
                            fuelStock -= 10;
                            System.out.println(name + " added to the queue 3 successfully");
                            break;
                        }
                        else if (queueThree[5] != null)
                        {
                            System.out.println("The Queue 3 is Full!!!");
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("You entered a wrong Queue number.Try again!");
            }
        }
        catch (InputMismatchException mismatchException)
        {
            input.nextLine();
            System.out.println("Invalid Input.Try Again!");
        }
    }

    public static void removeCustomer()
    {
        /*
            Removing a Customer from a specific location in a Queue
         */

        try {
            System.out.print("\nEnter the Queue Number of the Customer to be removed (from 1 to 3): ");
            int queueNo = input.nextInt();
            System.out.print("Enter the index of the Customer you want to remove (from 0 to 5): ");
            int index = input.nextInt();
            switch (queueNo) {
                case 1 -> {
                    if (queueOne[index] != null)
                    { // Check whether there's a customer in the queue to be removed
                        fuelStock += 10;
                        queueOne[index] = null;
                    }
                    else if (queueOne[index] == null)
                    {
                        System.out.println("There's no Customer to remove");
                        break;
                    }
                    for (int i = index + 1; i < queueOne.length; i++) {
                        if (queueOne[i - 1] == null)
                        {
                            queueOne[i - 1] = queueOne[i];
                            queueOne[i] = null;
                        }
                    }
                    System.out.println("The Customer in index " + index + " is removed from Queue 1 successfully.");
                }
                case 2 -> {
                    if (queueTwo[index] != null)
                    {
                        fuelStock += 10;
                        queueTwo[index] = null;
                    }
                    else if (queueTwo[index] == null)
                    {
                        System.out.println("There's no Customer to remove");
                        break;
                    }
                    for (int i = index + 1; i < queueTwo.length; i++)
                    {
                        if (queueTwo[i - 1] == null)
                        {
                            queueTwo[i - 1] = queueTwo[i];
                            queueTwo[i] = null;
                        }
                    }
                    System.out.println("The Customer in index " + index + " is removed from Queue 2 successfully.");
                }
                case 3 -> {
                    if (queueThree[index] != null)
                    {
                        fuelStock += 10;
                        queueThree[index] = null;
                    }
                    else if (queueThree[index] == null)
                    {
                        System.out.println("There's no Customer to remove");
                        break;
                    }
                    for (int i = index + 1; i < queueThree.length; i++)
                    {
                        if (queueThree[i - 1] == null)
                        {
                            queueThree[i - 1] = queueThree[i];
                            queueThree[i] = null;
                        }
                    }
                    System.out.println("The Customer in index " + index + " is removed from Queue 3 successfully.");
                }
            }
        }
        catch (InputMismatchException mismatchException)
        {
            input.nextLine();
            System.out.println("Invalid Input.Try Again!");
        }
    }

    public static void removeServedCustomer()
    {
        /*
            Removing a Served Customer from a Queue
         */

        try {
            System.out.print("Enter the queue Number (from 1 to 3): ");
            int queueNumber = input.nextInt();
            switch (queueNumber)
            {
                case 1:
                    if (queueOne[0] != null)
                    {
                        System.out.println("The Customer is served successfully");
                        queueOne[0] = null;
                        for (int i = 1; i < queueOne.length; i++) {
                            if (queueOne[i - 1] == null) {
                                queueOne[i - 1] = queueOne[i];
                                queueOne[i] = null;
                            }
                        }
                    }
                    else
                        System.out.println("The Queue 1 is empty");
                    break;

                case 2:
                    if (queueTwo[0] != null)
                    {
                        System.out.println("The Customer is served successfully");
                        queueTwo[0] = null;
                        for (int i = 1; i < queueTwo.length; i++) {
                            if (queueTwo[i - 1] == null) {
                                queueTwo[i - 1] = queueTwo[i];
                                queueTwo[i] = null;
                            }
                        }
                    }
                    else
                        System.out.println("The Queue 2 is empty");
                    break;

                case 3:
                    if (queueThree[0] != null)
                    {
                        System.out.println("The Customer is served successfully");
                        queueThree[0] = null;
                        for (int i = 1; i < queueThree.length; i++) {
                            if (queueThree[i - 1] == null) {
                                queueThree[i - 1] = queueThree[i];
                                queueThree[i] = null;
                            }
                        }
                    }
                    else
                        System.out.println("The Queue 3 is empty");
                    break;
            }
        }
        catch (InputMismatchException mismatchException)
        {
            input.nextLine();
            System.out.println("Invalid Input.Try Again!");
        }
    }

    public static void sortInAlphabeticalOrder()
    {
        /*
            Sorting The Names of Customers in Alphabetical Order
         */

        String[][] sortingArray = new String[3][6]; // Create a New string Array to copy the Original Array

        for (int i=0;i<3;i++)
        {
            for (int j=0;j<6;j++)
            {
                if (i==0) { sortingArray[i][j] = queueOne[j]; }
                if (i==1) { sortingArray[i][j] = queueTwo[j]; }
                if (i==2) { sortingArray[i][j] = queueThree[j]; }
                if (sortingArray[i][j] == null) { sortingArray[i][j] = "{}"; }
            }

            for (int j=0;j<6;j++)
            {
                for (int k=j+1;k<6;k++)
                {
                    if (sortingArray[i][j].compareTo(sortingArray[i][k]) > 0)
                    {
                        String tempVar;
                        tempVar = sortingArray[i][j];
                        sortingArray[i][j] = sortingArray[i][k];
                        sortingArray[i][k] = tempVar;
                    }
                }
            }
        }

        System.out.println("\nSorted Fuel Queues\n ");
        for (int i=0;i<3;i++){
            System.out.print("Queue " + (i+1) + ": ");
            for (String s : sortingArray[i]) {
                if (s.equals("{}")) {
                    System.out.print(" - ");
                } else
                    System.out.print(s + "  ");
            }
            System.out.println();
        }
    }

    public static void storeDataToFile()
    {
        /*
           Storing the data to a file
         */

        try {
            FileWriter fuelFile = new FileWriter("Fuel Management System - Galle.txt"); // Creating a new file to store data
            PrintWriter printWriter = new PrintWriter(fuelFile);

            for (int i=0;i<4;i++)
            {
                for (int j=0;j<6;j++)
                {
                    if (i==0) { printWriter.print(queueOne[j] + " "); }
                    if (i==1) { printWriter.print(queueTwo[j] + " "); }
                    if (i==2) { printWriter.print(queueThree[j] + " "); }
                }
                if (i==3) { printWriter.print(fuelStock);}
                printWriter.println();
            }
            fuelFile.close();
            System.out.println("Successfully store the data to the file");
        }
        catch (IOException ioException)
        {
            System.out.println("This file already exists!");
        }
    }

    public static void loadDataFromFile()
    {
        /*
            Loading data from the file
         */

        try {
            File fuelFile = new File("Fuel Management System - Galle.txt");
            Scanner scanner = new Scanner(fuelFile);
            for (int i=0;i<4;i++)
            {
                for (int j=0;j<6;j++)
                {
                    if (scanner.hasNext())
                    {
                        if (i==0)
                        {
                            queueOne[j] = scanner.next();
                            if (queueOne[j].equals("null")) { queueOne[j] = null; }
                        }

                        if (i==1)
                        {
                            queueTwo[j] = scanner.next();
                            if (queueTwo[j].equals("null")) { queueTwo[j] = null; }
                        }

                        if (i==2)
                        {
                            queueThree[j] = scanner.next();
                            if (queueThree[j].equals("null")) { queueThree[j] = null; }
                        }

                        if (i==3) { fuelStock = Integer.parseInt(scanner.next());}
                    }
                }
            }
            scanner.close();
            System.out.println("Successfully load the data from the file");
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.out.println("This file is not found.Try again!");
        }
    }

    public static void viewRemainingStock()
    {
        /*
            Display the remaining amount of Fuel Stock
         */

        System.out.println("Remaining Fuel Stock: " + fuelStock + "L");
    }

    public static void addFuelStock()
    {
        /*
            Adding Fuel to the Stock
         */

        try {
            System.out.print("Enter the amount of fuel you need to add to the stock: ");
            int addFuelAmount = input.nextInt();
            fuelStock += addFuelAmount;
            System.out.print("Successfully added " + addFuelAmount + "L of fuel to the stock.\n\nDo you want to view the current stock?(Y/N) ");
            String viewStock = input.next().toUpperCase();
            if (viewStock.equals("Y"))
            {
                viewRemainingStock();
            }
        }
        catch (InputMismatchException inputMismatchException)
        {
            input.nextLine();
            System.out.println("Invalid Input.Try Again");
        }
    }

    public static void viewWarningMessage()
    {
        /*
           When the Fuel Stock reached 500L ---> Printing a Warning Message of the remaining amount of Fuel
         */

        System.out.println("Alert Message: " + fuelStock +"L of fuel are remaining in the Current Fuel Stock!!!");

    }

    public static void main(String[] args)
    {
        System.out.println("\t...Welcome to the Fuel Queue Management System - Galle...\n");
        System.out.println("""
                ***************************************************************************************************
                100 or VFQ:    View all Fuel Queues.
                101 or VEQ:    View all Empty Queues.
                102 or ACQ:    Add customer to a Queue.
                103 or RCQ:    Remove a customer from a Queue. (From a specific location)
                104 or PCQ:    Remove a served customer.
                105 or VCS:    View Customers Sorted in alphabetical order (Do not use library sort routine)
                106 or SPD:    Store Program Data into file.
                107 or LPD:    Load Program Data from file.
                108 or STK:    View Remaining Fuel Stock.
                109 or AFS:    Add Fuel Stock.
                999 or EXT:    Exit the Program.
                ***************************************************************************************************
                """);

        boolean controller = true;
        while (controller)
        {
            System.out.print("\nSelect the correct operator from the console menu: ");
            String choice = input.next();

            if (choice.equals("100") || choice.equalsIgnoreCase("VFQ"))
            {
                viewAllQueues();
            }
            else if (choice.equals("101") || choice.equalsIgnoreCase("VEQ"))
            {
                viewEmptyQueues();
            }
            else if (choice.equals("102") || choice.equalsIgnoreCase("ACQ"))
            {
                addCustomer();
            }
            else if (choice.equals("103") || choice.equalsIgnoreCase("RCQ"))
            {
                removeCustomer();
            }
            else if (choice.equals("104") || choice.equalsIgnoreCase("PCQ"))
            {
                removeServedCustomer();
            }
            else if (choice.equals("105") || choice.equalsIgnoreCase("VCS"))
            {
                sortInAlphabeticalOrder();
            }
            else if (choice.equals("106") || choice.equalsIgnoreCase("SPD"))
            {
                storeDataToFile();
            }
            else if (choice.equals("107") || choice.equalsIgnoreCase("LPD"))
            {
                loadDataFromFile();
            }
            else if (choice.equals("108") || choice.equalsIgnoreCase("STK"))
            {
                viewRemainingStock();
            }
            else if (choice.equals("109") || choice.equalsIgnoreCase("AFS"))
            {
                addFuelStock();
            }
            else if (choice.equals("999") || choice.equalsIgnoreCase("EXT"))
            {
                System.out.println("Thank you!!! Have a nice day");
                controller=false;
            }
            else
            {
                System.out.println("Invalid operator");
            }
        }
    }
}