package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.Connection;


public class Employee_ManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		try {
		System.out.println("*******Menue*********");
		Thread.sleep(1000);
		System.out.println("Press 1 to add the Employe informations");
		Thread.sleep(500);
		System.out.println("Press 2 to view the list of employee in tabular form");
		Thread.sleep(500);
		System.out.println("Press 3 to edit the employee informations");
		Thread.sleep(500);
		System.out.println("Press 4 to delete the employee information");
		Thread.sleep(500);
		System.out.println();
		System.out.println("Enter Youre Choice : ");
		int cho=sc.nextInt();
		
		if(cho==1) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_JDBC?useSSL=false","root","Yash@3112");
			
			 System.out.println("Enter Youre Name");
			 String a=sc1.nextLine();
			 System.out.println("Enter Youre Email : ");
			 String emai=sc1.nextLine();
			 System.out.println("Enter Youre Position");
			 String b=sc1.nextLine();
			 System.out.println("Enter Youre City : ");
			 String cit=sc1.nextLine();
			 System.out.println("Enter Youre Country : ");
			 String cont=sc1.nextLine();
			 System.out.println("Enter Youre City_ID : ");
			 String cont_ID=sc1.nextLine();
			 System.out.println("Enter Youre Salary: ");
			 int des=sc.nextInt();
			 String sql="insert into Employee_Manage(name,email,position,salary,Doj,city,country, Contry_ID)values(?,?,?,?,?,?,?,?)";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, a);
			 ps.setString(2, emai);
			 ps.setString(3, b);
			 ps.setInt(4, des);
			 ps.setString(5, "2024/2/5");
			 ps.setString(6,cit);
			 ps.setString(7,cont);
			 ps.setString(8,cont_ID);
			 
			 // step 4 the query
			 ps.executeUpdate();
			 // step 5 
			 con.close();
			 
			 System.out.println("Data Inserted Successfully");
			 
		}
		if(cho==2) {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_JDBC","root","Yash@3112");
				
				Statement st= con.createStatement();
				
				ResultSet rs=st.executeQuery("select * from Employee_Manage");
				
				 System.out.println("------EMPLOYEE DETAILS----------");
			        while(rs.next())
			        {
			        	
			         System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3)+" \t   "+rs.getString(4)+" \t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9));	
			        }
		}
		if(cho==3) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_JDBC","root","Yash@3112");
			
			System.out.println("Input Youre id");
			int id=sc.nextInt();
			System.out.println("Input Youre DepName");
			String dep=sc1.nextLine();
			
			
			String query="update Employee_Manage set  position=? where id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(2,id );
			ps.setString(1, dep);
			int statement=0;
			statement=ps.executeUpdate();
			if(statement>0) {
				System.out.println("Data Updated");
			}else {
				System.out.println("Error");
			}
			
		}
		if(cho==4) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project_JDBC","root","Yash@3112");
			
			System.out.println("Enter Youre Employee Id : ");
			int id=sc.nextInt();
			
			String query="delete from Employee_Manage where id="+id;
			PreparedStatement ps=con.prepareStatement(query);
			int up=0;
			up=ps.executeUpdate();
			if(up>0) {
				System.out.println("Data Deleted");
			}else {
				System.out.println("Someting Went Wrong");
			}
		}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
