package com.SubjectService.SubjectService;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubjectAdapter{

    @Value("${nge.api.path}")
    String ngeApiPath;

    public Subject getSubjectById(int subject_id){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String endpointSubjectAPI = String.format(ngeApiPath + "/api/v0/subject/%d", subject_id);
            Subject subject = restTemplate.getForObject(endpointSubjectAPI,Subject.class);
            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Subject> getAllSubjectByProgram(int program_id) {
        try {            
            RestTemplate restTemplate = new RestTemplate();
            String endpointSubjectAPI = String.format(ngeApiPath + "/api/v0/program/%d/subjects", program_id);
            List<Subject> subject = restTemplate.getForEntity(endpointSubjectAPI, List.class).getBody();
            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}