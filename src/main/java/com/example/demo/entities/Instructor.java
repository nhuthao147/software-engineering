package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String instructor_id;
    private String name;
    private Date birthday;
    private Date start_day;
    private Date end_day;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department departments;

    @JsonIgnore
    @OneToMany(mappedBy = "instructors", cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList<Topic>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @OneToOne(mappedBy = "head")
    private JoinRequest joinRequest;

    public Instructor() {super();
    }

    public Instructor(Long id, String instructor_id, String name, Date birthday, Date start_day, Date end_day, Department departments, List<Topic> topics, User user) {
        this.id = id;
        this.instructor_id = instructor_id;
        this.name = name;
        this.birthday = birthday;
        this.start_day = start_day;
        this.end_day = end_day;
        this.departments = departments;
        this.topics = topics;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }
    @Column(name = "instructor_id", unique = true, nullable = false, length = 10)
    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String instructor_id) {
        this.instructor_id = instructor_id;
    }

    @Column(name = "start_day", length = 20)
    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    @Column(name = "end_day", length = 20)
    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
