package com.mkarasz.hw5.playTone;


/** Implements (simply) a MIDI note and its length.
 * @author Matt
 *
 */
public class MIDI {
	
	private enum Note { //made this to make switching easier
		C, CSHARP, D, DSHARP, E, F, FSHARP, G, GSHARP, A, ASHARP, B
	}
	
	int midiNumber = 0;
	NoteValue noteValue;
	/**
	 * Sets the MIDI to the default stuff, as seen in default helper method below.
	 */
	public MIDI(){
		setNoteDefault();
		noteValue = NoteValue.HALF;
	}
	
	/** Parses out the string note and sets the length
	 * @param note
	 * @param length
	 */
	public MIDI(String note, NoteValue noteValue){
		Note noteEnum = Note.A;
		String letter;
		int octave = 0;
		this.noteValue = noteValue;
		
		if(note.matches("^[A-G]{1}[#]?[-]?[0-9]{1}$")) {
			if(note.matches("[A-G]{1}[#]?[-]+[2-9]{1}")){ //checking for octaves less than -1
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.matches("[A,B]{1}[#]?[9]{1}")) { //checking for A9, A#9, and B9
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else if (note.equals("G#9")){ //couldn't do above cause G9 is valid, but G#9 isn't 
				setNoteDefault();
				System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
				return;
			}
			else{
				if(note.matches("[A-G]{1}[#]{1}.*")) {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = Note.ASHARP;
					}
					else if (letter.equals("C")){
						noteEnum = Note.CSHARP;
					}
					else if (letter.equals("D")){
						noteEnum = Note.DSHARP;
					}
					else if (letter.equals("F")){
						noteEnum = Note.FSHARP;
					}
					else
						noteEnum = Note.GSHARP;
					
					letter = note.substring(2);
					//System.out.println("" + letter + " what you entered.");
					octave = Integer.parseInt(letter);
				}
				else {
					letter = note.substring(0, 1);
					if (letter.equals("A")){
						noteEnum = Note.A;
					}
					else if (letter.equals("B")){
						noteEnum = Note.B;
					}
					else if (letter.equals("C")){
						noteEnum = Note.C;
					}
					else if (letter.equals("D")){
						noteEnum = Note.D;
					}
					else if (letter.equals("E")){
						noteEnum = Note.E;
					}
					else if (letter.equals("F")){
						noteEnum = Note.F;
					}
					else
						noteEnum = Note.G;
					
					letter = note.substring(1);
					octave = Integer.parseInt(letter);
				}
			}
		}
		else {
			System.out.println("Your note " + note + " was out of range. Setting to C4 Quarter note.");
			setNoteDefault();
			return;
		}
		
		switch (noteEnum){//performs calulation with offset
		case A:
			this.midiNumber = (69 + 0) + (octave - 4) * 12;
			break;
		case ASHARP:
			this.midiNumber = (69 + 1) + (octave - 4) * 12;
			break;
		case B:
			this.midiNumber = (69 + 2) + (octave - 4) * 12;
			break;
		case C:
			this.midiNumber = (69 - 9) + (octave - 4) * 12;
			break;
		case CSHARP:
			this.midiNumber = (69 - 8) + (octave - 4) * 12;
			break;
		case D:
			this.midiNumber = (69 - 7) + (octave - 4) * 12;
			break;
		case DSHARP:
			this.midiNumber = (69 - 6) + (octave - 4) * 12;
			break;
		case E:
			this.midiNumber = (69 - 5) + (octave - 4) * 12;
			break;
		case F:
			this.midiNumber = (69 - 4) + (octave - 4) * 12;
			break;
		case FSHARP:
			this.midiNumber = (69 - 3) + (octave - 4) * 12;
			break;
		case G:
			this.midiNumber = (69 - 2) + (octave - 4) * 12;
			break;
		case GSHARP:
			this.midiNumber = (69 - 1) + (octave - 4) * 12;
			break;
		}
	}
	
	/** Sets the MIDI number of the note and its length
	 * @param midiNumber
	 * @param length
	 */
	public MIDI(int midiNumber, NoteValue noteValue){
		this.midiNumber = midiNumber;
		this.noteValue = noteValue;
	}
	
	/** Sets the frequency of the note, and then the length
	 * @param frequency
	 * @param length
	 */
	public MIDI (double frequency, NoteValue noteValue){
		setFrequency(frequency);
		this.noteValue = noteValue;
	}
	
	/**
	 * Sets the MIDI note to default stuff. Easier on me than writing same code 40 times.
	 */
	private void setNoteDefault(){
		this.midiNumber = 60;
		this.noteValue = NoteValue.HALF;
	}
	
	/** Lets you set the frequency of the current MIDI note
	 * @param frequency to set
	 */
	public void setFrequency(double frequency){
		this.midiNumber = (int) (12 * (Math.log(frequency/440)/Math.log(2)) + 69);
	}
	
	/** Gets you the frequency of the current MIDI note
	 * @return frequency of the note
	 */
	public double getFrequency(){ //Hz
		return Math.pow(2, ((double)this.midiNumber - 69)/12) * 440;
	}
		
	/** Lets you set the MIDI number of the current note
	 * @param midi the MIDI number to set
	 */
	public void setMidiNumber(int midi){
		this.midiNumber = midi;
	}
	
	/** gets you the MIDI number of the current note
	 * @return midi number of note
	 */
	public int getMidiNumber(){
		return this.midiNumber;
	}
	
	/** lets you set the octave of the note. Doesn't affect where it is in the scale.
	 * @param octave the octave the note should take
	 */
	public void setOctave(int octave){
		int last = this.midiNumber % 12;
		this.midiNumber = octave * 12 + 12 + last;
	}
	
	/** Gets you the octave of the current note.
	 * @return the octave from -1 to 9
	 */
	public int getOctave(){
		return (int) ((this.midiNumber / 12) - 1);
	}
	
	/** Sets the note to sharp if it can be, else prints error and does nothing.
	 * 
	 */
	public void setSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
		case 2:
		case 5:
		case 7:
		case 9:
			this.midiNumber++;
			break;
		default:
			System.out.println("The current midi number cannot be made sharper.");
		}
	}
	
	/** Returns whether or not the note is sharp.
	 * @return true - note is sharp, else false
	 */
	public boolean isSharp(){
		int check = this.midiNumber % 12;
		switch(check){
		case 1:
		case 3:
		case 6:
		case 8:
		case 10:
			return true;
		default:
			return false;
		}
	}
	
	/** Returns the note of the current MIDI note
	 * @return the note
	 */
	public String getNote(){
		int check = this.midiNumber % 12;
		switch(check){
		case 0:
			return "C";
		case 1:
			return "C#";
		case 2:
			return "D";
		case 3:
			return "D#";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "F#";
		case 7:
			return "G";
		case 8:
			return "G#";
		case 9:
			return "A";
		case 10:
			return "A#";
		default:
			return "B";
		}
	}
	
	
	
	public NoteValue getNoteValue() {
		return noteValue;
	}

	public void setNoteValue(NoteValue noteValue) {
		this.noteValue = noteValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "SPN: " + getNote() + getOctave() + ", Frequency: " + getFrequency() + ", MIDI Number: " + getMidiNumber(); 
	}










}
