package com.bridgelabz.redisexample.model;

import java.io.Serializable;
/**
 * generated getters and setter and constructor
 * @author chaithra B N
 *
 */
public class User implements Serializable {
private String id;
private String name;
private Long salary;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User(String id, String name, Long salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
}
public Long getSalary() {
	return salary;
}
public void setSalary(Long salary) {
	this.salary = salary;
}

}
