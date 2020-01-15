package de.moldiy.ticketsystem.console.command.zwei_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"2dArraySumme"})
public class zweiDArraySumme extends CommandExecuter {

	private static int[][] array = {
			{4, 0, 2, 44},	
			{3, 20, 33, -4},
			{12, -30, 6, 110}
	};
	
	@Override
	public void executeComand(String[] args) {
		int Summe = 0;
		for(int[] x : array) {
			for(int y : x) {
				Summe += y;
			}
		}
		System.out.println("Die Gesammt Summe des 2D Arrays ist " + Summe);
	}
}
