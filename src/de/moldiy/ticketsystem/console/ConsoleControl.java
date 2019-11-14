package de.moldiy.ticketsystem.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ConsoleControl {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private HashMap<String, ComandExecuter> comands = new HashMap<String, ComandExecuter>();
	
	public ConsoleControl() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					String comand = "";
					try {
						comand = bufferedReader.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					String[] comandTiles = comand.split(" ");
					String[] argsFortheExecutor = null;
					if(comandTiles.length > 1) {
						argsFortheExecutor = Arrays.copyOfRange(comandTiles, 1, comandTiles.length);
					}
					ComandExecuter comandExecutor = findComand(comandTiles[0]);
					if(comandExecutor == null) {
						System.out.println("Befehl exestiert nicht!");
					} else {
						comandExecutor.executeComand(argsFortheExecutor);
					}
				}
			}
		}).start();
		
		ComandExecuter helpComand = new ComandExecuter() {
			@Override
			public void executeComand(String[] args) {
				for(ComandExecuter comandExe : comands.values()) {
					String comandDes = comandExe.getComandDescription();
					if(comandDes != null) System.out.println(comandExe.getComandDescription());
				}
			}
		};
		helpComand.setComandDescription("help");
		this.comands.put("help", helpComand);
		
		ComandExecuter exitComand = new ComandExecuter() {
			@Override
			public void executeComand(String[] args) {
				System.exit(0);
			}
		};
		exitComand.setComandDescription("exit (Schlieﬂt das programm)");
		this.comands.put("exit", exitComand);
	}
	
	public ComandExecuter findComand(String comand) {
		for(String s : comands.keySet()) {
			if(s.equals(comand)) {
				return comands.get(s);
			}
		}
		return null;
	}
	
	public void registerComand(String comandName, ComandExecuter comand) {
		this.comands.put(comandName, comand);
	}
	
	
}
