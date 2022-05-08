package com.greatlearning.model;
import com.greatlearning.head.*;

public class HrDepartment extends SuperDepartment {
	
	public String departmentName() {
		String DepartmentName="Welcome to HR Department";
		return DepartmentName;
	}
	
	public String getTodaysWork() {
		String TodayWork="Fill today's timesheet and mark your attendance";
		return TodayWork;
		
	}
	
	public String getWorkDeadline() {
		String WorkDeadline="Complete by EOD";
		return WorkDeadline;
	}
	
	public String doActivity() {
		String Activity="Team Launch";
		return Activity;
		
	}

}
