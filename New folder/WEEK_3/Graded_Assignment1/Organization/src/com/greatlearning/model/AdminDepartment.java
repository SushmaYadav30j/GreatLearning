package com.greatlearning.model;
import com.greatlearning.head.*;

public class AdminDepartment extends SuperDepartment {
	
	public String departmentName() {
		String DepartmentName="Welcome to Admin Department";
		return DepartmentName;
	}
	
	public String getTodaysWork() {
		String TodayWork="Complete your document Submission";
		return TodayWork;
		
	}
	
	public String getWorkDeadline() {
		String WorkDeadline="Complete by EOD";
		return WorkDeadline;
	}
	

}
