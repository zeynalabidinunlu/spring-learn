package com.dataJpa.services;

import java.util.List;

import com.dataJpa.dto.DtoStudent;
import com.dataJpa.dto.DtoStudentIU;
import com.dataJpa.entites.Student;

public interface IStudentService {

	public DtoStudent saveStudent(DtoStudentIU student);

	public List<DtoStudent> getAllStudents();

	public DtoStudent getStudentById(Integer id);

	public void deleteStudentById(Integer id);

	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);

}
