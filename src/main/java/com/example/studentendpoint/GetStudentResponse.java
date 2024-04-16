package com.example.studentendpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "",
   propOrder = {"student"}
)
@XmlRootElement(
   name = "getStudentResponse"
)
public class GetStudentResponse {
   @XmlElement(
      required = true
   )
   protected Student student;

   public GetStudentResponse() {
   }

   public Student getStudent() {
      return this.student;
   }

   public void setStudent(Student value) {
      this.student = value;
   }
}
