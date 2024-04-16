package com.example.studentendpoint;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class StudentEndpoint  {

    private static final String NAMESPACE_URI = "http://superdev.io/student-service";

    private final StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getCountry(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        Optional<Student> student = studentRepository.findById(request.id);
        if(student.isPresent()){
            response.setStudent(student.get()); // Fix: Pass the actual student object instead of Optional<Student>
            //convert this to json
        
        }
        

        return response;
    }
}


