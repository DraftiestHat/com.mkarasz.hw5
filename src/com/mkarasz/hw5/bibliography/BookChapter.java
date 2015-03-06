package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class BookChapter extends Book{
	ArrayList<Author> chapterAuthors;
	String chapterTitle;
	int beginPage;
	int endPage;
	
	public BookChapter(){
		this(null, 0, null, null, null, null, 0, null, null, 0, 0);
	}
	
	public BookChapter(String authors, int year, String title, String publisher, String publicationCity, String publicationState, int numberOfPages, String chapterAuthors, String chapterTitle, int beginPage, int endPage){
		super.authors = super.setAuthors(authors);
		super.setTitle(title);
		super.setYear(year);
		super.publicationCity = publicationCity;
		super.publisher = publisher;
		super.publicationState = publicationState;
		super.numberOfPages = numberOfPages;
		this.chapterAuthors = super.setAuthors(chapterAuthors);
		this.chapterTitle = chapterTitle;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}
	
	
	
	
	public void print(){
		ArrayList<Author> list = this.chapterAuthors;
		Author currentAuthor;
		if(list == null){
			System.out.println("ERROR: No author list.");
			return;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			printName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			printName(currentAuthor);
			System.out.print(" AND ");
			currentAuthor = list.get(1);
			printName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				printName(currentAuthor);
				System.out.print(", ");
			}
			System.out.print("AND ");
			currentAuthor = list.get(list.size() - 1);
			printName(currentAuthor);
		}
		
		System.out.print(" " + this.year + ". " + this.chapterTitle + ". In " + this.title + ", ");
		
		list = this.authors;
		if(list == null){
			System.out.println("ERROR: No author list.");
			return;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			printAltName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			printAltName(currentAuthor);
			System.out.print(" AND ");
			currentAuthor = list.get(1);
			printAltName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				printAltName(currentAuthor);
				System.out.print(", ");
			}
			System.out.print("AND ");
			currentAuthor = list.get(list.size() - 1);
			printAltName(currentAuthor);
		}
		
		System.out.print(", ");
		if(list.size() > 1){
			System.out.print("Eds. ");
		}
		else
			System.out.print("Ed. ");
		
		System.out.println(this.publisher + ", " + this.publicationCity + ", " + this.publicationState + ". pp. " + this.beginPage + "-" + this.endPage);
		
	}
	
	
	private void printName(Author currentAuthor){
		if(currentAuthor.initials == null){
			System.out.printf("%s, %s.", currentAuthor.lastName.toUpperCase(), currentAuthor.firstName.substring(0, 1).toUpperCase());
		}
		else
			System.out.printf("%s, %s.%s.", currentAuthor.lastName.toUpperCase(), currentAuthor.firstName.substring(0, 1).toUpperCase(), currentAuthor.initials.toUpperCase());
	}
	
	private void printAltName(Author currentAuthor){
		if(currentAuthor.initials == null){
			System.out.printf("%s. %s", currentAuthor.firstName.substring(0, 1).toUpperCase(), currentAuthor.lastName.toUpperCase());
		}
		else
			System.out.printf("%s.%s. %s", currentAuthor.firstName.substring(0, 1).toUpperCase(), currentAuthor.initials.toUpperCase(), currentAuthor.lastName.toUpperCase());
	}
	
	
	
}
