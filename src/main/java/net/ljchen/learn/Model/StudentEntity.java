package net.ljchen.learn.Model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Pattern(regexp = "male|female" , message = "Invalid Sex Field!")
    private String sex;

    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
