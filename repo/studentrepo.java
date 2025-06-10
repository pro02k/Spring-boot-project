package com.example.crudapp.repo;

import com.example.crudapp.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vijayalakshmi.kumar
 */
@Repository
public interface studentrepo extends JpaRepository<student , Long> {

       
 
}
