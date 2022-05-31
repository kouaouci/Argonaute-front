package techCallenge.Argonaute.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Argonautedto {

	// DTO attributes

	
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;

	// DTO GETTERS 1 SETTERS
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
