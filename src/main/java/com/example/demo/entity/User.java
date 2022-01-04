package com.example.demo.entity;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Document("users")
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String[] role;
	
	
}
