package com.MS.versionigController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	
	@GetMapping(value= "/person/v1")
	public Personv1 getPersonv1() {
		return new Personv1("Akash Singh");
	}
	
	@GetMapping(value= "/person/v2")
	public Personv2 getPersonv2() {
		return new Personv2(new Name("Akash","Singh"));
	}
	
	@GetMapping(value= "/person" , params = "v1")
	public Personv1 getPersonparamv1() {
		return new Personv1("Akash Singh");
	}
	
	@GetMapping(value= "/person" , params = "v2")
	public Personv2 getPersonparamv2() {
		return new Personv2(new Name("Akash","Singh"));
	}
	
	
	@GetMapping(value= "/person" , headers = "version=1")
	public Personv1 getPersonHeaderv1() {
		return new Personv1("Akash Singh");
	}
	
	@GetMapping(value= "/person" , headers = "version=2")
	public Personv2 getPersonHeaderv2() {
		return new Personv2(new Name("Akash","Singh"));
	}
	
	
	@GetMapping(value= "/person" , produces = "application/v1+json")
	public Personv1 getPersonMediav1() {
		return new Personv1("Akash Singh");
	}
	@GetMapping(value= "/person" , produces = "application/v2+json")
	public Personv2 getPersonMediav2() {
		return new Personv2(new Name("Akash","Singh"));
	}
	

}
