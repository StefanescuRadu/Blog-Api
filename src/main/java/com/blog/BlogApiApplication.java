package com.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.blog.entities.Role;
import com.blog.repositories.RoleRepo;
import com.blog.utils.AppConstants;

@SpringBootApplication
public class BlogApiApplication implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.passwordEncoder.encode("xyz"));
		
		try {
			
			Role admin_role = new Role();
			admin_role.setId(AppConstants.ADMIN_USER);
			admin_role.setName("ADMIN_USER");
			
			Role normal_role = new Role();
			normal_role.setId(AppConstants.NORMAL_USER);
			normal_role.setName("NORMAL_USER");
			
			List<Role> roles = List.of(admin_role,normal_role);
			
			List<Role> result = this.roleRepo.saveAll(roles);
			
			result.forEach(r -> {
				System.out.println(r.getName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
