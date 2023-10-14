package in.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import in.example.binding.Student;
import in.example.entity.StudentEntity;
import in.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	 private StudentRepository repo;
	
	
	public boolean getData(Student student) {
		System.out.println(student);
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		entity.setTimings(Arrays.toString(student.getTimings()));
		System.out.println(entity);
		repo.save(entity);
		return true;
	}
	
	
	public List<String> getCourse(){
		return Arrays.asList("Spring Boot", "Devops", "Java", "Python");
	}
	
	
	public List<String> getTimings(){
		return Arrays.asList("Morning", "Afternoon", "Evening");
	}
}
