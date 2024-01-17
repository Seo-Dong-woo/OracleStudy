package com.sist.dao;

public class RecipeVO {
	private int no;
	private String title, poster, writer, serving, time, difficulty, ingredient, cooking, cooking_image;
	
	public int getno() {
		return no;
	}
	public void setno(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getServing() {
		return serving;
	}
	public void setServing(String serving) {
		this.serving = serving;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getCooking() {
		return cooking;
	}
	public void setCooking(String cooking) {
		this.cooking = cooking;
	}
	public String getCooking_image() {
		return cooking_image;
	}
	public void setCooking_image(String cooking_image) {
		this.cooking_image = cooking_image;
	} 
}
