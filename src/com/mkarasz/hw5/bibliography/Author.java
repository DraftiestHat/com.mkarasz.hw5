package com.mkarasz.hw5.bibliography;

public class Author {
	String firstName;
	String lastName;
	String initials;
	
	public Author(String author){
			
		String[] s = author.split(" ");
		this.firstName = s[0];
		if (s.length > 2){
			for (int i = 1; i < s.length - 1; i++){
				if(i == 1){
					this.initials = s[i].substring(0, 1) + ".";
				}
				else
					this.initials = (this.initials + s[i].substring(0, 1) + ".");
			}
		}
		this.lastName = s[s.length - 1];
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		if(initials == null){
			return (firstName + " " + lastName);
		}
		return (firstName + " " + initials + " " + lastName);
	}
}
