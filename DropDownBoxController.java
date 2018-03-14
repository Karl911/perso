package com.kfa.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.kfa.spring.model.Customer;
import com.kfa.spring.validator.CustomerValidator;

@Controller
@RequestMapping("/customer.htm")
public class DropDownBoxController {
	
	CustomerValidator customerValidator;
	/*
	@Autowired
	public CustomerController(CustomerValidator customerValidator){
		this.customerValidator = customerValidator;
	}

	public DropDownBoxController() {
		setCommandClass(Customer.class);
		setCommandName("CustomerForm");
	}
	*/
	/* Ancienne méthode
	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception {

		Customer cust = new Customer();

		//make "Spring" as the default java skills selection
		cust.setJavaSkills("Spring");

		return cust;

	}
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){

		Customer cust = new Customer();
		//make "Spring" as the default java skills selection
		cust.setJavaSkills("Spring");
		
		//command object
		model.addAttribute("customer", cust);

		//return form view
		return "CustomerForm";
	}
	
	/*
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, Errors errors)
	{
		Customer customer = (Customer) command;
		return new ModelAndView("customerSuccess","customer", customer);
	}
	*/
	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("customer") Customer customer, BindingResult result, SessionStatus status)
	{
		// clear the command object from the session
		status.setComplete();
		
		// return form success view
		return "customerSuccess";
	}
	@ModelAttribute("countryList")
	protected Map<String, String> populateCountries()
	{
		//Data referencing for web framework selected
		Map<String, String> countries = new HashMap<String,String>();
		
		countries.put("US", "Etas-Unis");
		countries.put("FR", "France");
		
		/*
		Map<String, String> skills = new LinkedHashMap<String, String>();
		
		skills.put("Java", "Java");
		skills.put("Spr", "Spring");
		skills.put("Hibernate","Hibernate");
		*/
		//referenceData.put("javaSkillsList", skills);
		
		
		return countries;
	}
	
	@ModelAttribute("countryList")
	protected Map<String, String> populateJavaSkills()
	{
		Map<String, String> skills = new HashMap<String,String>();
		
		skills.put("Java", "Java");
		skills.put("Spr", "Spring");
		skills.put("Hibernate","Hibernate");
		
		return skills;
	}
}


