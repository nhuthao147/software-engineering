package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String department_id;

    private String name;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Topic> topics;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Student> students;
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Instructor> instructors;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_ID", referencedColumnName = "id")
    private Instructor head;

    private String head_id;

    public Department(Long id, String department_id, String name, List<Topic> topics, List<Student> students, List<Instructor> instructors, Instructor head, String headofdeparment_id) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
        this.topics = topics;
        this.students = students;
        this.instructors = instructors;
        this.head = head;
        this.head_id = head.getInstructor_id();
    }

    public Department() {super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "head_id", length = 100)
    public String getHead_id() {
        return head_id;
    }

    public void setHead_id(String headofdeparment_id) {
        this.head_id = headofdeparment_id;
    }

    @Column(name = "department_id", unique = true, nullable = false, length = 10)
    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }


    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Instructor getHead() {
        return head;
    }

    public void setHead(Instructor head) {
        this.head = head;
    }
}
