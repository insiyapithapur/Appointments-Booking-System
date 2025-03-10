package com.training.project.dao;

import java.util.List;

public interface IDao<T> {
	//Read
	public List<T> findAll();
	public T findByPk(int id);
	//public T findByName(String name);
	
	
	//Create 
	public boolean create(T t);
	
	//Update
	public boolean update(int id,T newt);
	
	//Delete
	public boolean delete(int id);
	
}
