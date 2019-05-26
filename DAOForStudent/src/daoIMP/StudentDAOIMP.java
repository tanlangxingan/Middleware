package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// 添加操作
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id, name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        //pstmt.setString(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  }
	      }

	    public void update(Student s){
	    String sql = "UPDATE student SET name =? Where id = ? ";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setString(1,s.getName());
	        pstmt.setLong(2,s.getID());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){ }
	    

	    }



	//public void delete(String iD){}//作业1
	    
	//public List findAll(){}//作业2



	public Student findByID(long iD){ 
	Student student = null;
	String sql = "SELECT id, name FROM student Where id = ? ";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1, iD);
	        ResultSet rs = pstmt.executeQuery();
	  
	        
	        if(rs.next()){
	student = new Student();
	student.setID(rs.getLong(1));
	student.setName(rs.getString(2));}
	rs.close();
	pstmt.close();
	conn.close();
	
	        }
	     catch(Exception e){ }
	
	     return student;
	}



	}
