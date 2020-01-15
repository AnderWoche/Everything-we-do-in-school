package de.moldiy.ticketsystem.console.command.ein_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"dieZweiGroessten"})
public class CommandDieZweiGroessten extends CommandExecuter {

	private static int[] array = {3, 1, 5, 7, 4, 12, -3, 8, -2};
	
	@Override
	public void executeComand(String[] args) {
		int groessteZahl  = Integer.MIN_VALUE;
		int zweitGroesteZahl = groessteZahl;
		
		for(int element : array) {
			if(element > groessteZahl) {
				zweitGroesteZahl = groessteZahl;
				groessteZahl = element;
				
			} else if(element > zweitGroesteZahl){
				zweitGroesteZahl = element;
			}
		}
		System.out.println(groessteZahl);
		System.out.println(zweitGroesteZahl);
	}

}
