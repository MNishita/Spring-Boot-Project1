package com.mycompany.Student;

import com.mycompany.Student.Repository.StudentRepository;
import com.mycompany.Student.students.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class StudentApplicationTests {
	@Autowired
	private StudentRepository repo;

	@Test
	public void testAddNew() {
		Student student = new Student();
		student.setEmail("abc123@gmail.com");
		student.setName("Nishita");
		student.setCollege("BRECW");
		student.setBranch("CSE");

		Student savedStudent = repo.save(student);

		Assertions.assertNotNull(savedStudent);
	}

	@Test
	public void testListAll() {
		Iterable<Student> students = repo.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testUpdate() {
		Integer studentId = 2;
		Optional<Student> optionalStudent = repo.findById(studentId);
		Student student = optionalStudent.get();
		student.setBranch("ECE");
		student.setName("Akshitha");
		student.setEmail("def456@gmail.com");
		repo.save(student);
	}

	@Test
	public void testGet() {
		Integer studentId = 2;
		Optional<Student> optionalStudent = repo.findById(studentId);
		Student student = optionalStudent.get();
		System.out.println(student);
	}

	@Test
	public void testDelete() {
		Integer studentId = 9;
		repo.deleteById(studentId);
	}
}
