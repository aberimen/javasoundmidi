package main;


import javax.sound.midi.*;


public class App {
	static MidiChannel midiChannel1;
	
	public static void main(String[] main)  {
		Synthesizer synthesizer = null;
		try {
			synthesizer = MidiSystem.getSynthesizer();
			synthesizer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		/*
		// Var olan enstrümanlarý göstermek için
		Soundbank sb ;
		sb = synthesizer.getDefaultSoundbank();
		Instrument[] ins = sb.getInstruments();
		for (Instrument i : ins) {
			System.out.println(i.toString());
		} 
		*/
		
		MidiChannel[] allChannels = synthesizer.getChannels();
		midiChannel1 = allChannels[0];
		midiChannel1.programChange(0); // Enstrüman numarasý -> 0: Instrument: Piano 1 
		
		
		/* sýrasýyla 			do, re , mi, fa, sol, la, si
		 * 5. aralýk notalarý ->  72, 74, 76, 77, 79, 81, 83 
		 */

		playNote(79,8);// 8lik sol notasý
		playNote(81,8);
		
		playNote(83,4);
		playNote(83,4);
		playNote(83,4);
		playNote(83,4);
		
		playNote(83,8);
		
		playNote(83,4);
		
		playNote(81,8); 

		playNote(81,8);
		
		playNote(83,4);
		
		playNote(81,8);
		
		playNote(81,8);
		
		playNote(79,8);
		playNote(81,4);
		


		playNote(79,8);
		playNote(81,8);
	
		playNote(81,4);
		playNote(81,8);
		
		playNote(79,8);
		playNote(81,4);
		

		playNote(79,8);
		playNote(79,8);
		playNote(81,8);
		playNote(83,8);		
		
		playNote(83,4);	
		
		playNote(81,8);	
		playNote(79,8);	
		
		playNote(79,4);	
		
		playNote(77,8);	
		playNote(76,8);	
		
		playNote(76,2);
		
	}
	
	static void playNote(int nota, int notaDegeri) { 
		int tempo = 120;
		int delay = (60000/tempo)*4;
			midiChannel1.noteOn(nota,100);
			try {
				Thread.sleep(delay/notaDegeri);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			midiChannel1.noteOff(nota,100);
		
	}
	


}
