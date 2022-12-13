package com.example.demo.dto;

import com.example.demo.entities.Department;
import com.example.demo.entities.Topic;
import com.example.demo.entities.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class UserProfile {

    private static final long serialVersionUID = 1L;
    private String role;
    private List<String> function;
    private String user_id;
    private String name;
    private Date birthday;
    private Date start_day;
    private Date end_day;
    private String username;
    private String topicid;
    private String departmentid;


    public UserProfile(String role, List<String> function, String user_id, String name, Date birthday, Date start_day, Date end_day, String username, String topicid, String departmentid) {
        this.role = role;
        this.function = function;
        this.user_id = user_id;
        this.name = name;
        this.birthday = birthday;
        this.start_day = start_day;
        this.end_day = end_day;
        this.username = username;
        this.topicid = topicid;
        this.departmentid = departmentid;
    }

    public UserProfile() {super();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getFunction() {
        return function;
    }

    public void setFunction(List<String> function) {
        this.function = function;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStart_day() {
        return start_day;
    }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() {
        return end_day;
    }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }
}
