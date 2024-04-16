package com.example.studentendpoint;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
   name = "",
   propOrder = {"id"}
)
@XmlRootElement(
   name = "getStudentRequest"
)
public class GetStudentRequest {
   protected int id;

   public GetStudentRequest() {
   }

   public int getId() {
      return this.id;
   }

   public void setId(int value) {
      this.id = value;
   }
}
