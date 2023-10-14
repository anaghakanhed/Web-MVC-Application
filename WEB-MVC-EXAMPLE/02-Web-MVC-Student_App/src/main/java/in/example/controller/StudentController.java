package in.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.example.binding.Student;
import in.example.repository.StudentRepository;
import in.example.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String loadIndexPage(Model model) {
		Student sObj = new Student();
		initBinding(model, sObj);
		return "index";

	}

	private void initBinding(Model model, Student sObj) {
		model.addAttribute("student", sObj);
		model.addAttribute("courses", service.getCourse());
		model.addAttribute("timings", service.getTimings());
	}

	@PostMapping("/save")
	public String handleSubmitButton(Student s, Model model) {
		boolean status = service.getData(s);
		if (status) {
			model.addAttribute("msg", "Data Saved...");
		}
		Student sObj = new Student();
		initBinding(model, sObj);
		return "index";
	}
}
