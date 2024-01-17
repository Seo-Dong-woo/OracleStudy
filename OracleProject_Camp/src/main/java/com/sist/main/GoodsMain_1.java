package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.GoodsDAO;
import com.sist.dao.GoodsVO;

public class GoodsMain_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodsDAO dao=new GoodsDAO();
		GoodsVO vo=new GoodsVO();
		try
		{
			for(int i=1;i<=19;i++)
			{
				Document doc=Jsoup.connect("https://campinglist.co.kr/product/list.html?cate_no=174&page=" + i).get();
				Elements link=doc.select("strong.name a");
			
				for(int j=0;j<link.size();j++)
				{
					try
					{
						String str=link.get(j).attr("href");
						String subLink="https://campinglist.co.kr" + str;
						//System.out.println(subLink);
						Document doc2=Jsoup.connect(subLink).get();
					
						// 제목
						Elements title=doc2.select("div.headingArea");
						vo.setTitle(title.text());
					
						// 이미지
						Elements poster=doc2.select("div.keyImg a img");
						vo.setPoster(poster.attr("src"));
					
						// 판매가
						Elements selling_price=doc2.select("strong#span_product_price_text");
						vo.setSelling_price(Integer.parseInt(selling_price.text().replaceAll("[^0-9]", "")));
					
						// 기존판매가
						Elements original_price=doc2.select("span#span_product_price_custom");
						if(original_price.text()=="")
							vo.setOriginal_price(Integer.parseInt(selling_price.text().replaceAll("[^0-9]", "")));
						else
							vo.setOriginal_price(Integer.parseInt(original_price.text().replaceAll("[^0-9]", "")));
						
						// 상세보기 이미지
						try
						{
						String detailPosterAll="";
						Elements detail_poster=doc2.select("div.continner img");
						for(int z=0;z<detail_poster.size();z++)
						{
							
							detailPosterAll+=detail_poster.get(z).attr("src") + "|";
						}
						detailPosterAll=detailPosterAll.substring(0, detailPosterAll.lastIndexOf("|"));
						
						vo.setDetail_poster(detailPosterAll);
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
		
					
						// 합쳐져 있는 데이터 인덱스로 값 받음
						for(int k=0;k<=6;k++)
						{
							try
							{
								Element etc=doc2.select("div.disnoul_left").get(k);
								// 적립금(마일리지)
								if(etc.text().contains("적립금"))
								{
									Element mileage=doc2.select("div.disnoul_right").get(k);
									vo.setMileage(Integer.parseInt(mileage.text().substring(0, mileage.text().length()-6).replaceAll("[^0-9]", "")));
									//System.out.println(mileage.text().substring(0, mileage.text().length()-6).replaceAll("[^0-9]", ""));
								}
								// 브랜드
								else if(etc.text().contains("브랜드"))
								{
									Element brand=doc2.select("div.disnoul_right").get(k);
									vo.setBrand(brand.text());
									//System.out.println(brand.text());
								}
								// 상품 요약 정보
//								else if(etc.text().contains("상품요약정보"))
//								{
//									Element summary=doc2.select("div.disnoul_right").get(k);
//									vo.setSummary(summary.text());
//									//System.out.println(summary.text());
//								}
								// 배송비
								else if(etc.text().contains("배송비"))
								{
									Element delivery_price=doc2.select("div.disnoul_right").get(k);
									vo.setDelivery_price(delivery_price.text().substring(23, delivery_price.text().length()-21));
									//System.out.println(delivery_price.text().substring(23, delivery_price.text().length()-21));
								}
								else if(etc.text().contains("A/S안내"))
								{
									Element after_service=doc2.select("div.disnoul_right").get(k);
									vo.setAfter_service(after_service.text());
									//System.out.println(after_service.text());
								}
							
						
							}catch(Exception ex) {}
						
						}
						dao.CampGoodsDetailData(vo);
					
					}catch(Exception ex) {}
					
				}
				
			}
			System.out.println("SAVE END");
		}catch(Exception ex) {}
		
	}
	
}
