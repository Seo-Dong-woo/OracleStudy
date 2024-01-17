package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RecipeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.111:1521:XE";
	
	public RecipeDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL, "hr", "happy");
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	public void RecipeDetailData(RecipeVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO recipe VALUES("
					 + "recipe_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getPoster());
			ps.setString(3, vo.getWriter());
			ps.setString(4, vo.getServing());
			ps.setString(5, vo.getTime());
			ps.setString(6, vo.getDifficulty());
			ps.setString(7, vo.getIngredient());
			ps.setString(8, vo.getCooking());
			ps.setString(9, vo.getCooking_image());
			ps.executeUpdate();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
