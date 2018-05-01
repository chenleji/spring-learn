package net.ljchen.learn.Controller;

import net.ljchen.learn.Model.StudentEntity;
import net.ljchen.learn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("")
    public ResponseEntity getStudent(){
        return ResponseEntity.ok(service.listStudents());
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getStudentByAge(@PathVariable("age") int age){
        return ResponseEntity.ok(service.getStudentByAge(age));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody @Valid StudentEntity student, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid Format!");
        }
        return ResponseEntity.ok(service.addStudent(student));
    }
}
