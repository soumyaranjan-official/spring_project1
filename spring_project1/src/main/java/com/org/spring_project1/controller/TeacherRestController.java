package com.org.spring_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.spring_project1.dao.TeacherDao;
import com.org.spring_project1.dto.Teacher;

@RestController
public class TeacherRestController {
	@Autowired	
	TeacherDao dao;
	
	@PostMapping("/teacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		
		return dao.saveTeacher(teacher);
	}
	
	
	@GetMapping("/teacher")
	public List<Teacher> fetchAllTeachers(){
		
		return dao.fetchAllTeacher();
	}
	
	
	@GetMapping("teacher/fetchById/{id}")
	public Teacher fetchTeacherById(@PathVariable int id) {
		return dao.fetchById(id);
	}
	
	@DeleteMapping("teacher/deleteTeacherById/{id}")
	public String deleteTeacherById(@PathVariable int id)
	{
		 dao.deleteTeacherById(id);
		return "Teacher Deleted successfully";
	}
	
	@PutMapping("/teacher/updateTeacherById/{id}")
	public Teacher updateTeacherByid(@RequestBody Teacher teacher, @PathVariable int id) {
			  Teacher teacher2 = dao.fetchById(id);
			  if(teacher2!=null) {
				  teacher.setId(teacher2.getId());
				  dao.saveTeacher(teacher);
			  }
	
			  return teacher;
	}
	
	@GetMapping("/teacher/{email}/{password}")
	public boolean verifyTeacherByEmailAndPassword(@PathVariable String email, @PathVariable String password){
		return dao.verifyTeacherByEmailAndPassword(email,password);
		
	}

	@GetMapping("/byName/{name}/{password}")
	public boolean verifyTeacherByName(@PathVariable String name, @PathVariable String password) {
		
		
		return dao.verifyTeacherByName(name, password);
	}
	
}
