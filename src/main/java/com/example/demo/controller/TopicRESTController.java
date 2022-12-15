package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Topic;
import com.example.demo.service.TopicService;



@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/rest")
public class TopicRESTController {

    @Autowired
    private TopicService TopicService;

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
        return TopicService.updateTopic(empForm);
    }

    @RequestMapping(value = "/topic/{empId}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public String updateTopic(@PathVariable("empId") Long empId){
        System.out.println("(Service Side) Deleting Topic with empId: " + empId);
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

