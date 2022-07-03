package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.kitchen;

@Repository
public class kitchenrepo {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	//to add kitchenset
	public String add(kitchen k, MultipartFile image){
		try {
			  String query="insert into kpattern values(?,?,?,?)";
			  int x=jdbctemplate.update(query,new Object[] {k.getSetid(), image.getInputStream(), k.getSetname(), k.getReview()});
			  if(x!=0) {
				  return "success";
			  }else {
				  return "failed";
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
		
	}
	
	//get the image
	public byte[] getimage(int setid) {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				return rs.getBytes("image");
			}
			
		}
		try {
			
			String query="select image from kpattern where setid=?";
			byte[] b=(byte[])jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {setid});
			return b;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	//get the kitchen set
	public List<kitchen> getkitchenset(){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				kitchen k=new kitchen();
				k.setSetid(rs.getInt("setid"));
				k.setSetname(rs.getString("setname"));
				k.setReview(rs.getString("review"));
				
				return k;
			}
			
		}
		try {
			String query="select * from kpattern";
			List<kitchen> b=jdbctemplate.query(query, new DataMapper());
			return b;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//delete by setid
	public String deletebysetid(int setid) {
		
		try {
			
			String query="delete from kpattern where setid=?";
			int x=jdbctemplate.update(query, new Object[] {setid});
			if(x!=0){
				return "success";
			}else {
				return "failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//get all setids only
	public List<Integer> getallidsonly() {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				return rs.getInt("setid");
			}
			
		}
		try {
			
			String query="select * from kpattern";
			List<Integer> ids=jdbctemplate.query(query, new DataMapper());
			return ids;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	//get kitchen by id
	public kitchen getkitchenbysetid(int setid) {
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				kitchen k=new kitchen();
				k.setSetid(rs.getInt("setid"));
				k.setSetname(rs.getString("setname"));
				k.setReview(rs.getString("review"));
				
				return k;
			}
			
		}
		try {
			String query="select * from kpattern where setid=?";
			kitchen k=(kitchen)jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {setid});
			return k;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	//update image
	public String updateimage(int setid, MultipartFile image) {
		try {
			
			String query="update kpattern set image=? where setid=?";
			int x=jdbctemplate.update(query, new Object[] {image.getInputStream(), setid});
			if(x!=0) {
				return "success";
			}else {
				return "failed";
			}
		} catch (Exception e){
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
		}
	}
	
	//update kitchen set 
	public String updatekitchenset(kitchen k){
		try {
			String query="update kpattern set setname=?,  review=? where setid=?";
			int x=jdbctemplate.update(query, new Object[] {k.getSetname(), k.getReview(), k.getSetid()});
			if(x!=0) {
				return "success";
			}else {
				return "failed";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "falied";
		}
		
	}
	
	//like review kitchenset
	public List<kitchen> getlikereview(String review){
		class DataMapper implements RowMapper{

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				kitchen k=new kitchen();
				k.setSetid(rs.getInt("setid"));
				k.setSetname(rs.getString("setname"));
				k.setReview(rs.getString("review"));
				
				return k;
			}
			
		}
		try {
			String query="select * from kpattern where review like?";
			List<kitchen> k=jdbctemplate.query(query, new DataMapper(), new Object[] {"%"+review+"%"});
			return k;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
