package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"topics"})
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

    @OneToMany(mappedBy = "instructors", cascade = CascadeType.ALL)
    private List<Topic> topics = new ArrayList<Topic>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Instructor() {super();
    }
    public Instructor(Long id, String instructor_id, String name, Date birthday, Date start_day, Date end_day, Department departments, List<Topic> topics,
    		User user) {
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
    @Column(name = "instructor_id", unique = true, nullable = false, length = 10)
    public String getInstructorId() {
        return instructor_id;
    }

    public void setInstructorId(String studentId) {
        this.instructor_id = studentId;
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
    @Column(name = "start_day", length = 20)
    public Date getStartDay() {
        return start_day;
    }

    public void setStartDay(Date start_day) {
        this.start_day = start_day;
    }
    @Column(name = "end_day", length = 20)
    public Date getEndDay() {
        return end_day;
    }

    public void setEndDay(Date end_day) {
        this.end_day = end_day;
    }
    
    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
