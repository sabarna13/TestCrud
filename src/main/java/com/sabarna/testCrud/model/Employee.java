package com.sabarna.testCrud.model;

import javax.persistence.*;

@Entity
@Table(name = "employee", indexes = {
        @Index(name = "idx_employee_id_unq", columnList = "id", unique = true)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Employee() {
        super();
    }

    public Employee(long id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

