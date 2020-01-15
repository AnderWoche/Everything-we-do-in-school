package de.moldiy.ticketsystem.console.command.ein_dim_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"dreisummen2"})
public class CommandDreiSummen2 extends CommandExecuter {

	private int[] array;
	
	public void executeComand(String[] args) {
		this.array = new int[20];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < this.array.length; i++) {
			System.out.println("Bitte geben sie eine Zahl ein (zum Beenden eine negative):");
			int eingegebendeZahl;
			try {
				String inputZahl = bufferedReader.readLine();
				eingegebendeZahl = Integer.parseInt(inputZahl);
			} catch (NumberFormatException e) {
				System.out.println("Bitte geben Sie eine ganze Zahl ein!");
				continue;
			} catch (IOException e) {
				System.out.println("Ein Fehler ist aufgetreten. Versuchen Sie es erneut!");
				continue;
			}
			if(eingegebendeZahl < 0) {
				break;
			} else {
				this.array[i] = eingegebendeZahl;
			}
		}
		int summeGeradeZahlen = 0;
		int summeUngeradeZahlen = 0;
		
		for(int i = 0; i < this.array.length; i++) {
			int arrayzahl = this.array[i];
			
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
