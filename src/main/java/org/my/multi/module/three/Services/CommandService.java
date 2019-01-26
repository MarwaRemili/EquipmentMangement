/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.multi.module.three.Services;

import org.my.multi.module.three.Entities.Command;
import org.my.multi.module.three.Repositories.CommandRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marwa
 */
@RestController    // This means that this class is a Controller
@RequestMapping(path = "/command")
public class CommandService {
    
    @Autowired
    private CommandRepository commandRepository;

    @PostMapping(path = "/add")
    @CrossOrigin(origins = "http://localhost:4200")// Map ONLY GET Requests
    public void addNewCommand(@RequestBody Command e
    ) throws IOException {

        commandRepository.save(e);

    }

    @GetMapping(path = "/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    List<Command> getAllCommands() {
        // This returns a JSON or XML with the users
        return (List<Command>) commandRepository.findAll();
    }

    @GetMapping(path = "/getCommand")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Command> getCommandById(Integer id) {
        // This returns a JSON or XML with the users
        return commandRepository.findById(id);
    }

    @PostMapping(path = "/edit")
   @CrossOrigin(origins = "http://localhost:4200")
    public void editCommand(@RequestBody Command e) {
        // This returns a JSON or XML with the users
        
        commandRepository.save(e);
       
      
        
            
        
    }

   @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteCommand(@PathVariable int id) {
	commandRepository.deleteById(id);
        }
     @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody Optional<Command> getCommandById(@PathVariable int id) {
	return commandRepository.findById(id);
        }
    @CrossOrigin(origins = "http://localhost:4200")
     @GetMapping(path = "/unvalidated")
       public @ResponseBody List<Command> findUnseen()
               {
               List<Command> l =     (List<Command>) commandRepository.findAll();
               for(int i =0 ; i< l.size();i++)
               {
                   if(l.get(i).getStatus()==true) l.remove(i);
               }
               return l;
               }
       
   
    @PostMapping(path = "/validate")
    @CrossOrigin(origins = "http://localhost:4200")// Map ONLY GET Requests
    public void validate(@RequestBody Command e
    ) throws IOException {
        commandRepository.save(e);

    }
}
