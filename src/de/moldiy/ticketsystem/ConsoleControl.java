package de.moldiy.ticketsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ConsoleControl {
	
	private BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	private HashMap<String, ComandExecuted> comands = new HashMap<String, ComandExecuted>();
	
	public ConsoleControl() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					String comand = "";
					try {
						comand = buffer.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					String[] comandTiles = comand.split(" ");
					String[] argsFortheExecutor = null;
					if(comandTiles.length > 1) {
						argsFortheExecutor = Arrays.copyOfRange(comandTiles, 1, comandTiles.length);
					}
					ComandExecuted comandExecutor = findComand(comandTiles[0]);
					if(comandExecutor == null) {
						System.out.println("Befehl exestiert nicht!");
					} else {
						comandExecutor.executeComand(argsFortheExecutor);
					}
				}
			}
		}).start();
	}
	
	public ComandExecuted findComand(String comand) {
		for(String s : comands.keySet()) {
			if(s.equals(comand)) {
				return comands.get(s);
			}
		}
		return null;
	}
	
	public void registerComand(String comandName, ComandExecuted comand) {
		this.comands.put(comandName, comand);
	}
	
	
}
