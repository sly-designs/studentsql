package com.example.demo.student;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)

    private Long id;
    private String name;
    private  Long mark;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   Long mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name,
                   Long mark) {
        this.name = name;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
