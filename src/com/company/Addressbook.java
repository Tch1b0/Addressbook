package com.company;
import java.util.Scanner;

public class Addressbook {

    public static Person p = new Person();

    public static void main(String[] args){
        register();
        read();
    }
    static void register(){

        Scanner scanner = new
                Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        p.setName(name);

        System.out.println("Enter your age:");
        try {
            byte age = scanner.nextByte();
            p.setAge(age);
        }
        catch(Exception e){
            System.out.println("I am sure you are not that old");
        }

    }
    static void read(){
        System.out.println("Name: "+p.getName());
        System.out.println("Age: "+p.getAge());
    }
}
