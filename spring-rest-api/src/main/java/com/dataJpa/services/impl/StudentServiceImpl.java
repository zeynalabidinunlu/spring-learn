package com.dataJpa.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataJpa.entites.Student;
import com.dataJpa.repository.StudentRepository;
import com.dataJpa.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student getStudentById(Integer id) {

		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteStudentById(Integer id) {
		Student dbStudent = getStudentById(id);
		if (dbStudent != null) {
			studentRepository.delete(dbStudent);
		}
	}

	@Override
	public Student updateStudent(Integer id, Student uptadeStudent) {
		Student dbStudent = getStudentById(id);
		if (dbStudent != null) {
			dbStudent.setFirstName(uptadeStudent.getFirstName());
			dbStudent.setLastName(uptadeStudent.getLastName());
			dbStudent.setBirtOfDate(uptadeStudent.getBirtOfDate());

			return	studentRepository.save(dbStudent);
		}
return null;
	}

}
