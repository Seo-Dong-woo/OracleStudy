package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.111:1521:XE";
	// 에러 => output => this.conn NULL
	public GoodsDAO()
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
	public void CampGoodsDetailData(GoodsVO vo)
	{
		try
		{
			getConnection();
//			String sql="INSERT INTO goods VALUES("
//					  + "goods_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getPoster());
//			ps.setInt(3, vo.getSelling_price());
//			ps.setInt(4, vo.getOriginal_price());
//			ps.setInt(5, vo.getMileage());
//			ps.setString(6, vo.getBrand());
//			ps.setString(7, vo.getSummary());
//			ps.setString(8, vo.getDelivery_price());
//			ps.setString(9, vo.getAfter_service());
			
			//goods_category
//			String sql="INSERT INTO goods_category VALUES(4, '여행용품')";
//			ps=conn.prepareStatement(sql);
//
//			ps.executeUpdate();
			
			//1번 goods
//			String sql="INSERT INTO goods1 VALUES("
//					  + "1, goods1_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getPoster());
//			ps.setInt(3, vo.getSelling_price());
//			ps.setInt(4, vo.getOriginal_price());
//			ps.setInt(5, vo.getMileage());
//			ps.setString(6, vo.getBrand());
//			ps.setString(7, vo.getDelivery_price());
//			ps.setString(8, vo.getAfter_service());
//			ps.setString(9, vo.getDetail_poster());
//			ps.executeUpdate();
			
			//2번 goods
//			String sql="INSERT INTO goods2 VALUES("
//					  + "2, goods2_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getPoster());
//			ps.setInt(3, vo.getSelling_price());
//			ps.setInt(4, vo.getOriginal_price());
//			ps.setInt(5, vo.getMileage());
//			ps.setString(6, vo.getBrand());
//			ps.setString(7, vo.getDelivery_price());
//			ps.setString(8, vo.getAfter_service());
//			ps.setString(9, vo.getDetail_poster());
//			ps.executeUpdate();
			
			//3번 goods
//			String sql="INSERT INTO goods3 VALUES("
//					  + "3, goods3_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getPoster());
//			ps.setInt(3, vo.getSelling_price());
//			ps.setInt(4, vo.getOriginal_price());
//			ps.setInt(5, vo.getMileage());
//			ps.setString(6, vo.getBrand());
//			ps.setString(7, vo.getDelivery_price());
//			ps.setString(8, vo.getAfter_service());
//			ps.setString(9, vo.getDetail_poster());
//			ps.executeUpdate();
			
			//4번 goods
			String sql="INSERT INTO goods4 VALUES("
					  + "4, goods4_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getPoster());
			ps.setInt(3, vo.getSelling_price());
			ps.setInt(4, vo.getOriginal_price());
			ps.setInt(5, vo.getMileage());
			ps.setString(6, vo.getBrand());
			ps.setString(7, vo.getDelivery_price());
			ps.setString(8, vo.getAfter_service());
			ps.setString(9, vo.getDetail_poster());
			ps.executeUpdate();
			
			// 상세보기 이미지 넣은 테이블
//			String sql="INSERT INTO example VALUES("
//					  + "1, example_gno_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, vo.getTitle());
//			ps.setString(2, vo.getPoster());
//			ps.setInt(3, vo.getSelling_price());
//			ps.setInt(4, vo.getOriginal_price());
//			ps.setInt(5, vo.getMileage());
//			ps.setString(6, vo.getBrand());
//			ps.setString(7, vo.getDelivery_price());
//			ps.setString(8, vo.getAfter_service());
//			ps.setString(9, vo.getDetail_poster());
//			ps.executeUpdate();
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
