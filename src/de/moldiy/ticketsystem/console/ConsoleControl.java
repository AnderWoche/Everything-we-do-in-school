package de.moldiy.ticketsystem.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;
import de.moldiy.ticketsystem.console.command.ExitCommand;

public class ConsoleControl {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	private ArrayList<CommandExecuter> commands = new ArrayList<CommandExecuter>();
	private HashMap<String, CommandExecuter> commands = new HashMap<String, CommandExecuter>();
	
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
					CommandExecuter comandExecutor = commands.get(comandTiles[0]);
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
	
	public <T extends CommandExecuter> void registerCommand(T command) {
		if(ExitCommand.class.isAnnotationPresent(ExecuteCommand.class)) {
			for(String exeCommand : command.getClass().getAnnotation(ExecuteCommand.class).value()) {
				if(!this.commands.containsKey(exeCommand)) {
					this.commands.put(exeCommand, command);
				} else {
					throw new CommandNameAlreadyInUseExeption("The ExeCuteCommandName "+ exeCommand +" is already used");
				}
			}
		} else {
			throw new NoCommandNameExeption("No (ExecuteCommand) Annotation found in the Class");
		}
	}
	
	public class NoCommandNameExeption extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public NoCommandNameExeption(String text) {
			super(text);
		}
	}
	
	public class CommandNameAlreadyInUseExeption extends RuntimeException {
		private static final long serialVersionUID = 7470171960944793155L;
		public CommandNameAlreadyInUseExeption(String text) {
			super(text);
		}
	}
}
