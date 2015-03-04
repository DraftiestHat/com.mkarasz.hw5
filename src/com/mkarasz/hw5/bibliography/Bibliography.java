package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public abstract class Bibliography {
	ArrayList<Author> author;
	int year;
	String title;
	
	private ArrayList<String> getAuthor() {
		return author;
	}
	private void setAuthor(ArrayList<String> author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
