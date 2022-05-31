package techCallenge.Argonaute.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import techCallenge.Argonaute.Dto.Argonautedto;
import techCallenge.Argonaute.Entity.Argonaute;
import techCallenge.Argonaute.Repository.ArgonauteRepository;

@Service
public class ArgonauteService {
	
	@Autowired
	ArgonauteRepository argonauteRepository;

	
	// recuperer tous les argonautes
	public List<Argonaute> findAll(){
		return argonauteRepository.findAll();
	}
	// recuperer un seul argonaute
	public Argonaute getOne(Long id) {
		Optional<Argonaute>  optArgonaute = argonauteRepository.findById(id);
		if(optArgonaute.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optArgonaute.get();
	}
	
	// creer un argonaute dans la BDD
public  Argonaute create(Argonautedto argonauteDto) throws IllegalStateException,IOException{
		
		Argonaute argonaute = new Argonaute();
		argonaute.setName(argonauteDto.getName());
		
		return argonauteRepository.save(argonaute);
	}


// modifier
public Argonaute update(Long id, Argonautedto argonauteDto) throws IOException{
	Optional<Argonaute> optArgonaute = argonauteRepository.findById(id);
	if(optArgonaute.isPresent()) {
		
		
			Argonaute argonaute =optArgonaute.get();
			argonaute.setName(argonauteDto.getName());
			return argonauteRepository.save(argonaute);
		}
	
else 
	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}

// supprimer


public void delete(Long id) throws IOException{
	Optional<Argonaute> optArgonaute= argonauteRepository.findById(id);
	if(optArgonaute.isEmpty()) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	Argonaute argonaute = optArgonaute.get();

	argonauteRepository.deleteById(id);
}





	
	

	












	}

