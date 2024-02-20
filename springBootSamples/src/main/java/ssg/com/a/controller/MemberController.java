package ssg.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("allmember")
	public List<MemberDto> allmember(){
		System.out.println("MemberController allmember :" + new Date());
		
		return service.allmember();
	}
	
	
	@PostMapping("idcheck")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck : " + new Date());
		
		boolean isS = service.idcheck(id);
		if(isS) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping("addmember")
	public String addmember(MemberDto add) {
		System.out.println("MemberController addmember :" + new Date());
		System.out.println(add.toString());
		
		boolean isS = service.addmember(add);
		if(isS) {
			return "YES";
		}
		
		return "NO";
		
	}
	
	@PostMapping("login")
	public MemberDto login(MemberDto mem) {
		System.out.println("MemberController login : " + new Date());
		
		return service.login(mem);
	}
	
}
