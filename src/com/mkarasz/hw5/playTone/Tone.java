package com.mkarasz.hw5.playTone;

import javax.sound.midi.*;

public class Tone {
	
	private static boolean	DEBUG = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Help from: http://jsresources.org/examples/SynthNote.java.html
	 */
	public void generateTone(Tempo tempo){ 
		int nVelocity = 127; // Don't know what this actually does, but I need it.
		
		
		Synthesizer synth = null;
		try {
			synth = MidiSystem.getSynthesizer();
		}
		catch (MidiUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		if (DEBUG) out("Synthesizer: " + synth);
		
		//Need to open the synthesizer for it to actually play
		try
		{
			synth.open();
		}
		catch (MidiUnavailableException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	
		MidiChannel[]	channels = synth.getChannels();
		MidiChannel	channel = channels[1]; //Don't know what the MIDI channel does. Gotta check it out.
		if (DEBUG) out("MidiChannel: " + channel);
		channel.noteOn(tempo.getNote().getMidiNumber(), nVelocity);
	
		try
		{
			Thread.sleep((int)tempo.calcSeconds());
		}
		catch (InterruptedException e)
		{
		}
		
		channel.noteOff(tempo.getNote().getMidiNumber());
		
		synth.close();
	}
	
	/** Also stolen from http://jsresources.org/examples/SynthNote.java.html
	 * Prints out a given string.
	 * @param strMessage
	 */
	private static void out(String strMessage)
	{
		System.out.println(strMessage);
	}

}
