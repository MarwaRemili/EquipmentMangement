/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.multi.module.three.controller;

import org.my.multi.module.three.Entities.Product;
import org.my.multi.module.three.Entities.Student;
import org.my.multi.module.three.Repositories.ProductRepository;
import org.my.multi.module.three.Repositories.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author marwa
 */
@Controller
 @RequestMapping(path="/student")
public class StudentController {
   @Autowired
   private StudentServices studentService;
  
        @GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewStudent (@RequestParam String stname
			, @RequestParam String des, @RequestParam Integer quantity, @RequestParam Integer max) {

		Student st = new Student();
                st.setName(stname);
		return "Saved";
	}
}
