package in.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer pid;
	
	@NotBlank(message="Name is mandatory")
	@Size(min=3, max=15, message="Name should have only 3 to 15 characters")
	private String name;
	
	@NotNull(message="Price is mandatory")
	@Positive
	private Double price;
	
	@NotNull(message="Quantity is mandatory")
	private Integer qty;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	
	
}
