package com.driver;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository() ;
    public void addStudent(Student student) {
        studentRepository.addS(student) ;
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addT(teacher);
    }

    public void addPair(String student, String teacher) {
        studentRepository.addP(student,teacher);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name) ;
    }


    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name) ;
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return studentRepository.getStudentByTeacherName(teacher)  ;
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents() ;
    }

    public void deleteTeacherByName(String teacher) {
         studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
