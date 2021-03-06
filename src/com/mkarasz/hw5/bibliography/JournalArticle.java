package com.mkarasz.hw5.bibliography;

import java.util.ArrayList;

public class JournalArticle extends Bibliography{
	protected String journalName;
	protected int volume;
	protected int beginPage;
	protected int endPage;
	
	
	/**
	 * Default constructor
	 */
	public JournalArticle() {
		this(null, 0, null, null, 0, 0, 0);
	}
	
	
	/**
	 * Sets all stuff in journal article
	 * @param authors the authors
	 * @param year the year of the journal
	 * @param title the title of the article
	 * @param journalName where the article was published
	 * @param volume the number of the voluem
	 * @param beginPage
	 * @param endPage
	 */
	public JournalArticle(String authors, int year, String title, String journalName, int volume, int beginPage, int endPage){
		this.authors = super.setAuthors(authors, this.authors);
		super.setTitle(title);
		super.setYear(year);
		this.journalName = journalName;
		this.volume = volume;
		this.beginPage = beginPage;
		this.endPage = endPage;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		ArrayList<Author> list = this.authors;
		Author currentAuthor;
		String retString = "";
		
		if(list == null){
			System.out.println("ERROR: No author list.");
			return null;
		}
		else if(list.size() == 1){
			currentAuthor = list.get(0);
			retString += printName(currentAuthor);
		}
		else if(list.size() == 2){
			currentAuthor = list.get(0);
			retString += printName(currentAuthor) + " AND ";
			currentAuthor = list.get(1);
			retString += printName(currentAuthor);
		}
		else {
			for(int i = 0; i < list.size() - 1; i++){
				currentAuthor = list.get(i);
				retString += printName(currentAuthor) + ", ";
			}
			retString += "AND ";
			currentAuthor = list.get(list.size() - 1);
			retString += printName(currentAuthor);
		}
		
		retString += " " + this.year + ". " + this.title + ". " + this.journalName + ". vol. " + this.volume + ". pp. " + this.beginPage + "-" + this.endPage;
		return retString;
	}
	
	/** Returns a string that prints the name correctly.
	 * @param currentAuthor the author to print
	 * @return the name in the right format
	 */
	private String printName(Author currentAuthor){
		String s = null;
		if(currentAuthor.getInitials() == null){
			s = "" + currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase();
			
		}
		else
			s = currentAuthor.getLastName().toUpperCase() + ", " + currentAuthor.getFirstName().substring(0, 1).toUpperCase() + "." + currentAuthor.getInitials().toUpperCase();
		return s;
	}
}
