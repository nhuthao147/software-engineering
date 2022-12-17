package com.example.demo.service;

import com.example.demo.Repository.JoinRequestRepository;
import com.example.demo.dao.JoinRequestDAO;
import com.example.demo.entities.JoinRequest;
import com.example.demo.entities.JoinRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JoinRequestService {
    @Autowired
    JoinRequestRepository joinRequestRepository;
    
    @Autowired
    JoinRequestDAO joinRequestDAO;

    public JoinRequest getById(Long aLong) {
        return joinRequestRepository.getById(aLong);
    }

    public List <JoinRequest> findAll() {
        return joinRequestRepository.findAll();
    }

    public <S extends JoinRequest> S save(S entity) {
        return joinRequestRepository.save(entity);
    }

    public JoinRequest getJoinRequest(Long empId) {
        return joinRequestDAO.getJoinRequest(empId);
    }

    public JoinRequest addJoinRequest (JoinRequest joinRequest) {
//        JoinRequest joinRequest = joinRequestDAO.addJoinRequest(joinRequest);
//        JoinRequest.set("T"+JoinRequest.getId());
        joinRequestDAO.addJoinRequest(joinRequest);
        return joinRequest;
    }

    public JoinRequest updateJoinRequest(JoinRequest JoinRequest) {
        return joinRequestDAO.updateJoinRequest(JoinRequest);
    }

    public void deleteJoinRequest (Long empId) {
        joinRequestDAO.deleteJoinRequest(empId);
    }

    public List<JoinRequest> getAllJoinRequests(){
        return joinRequestDAO.getAllJoinRequest();
    }
}
