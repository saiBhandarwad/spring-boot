package com.iscap.hybernateRestApi.serviceImpl;

import com.iscap.hybernateRestApi.dao.StudentDao;
import com.iscap.hybernateRestApi.model.Student;
import com.iscap.hybernateRestApi.response.BasicResponseMsg;
import com.iscap.hybernateRestApi.response.StudentRequestVo;
import com.iscap.hybernateRestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            Student student = new Student();
            student.setAddress(studentRequestVo.getAddress());
            student.setAge(studentRequestVo.getAge());
            student.setName(studentRequestVo.getName());
            student.setMobileNumber(studentRequestVo.getMobileNumber());
            student.setRollNumber(studentRequestVo.getRollNumber());
            Student save = studentDao.save(student);
            response.setData(save.getId());
            response.setMessage("student saved successfully");
            response.setStatus(201);
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BasicResponseMsg getStudent(StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            Optional<Student> result  = studentDao.findById(Long.parseLong(studentRequestVo.getId()));
            if(result.isEmpty()){
                response.setData(null);
                response.setMessage("student with this id is not present");
                response.setStatus(404);
            }else{
                response.setData(result);
                response.setMessage("student is present");
                response.setStatus(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
    @Override
    public BasicResponseMsg getAllStudents() {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            List<Student> result = studentDao.findAll();
            if(result.isEmpty()){
                response.setData(null);
                response.setMessage("student table is empty, no data is there in student table");
                response.setStatus(200);
            }else {
                response.setData(result);
                response.setMessage("student table has data");
                response.setStatus(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BasicResponseMsg updateStudent(StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {

            Optional<Student> result  = studentDao.findById(Long.parseLong(studentRequestVo.getId()));

            if(result.isEmpty()){
                response.setData(null);
                response.setMessage("student with this id is not present");
                response.setStatus(404);
            }else{
                Student student = result.get();
                if(studentRequestVo.getAddress()!=null){
                    student.setAddress(studentRequestVo.getAddress());
                }
                if(studentRequestVo.getAge()!=null){
                    student.setAge(studentRequestVo.getAge());
                }
                if(studentRequestVo.getName()!=null){
                    student.setName(studentRequestVo.getName());
                }
                if(studentRequestVo.getMobileNumber()!=null){
                    student.setMobileNumber(studentRequestVo.getMobileNumber());
                }
                if(studentRequestVo.getRollNumber()!=null){
                    student.setRollNumber(studentRequestVo.getRollNumber());
                }

                Student save = studentDao.save(student);
                response.setData(save);
                response.setMessage("student updated successfully");
                response.setStatus(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
    @Override
    public BasicResponseMsg deleteStudent(StudentRequestVo studentRequestVo) {
        BasicResponseMsg response = new BasicResponseMsg();
        try {

            Optional<Student> result  = studentDao.findById(Long.parseLong(studentRequestVo.getId()));
            if(result.isEmpty()){
                response.setData(null);
                response.setMessage("student with this id is not present");
                response.setStatus(404);
            }else{
                studentDao.delete(result.get());
                response.setData(null);
                response.setMessage("student deleted successfully");
                response.setStatus(200);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
