package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String studentId;
    private String name;
    private Date birthday;
    private Date startDay;
    private Date endDay;
    private String departmentId;
    private String username;

    @ManyToOne
    @JoinColumn(name="id")
    private Topic topics;

    public Student(Long id, String studentId, String name, Date birthday, Date startDay, Date endDay, String departmentId, String username, Topic topics) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.birthday = birthday;
        this.startDay = startDay;
        this.endDay = endDay;
        this.departmentId = departmentId;
        this.username = username;
        this.topics = topics;
    }

    public Student(Long id, String studentId, String name, Date birthday, Date startDay, Date endDay, String departmentId, String username) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.birthday = birthday;
        this.startDay = startDay;
        this.endDay = endDay;
        this.departmentId = departmentId;
        this.username = username;
    }

    public Student() {super();
    }

    public Topic getTopics() {
        return topics;
    }

    public void setTopics(Topic topics) {
        this.topics = topics;
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
    @Column(name = "studentId", unique = true, nullable = false, length = 10)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "birthday", length = 20)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Column(name = "startDay", length = 20)
    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }
    @Column(name = "endDay", length = 20)
    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
    @Column(name = "departmentId", length = 20)
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    @Column(name = "username", length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
