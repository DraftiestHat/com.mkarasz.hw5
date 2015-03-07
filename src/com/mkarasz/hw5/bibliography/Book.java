package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class Book extends Bibliography {
	protected String publisher;
	protected String publicationCity;
	protected String publicationState;
	protected int numberOfPages;
	
	public Book(){
		this(null, 0, null, null, null, null, 0);
	}
	
	public Book(String authors, int year, String title, String publisher, String publicationCity, String publicationState, int numberOfPages){
		this.authors = super.setAuthors(authors);
		super.setTitle(title);
		super.setYear(year);
		this.publicationCity = publicationCity;
		this.publisher = publisher;
		this.publicationState = publicationState;
		this.numberOfPages = numberOfPages;
	}
	
	public void print(){
		ArrayList<Author> list = this.authors;
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
		
		System.out.print(" ");
		
		System.out.println(this.year + ". " + this.title + ". " + this.publisher + ", " + this.publicationCity + ", " + this.publicationState + ". " + this.numberOfPages + " pp.");
		
	}
	
	private void printName(Author currentAuthor){
		if(currentAuthor.getInitials() == null){
			System.out.printf("%s, %s.", currentAuthor.getLastName().toUpperCase(), currentAuthor.getFirstName().substring(0, 1).toUpperCase());
		}
		else
			System.out.printf("%s, %s.%s", currentAuthor.getLastName().toUpperCase(), currentAuthor.getFirstName().substring(0, 1).toUpperCase(), currentAuthor.getInitials().toUpperCase());
	}
}
