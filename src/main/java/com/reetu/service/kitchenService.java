package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.kitchen;

public interface kitchenService {
	public String add(kitchen k, MultipartFile image);
	public byte[] getimage(int setid);
	public List<kitchen> getkitchenset();
	public String deletebysetid(int setid) ;
	public List<Integer> getallidsonly();
	public kitchen getkitchenbysetid(int setid);
	public String updateimage(int setid, MultipartFile image);
	public String updatekitchenset(kitchen k);
	public List<kitchen> getlikereview(String review);

}
