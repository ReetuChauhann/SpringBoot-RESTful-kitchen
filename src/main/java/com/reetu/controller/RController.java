package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.kitchen;
import com.reetu.service.kitchenService;

@RestController
public class RController {
	
	@Autowired
	kitchenService ks;
	
	@RequestMapping("/")
	public String page() {
		return "welcome honey";
	}
	
	@PostMapping("/addkitchenset")
	public ResponseEntity<String> addkitchenset(@RequestPart("kitchen") kitchen k, @RequestPart("image") MultipartFile image){
		String r=ks.add(k, image);
		if(r.equals("success")) {
			return new ResponseEntity<String>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	@GetMapping("/getallkitchen")
	public List<kitchen> getallkitchen() {
		List<kitchen> k=ks.getkitchenset();
		return k;
	}
	
	@GetMapping("/getallids")
	public List<Integer> getallids(){
		List<Integer> ids=ks.getallidsonly();
		return ids;
	}
	
	@GetMapping("/getlikereview/{review}")
	public List<kitchen> getlikereview(@PathVariable("review") String review){
		List<kitchen> k=ks.getlikereview(review);
		return k;
		
	}
	
	@GetMapping("/getkitchenbyid/{setid}")
	public kitchen getkitchennyid(@PathVariable("setid") int setid) {
		kitchen k=ks.getkitchenbysetid(setid);
		return k;
		
	}
	
	@DeleteMapping("/deletekitchenbyid/{setid}")
	public ResponseEntity<String> deletebysetid(@PathVariable("setid") int setid) {
		String r=ks.deletebysetid(setid);
		if(r.equals("success")) {
			return new ResponseEntity<String>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	@PutMapping("/updatekitchenset")
	public ResponseEntity<String> updatekitchenset(@RequestBody kitchen k){
		String r=ks.updatekitchenset(k);
		if(r.equals("success")) {
			return new ResponseEntity<String>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED);
		}
	}
	
       @PutMapping("/updateimage") public ResponseEntity<String> updateimage(int setid, @RequestPart("image") MultipartFile image){ 
    	   String r=ks.updateimage(setid, image); 
        if(r.equals("success")) { 
	    return new  ResponseEntity<String>(r, HttpStatus.OK);
      }else { 
	  
    	return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED); 
	  }
   }

	
//	@PutMapping("/updateimage/{setid}")
//	public ResponseEntity<String> updateimage(@PathVariable("setid") int setid, @RequestPart("image") MultipartFile image){
//		String r=ks.updateimage(setid, image);
//		if(r.equals("success")) {
//			return new ResponseEntity<String>(r, HttpStatus.OK);
//		}else {
//			return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED);
//		}
//	}
	
	@GetMapping("/getimage/{setid}")
	public byte[] getimage(@PathVariable("setid") int setid) {
		byte[] b=ks.getimage(setid);
		return b;
	}

}
