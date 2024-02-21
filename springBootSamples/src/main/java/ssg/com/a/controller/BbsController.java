package ssg.com.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@GetMapping("bbslist")
	public Map<String, Object> bbslist(BbsParam param){
		System.out.println("BbsController bbslist " + new Date());
		
		//글목록
		List<BbsDto> list = service.bbslist(param);
		
		//글의 총갯수
		int count = service.getallbbs(param);
		int pageBbs = count / 10;
		
		if((count % 10) > 0) {
			
			pageBbs = pageBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bbslist", list);
		map.put("pageBbs", pageBbs);
		
		return map;
	}
	
	@GetMapping("bbswrite")
	public String bbswrite(BbsDto dto) {
		System.out.println("BbsController write " + new Date());
		
		boolean isS = service.bbswrite(dto);
		if(isS) {
			return "YES";
		}
		
		return "NO";
	}
	
	@GetMapping("bbsdetail")
	public BbsDto bbsdetail(int seq) {
		System.out.println("BbsController bbsdetail " + new Date());
		
		service.readcount(seq);
		
	    return service.bbsdetail(seq);
	}
	
	@GetMapping("bbsupdate")
	public String bbsupdate(BbsDto dto) {
		System.out.println("BbsController bbsupdate " + new Date());

		
		boolean isS = service.bbsupdate(dto);
		if(!isS) {
			return "NO";
		}
		
		return "YES";
	}
	
	@GetMapping("bbsdelete")
	public String bbsdelete(int seq) {
		System.out.println("BbsController bbsdelete " + new Date());

		
		boolean isS = service.bbsdelete(seq);
		if(isS) {
			return "YES";
		}
		
		return "NO";
	}
}
