package com.mkarasz.hw5.playTone;

/** Implements a basic class for a Tempo using MIDI notes
 * @author Matt
 *
 */
public class Tempo {
	
	NoteValue noteValue;
	double bpm;
	
	/**
	 * Default constructor. Sets bpm to 60 and the note to default midi note.
	 */
	public Tempo() {
		this.noteValue = NoteValue.QUARTER;
		this.bpm = 60;
	}
	
	/**
	 * Lets you set all parameters of the Tempo.
	 * @param bpm the beats per minute of the Tempo
	 * @param note the MIDI note to store
	 */
	public Tempo(double bpm, NoteValue noteValue){
		this.noteValue = noteValue;
		this.bpm = bpm;
	}	

	/**
	 * returns the beats per minute of the Tempo
	 * @return the bpm
	 */
	public double getBpm() {
		return bpm;
	}

	/**
	 * Lets you set the beats per minute of the Tempo
	 * @param bpm the bpm to set
	 */
	public void setBpm(double bpm) {
		this.bpm = bpm;
	}

	public NoteValue getNoteValue() {
		return noteValue;
	}

	public void setNoteValue(NoteValue noteValue) {
		this.noteValue = noteValue;
	}

	/**
	 * Calculates how many seconds each note of a Tempo lasts.
	 * @return the seconds the note lasts
	 */
	public double getDuration(NoteValue noteValue){
		double bps = bpm/60;
		
		switch (this.getNoteValue()){
		case WHOLE:
			return 4 / bps;
		case HALF:
			return 2 / bps;
		case QUARTER:
			return 1 / bps;
		case EIGHTH:
			return (1/2) / bps;
		case SIXTEENTH:
			return (1/4) / bps;
		case THIRTYSECONDTH:
			return (1/8) / bps;
		case SIXTYFOURTH:
			return (1/16) / bps;
		default:
			return 0;
		}
	}
	
}
