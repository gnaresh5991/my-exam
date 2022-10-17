package com.test.consepts;

import java.sql.*;
import java.util.*;

public class EmployeeService implements EmployeeDao {

	List<Employee> emp=new ArrayList<>();
	@Override
	public void displayEmployee(Employee e) {
		try{
			Connection con=ConnectionFactory.getConnection();
			
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from employee");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
		}
		catch (Exception x)
		{
			System.out.println(x);
		}
	}
	
	@Override
	public void addEmployee(Employee e) {
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement stm=con.createStatement();
			int k=stm.executeUpdate("INSERT INTO `springdb`.`employee` (`id`, `name`, `address`, `pincode`) VALUES ('"+e.getEmpid()+"', '"+e.getName()+"', '"+e.getAddress()+"', '"+e.getPincode()+"')");
			if(k!=0) System.out.println("data inserted successfully  !");
		}
		catch (Exception x)
		{
			System.out.println(x);

		}
	}

	@Override
	public void updateEmployee(Employee e) {
		try{
			Connection con=ConnectionFactory.getConnection();
			Statement stm=con.createStatement();
			int k=stm.executeUpdate("UPDATE `springdb`.`employee` SET `name` = '"+e.getName()+"', `address` = '"+e.getAddress()+"', `pincode` = '"+e.getPincode()+"' WHERE (`id` ='"+e.getEmpid()+"' )");
			if(k!=0) System.out.println("data updated successfully !");
		}
		catch (Exception x)
		{
			System.out.println(x);

		}		
	}

	@Override
	public void deleteEmployee(Employee e) {

		try{
			Connection con=ConnectionFactory.getConnection();
			Statement stm=con.createStatement();
			System.out.println(e.getEmpid());

			int k=stm.executeUpdate("DELETE FROM `springdb`.`employee` WHERE (`id` = '"+e.getEmpid()+"')");
			if(k!=0) System.out.println("data deleted successfully!");
		}
		catch (Exception x)
		{
			System.out.println(x);
		}		
	}
}
