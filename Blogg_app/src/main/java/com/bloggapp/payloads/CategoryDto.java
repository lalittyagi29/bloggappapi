package com.bloggapp.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min=3,max=10,message="Title must have min char 3 and maximum 10 char")
	private String categoryTitle;
	@NotEmpty
	private String categoryAbout;

}
