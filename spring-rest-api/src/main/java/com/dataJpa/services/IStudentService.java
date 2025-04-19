package com.dataJpa.services;

import java.util.List;

import com.dataJpa.entites.Student;

public interface IStudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public void deleteStudentById(Integer id);

	public Student updateStudent(Integer id, Student uptadeStudent);

}
