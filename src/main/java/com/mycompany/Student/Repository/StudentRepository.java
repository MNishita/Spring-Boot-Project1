package com.mycompany.Student.Repository;

import com.mycompany.Student.students.Student;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
