package com.greatlearning.model;
import com.greatlearning.head.*;

public class TechDepartment extends SuperDepartment{
	
	public String departmentName() {
		String DepartmentName="Welcome to Tech Department";
		return DepartmentName;
	}
	
	public String getTodaysWork() {
		String TodayWork="Complete coding of module 1";
		return TodayWork;
		
	}
	
	public String getWorkDeadline() {
		String WorkDeadline="Complete by EOD";
		return WorkDeadline;
	}
	
	public String getTechStackInformation() {
		String TechStackInformation="core Java";
		return TechStackInformation;
		
	}

}
