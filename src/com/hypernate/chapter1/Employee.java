package com.hypernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "EmpoyeeInfo")
public class Employee {

	private int empId;
	private String empName;

	private String empPassword;
	private String empEmailAdress;
	private boolean isPermanent;
	private Calendar empJoinDate;
	private Date empLoginTime;

	@Transient
	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Column(nullable = false)
	public String getEmpEmailAdress() {
		return empEmailAdress;
	}

	public void setEmpEmailAdress(String empEmailAdress) {
		this.empEmailAdress = empEmailAdress;
	}

	@Basic
	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLoginTime() {
		return empLoginTime;
	}

	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}

	@Id
	@Column(name = "EmployeeId")
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
