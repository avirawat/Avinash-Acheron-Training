package com.shristi.autojavabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
	
	@Bean
	@Primary
	public Instrument sguitar() {
		return new Guitar();
	}
	
	@Bean
	public Instrument spiano() {
		return new Piano();
	}
	
	@Bean
	public Instrument sviolin() {
		return new Violin();
	}
	
	@Bean
	public Performer performer() {
		return new Performer();
	}
	
}
