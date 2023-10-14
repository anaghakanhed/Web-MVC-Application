package in.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.example.entity.Product;
import in.example.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		model.addAttribute("p",new Product() );
		return "index";
	}
	
	@PostMapping("/product")
	public String handleSave(@ModelAttribute("p") Product p,Model model ) {
		 p = repo.save(p);
		if(p.getPid() != null) {
			model.addAttribute("msg", "Product Saved...");
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String getAllData(Model model) {
		List<Product> prod= repo.findAll();
		model.addAttribute("prods", prod);
		return "data";
	}
}
