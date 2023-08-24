package com.example.student.management.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student s) {
        return studentRepository.addStudent(s);
    }

    public Student getStudentUsingReqParam(int regNo) {
        return studentRepository.getStudentUsingReqParam(regNo);
    }

    public Student getStudentUsingPathVar(int regNo) {
       return studentRepository.getStudentUsingPathVar(regNo);
    }

    public String updateAge(int regNo, int newAge) {
        return studentRepository.updateAge(regNo, newAge);
    }

    public String deleteStudentUsingReqParam(int regNo) {
        return studentRepository.deleteStudentUsingReqParam(regNo);
    }

    public String deleteStudentUsingPathVar(int regNo) {
        return studentRepository.deleteStudentUsingPathVar(regNo);
    }

    public String changeCourseUsingBothReqParam(int regNo, String newCourse) {
        return studentRepository.changeCourseUsingBothReqParam(regNo, newCourse);
    }

    public String changeCourseUsingBothPathVar(int regNo, String newCourse) {
        return studentRepository.changeCourseUsingBothPathVar(regNo, newCourse);
    }

    public String changeCourseUsingOneReqParamOnePathVar(int regNo, String newCourse) {
        return studentRepository.changeCourseUsingOneReqParamOnePathVar(regNo, newCourse);
    }

    public String changeCourseAndAge(int regNo, Student s) {
        return studentRepository.changeCourseAndAge(regNo, s);
    }
}
