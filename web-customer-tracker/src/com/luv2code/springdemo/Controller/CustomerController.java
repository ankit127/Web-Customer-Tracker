package com.luv2code.springdemo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject DAO in this controller
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String CustomerList(Model model) {

		// get customers from the dao
		List<Customer> theCustomers = customerService.getCustomers();

		// add customer to spring mvc model
		model.addAttribute("customers", theCustomers);

		return "customer-list";
	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer theCustomer = new Customer();

		model.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			customerService.saveCustomer(theCustomer);

			return "redirect:/customer/list";

		}

	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model model) {

		// get the customer from db
		Customer theCustomer = customerService.getCustomers(theId);

		// set the customer to model
		model.addAttribute("customer", theCustomer);

		// send to our form
		return "customer-form";
	}

	@GetMapping("delete")
	public String showFormForDelete(@RequestParam("customerId") int theId,
			Model model) {
		// send id to delete from customer
		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}

}
