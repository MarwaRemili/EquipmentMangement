/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.multi.module.three.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.my.multi.module.three.Entities.Command;
import org.my.multi.module.three.Entities.Equipement;
import org.my.multi.module.three.Entities.Product;
import org.my.multi.module.three.Repositories.EquipementRepository;
import org.my.multi.module.three.Repositories.ProductRepository;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marwa
 */
@RestController    // This means that this class is a Controller
@RequestMapping(path = "/equipement")
public class EquipementService {

    @Autowired
    private EquipementRepository equipementRepository;

    @PostMapping(path = "/add")
    @CrossOrigin(origins = "http://localhost:4200")// Map ONLY GET Requests
    public void addNewEquipement(@RequestBody Equipement e
    ) throws IOException {

        equipementRepository.save(e);

    }

    @GetMapping(path = "/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Equipement> getAllEquipements() {
        // This returns a JSON or XML with the users
        return equipementRepository.findAll();
    }

    @GetMapping(path = "/getEquip")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Equipement> getEquipementById(Integer id) {
        // This returns a JSON or XML with the users
        return equipementRepository.findById(id);
    }

    @PostMapping(path = "/edit")
   @CrossOrigin(origins = "http://localhost:4200")
    public void editEquipement(@RequestBody Equipement e) {
        // This returns a JSON or XML with the users
        
        equipementRepository.save(e);
       
      
        
            
        
    }

   @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteEquipment(@PathVariable int id) {
	equipementRepository.deleteById(id);
        }
     @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody Optional<Equipement> getEquipmentById(@PathVariable int id) {
	return equipementRepository.findById(id);
        }
     @PostMapping(path = "/validate")
    @CrossOrigin(origins = "http://localhost:4200")// Map ONLY GET Requests
    public void validate(@RequestBody Equipement e
    ) throws IOException {
        equipementRepository.save(e);

    }
    
}
