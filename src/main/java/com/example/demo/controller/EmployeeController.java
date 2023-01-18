package com.example.demo.controller;

import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/") 
	public String home(Model m)
	{
		/*
		 * List<Employee> emp=service.getAllEmp(); m.addAttribute("emp",emp);
		 */
		logger.info("Home page accessed.");
		/* return "index"; */
		return findPaginated(0, m);
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		logger.info("Add employee page accessed.");
		return "add_employee";
	}

	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee details added successfully.");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e =service.getEmpById(id);
		m.addAttribute("emp",e);
		logger.info("Edit page accessed.");
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Updated Successfully.");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Data Deleted Successfully.");
		logger.info("Employee Deleted.");
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Employee> emplist = service.getEMpByPaginate(pageno, 2);
		m.addAttribute("emp", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "index";
	}
		
}
