package Main;

import Models.Person;
import Models.School;
import Models.Student;
import Models.Teacher;
import services.SchoolServices;
import tools.Action;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;

public class Hmi {


    private static SchoolServices schoolServices;
    private static Random reader;

    public static void start(){
        Scanner scanner= new Scanner(System.in);
       School school= Hmi.createSchool();
        System.out.println("Welcome to  "+ school.getName() + " in "+ school.getAddress());
        String action;

        do{
            System.out.println("what do you want to do ?");
            action = scanner.next();



            switch (action){
                case "addStudent":
                    Hmi.addStudent();
                    break;

                case "printAllStudents":
                    Hmi.printAllStudents();
                    break;

                case "addTeacher":
                    Hmi.addTeacher();
                    break;

                case "printAllTeacher":
                    Hmi.printAllTeacher();
                    break;

                case "findStudentByName":
                    Hmi.printDataPerson(Action.STUDENT);
                    break;

                case "findTeacherByName":
                    Hmi.printPersonByName(Action.TEACHER);
                    break;

                case "removeStudent":
                    Hmi.removePerson(Action.STUDENT);
                    break;

                case "removeTeacher":
                    Hmi.removePerson(Action.TEACHER);
                    break;    





            }

        }while (!action.equals("exit"));




    }

    private static void printDataPerson(Action action) {
    }

    private static School createSchool(){
        School school = new School();
        school.setName("FIRAT UNIVERSITY ");
        school.setAddress("turkey");
        school.setPhoneNumber("535 555 55 55");
        Hmi.schoolServices=new SchoolServices(school);

        return school;

    }

    public static void addStudent(){
        Scanner scanner= new Scanner(System.in);
        Student student = new Student();
        Hmi.setDataPerson(student);
        Hmi.schoolServices.addStudent(student);

    }
    public static void addTeacher(){
        Scanner scanner= new Scanner(System.in);
        Teacher teacher = new Teacher();
        Hmi.setDataPerson(teacher);
        Hmi.schoolServices.addTeacher(teacher);
    }
    public static void printAllStudents(){
        for(Student student : Hmi.schoolServices.getSchool().getStudents()){
            System.out.println(student.getData());
        }

    }
    public static void printAllTeacher(){
        for(Teacher teacher : Hmi.schoolServices.getSchool().getTeachers()){
            System.out.println(teacher.getData());
        }

    }
    private static void setDataPerson(Person p ){
        Scanner scanner= new Scanner(System.in);
        System.out.println("plase enter the name");
        p.setName(scanner.next());
        System.out.println("plase enter the age");
        p.setAge(scanner.nextInt());

        if(p instanceof Teacher){
            System.out.println("plase enter the salary");
            ((Teacher) p).setSalary(reader.nextFloat());
         }else if(p instanceof Student){
            System.out.println("plase enter the phone number");
            ((Student) p).setParentPhoneNumber(scanner.next());
        }
    }


    private static void printPersonByName(Action action){
         Person p = Hmi.findPersonByName(action);
         Hmi.printDataPerson(p);
    }

    private static void printDataPerson(Person person){

        if(person == null){
            System.out.println("Name not find");
        }else{
            System.out.println(person.getData());
        }
    }
    private static Person findPersonByName(Action action){

        Scanner reader = new Scanner(System.in);

        System.out.println("plase enter the name");
        String name = reader.next();
        Person p;
        if(action == Action.STUDENT){
              p = Hmi.schoolServices.getStudentByName(name);
        }
        else{
            p = Hmi.schoolServices.getTeacherByName(name);
        }

        if(p == null){
            System.out.println("Name not find");
        }else{
            System.out.println(p.getData());
        }
        return p;

    }

    private static void removePerson(Action action){
        Person p = Hmi.findPersonByName(action);
        if(p instanceof Student) {
            Hmi.schoolServices.removeStudent((Student) p);
        }else{
            Hmi.schoolServices.removeTeacher((Teacher) p);
        }
    }

}
