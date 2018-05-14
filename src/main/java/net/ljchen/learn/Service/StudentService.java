package net.ljchen.learn.Service;

import net.ljchen.learn.Dao.StudentRepository;
import net.ljchen.learn.Model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentEntity> getStudentByAge(int age){
        return repository.getByAge(age);
    }

    public StudentEntity getStudentById(Long id){
        return repository.getOne(id);
    }

    public List<StudentEntity> listStudents(){
        return repository.findAll();
    }

    public StudentEntity addStudent(StudentEntity student) {
        return repository.save(student);
    }

}
