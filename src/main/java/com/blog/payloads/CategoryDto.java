package com.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min = 4 , message = "Minimum size is 4 characters")
	private String categoryTitle;
	
	@NotBlank
	@Size(max = 10 , message = "Maximum size is 10 characters")
	private String categoryDescription;
}
