package com.iscap.hybernateRestApi.restController;

import com.iscap.hybernateRestApi.response.BasicResponseMsg;
import com.iscap.hybernateRestApi.response.StudentRequestVo;
import com.iscap.hybernateRestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("saveStudent")
    public ResponseEntity<BasicResponseMsg> saveStudent(@RequestBody StudentRequestVo studentRequestVo){
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            response = studentService.saveStudent(studentRequestVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAllStudents")
    public ResponseEntity<BasicResponseMsg> getAllStudents() {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            response = studentService.getAllStudents();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("getStudent")
    public ResponseEntity<BasicResponseMsg> getStudent(@RequestBody StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            response = studentService.getStudent(studentRequestVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("updateStudent")
    public ResponseEntity<BasicResponseMsg> updateStudent(@RequestBody StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            response = studentService.updateStudent(studentRequestVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("deleteStudent")
    public ResponseEntity<BasicResponseMsg> deleteStudent(@RequestBody StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            response = studentService.deleteStudent(studentRequestVo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
