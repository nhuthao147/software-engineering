package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String departmentId;
    private String headId;
    private String name;

    @OneToMany(mappedBy = "topics", cascade = CascadeType.ALL)
    private Set<Topic> topics;

    public Department(Long id, String departmentId, String headId, String name, Set<Topic> topics) {
        this.id = id;
        this.departmentId = departmentId;
        this.headId = headId;
        this.name = name;
        this.topics = topics;
    }

    public Department(Long id, String departmentId, String headId, String name) {
        this.id = id;
        this.departmentId = departmentId;
        this.headId = headId;
        this.name = name;
    }

    public Department() {super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "departmentId", unique = true, nullable = false, length = 10)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "headId", length = 20)
    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
