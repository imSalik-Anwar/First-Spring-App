package com.example.student.management.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    // Taking input using RequestBody
    @PostMapping("/addstudent") // URL: localhost:8080/addstudent
    public  String addStudent(@RequestBody Student s){
        return studentService.addStudent(s);
    }

    // Taking input using RequestParam
    @GetMapping("/getstudent") // URL: localhost:8080/getstudent?id=value
    public Student getStudentUsingReqParam(@RequestParam("id") int regNo){
            return studentService.getStudentUsingReqParam(regNo);
    }

    // Taking input using PathVariable
    @GetMapping("/getstudent/{id}") // URL: localhost:8080/getstudent/value
    public Student getStudentUsingPathVar(@PathVariable("id") int regNo){
        return studentService.getStudentUsingPathVar(regNo);
    }

    // Taking input using more than one RequestParam
    @PutMapping("/updatestudentage") // URL: localhost:8080/updatestudentage?id=value&age=value
    public String updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
        return studentService.updateAge(regNo, newAge);
    }

    // delete a student  --> request param
    @DeleteMapping("/deletestudentusingreqparam") // URL: localhost:8080/deletestudentusingreqparam?id=value
    public String deleteStudentUsingReqParam(@RequestParam("id") int regNo){
        return studentService.deleteStudentUsingReqParam(regNo);
    }

    // delete a student ---> path variable
    @DeleteMapping("/deletestudentusingpathvar/{id}") // URL: localhost:8080/deletestudentusingpathvar/value
    public String deleteStudentUsingPathVar(@PathVariable("id") int regNo){
        return studentService.deleteStudentUsingPathVar(regNo);
    }

    // change course of a student (regNo, course)  ---> Both as request params
    @PutMapping("/changecourseusingbothreqparam") // URL: localhost:8080/changecourseusingbothreqparam?id=value&course=value
    public String changeCourseUsingBothReqParam(@RequestParam("id") int regNo, @RequestParam("course") String newCourse){
        return studentService.changeCourseUsingBothReqParam(regNo, newCourse);
    }

    // change course of a student(regNo, newCourse)  ----> Both as path variables
    @PutMapping("/changecourseusingbothpathvar/{id}/{course}") // URL: localhost:8080/changecourseusingbothpathvar/value/value
    public String changeCourseUsingBothPathVar(@PathVariable("id") int regNo, @PathVariable("course") String newCourse){
        return studentService.changeCourseUsingBothPathVar(regNo, newCourse);
    }

    // change course (regNo, newCourse) --> One as request param, one as path variable
    @PutMapping("/changecourseusingonereqparamonepathvar/{id}") // URL: localhost:8080/changecourseusingonereqparamonepathvar/value?course=value
    public String changeCourseUsingOneReqParamOnePathVar(@PathVariable("id") int regNo, @RequestParam("course") String newCourse){
        return studentService.changeCourseUsingOneReqParamOnePathVar(regNo, newCourse);
    }

    // change course and age ---> regNo as request param, entire student object as request body
    @PutMapping("/changecourseandage") // URL: not done
    public String changeCourseAndAge(@RequestParam("id") int regNo, Student s){
        return studentService.changeCourseAndAge(regNo, s);
    }

}
