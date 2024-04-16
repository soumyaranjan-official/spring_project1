package com.org.spring_project1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.spring_project1.dto.Teacher;
import com.org.spring_project1.repository.TeacherRepository;

@Component
public class TeacherDao {
	@Autowired
	TeacherRepository repo;

	public Teacher saveTeacher(Teacher teacher) {
		return repo.save(teacher);
	}

	public List<Teacher> fetchAllTeacher() {

		return repo.findAll();
	}

	public Teacher fetchById(int id) {
		Optional<Teacher> optional = repo.findById(id);

		if (optional != null) {
			return optional.get();
		}
		return null;
	}

	public Teacher deleteTeacherById(int id) {
		Teacher teacher = fetchById(id);
		if (teacher != null) {
			repo.delete(teacher);
		}
		return teacher;

	}

	public boolean verifyTeacherByEmailAndPassword(String email, String password) {
		return !repo.findByEmailAndPassword(email, password).isEmpty();
	}

	public boolean verifyTeacherByName(String name, String password) {
		return !repo.findByNameAndPassword(name, password).isEmpty();

	}

}
