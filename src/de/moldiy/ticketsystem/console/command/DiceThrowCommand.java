package de.moldiy.ticketsystem.console.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DiceThrowCommand extends CommandExecuter {

	public DiceThrowCommand() {
		super("diceThrow");
		// TODO Auto-generated constructor stub
	}

	/**
	 * execute the DiceThrow Program.
	 * 
	 * @author David Humann, Florian Hoffmann.
	 * @version 1
	 * @return void
	 */
	@Override
	public void executeComand(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> throwNummbers = new ArrayList<Integer>();
		int countOfThrows;

		while (true) {
			// Eingabeaufforderung
			System.out.print("Bitte geben Sie die Anzahl der Wurfversuche ein: ");
			
			// Pr�fe: Ist die Eingabe eine ganze Zahl im Bereich 1 bis 10?
			try {
				String input = bufferedReader.readLine();
				countOfThrows = Integer.parseInt(input);

			} catch (NumberFormatException e) {
				System.out.println("Bitte geben Sie eine ganze Zahl ein!");
				continue;
			} catch (IOException e) {
				System.out.println("Ein Fehler ist aufgetreten. Versuchen Sie es erneut!");
				return;
			}

			if (!(1 <= countOfThrows && countOfThrows <= 10)) {
				System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 10 ein!");
				continue;
			}

			// W�rfel werfen und ausgeben
			Random rand = new Random();
			for (int i = 1; i <= countOfThrows; i++) {
				int randomInt = rand.nextInt(5) + 1;
				throwNummbers.add(randomInt);
				System.out.println(i + ". Wurf: " + randomInt);
			}

			// Augensumme bestimmen und ausgeben
			int sumOfPoints = 0;
			for (int arrayNumber : throwNummbers) {
				sumOfPoints += arrayNumber;
			}
			System.out.println("Die Gesamtaugensumme betr�gt: " + sumOfPoints);

			// Durchschnittliche Augenzahl bestimmen und ausgeben
			float average = (float) sumOfPoints / countOfThrows;
			System.out.printf("Die durchschnittliche Augenzahl betr�gt: %.2f%n", average); 

			HashMap<Integer, Integer> countOfApsoluteNumber = new HashMap<Integer, Integer>();
			
			for(int integerInThrowedNumbers : throwNummbers) {
				if(!countOfApsoluteNumber.containsKey(integerInThrowedNumbers)) {
					countOfApsoluteNumber.put(integerInThrowedNumbers, 0);
				}
				int count = countOfApsoluteNumber.get(integerInThrowedNumbers);
				countOfApsoluteNumber.put(integerInThrowedNumbers, ++count);
			}
			
			System.out.println("Absolute H�ufigkeiten:");
			countOfApsoluteNumber.forEach((key, value) -> {
				System.out.println("Die zahl " + key + " kommt " + value + " vor.");
			});
			
			break;
		}

	}

}