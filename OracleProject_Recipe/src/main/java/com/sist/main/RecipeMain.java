package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.RecipeDAO;
import com.sist.dao.RecipeVO;

public class RecipeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeDAO dao=new RecipeDAO();
		RecipeVO vo=new RecipeVO();
		try
		{
			for(int i=1;i<=50;i++)
			{
				Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html?page=" + i).get();
				Elements link=doc.select("div.common_sp_thumb a");
			
				for(int j=0;j<link.size();j++)
				{
					try
					{
						String str=link.get(j).attr("href");
						String subLink="https://www.10000recipe.com" + str;
						//System.out.println(subLink);
						Document doc2=Jsoup.connect(subLink).get();
					
						// 제목
						Elements title=doc2.select("div.view2_summary h3");
						System.out.println(title.text());
						vo.setTitle(title.text());
					
						// 이미지
						Elements poster=doc2.select("div.centeredcrop img");
						System.out.println(poster.attr("src"));
						vo.setPoster(poster.attr("src"));
						
						// 작성자
						Elements writer=doc2.select("span.user_info2_name");
						System.out.println(writer.text());
						vo.setWriter(writer.text());
						
						// 조회수
						//Elements hit=doc2.select("span.hit");
						//System.out.println(hit.text());
					
						// 인분
						Elements serving=doc2.select("span.view2_summary_info1");
						System.out.println(serving.text());
						vo.setServing(serving.text());
						
						// 시간
						Elements time=doc2.select("span.view2_summary_info2");
						System.out.println(time.text());
						vo.setTime(time.text());
						
						// 난이도
						Elements difficulty=doc2.select("span.view2_summary_info3");
						System.out.println(difficulty.text());
						vo.setDifficulty(difficulty.text());
						
						// 재료
						//Elements ingredient=doc2.select("div#divConfirmedMaterialArea li");
						//String none=ingredient.text().replaceAll("구매", "");
						//System.out.println(none.replaceAll("  ", " "));
						//vo.setIngredient(ingredient.text().replace("구매", "").replaceAll("  ", " "));
						/*
						 * String none2=none.replaceAll("  ", ""); String[] arr=none2.split(" ");
						 * for(String s:arr) System.out.println(s);
						 */
						// 재료
						//Elements ingredient=doc2.select("div#divConfirmedMaterialArea li");
						//String none=ingredient.text().replaceAll("구매", "");
						//System.out.println(none.replaceAll("  ", " "));
						//vo.setIngredient(ingredient.text().replace("구매", "").replaceAll("  ", " "));
						/*
						 * String none2=none.replaceAll("  ", ""); String[] arr=none2.split(" ");
						 * for(String s:arr) System.out.println(s);
						 */
						
						Elements ingredient=doc2.select("div#divConfirmedMaterialArea li");
						
						String ingredientAll="";
						for(int x=0;x<ingredient.size();x++)
						{
				
							ingredientAll+=ingredient.get(x).text().replaceAll("구매 ", "")+"|";
							//String none=ingredient.text().replaceAll("구매", "");
							
						}
						ingredientAll=ingredientAll.substring(0, ingredientAll.lastIndexOf("|"));
						System.out.println(ingredientAll);
						
						vo.setIngredient(ingredientAll);;

				


						
						// 조리도구
						//Elements tools=doc2.select("ul.case1");
						//System.out.println(tools.text().replaceAll("구매", ""));
						
					
						// 조리 순서
						String cookingAll="";
						String cookingImageAll="";
						for(int l=1;l<=20;l++)
						{
							
							Elements cooking=doc2.select("div#stepdescr" + l);
							if(cooking.text()=="")
								break;
							///System.out.println(cooking.text());
							
							
							cookingAll+=cooking.text() + "|";
						
							
							/*
							 * if(cooking.text().contains(".")) {
							 * System.out.println(cooking.text().substring(0,
							 * cooking.text().indexOf(".")+1)); } else { System.out.println(cooking.text());
							 * }
							 */
							Elements cooking_image=doc2.select("div#stepimg" + l + " img");
							if(cooking_image.attr("src")=="")
								break;
							System.out.println(cooking_image.attr("src"));
							
							
							cookingImageAll+=cooking_image.attr("src");
							cookingImageAll+="|";
						}
						cookingAll=cookingAll.substring(0, cookingAll.lastIndexOf("|"));
						cookingImageAll=cookingImageAll.substring(0, cookingImageAll.lastIndexOf("|"));
						//System.out.println();
						vo.setCooking(cookingAll);		
						vo.setCooking_image(cookingImageAll);
						dao.RecipeDetailData(vo);
					
					}catch(Exception ex) {ex.printStackTrace();}
					
				}
				
			}
			System.out.println("SAVE END");
		}catch(Exception ex) {}
	}

}
