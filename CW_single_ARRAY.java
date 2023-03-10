//importing necessary packages ie scanner,file handle,error handle

import java.util.ArrayList;
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.stream.Collectors;


public class CW_single_ARRAY {
    //defining 3 single dimension arrays to store values
    //usage of char allows to get the desired 'x' out put for seat taken

    static char[] row1 = new char[12];
    static char[] row2 = new char[16];
    static char[] row3 = new char[20];



    //an empty unknown length of ticket class array  to store ticket info
    static ArrayList<Ticket> ticket_list= new ArrayList<Ticket>();
    static ArrayList<Ticket> ticket_list_sorted= new ArrayList<Ticket>();


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);//defining a scanner object for input purpose

        //a control variable to adjust the while loop flow

        int input = '9';




        // a boolean controller to get an integer input

        boolean input_is_int = true;









        //setting a default value for arrays to differentiate inputs

        array_0();





        //setting a while loop to keep the user engage in multiple choices until he ends it
        while (input != '0') {
            //interface for the programme
            System.out.println("\n" + "-".repeat(16));
            System.out.println("\n" + "Welcome to the new theatre" + "\n");
            System.out.println("-".repeat(16) + "\n");


            System.out.println("*".repeat(4) + "please select an option below" + "*".repeat(4) + "\n" + "\n" +
                    "\n1) Buy a ticket" +
                    "\n2) Print seating area" +
                    "\n3) Cancel ticket" +
                    "\n4) List available seats" +
                    "\n5) Save to file" +
                    "\n6) Load from file" +
                    "\n7) Print ticket information and total price" +
                    "\n8) Sort tickets by price" +
                    "\n      " + "0) Quit");

            System.out.println("-".repeat(10) + "\nenter an option");

            //making sure the input is an integer

            do {
                try {
                    input = scan.nextInt();
                    input_is_int = false;
                } catch (Exception e) {
                    System.out.println("enter a valid response");
                    scan.nextLine();//disregard the nex line to continue

                }
            }
            while (input_is_int);

            //if else statements to divert to user choice
            if (input == 1) {
                int x = 9; // a control variable to adjust the while loop flow
                while (x != 0) {
                    System.out.println("enter the seat row");
                    int srow = scan.nextInt();//getting the user input for the row

                    //diverting user input according to seat row
                    if (srow == 1) {

                        buy_ticket(row1,10,1,ticket_list);


                    } else if (srow == 2) {

                        buy_ticket(row2,20,2,ticket_list);
                    } else if (srow == 3) {

                        buy_ticket(row3,30,3,ticket_list);
                    } else {
                        System.out.println("invalid input.available rows -1,2,3\n");
                        continue;
                    }
                    for(int i=0;i<ticket_list.size();i++){
                        Ticket l=ticket_list.get(i);
                        l.print();
                    }
                    //to purchase of multiple seats

                    System.out.println("\n" + "\n" + "Do you wanna purchase more tickets?" + "\nif yes enter 1" + "\nif no enter 0");

                    x = scan.nextInt();
                    //continue;


                }

            } else if (input == 2) {

                seatings_p();

            } else if (input == 0) {
                //end the programme
                System.out.println("thank you until next time!!!!");
                break;
            } else if (input == 3) {
                int e = 9;


                while (e != 0) {


                    System.out.println("enter the seat row");
                    int srow = scan.nextInt();
                    //replacing the default value to purchased items
                    if (srow == 1) {

                        cancel_s(row1,ticket_list);


                    } else if (srow == 2) {
                        cancel_s(row2,ticket_list);

                    } else if (srow == 3) {
                        cancel_s(row3,ticket_list);

                    } else//rows in range
                    {
                        System.out.println("invalid input.available rows -1,2,3\n");
                        continue;
                    }


                    System.out.println("\n" + "\n" + "Do you want to cancel additional tickets?" + "\nif yes enter any button" + "\nif no enter 0");

                    e = scan.nextInt();
                    continue;
                }


            } else if (input == 4) {
                System.out.println("\n" + "the available rows are" + "\n");
                available_s();
            } else if (input == 5) {
                save_f();

            } else if (input == 6) {
                load_f();
                //check if the loaded data is correct

               /*loop_for(row1);
                loop_for(row2);
                loop_for(row3);*/

            }
            else if (input==7){
                print_ticket_info();

            }
            /*else if (input==8){
                sort_tickets();

            }*/
            else{

            }

        }

    }
				/*
				else if (input==7){
					}



				else{
				   continue;	 }*/



    //giving the arrays a default visible value
    public static void array_0() {


        char c = '0';

        for (int s = 0; s < row1.length; s++) {

            row1[s] = c;

        }
        for (int s = 0; s < row2.length; s++) {

            row2[s] = c;

        }
        for (int s = 0; s < row3.length; s++) {

            row3[s] = c;

        }


    }

    // minimizing the repetition of stage ui
    public static void stage(char[] row) {
        System.out.println(" ".repeat((row.length + 3)) + " *".repeat(4));
        System.out.println(" ".repeat((row.length + 5)) + "STAGE");
        System.out.println(" ".repeat((row.length + 3)) + " *".repeat(4));

        System.out.print(" ".repeat(6));
    }

    //minimizing the repetition of seat arrangement
    public static void loop_for(char[] row) {

        for (int l = 0; l < row.length; l++) {


            if (l == (row.length) / 2) {
                System.out.print(" ".repeat(3) + row[l] + "|");
            } else {

                System.out.print(row[l] + "|");
            }
        }
    }


    public static void buy_ticket(char[] row,int price,int row_number,ArrayList<Ticket> ticket_list) {

        //defining a scanner object to take seat input after requiring row

        Scanner scan = new Scanner(System.in);
        //getting the user info from person as an object

        System.out.println("please enter your details");


        System.out.println("please enter your name");
        String name_person = scan.next();
        System.out.println("please enter your surname");
        String sur_name_person = scan.next();
        System.out.println("please enter your email address");
        String email_person = scan.next();

        person person1 = new person(name_person, sur_name_person, email_person);
        System.out.println(person1.name + " " + person1.email + " " + person1.sur_name);





        stage(row);
        loop_for(row);

        System.out.println("\n" + "\n" + "enter the required seat number-(1-" + row.length + ")" + "\n" +
                "available- 0" + "\n" + "unavailable- x" + "\n");


        int snum = scan.nextInt();
        char temp = 'X';
        //replacing the default empty array value by 'X' to show purchase
        row[snum - 1] = temp;


        stage(row);
        loop_for(row);
        //creating a new ticket object with row,seat,price and first personal

        Ticket ticket=new Ticket(row_number,snum,price,person1);

        ticket_list.add(ticket);




    }


    public static void seatings_p() {

        System.out.println(" ".repeat((19)) + " *".repeat(4));
        System.out.println(" ".repeat((21)) + "STAGE");
        System.out.println(" ".repeat((19)) + " *".repeat(4));

        System.out.print(" ".repeat(10));

        loop_for(row1);


        System.out.println("");
        System.out.print(" ".repeat(6));

        loop_for(row2);

        System.out.println("");
        System.out.print(" ".repeat(2));

        loop_for(row3);
    }


    public static void cancel_s(char[] row, ArrayList<Ticket> ticket_list) {
        Scanner scan = new Scanner(System.in);// defining a scanner object to take seat input after requiring row

        stage(row);

        loop_for(row);


        System.out.println("\n" + "\n" + "enter the  seat number required to be canceled-(1-" + row.length + ")" + "\n" +
                "available- 0" + "\n" + "unavailable- x" + "\n");


        int snum = scan.nextInt();//continuity

        //checking if purchased or not before cancelling
        if (row[snum - 1] != 'X') {

            System.out.println("This seat is not purchased");
            return;

        } else {
            char temp = '0';
            row[snum - 1] = temp;


            //1st method`
            //prompting user to manually remove the ticket lessening the error that could occur

            /* ticket_list.remove(ticket_number-1);*/


            }
            System.out.println("\n"+"available tickets"+"\n");
            for(int i=0;i<ticket_list.size();i++){

                Ticket ticket=ticket_list.get(i);
                System.out.print("ticket number:"+ticket_list.indexOf(ticket));
                ticket.print();
            }
            System.out.println("select the ticket-number you want to remove");
            int ticket_number=scan.nextInt();

            //2 method
            //automatically removing the ticket successively purchased
            //disadvantages:only removes the ticket which was purchased right before
            /* ticket_list.remove(ticket_number-1);*/

            System.out.println("this ticket has been removed");
            ticket_list.get(ticket_number).print();
            ticket_list.remove(ticket_number);













            stage(row);

            loop_for(row);
        }




    public static void avail_seat(char[] row, char a) {
        int count = 0;//to keep the purchased seat count per row
        System.out.print("row" + a + ":");
        for (int s = 0; s < row.length; s++) {
            //prints the index of available seats

            if (row[s] == 'X') {
                count++;
                continue;//skip the printing of purchased seat

            } else {
                System.out.print((s + 1) + " ");
            }
        }
        System.out.print(" [only " + (row.length - count) + " available]");
        System.out.println("");

    }

    public static void available_s() {
        avail_seat(row1, '1');

        avail_seat(row2, '2');

        avail_seat(row3, '3');

    }


    public static void save_f() {
        //try block to avoid errors interrupting the programme
        try {
            File file = new File("SEATINGS.txt");//creating a file
            FileWriter file_writer = new FileWriter("SEATINGS.txt");//creating the file writer object

            file_writer.write("row1:");
            //writing the index values of each arrays
            for (char value : row1) {

                file_writer.write(value );


            }
            file_writer.write("row2:");
            for (char value : row2) {

                file_writer.write(value );


            }
            file_writer.write("row3:");
            for (char value : row3) {

                file_writer.write(value );


            }
            file_writer.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("row data saved successfully");

    }

    public static void load_f( ) {



        try {

            File file = new File("SEATINGS.txt");//creating a file
            Scanner file_reader = new Scanner(file);//creating a scanner object
            String  d=null;//using null string to convert the file items to a string

            int j=0,l=0,m=0;//initiallizing 3 diff  count var for the for loop ahead
            while (file_reader.hasNext()) {
                for (int i=0; file_reader.hasNext();i++){

                    d = file_reader.nextLine();//converting file items to a single string
                }


            }
            file_reader.close();

            //assigning seat values to the original char array
            //seat values are obtained by removing the unnecessary char's

            //row1
            for (int i=5; i<17;i++){

                assert d != null;
                row1[j]=d.charAt(i);
                // System.out.print(row1[j]);
                j++;

            }


            //row2
            for (int i=22; i<38;i++){

                row2[l]=d.charAt(i);
                //System.out.print(row2[l]);
                l++;

            }


            //row3
            for (int i=43; i<63;i++){
                row3[m]=d.charAt(i);
                //System.out.print(row3[m]);
                m++;

            }


            //loop_for(rows);



        } catch (IOException ex) {
            System.out.println(ex);
        }System.out.println("row data loaded successfully");



    }

    public static void print_ticket_info(){
        float total_ticket_price=0;
        for (Ticket l : ticket_list) {
            l.print();
        }
        System.out.println("\n"+"the  total price:");
        for (Ticket l : ticket_list) {
            total_ticket_price = total_ticket_price + l.price;
        }
        System.out.print(total_ticket_price);


    }
   /* public List<String> sortList() {
        List<String> listString = memberList.stream().map(DefaultMember::getMemberFullName).collect(Collectors.toList());
        System.out.println(listString.stream().sorted().collect(Collectors.toList()));
        System.out.println("Sorted!");
        return listString.stream().sorted().collect(Collectors.toList());
    }*/

    public static void sort_tickets(ArrayList<Ticket> ticket_list) {





    }




}

























