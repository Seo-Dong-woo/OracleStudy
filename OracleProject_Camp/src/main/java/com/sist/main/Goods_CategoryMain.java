package com.sist.main;

import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

public class Goods_CategoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsDAO dao=new GoodsDAO();
		GoodsVO vo=new GoodsVO();
		dao.CampGoodsDetailData(vo);
	}

}
