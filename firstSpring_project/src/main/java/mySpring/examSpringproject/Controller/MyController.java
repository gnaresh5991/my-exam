package mySpring.examSpringproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mySpring.examSpringproject.Service.ProductService;
import mySpring.examSpringproject.model.Employee1;
@Controller
public class MyController {

	@Autowired
	ProductService pdsv;
	
	@RequestMapping("/display")
	public String showhomepage(Model model )
	{
		List<Employee1> li=pdsv.display();
		model.addAttribute("abc", li);
		return "show";
	}

	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Employee1 Employee1= new Employee1();
		model.addAttribute("employee1", Employee1);
		return "addpro";
	}
	@RequestMapping(value =  "/save" , method = RequestMethod.POST)
	public String saveData(@ModelAttribute("Employee1") Employee1 employee1)
	{
		pdsv.saveProduct(employee1);
		return "redirect:/display"; 
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name = "id") int id)
	{
		ModelAndView view = new ModelAndView("edit");
		Employee1 employee1 = pdsv.getProd(id);
		view.addObject("employee1", employee1);
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id") int id)
	{
		pdsv.delete(id);
		return "redirect:/display";
	} 



}


