package com.example.demo.controller;

import com.example.demo.entities.JoinRequest;
import com.example.demo.entities.Topic;
import com.example.demo.service.JoinRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3001", "https://software-engineering-kjob.vercel.app"})
@RequestMapping("/rest")
public class JoinRequestController {
    @Autowired
    JoinRequestService joinRequestService;

    @RequestMapping(value = "/join",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<JoinRequest> getTopics(){
        List<JoinRequest> list = joinRequestService.findAll();
        return list;
    }

    @RequestMapping(value = "/join",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public JoinRequest getTopics(@RequestBody JoinRequest joinRequest){
        return joinRequestService.addJoinRequest(joinRequest);
    }

    @RequestMapping(value = "/join/status",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public JoinRequest updateTopicStatus(@RequestBody JoinRequest joinRequest){
//        System.out.println("(Service Side) Editing Topic with status: " + joinRequest.getStatus());
        JoinRequest joinRequest1 = joinRequestService.getJoinRequest(joinRequest.getId());
//        System.out.println(joinRequest1.getStatus());
        joinRequest1.setStatus(joinRequest.getStatus());
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
        return joinRequestService.updateJoinRequest(joinRequest1);
    }

    @RequestMapping(value = "/join/review",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public JoinRequest updateTopicReview(@RequestBody JoinRequest joinRequest){
//        System.out.println("(Service Side) Editing Topic with status: " + joinRequest.getStatus());
        JoinRequest joinRequest1 = joinRequestService.getJoinRequest(joinRequest.getId());
//        System.out.println(joinRequest1.getStatus());
        joinRequest1.setPoint(joinRequest.getPoint());
        joinRequest1.setReview(joinRequest.getReview());
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
        return joinRequestService.updateJoinRequest(joinRequest1);
    }
}
