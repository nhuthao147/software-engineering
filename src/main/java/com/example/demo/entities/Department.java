package com.example.demo.entities;

import java.io.Serializable;
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

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Topic> topics;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Student> students;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Instructor> instructors;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_ID", referencedColumnName = "id")
    private Instructor head;

    public Department(Long id, String department_id, String name, Set<Topic> topics) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
        this.topics = topics;
    }

    public Department(Long id, String department_id, String headId, String name) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
    }

    public Department() {super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "department_id", unique = true, nullable = false, length = 10)
    public String getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(String department_id) {
        this.department_id = department_id;
    }


    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
