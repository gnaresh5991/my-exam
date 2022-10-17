package com.test.consepts;


import java.util.*;

public class EmpController {


	public static void empInfo()
	{
	List<Employee> emp=new ArrayList<>();
		
	Scanner s=new Scanner(System.in);
	Employee e=new Employee();
	System.out.println("enter the  employee id  :");
	int eid=s.nextInt();
	System.out.println("enter employee name  ");
	String un=s.next();
	System.out.println("enter  employee city ");
	String ct=s.next();
	System.out.println("enter employee pincde ");
	int pin=s.nextInt();
	
	
	e.setEmpid(eid);
	e.setName(un);
	e.setAddress(ct);
	e.setPincode(pin);
	
	emp.add(e);
	
	EmployeeService es=new EmployeeService();

	System.out.println("enter your choice ");
	System.out.println("1.Display\n2.Insert\n3.Update\n4.Delete");
	int ch=s.nextInt();
	switch(ch)
	{
	case 1:  es.displayEmployee(e);break;
	case 2:  es.addEmployee(e);	break;
	case 3:  es.updateEmployee(e);break;
	case 4:  es.deleteEmployee(e);break;
	default : System.out.println("Invalid input !");
	}
	s.close();
	}
	public static void main(String[] args) {
		empInfo();
	}
}

