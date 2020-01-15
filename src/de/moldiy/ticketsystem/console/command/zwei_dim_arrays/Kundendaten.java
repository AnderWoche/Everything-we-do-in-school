package de.moldiy.ticketsystem.console.command.zwei_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"kundenDaten"})
public class Kundendaten extends CommandExecuter {

	private static final String[] namen = {
			"Max Schmidt", "Lisa Marx", "Robin Meier",
			"Lara Huber", "Anna Groß", "Heribert Lehmann",
			"Harry Potter", "Obi-wam Kenobi", "Julia Kron"
	};
	
	private static final int[] alter = {
			33, 28, 12,
			22, 23, 64,
			16, 102, 18
	};
	
	private static final boolean[] weiblich = {
			false, true, false,
			true, true, false,
			false, false, true
	};
	
	@Override
	public void executeComand(String[] args) {
		// Frauen auflisten
		for (int i = 0; i < namen.length; i++) {
			if (weiblich[i]) {
				System.out.println("Frau " + namen[i] + " (" + alter[i]+ " Jahre)");
			}
		}
		// Herrenauflisten
		for (int i = 0; i < namen.length; i++) {
			if (!weiblich[i]) {
				System.out.println("Herr " + namen[i] + " (" + alter[i]+ " Jahre)");
			}
		}
		
		int frauen = 0;
		int youngster = 0;
		int alteDudes = 0;
		for (int i = 0; i < namen.length; i++) {
			if (weiblich[i]) frauen++;
			if (alter[i] < 40) youngster++;
			if (!weiblich[i] && alter[i] > 30) alteDudes++;
		}
		System.out.println("Anzahl der Frauen: " + frauen);
		System.out.println("Anzahl der U-40er: " + youngster);
		System.out.println("Anzahl der Männer über 30: " + alteDudes);
	}

}
