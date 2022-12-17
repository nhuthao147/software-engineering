package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.DepartmentService;
import com.example.demo.service.InstructorService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Topic;
import com.example.demo.service.TopicService;



@RestController
@CrossOrigin(origins = {"http://localhost:3001", "https://software-engineering-kjob.vercel.app"})
@RequestMapping("/rest")
public class TopicRESTController {

    @Autowired
    private TopicService TopicService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private InstructorService instructorService;
    @RequestMapping(value = "/topic",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Topic> getTopics(){
        List<Topic> list = TopicService.getAllTopics();
        return list;
    }
    
    @RequestMapping(value = "/topic",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Topic addTopic(@RequestBody Topic empForm){
        System.out.println("(Service Side) Creating Topic with id: " + empForm.getId());
        return TopicService.addTopic(empForm);
    }

    @RequestMapping(value = "/topic",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Topic updateTopic(@RequestBody Topic empForm){
        System.out.println("(Service Side) Editing Topic with id: " + empForm.getId());
        empForm.setTopic_id("T"+empForm.getId());
        return TopicService.updateTopic(empForm);
    }
    @RequestMapping(value = "/topic/status",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Topic updateTopicStatus(@RequestBody Topic empForm){
        System.out.println("(Service Side) Editing Topic with status: " + empForm.getStatus());
        Topic topic = TopicService.getTopic(empForm.getId());
        topic.setStatus(empForm.getStatus());
//        System.out.println(topic.getStatus());
//        empForm.setTopic_id(topic.getTopic_id());
//        empForm.setDescription(topic.getDescription());
//        empForm.setDepartments(topic.getDepartments());
////        empForm.setStudents(topic.getStudents());
//        empForm.setInstructors(topic.getInstructors());
//        empForm.setEnd_day(topic.getEnd_day());
//        empForm.setStart_day(topic.getStart_day());
//        empForm.setStatus(topic.getStatus());
//        TopicService.updateTopic(topic);
//        studentService.findStudentByTopic(topic.getId());
        return TopicService.updateTopic(topic);
    }

    @RequestMapping(value = "/topic/{empId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public String updateTopic(@PathVariable("empId") Long empId){
        System.out.println("(Service Side) Deleting Topic with empId: " + empId);
        Topic topic = TopicService.getTopic(empId);
        topic.setDepartments(null);
        topic.getStudents().forEach(c->c.setTopic(null));
        topic.setStudents(null);
        topic.setInstructors(null);
        TopicService.updateTopic(topic);
        TopicService.deleteTopic(empId);
        return "Delete successful";
    }

    @RequestMapping(value = "/topic/{empId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Topic getTopic(@PathVariable("empId") Long empId){
        return TopicService.getTopic(empId);
    }

}

