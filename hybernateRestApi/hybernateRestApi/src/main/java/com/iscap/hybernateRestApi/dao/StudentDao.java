package com.iscap.hybernateRestApi.dao;

import com.iscap.hybernateRestApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Long> {
}
