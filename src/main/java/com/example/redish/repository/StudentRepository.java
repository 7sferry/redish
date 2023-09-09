/************************
 * Made by [MR Ferry™]  *
 * on September 2023    *
 ************************/

package com.example.redish.repository;

import com.example.redish.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{
}
