package de.moldiy.ticketsystem.console.command.zwei_dim_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"kleine1x1"})
public class Kleine1x1eins extends CommandExecuter {

	@Override
	public void executeComand(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int zahleingabe = 1;
		try {
			System.out.println("Geben sie eine ganze zahl ein: ");
			String input = bufferedReader.readLine();
			zahleingabe = Integer.parseInt(input);

		} catch (NumberFormatException e) {
//			System.out.println("Bitte geben Sie eine ganze Zahl ein!");
		} catch (IOException e) {
//			System.out.println("Ein Fehler ist aufgetreten. Versuchen Sie es erneut!");
		}
		for(int y = 1; y <= zahleingabe; y++) {
			for(int x = 1; x <= zahleingabe; x++) {
				System.out.print(x * y);
				if(x == zahleingabe) {
					System.out.println();
				} else {
					System.out.print("\t");
				}
			}
		}
		
	}

}
