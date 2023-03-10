import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
public class file_handling {
    public static void main(String[]args){
        char [] ddd= {'1','2','3'};
        try{
       File file=new File("text.txt");
            Scanner  sc=new Scanner(file);
        //boolean file_created = file.createNewFile();

        /*if(file_created){
            System.out.println("file successfully created"+file.getName());
        }
       else if(file.exists()){
            System.out.println("file already exist");

        }
        else {
            System.out.println("file creation unsuccessfull");
        }

       FileWriter write_file= new FileWriter("text.txt");
        for (char value:ddd){
            write_file.write(value );
            }write_file.close();

            char [] ccc= new char[ddd.length];
            int i=0;
            while(sc.hasNext()){

            char cc=sc.next().charAt(0);
               for(int i:ccc.length){
            }sc.close();


        }
        catch (IOException ex){
            ex.printStackTrace();

            //System.out.println(ex);
        }


    }
}
*/


public class file_handling {

    String name;
    String work;
    int age;
   double salary=10000;



    file_handling(String name, String work, int age,double salary){
        this.name=name;
        this.work=work;
        this.age=age;
        this.salary=salary;

    }
    void raise_salary(){
        this.salary=this.salary+10000;
    }

    void reduce_salary(){
        this.salary=this.salary-10000;
    }
}