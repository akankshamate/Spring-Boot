package com.Akanksha.RestFulWebservices;

import java.net.URI;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Akanksha.RestFulWebservices.Posts.Post;
import com.Akanksha.RestFulWebservices.Posts.PostRepository;

@RestController
public class UserJPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/hello-World-internationalized")
	public String helloWorldInternationalized (/*@RequestHeader(name="Accept-language",required=false)Locale locale*/)  {
		return messageSource.getMessage("good.morning.message",null, "Default Message",/* locale*/LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id) {
		
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		EntityModel<User> model=EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkToUsers = 
				linkTo(methodOn(this.getClass()).retriveAllUsers());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> creatUser(@Valid @RequestBody User user) {
		User savedUser=userRepository.save(user);
		
		//CREATED
		///users/{id}  savedUser.getId()
		
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		 userRepository.deleteById(id);
		
	}
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retriveAllUsers(@PathVariable int id){
		Optional<User> userOptional =userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return userOptional.get().getPosts();
	}
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> creatPost(@PathVariable int id,@RequestBody Post post) {
		
		Optional<User> userOptional =userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		User user=userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		URI location=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
