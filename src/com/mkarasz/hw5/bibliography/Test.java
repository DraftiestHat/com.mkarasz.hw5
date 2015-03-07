package com.mkarasz.hw5.bibliography;


public class Test {

	public static void main(String[] args) {
		JournalArticle art = new JournalArticle("Adam M. Abdelbar and Sam Morris Hedetniemi", 1998, "Approximating MAPs for belief networks in NP-hard and other theorems", "Artificial Intelligence", 102, 21, 38);
		art.print();
		System.out.println();
		
		Newspaper news = new Newspaper("Edward White", "Chatting a singer up the pop charts", 3, 23, 1999, "Wall Street Journal");
		news.print();
		System.out.println();
		
		//public BookChapter(String authors, int year, String title, String chapterAuthors, String chapterTitle, String publisher, String publicationCity, String publicationState, int beginPage, int endPage)
		BookChapter bookChap = new BookChapter("Hunter S. Thompson", 1976, "Richard Nixon and how the Washington Redskins lost the Vietnam War", "New Journalism Anthology", "Tom Wolfe", "Random House", "New York", "NY", 17, 52);
		bookChap.print();
		System.out.println();
		bookChap = new BookChapter("Tom Wolfe", 1976, "New Journalism Anthology", "Hunter S. Thompson", "Richard Nixon and how the Washington Redskins lost the Vietnam War", "Random House", "New York", "NY", 17, 52);
		bookChap.print();
		System.out.println();
		bookChap = new BookChapter("Robert Wison and Frank Keil", 1999, "The Encyclopedia of Cognitive Science", "Explanation-based learning", "Robert Greiner","MIT Press", "Cambridge", "MA", 301, 303);
		bookChap.print();
		System.out.println();
		bookChap = new BookChapter("Mark Twain, Henry David Thoreau, and Ralph Waldo Emerson", 1881, "Fear of the Opulent Eyeball and Other Meditations Along the Reflecting Pond", "Mark Twain", "A Connecticut Yankee in Transcendental Land", "Random House", "New York", "NY", 117, 132);  
		bookChap.print();
		System.out.println();
		
		Book book;
		book = new Book("Morgan Ginsberg", 1987, "Readings in Nonmonotonic Reasoning", "Morgan Kaufmann", "Los Altos", "CA", 454);
		book.print();
		System.out.println();
		
		book = new Book("Mark Twain and Henry David Thoreau", 1880, "The Book That Never Was", "Random House", "New York", "NY", 608);
		book.print();
		System.out.println();
		book = new Book("Mark Twain, Henry David Thoreau, and Ralph Waldo Emerson", 1881, "Fear of the Opulent Eyeball and Other Meditations Along the Reflecting Pond", "Random House", "New York", "NY", 1573); 
		book.print();
		System.out.println();
		
		//don't name this class "URL" -- Java already uses that name
		WebReference web = new WebReference("A Memory-Efficient Doubly Linked List", "Pete Sinah", 2004, 2, 14, 2013, "http://www.linuxjournal.com/article/6828?page=0,0");
		web.print();
		System.out.println();
		web = new WebReference("Android", 2012, 2, 14, 2012, "http://www.android.com");
		web.print();
		System.out.println();
		
		Poem poem = new Poem("Robert Burns", "Red, Red Rose.", 1995, "100 Best-Loved Poems.", "Philip Smith", "New York", "Dover", 26, 26, "Print"); // with editor
		poem.print();
		System.out.println();
		poem = new Poem("Walt Whitman", "I Sing the Body Electric.", 1991, "Selected Poems.", "New York", "Dover", 12, 19, "Print"); // without editor
		poem.print();
		System.out.println();
		//Poem(String authors, String title, int year, String collection, String publicationState, String publisher, int beginPage, int endPage, String medium)
	}

}
