package com.skcraft.launcher.model.modpack;

import com.skcraft.launcher.Configuration;

import lombok.Data;
import lombok.NonNull;

@Data
public class RecommendedOptions {

	private int minMemory;
	private int maxMemory;
	private int permGen;
	
	@Data
	/**
	 * Adapter for comparing a RecommendedOptions object to a Configuration object
	 * 
	 * Used to compare all options that have corresponding values in the Configuration
	 * class to their corresponding values in an instance of the Configuration class.
	 * (at present, all fields in RecommendedOptions correspond to Configuration)
	 * 
	 */
	public class ConfigAdapter {
		
		@NonNull private RecommendedOptions recommended = RecommendedOptions.this;
		@NonNull private Configuration config;
		
		public boolean isAcceptable() {
			return isMinMemoryAcceptable() && isMaxMemoryAcceptable() && isPermGenAcceptable();
		}
		
		public boolean isMinMemoryAcceptable() {
			return config.getMinMemory() >= recommended.getMinMemory();
		}
		
		public boolean isMaxMemoryAcceptable() {
			return config.getMaxMemory() >= recommended.getMaxMemory();
		}
		
		public boolean isPermGenAcceptable() {
			return config.getPermGen() >= recommended.getPermGen();
		}
		
		public void correctConfig(){
			correctMinMemory();
			correctMaxMemory();
			correctPermGen();
		}
		
		public void correctMinMemory() {
			config.setMinMemory(recommended.getMinMemory());
		}
		
		public void correctMaxMemory() {
			config.setMaxMemory(recommended.getMaxMemory());
		}
		
		public void correctPermGen() {
			config.setPermGen(recommended.getPermGen());
		}
	}

}
