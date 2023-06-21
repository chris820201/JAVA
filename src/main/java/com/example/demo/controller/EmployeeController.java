package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private EmployeeServiceImpl empSerImpl;
    // display list of employees
    
    // public String getUsers(Model model, @RequestParam(defaultValue = "0") int page)
    @GetMapping("/employee")
    //public String viewHomePage(Model model)  //,@RequestParam(defaultValue = "0") int page) {
    public String viewHomePage(Model model,@RequestParam(defaultValue = "0") int page) {
    	//page=0;
    	// Page<Employee> empPage = empSerImpl.getUsersPageable(page);
     	
    	Page<Employee> empPage = employeeService.getUsersPageable(page);
    	
    	model.addAttribute("listEmployees", empPage.getContent());
    	//model.addAttribute("emps", empPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", empPage.getTotalPages());
        return "indexEmp";
    	
    	//model.addAttribute("listEmployees", employeeService.getAllEmployees());
    	   	
    	//return "indexEmp";
    	//return "Employee";
    }

    @GetMapping("/showForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }
    
    
    
    
    
}
