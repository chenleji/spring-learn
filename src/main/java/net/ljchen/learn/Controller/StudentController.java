package net.ljchen.learn.Controller;

import net.ljchen.learn.Model.StudentEntity;
import net.ljchen.learn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("")
    public ResponseEntity getStudent() {
        return ResponseEntity.ok(service.listStudents());
    }

    @GetMapping("/age/{age}")
    public ResponseEntity getStudentByAge(@PathVariable("age") int age) {
        return ResponseEntity.ok(service.getStudentByAge(age));
    }

//    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Resource<StudentEntity> getStudentByAgeInHyperMedia(@PathVariable("id") Long id) {
//        StudentEntity studentEntity = service.getStudentById(id);
//        Resource<StudentEntity> resource = new Resource<>(studentEntity);
//
//        resource.add(linkTo(methodOn(StudentController.class).getStudentByAgeInHyperMedia(id)).withSelfRel());
//        return resource;
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addStudent(@RequestBody @Valid StudentEntity student, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid Format!");
        }
        return ResponseEntity.ok(service.addStudent(student));
    }
}
