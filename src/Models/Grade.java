package Models;

import java.util.ArrayList;

public class Grade {

    String code;
    String neme ;
    Teacher teacher;
    ArrayList<Student> students;

    public Grade(String code, String neme) {
        this.code = code;
        this.neme = neme;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNeme() {
        return neme;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void  addStudent(Student student){
        this.students.add(student);
    }

    public void  removeStudent(Student student){
        this.students.add(student);
    }


}
