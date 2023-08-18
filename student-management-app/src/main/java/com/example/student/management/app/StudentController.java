package com.example.student.management.app;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
    Map<Integer, Student> db = new HashMap<>();

    // Taking input using RequestBody
    @PostMapping("/addstudent") // URL: localhost:8080/addstudent
    public  String addStudent(@RequestBody Student s){
        if(db.containsKey(s.getRegNo())){
            return "Student is already registered";
        } else {
            db.put(s.getRegNo(), s);
        }
        return "Student registered successfully";
    }

    // Taking input using RequestParam
    @GetMapping("/getstudent") // URL: localhost:8080/getstudent?q=value
    public Student getStudentUsingReqParam(@RequestParam("id") int regNo){
            return db.get(regNo);
    }

    // Taking input using PathVariable
    @GetMapping("/getstudent/{id}") // URL: localhost:8080/getstudent/value
    public Student getStudentUsingPathVar(@PathVariable("id") int regNo){
        return db.get(regNo);
    }

    // Taking input using more than one RequestParam
    @PutMapping("/updatestudentage") // URL: localhost:8080/updatestudentage?id=value&age=value
    public String updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
        db.get(regNo).setAge(newAge);
        return "Age updated";
    }

    // delete a student  --> request param
    @DeleteMapping("/deletestudentusingreqparam") // URL: localhost:8080/deletestudentusingreqparam?id=value
    public String deleteStudentUsingReqParam(@RequestParam("id") int regNo){
        if(db.containsKey(regNo)){
            db.remove(regNo);
            return "Student deleted";
        }
        return "Student does not exist";
    }

    // delete a student ---> path variable
    @DeleteMapping("/deletestudentusingpathvar/{id}") // URL: localhost:8080/deletestudentusingpathvar/value
    public String deleteStudentUsingPathVar(@PathVariable("id") int regNo){
        if(db.containsKey(regNo)){
            db.remove(regNo);
            return "Student deleted";
        }
        return "Student does not exist";
    }

    // change course of a student (regNo, course)  ---> Both as request params
    @PutMapping("/changecourseusingbothreqparam") // URL: localhost:8080/changecourseusingbothreqparam?id=value&course=value
    public String changeCourseUsingBothReqParam(@RequestParam("id") int regNo, @RequestParam("course") String newCourse){
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    // change course of a student(regNo, newCourse)  ----> Both as path variables
    @PutMapping("/changecourseusingbothpathvar/{id}/{course}") // URL: localhost:8080/changecourseusingbothpathvar/value/value
    public String changeCourseUsingBothPathVar(@PathVariable("id") int regNo, @PathVariable("course") String newCourse){
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    // change course (regNo, newCourse) --> One as request param, one as path variable
    @PutMapping("/changecourseusingonereqparamonepathvar/{id}") // URL: localhost:8080/changecourseusingonereqparamonepathvar/value?course=value
    public String changeCourseUsingOneReqParamOnePathVar(@PathVariable("id") int regNo, @RequestParam("course") String newCourse){
        if(db.containsKey(regNo)){
            db.get(regNo).setCourse(newCourse);
            return "Course updated";
        }
        return "Student does not exist";
    }

    // change course and age ---> regNo as request param, entire student object as request body
    @PutMapping("/changecourseandage") // URL: not done
    public String changeCourseAndAge(@RequestParam("id") int regNo, Student s){
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
