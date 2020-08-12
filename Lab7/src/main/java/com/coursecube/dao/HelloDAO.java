package com.coursecube.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDAO {
	public HelloDAO(){
	    System.out.println("Hello DAO-D.C");
    }
    public void show(){
	    System.out.println("HelloDAO - show()");
    }
}
