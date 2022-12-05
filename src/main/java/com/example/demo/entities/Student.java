package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String student_id;
    private String name;
    private Date birthday;
    private Date start_day;
    private Date end_day;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @ManyToOne
    @JoinColumn(name="topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department departments;

    public Student(Long id, String student_id, String name, Date birthday, Date start_day, Date end_day, Topic topic,
    		User user, Department departments) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.birthday = birthday;
        this.start_day = start_day;
        this.end_day = end_day;
        this.topic = topic;
        this.user = user;
        this.departments = departments;
    }

    public Student() {super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "student_id", unique = true, nullable = false, length = 10)
    public String getStudentId() {
        return student_id;
    }

    public void setStudentId(String student_id) {
        this.student_id = student_id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
    
}
