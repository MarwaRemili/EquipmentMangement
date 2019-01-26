/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.multi.module.three.Services;

import org.my.multi.module.three.Entities.Product;
import org.my.multi.module.three.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marwa
 */
@RestController    // This means that this class is a Controller
@RequestMapping(path="/prod")
public class ProductController {
        @Autowired 
	private ProductRepository productRepository;
        @GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String pname
			, @RequestParam String des, @RequestParam Integer quantity, @RequestParam Integer max) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Product p = new Product();
                p.setpName(pname);
		p.setDes(des);
                p.setQuantity(quantity);
                p.setMax(max);
		productRepository.save(p);
		return "Saved";
	}
        @GetMapping(path="/all")
	public @ResponseBody Iterable<Product> getAllProducts() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}
}
