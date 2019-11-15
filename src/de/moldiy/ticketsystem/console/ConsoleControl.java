package de.moldiy.ticketsystem.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import de.moldiy.ticketsystem.console.command.CommandExecuter;

public class ConsoleControl {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<CommandExecuter> commands = new ArrayList<CommandExecuter>();
	
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
					CommandExecuter comandExecutor = findCommand(comandTiles[0]);
					if(comandExecutor == null) {
						System.out.println("Befehl exestiert nicht!");
					} else {
						comandExecutor.executeComand(argsFortheExecutor);
					}
				}
			}
		}).start();
		
//		CommandExecuter helpComand = new CommandExecuter() {
//			@Override
//			public void executeComand(String[] args) {
//				for(CommandExecuter comandExe : commands.values()) {
//					String comandDes = comandExe.getComandDescription();
//					if(comandDes != null) System.out.println(comandExe.getComandDescription());
//				}
//			}
//		};
//		helpComand.setComandDescription("help");
//		this.commands.put("help", helpComand);
//		
//		CommandExecuter exitComand = new CommandExecuter() {
//			@Override
//			public void executeComand(String[] args) {
//				System.exit(0);
//			}
//		};
//		exitComand.setComandDescription("exit (Schlieﬂt das programm)");
//		this.commands.put("exit", exitComand);
	}
	
	public CommandExecuter findCommand(String comand) {
		for(CommandExecuter exe : commands) {
			if(exe.getCommand().equals(comand)) {
				return exe;
			}
		}
		return null;
	}
	
	public void registerCommand(CommandExecuter comand) {
		this.commands.add(comand);
	}
	
	public ArrayList<CommandExecuter> getCommands() {
		return this.commands;
	}
	
	
}
