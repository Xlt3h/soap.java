package com.example.studentendpoint;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    

}