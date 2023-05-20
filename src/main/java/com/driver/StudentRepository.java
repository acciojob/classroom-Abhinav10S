package com.driver;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap  ;

public class StudentRepository {
    private List<Student> studentData = new ArrayList<>() ;
    private List<Teacher> teacherData = new ArrayList<>() ;
    private Map <Teacher,List<Student>> studentTeacherPair = new HashMap <>() ;


    public void addS(Student student) {
        studentData.add(student) ;
    }

    public void addT(Teacher teacher) {
        teacherData.add(teacher)  ;
    }

    public void addP(String student, String teacher) {
        Teacher teacher1 = getTeacherByName(teacher);
        Student student1 = getStudentByName(student) ;

        List<Student> list = studentTeacherPair.getOrDefault(teacher1,new ArrayList <Student> () ) ;
        list.add(student1);
        studentTeacherPair.put(teacher1,list) ;
    }


    public Student getStudentByName(String name) {
        for (Student student : studentData){
            if(student.getName().equals(name)) return student ;
        }
        return new Student () ;
    }

    public Teacher getTeacherByName(String name) {
        for (Teacher teacher : teacherData){
            if(teacher.getName().equals(name)) return teacher ;
        }
        return new Teacher() ;
    }

    public List<String> getStudentByTeacherName(String teacher) {
        List<String> allStudentByTeacher=new ArrayList<>();
        Teacher teacher1=getTeacherByName(teacher);
        List<Student> studentList=studentTeacherPair.getOrDefault(teacher1,new ArrayList<>());
        for(Student student:studentList){
            allStudentByTeacher.add(student.getName());
        }
        return allStudentByTeacher;
    }

    public List<String> getAllStudents() {
        List<String> allStudentsList = new ArrayList<>() ;
        for ( Student student : studentData){
            allStudentsList.add(student.getName()) ;
        }
        return allStudentsList ;
    }

    public void deleteTeacherByName(String teacher) {
        Teacher teacher1 = getTeacherByName(teacher) ;
        List<Student> listOfRemoveStudent = studentTeacherPair.getOrDefault(teacher1 , new ArrayList <>()) ;
        for (Student student : listOfRemoveStudent){
            studentData.remove(student) ;
        }
        studentTeacherPair.remove(teacher1) ;
        teacherData.remove(teacher1) ;
    }

    public void deleteAllTeachers() {
        for (Teacher teacher : new ArrayList<>(teacherData)){
            deleteTeacherByName(teacher.getName());
        }
        teacherData.clear();
        studentTeacherPair.clear();
    }
}
