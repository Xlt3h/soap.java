package com.example.studentendpoint;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
   public ObjectFactory() {
   }

   public GetStudentRequest createGetStudentRequest() {
      return new GetStudentRequest();
   }

   public GetStudentResponse createGetStudentResponse() {
      return new GetStudentResponse();
   }

   public Student createStudent() {
      return new Student();
   }
}
