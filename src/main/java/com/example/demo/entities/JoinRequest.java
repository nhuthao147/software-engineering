package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "joinrequest")
public class JoinRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private Topic topic;

    @Column(name = "point")
    private Double point;

    @Column(name = "review")
    private String review;

    @OneToOne
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "headid", referencedColumnName = "id")
    private Instructor head;

    public JoinRequest() {
    }

    public JoinRequest(int status, Long id, Topic topic, Student student, Instructor head) {
        this.status = status;
        this.id = id;
        this.topic = topic;
        this.student = student;
        this.head = head;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name = "status", length = 20)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}