package com.plm.conn.hcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plm.conn.beans.Person;

@Controller
public class SpringMVCController {
 
	@RequestMapping(value = "/paginationDisplayTag", method = RequestMethod.GET)
	public String paginationDisplayTag(@ModelAttribute("person") Person person,
			BindingResult result, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		List<Person> objs = new ArrayList<Person>();
		for (int j = 0; j < 10; j++) {
			Person p = new Person();
			p.setDescription("setDescription" + j);
			p.setEmail("setEmail" + j);
			p.setId("setId" + j);
			p.setName("setName" + j);
			p.setStatus("setStatus" + j);
			objs.add(p);
			System.out.println(" printing >>>>>"+p.getName());
		}
		
		person.setPersonList(objs);
		return "paginationDisplayTag";

	}
}
