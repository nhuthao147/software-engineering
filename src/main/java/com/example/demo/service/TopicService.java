package com.example.demo.service;


import java.util.List;
import java.util.Optional;


import com.example.demo.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TopicDAO;
import com.example.demo.entities.Topic;


@Service
@Transactional
public class TopicService {

    @Autowired
    private TopicDAO TopicDAO;

    @Autowired
    private TopicRepository topicRepository;
    public Topic getTopic(Long empId) {
        return TopicDAO.getTopic(empId);
    }
    public Topic getById(Long aLong) {
        return topicRepository.getById(aLong);
    }

    public Topic addTopic (Topic Topic) {
        Topic topic = TopicDAO.addTopic(Topic);
        topic.setTopic_id("T"+topic.getId());
        TopicDAO.updateTopic(topic);
        return topic;
    }

    public Topic updateTopic(Topic Topic) {
        return TopicDAO.updateTopic(Topic);
    }

    public void deleteTopic (Long empId) {
        TopicDAO.deleteTopic(empId);
    }

    public List<Topic> getAllTopics(){
        return TopicDAO.getAllTopic();
    }
}

