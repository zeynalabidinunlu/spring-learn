package com.dataJpa.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dataJpa.controller.impl.StudentControllerImpl;
import com.dataJpa.dto.DtoStudent;
import com.dataJpa.dto.DtoStudentIU;
import com.dataJpa.entites.Student;
import com.dataJpa.repository.StudentRepository;
import com.dataJpa.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {


	@Autowired
	private StudentRepository studentRepository;


	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();

		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);

		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;

	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();

		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);

		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dto = new DtoStudent();

		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();
			BeanUtils.copyProperties(dbStudent, dto);
		}
		return dto;
	}

	@Override
	public void deleteStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dto=new DtoStudent();
		
		Optional<Student> optional=	studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent= optional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirtOfDate(dtoStudentIU.getBirtOfDate());
			
			Student uptatedStudent=	studentRepository.save(dbStudent);
			BeanUtils.copyProperties(uptatedStudent, dto);
			return dto;
		}
		
		return null;
		//		DtoStudent dtoStudent =getStudentById(id);
//		
//		if (dtoStudent != null) {
//			dtoStudent.setFirstName(uptadeStudent.getFirstName());
//			dtoStudent.setLastName(uptadeStudent.getLastName());
//			dtoStudent.setBirtOfDate(uptadeStudent.getBirtOfDate());
//
//			return studentRepository.save(dbStudent);
//		}
	
	}
}
