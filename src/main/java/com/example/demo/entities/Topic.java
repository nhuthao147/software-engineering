package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String topicId;
    private String description;
    private Date startDay;
    private Date endDay;

    @ManyToOne
    @JoinColumn(name="departmentId")
    private Department department;

    private int status;
    @OneToMany(mappedBy = "topics", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name="instructorId")
    private Instructor headOfDepartment;

    public Topic(Long id, String topicId, String description, Date startDay, Date endDay, Department department, int status, List<Student> students, Instructor headOfDepartment) {
        this.id = id;
        this.topicId = topicId;
        this.description = description;
        this.startDay = startDay;
        this.endDay = endDay;
        this.department = department;
        this.status = status;
        this.students = students;
        this.headOfDepartment = headOfDepartment;
    }

    public Topic() {super();
    }


    @Column(name = "studentId", unique = true, nullable = false, length = 10)
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
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

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Instructor getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Instructor headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Column(name = "startDay")
    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    @Column(name = "endDay")
    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Column(name = "id", unique = true, nullable = false)
    public void setId(Long id) {
        this.id = id;
    }

}
