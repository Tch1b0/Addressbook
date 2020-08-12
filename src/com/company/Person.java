package com.company;

public class Person {

    String name = "a"; //this is the standard 'name'
    int age = 0;       //this is the standard 'age'
    String country = "unknown";

    void setName(String name){
        this.name = name;
    }
    String getName() {
        return this.name;
    }

    void setAge(int age){
        this.age = age;
    }
    int getAge(){
        return this.age;
    }

    void setCountry(String country){
        this.country = country;
    }
    String getCountry(){
        return this.country;
    }
}
