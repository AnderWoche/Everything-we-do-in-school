package de.moldiy.ticketsystem.console.command.ein_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;
@ExecuteCommand({"dreisummen"})
public class CommandDreiSummen extends CommandExecuter {

	private static int[] array = {3, 2, 5, 7, 9, 12, 97, 24, 54};
	
	@Override
	public void executeComand(String[] args) {
		int summeGeradeZahlen = 0;
		int summeUngeradeZahlen = 0;
		
		for(int i = 0; i < array.length; i++) {
			int arrayzahl = array[i];
			
			if(arrayzahl % 2 == 0) {
				summeGeradeZahlen += arrayzahl;
			} else {
				summeUngeradeZahlen += arrayzahl;
			}
		}
		System.out.println("Die Summe der GeradenZahlen ist " + summeGeradeZahlen);
		System.out.println("Die summe der Ungeraden ist " + summeUngeradeZahlen);
		System.out.println("Die Summe aller Zahlen ist " + (summeGeradeZahlen + summeUngeradeZahlen));
	}

}
