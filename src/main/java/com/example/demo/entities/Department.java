package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"topics","students","instructors", "head"})
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
    
    private String head_id;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Topic> topics;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Student> students;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private List<Instructor> instructors;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_ID", referencedColumnName = "id")
    private Instructor head;
    
    public Department(Long id, String department_id, String name, Set<Topic> topics, List<Instructor> instructors, Instructor head,
    		String head_id) {
        this.id = id;
        this.department_id = department_id;
        this.name = name;
        this.topics = topics;
        this.instructors = instructors;
        this.head = head;
        this.head_id = head.getInstructorId();
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

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
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
	
	@Column(name = "head_id")
	public String getHead_id() {
		return head_id;
	}


	public void setHead_id(String head_id) {
		this.head_id = head_id;
	}

	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}
    
}
