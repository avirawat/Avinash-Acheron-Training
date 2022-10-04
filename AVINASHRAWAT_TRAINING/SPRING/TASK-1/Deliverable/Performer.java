package com.shristi.autojavabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class Performer {
	@Autowired
	@Qualifier("sviolin")         //by type
	Instrument instrument;
	
	@Autowired                       
	Instrument ginstrument;      //by name
	
	@Autowired
	@Qualifier("spiano")           // type
	Instrument pinstrument;
	
	
	
	
	void playSong(String type,String song) {
		System.out.println("Song type");
		if(type.equals("violin"))
			instrument.play(song);
		if(type.equals("guitar"))
			ginstrument.play(song);
		if(type.equals("piano"))
			pinstrument.play(song);
	}
}
