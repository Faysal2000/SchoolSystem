package services;

import Models.Grade;
import Models.School;
import Models.Student;
import Models.Teacher;

public class SchoolServices {

    School school;

    public SchoolServices(School school) {
        this.school = school;
    }

    public SchoolServices() {
    }

    public School getSchool() {
        return school;
    }

    public void addStudent(Student student){

        this.school.getStudents().add(student);

    }
    public  void  addTeacher(Teacher teacher){
        this.school.getTeachers().add(teacher);

    }
    public void addGrade(Grade grade){
        this.school.getGrades().add(grade);
    }

     public void removeStudent(Student student){
        this.school.getStudents().remove(student);
     }

    public void removeTeacher(Teacher teacher){
        this.school.getStudents().remove(teacher);
    }

    public void removeGrade(Grade grade){
        this.school.getStudents().remove(grade);
    }

    public Student getStudentByName(String name){

        for(Student student: this.school.getStudents()){
            if(student.getName().toUpperCase().equals(name.toUpperCase())){
                return student;
            }
        }
        return null;

    }


    public Teacher getTeacherByName(String name){

        for(Teacher teacher: this.school.getTeachers()){
            if(teacher.getName().toUpperCase().equals(name.toUpperCase())){
                return teacher;
            }
        }
        return null;

    }


    public Grade getGradeByName(String code){

        for(Grade grade: this.school.getGrades()){
            if(grade.getCode().equals(code)){
                return grade;
            }
        }
        return null;

    }





}
