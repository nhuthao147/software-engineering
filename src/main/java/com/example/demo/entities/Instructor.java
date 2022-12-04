package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String instructorId;
    private String name;
    private Date birthday;
    private Date startDay;
    private Date endDay;
    private String departmentId;
    private String username;

    @OneToMany(mappedBy = "topics", cascade = CascadeType.ALL)
    private Set<Topic> topics;

    public Instructor(Long id, String instructorId, String name, Date birthday, Date startDay, Date endDay, String departmentId, String username) {
        this.id = id;
        this.instructorId = instructorId;
        this.name = name;
        this.birthday = birthday;
        this.startDay = startDay;
        this.endDay = endDay;
        this.departmentId = departmentId;
        this.username = username;
    }

    public Instructor() {super();
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
    @Column(name = "instructorId", unique = true, nullable = false, length = 10)
    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String studentId) {
        this.instructorId = studentId;
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
