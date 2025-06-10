/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

package com.example.crudapp.controller;

import com.example.crudapp.model.student;
import com.example.crudapp.repo.studentrepo;
import java.util.ArrayList;
import java.util.List;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vijayalakshmi.kumar
 */

@RestController
public class studentcontroller {
 @Autowired
 private studentrepo studentrepo;
 
 @GetMapping("/getallsutudents")
    public ResponseEntity<List<student>> getallsutudents() {
        try {
            List<student> studentlist = new ArrayList<>();
            studentrepo.findAll().forEach(studentlist::add);

            if (studentlist.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studentlist,HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     @PostMapping("/addstudent")
     public ResponseEntity<student> addStudent(@RequestBody student Student) {
        student studentObj = studentrepo.save(Student);
        return new ResponseEntity<>(studentObj, HttpStatus.OK);
     }


    //  @PostMapping("/updatestudentById/{id}")
    //  public ResponseEntity<student> updatestudentById(@PathVariable long id, @RequestBody student newstudentdata){
    //     Optional<student> oldstudentData=studentrepo.findById(id);
    //     if (oldstudentData.isPresent()){
    //         student updatestudent=oldstudentData.get();
    //         updatestudent.setName(newstudentdata.getName());
    //         updatestudent.setMarks(newstudentdata.getMarks());

    //         student studentObj =studentrepo.save(updatestudent);
    //         return new ResponseEntity<>(studentObj, HttpStatus.OK);

    //     }
    //      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //  }

    @PutMapping("/updatestudentById/{id}")
public ResponseEntity<student> updateStudentById(@PathVariable Long id, @RequestBody student newStudentData) {
            return studentrepo.findById(id)
            .map(studentnew -> {
                studentnew.setName(newStudentData.getName());
                studentnew.setMarks(newStudentData.getMarks());
                student updatedStudent = studentrepo.save(studentnew);
                return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
            })
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}



     @PostMapping("/deletestudentById/{id}")
     public ResponseEntity<HttpStatus> deletestudentById(@PathVariable long id){
        studentrepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }


}
