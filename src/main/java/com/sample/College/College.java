package com.sample.College;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="dabbaCollege")
public class College {
@Id
private int colCode;
private String name;
private int branch;
public int getColCode() {
	return colCode;
}
public void setColCode(int colCode) {
	this.colCode = colCode;
}
public int getBranch() {
	return branch;
}
public void setBranch(int branch) {
	this.branch = branch;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
