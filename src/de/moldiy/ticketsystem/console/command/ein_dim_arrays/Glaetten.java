package de.moldiy.ticketsystem.console.command.ein_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"glaetten"})
public class Glaetten extends CommandExecuter {

	private static int[] array = {5, 5, 4, 5, 6, 6, 7, 6, 5, 4, 1, 4};
	private static int[] geglaettet = new int[array.length];

	@Override
	public void executeComand(String[] args) {
		geglaettet[0] = (array[0] + array[1]) / 2;
		geglaettet[geglaettet.length -1] = (array[array.length -1] + array[array.length -2]) / 2;
		
		for(int i = 1; i < array.length - 1; i++) {
			geglaettet[i] = (array[i-1] + array[i] + array[i+1]) / 3;
		}
		for(int output : geglaettet) {
			System.out.print(output + " ");
		}
		System.out.println();
	}

}
