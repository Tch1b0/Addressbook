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

        while (true) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            p.setName(name);

            try {
                System.out.println("Enter your age:");
                byte age = scanner.nextByte();
                p.setAge(age);
                break;
            }
            catch (Exception e) {
                System.out.println("I am sure you are not that old");
                System.exit(0);
            }
        }

    }
    static void read(){
        System.out.println("Name: "+p.getName());
        System.out.println("Age: "+p.getAge());
    }
}
