package techCallenge.Argonaute.Controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import techCallenge.Argonaute.Dto.Argonautedto;
import techCallenge.Argonaute.Entity.Argonaute;
import techCallenge.Argonaute.Repository.ArgonauteRepository;
import techCallenge.Argonaute.service.ArgonauteService;

@RestController
@RequestMapping("/argonaute")
@CrossOrigin
public class ArgonauteController {
	@Autowired
	ArgonauteService argonauteService;
	@Autowired
	ArgonauteRepository argonauteRepository;
	
	@GetMapping
	public List<Argonaute> findAll(){
		return argonauteService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Argonaute getOne(@PathVariable(required=true) Long id) {
		return argonauteService.getOne(id);
	}
	
	@PostMapping
	public Argonaute save(@Valid @RequestBody Argonautedto argonauteDto)
	throws IllegalStateException,IOException{
		return argonauteService.create(argonauteDto);
	}
	
	@PutMapping( "/{id}")
	public Argonaute update(@Valid @RequestBody Argonautedto argonauteDto, @PathVariable(required= true ) Long id) throws IOException{
		return argonauteService.update(id, argonauteDto);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) throws IOException{
		argonauteService.delete(id);
	}
	
	
	

}

