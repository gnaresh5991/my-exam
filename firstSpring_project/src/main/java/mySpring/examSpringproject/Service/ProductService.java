package mySpring.examSpringproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mySpring.examSpringproject.Repo.ProductRepo;
import mySpring.examSpringproject.model.Employee1;

@Service
public class ProductService {

	@Autowired
	ProductRepo prp;
	public List<Employee1> display()
	{
		return prp.findAll();
	}
	public void saveProduct(Employee1 product)
	{
		prp.save(product);
	}
	public Employee1 getProd(long id)
	{
		return prp.findById(id).get();
	}
	public void delete(long id)
	{
		prp.deleteById(id);
	}
}
