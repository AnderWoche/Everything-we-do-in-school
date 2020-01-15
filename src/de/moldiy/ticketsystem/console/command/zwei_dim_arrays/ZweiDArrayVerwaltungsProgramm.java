package de.moldiy.ticketsystem.console.command.zwei_dim_arrays;

import de.moldiy.ticketsystem.console.command.CommandExecuter;
import de.moldiy.ticketsystem.console.command.ExecuteCommand;

@ExecuteCommand({"zweiDArrayVerwaltung"})
public class ZweiDArrayVerwaltungsProgramm extends CommandExecuter {

	private static final int[][] tabelle = {
			{1001, 5, 500, 0},
			{2001,23, 1200,0},
			{3001,2,85,0}
	};
 	@Override
	public void executeComand(String[] args) {
 		artikelAnzeige();
 		for(int[] artikel : tabelle) {
 			artikel[3] = artikel[2] * artikel[1];
 		}
 		artikelAnzeige();
	}
 	
 	private void artikelAnzeige() {
		for(int[] artikel: tabelle) {
			int id = artikel[0];
			int verfuegbar = artikel[1];
			int preis = artikel[2];
			int summe = artikel[3];
			System.out.println(verfuegbar + "x Artikel Nr. " + id + " à " + preis + " EUR = " + summe);	
		}
 	}

}
