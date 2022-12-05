package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String topic_id;
    private String description;
    private Date start_day;
    private Date end_day;

    private int status;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department departments;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students= new ArrayList<Student>();

    @ManyToOne
    @JoinColumn(name="instructor_id")
    private Instructor instructors;

    public Topic(Long id, String topic_id, String description, Date start_day, Date end_day, int status, Department departments, List<Student> students, Instructor instructors) {
        this.id = id;
        this.topic_id = topic_id;
        this.description = description;
        this.start_day = start_day;
        this.end_day = end_day;
        this.status = status;
        this.departments = departments;
        this.students = students;
        this.instructors = instructors;
    }

    public Topic() {super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "topic_id", unique = true, nullable = false, length = 10)
    public String gettopic_id() {
        return topic_id;
    }

    public void settopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "status", length = 20)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Column(name = "start_day")
    public Date getstart_day() {
        return start_day;
    }

    public void setstart_day(Date start_day) {
        this.start_day = start_day;
    }

    @Column(name = "end_day")
    public Date getend_day() {
        return end_day;
    }

    public void setend_day(Date end_day) {
        this.end_day = end_day;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructor getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructor instructors) {
        this.instructors = instructors;
    }
}
