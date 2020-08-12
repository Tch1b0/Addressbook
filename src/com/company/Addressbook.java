package com.company;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public abstract class Addressbook {

    public static Person p = new Person();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            scanner.reset();
            System.out.println(">write(w) read(r) save(s) exit(e)<");
            String mode = scanner.nextLine();
            if (mode.startsWith("w")) register();
            else if (mode.startsWith("r")) readMenu();
            else if (mode.startsWith("s")) save(p.getName(),p.getAge());
            else if (mode.startsWith("e")) System.exit(0);
        }
    }
    static void register(){
        if (p.getName().length() > 2 & p.getAge() == 0) {
            System.out.println("This Persons information already got entered");
        }
        while (p.getName().length() < 2 ) {             //while the entered name has got less than 2 characters
            System.out.println("Enter your name:");
            String name = scanner.nextLine();           //you enter a name...
            p.setName(name);                            //...and it gets set
        }
        while (p.getAge() == 0){                        //while the age is 0
            try
            {
                System.out.println("Enter your age:");
                int age = scanner.nextInt();            //you enter an age...
                p.setAge(age);                          //...and it gets set

            }
            catch (Exception e)                         //if not a number but a String got entered
            {
                System.out.println("That's not a number");
                System.exit(0);                   //the program gets closed (because of a current bug)
            }
        }

    }


    public static void save(String name, int age){

        File file = new File("contacts.csv");
        try
        {
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =  new PrintWriter(bw);

            pw.println(name+","+age);
            pw.flush();
            pw.close();

            System.out.println("*** Successfully saved "+name+" ***\n");
        }
        catch (Exception e)
        {
            System.out.println("*** "+name+" could not get saved ***\n");
        }
    }
    static void readMenu(){
        System.out.println(">>list all(a) certain person(name of person) go back(e)<<"); //the '>>' are there so you know you are not in the main menu
        String readmode = scanner.nextLine();

        if (readmode.startsWith("a") ) readAll();
        else{
            System.out.println("This feature is still being developed");
        }
    }

    static void readAll(){
        File file = new File("contacts.csv");
        try
        {
            Scanner inputStream = new Scanner(file);
            inputStream.next();
            while (inputStream.hasNext()){               //while the current line has a next line
                String data = inputStream.next();
                String[] place = data.split(",");  //the info gets separated with a comma
                System.out.println(place[0]);            //prints out a line
            }
            inputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
