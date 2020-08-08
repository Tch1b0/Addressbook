package com.company;
import java.util.Scanner;

public class Addressbook {

    public static Person p = new Person();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        register();
        read();
    }
    static void register(){

        while (p.getName().length() < 2 ) {          //while the entered name has less than 2 characters
            System.out.println("Enter your name:");
            String name = scanner.nextLine();        //you enter a name...
            p.setName(name);                         //...and it gets set
        }
        while (p.getAge() == 0){                     //while the age is 0
            try {
                System.out.println("Enter your age:");
                int age = scanner.nextInt();         //you enter an age...
                p.setAge(age);                       //...and it gets set

            } catch (Exception e) {                  //if not a number but a String got entered
                System.out.println("That's not a number");
                System.exit(0);                //the program gets closed (because of a current bug)
            }
        }

    }
    static void read(){
        System.out.println('\n'+"Name: "+p.getName()); //the name entered in register gets printed out
        System.out.println("Age: "+p.getAge());        //the age entered in register gets printed out
    }
}
