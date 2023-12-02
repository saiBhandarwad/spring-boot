package com.iscap.hybernateRestApi.service;

import com.iscap.hybernateRestApi.response.BasicResponseMsg;
import com.iscap.hybernateRestApi.response.StudentRequestVo;



public interface StudentService {
    BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo);
    BasicResponseMsg getStudent(StudentRequestVo studentRequestVo);
    BasicResponseMsg getAllStudents();

    BasicResponseMsg deleteStudent(StudentRequestVo studentRequestVo);

    BasicResponseMsg updateStudent(StudentRequestVo studentRequestVo);
}
