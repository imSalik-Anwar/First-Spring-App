package com.example.student.management.app;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentRepository {
    Map<Integer, Student> db = new HashMap<>();

    public String addStudent(Student s) {
        if(db.containsKey(s.getRegNo())){
            return "Student is already registered";
        } else {
            db.put(s.getRegNo(), s);
        }
        return "Student registered successfully";
    }

    public Student getStudentUsingReqParam(int regNo) {
        return db.get(regNo);
    }

    public Student getStudentUsingPathVar(int regNo) {
        return db.get(regNo);
    }

    public String updateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
        return "Age updated";
    }

    public String deleteStudentUsingReqParam(int regNo) {
        if(db.containsKey(regNo)){
            db.remove(regNo);
            return "Student deleted";
        }
        return "Student does not exist";
    }

    public String deleteStudentUsingPathVar(int regNo) {
        if(db.containsKey(regNo)){
            db.remove(regNo);
            return "Student deleted";
        }
        return "Student does not exist";
    }

    public String changeCourseUsingBothReqParam(int regNo, String newCourse) {
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    public String changeCourseUsingBothPathVar(int regNo, String newCourse) {
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    public String changeCourseUsingOneReqParamOnePathVar(int regNo, String newCourse) {
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    public String changeCourseAndAge(int regNo, Student s) {
        if(db.containsKey(regNo)){
            String newCourse = s.getCourse();
            int newAge = s.getAge();
            db.get(regNo).setCourse(newCourse);
            db.get(regNo).setAge(newAge);
            return "Course and age updated";
        }
        return "Student does not exist";
    }
}
