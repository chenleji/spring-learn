package net.ljchen.learn.Dao;

import net.ljchen.learn.Model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
    List<StudentEntity> getByAge(int age);
}
