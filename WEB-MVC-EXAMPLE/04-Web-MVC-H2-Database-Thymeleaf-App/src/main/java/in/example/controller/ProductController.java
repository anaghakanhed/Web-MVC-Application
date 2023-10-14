package in.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.example.entity.Product;
import in.example.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository repo;

	@GetMapping("/")
	public String loadIndexPage(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	@PostMapping("/product")
	public String saveData(@Validated @ModelAttribute("product") Product p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		p = repo.save(p);
		if (p.getPid() != null) {
			model.addAttribute("msg", "Product Saved...");
		}
		return "index";
	}

	@GetMapping("/products")
	public String viewProducts(Model model) {
		List<Product> list = repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}

	@GetMapping("/delete")
	public String deleteRecord(@RequestParam("pid") Integer pid, Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg", "Record Deleted...");
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/edit")
	public String editRecord(@RequestParam("pid") Integer pid, Model model) {
		Optional<Product> findById = repo.findById(pid);
		if (findById.isPresent()) {
			Product product = findById.get();
			model.addAttribute("product", product);
		}
		return "index";
	}
}
