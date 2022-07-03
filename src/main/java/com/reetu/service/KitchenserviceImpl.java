package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.kitchen;
import com.reetu.dao.kitchenrepo;

@Service
public class KitchenserviceImpl implements kitchenService {
	
	@Autowired
	kitchenrepo kr;

	@Override
	public String add(kitchen k, MultipartFile image) {
		// TODO Auto-generated method stub
		return kr.add(k, image);
	}

	@Override
	public byte[] getimage(int setid) {
		// TODO Auto-generated method stub
		return kr.getimage(setid);
	}

	@Override
	public List<kitchen> getkitchenset() {
		// TODO Auto-generated method stub
		return kr.getkitchenset();
	}

	@Override
	public String deletebysetid(int setid) {
		// TODO Auto-generated method stub
		return kr.deletebysetid(setid);
	}

	@Override
	public List<Integer> getallidsonly() {
		// TODO Auto-generated method stub
		return kr.getallidsonly();
	}

	@Override
	public kitchen getkitchenbysetid(int setid) {
		// TODO Auto-generated method stub
		return kr.getkitchenbysetid(setid);
	}

	@Override
	public String updateimage(int setid, MultipartFile image) {
		// TODO Auto-generated method stub
		return kr.updateimage(setid, image);
	}

	@Override
	public String updatekitchenset(kitchen k) {
		// TODO Auto-generated method stub
		return kr.updatekitchenset(k);
	}

	@Override
	public List<kitchen> getlikereview(String review) {
		// TODO Auto-generated method stub
		return kr.getlikereview(review);
	}

}
