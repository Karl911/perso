package com.kfa.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kfa.spring.model.Customer;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Customer customer = (Customer) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "javaSkills", "required.skills");
		
		if ("NONE".equals(customer.getCountry()))
		{
			errors.rejectValue("country", "required.country");
		}
	}
}
