package de.moldiy.ticketsystem.console.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@ExecuteCommand({"sieb"})
public class Sieb_des_EratosthenesCommand extends CommandExecuter {

	private int maxZahl;
	boolean[] istPrimArray;
	int pruefGrenze;

	@Override
	public void executeComand(String[] args) {
		if(args == null) {
			System.out.println("Bitte gib als argument eine Natürliche zahl ein!");
			return;
		}
		if (args.length == 1) {
			int maxZahl = 0;
			try {
				maxZahl = Integer.parseInt(args[0]);
				if(maxZahl < 1) {
					System.out.println("Bitte gebe eine Positive zahl ein!");
					return;
				}

				this.maxZahl = maxZahl;
				istPrimArray = new boolean[maxZahl];
				
				siebVomGriechen(maxZahl);
				
				for(int i = 0; i < this.istPrimArray.length; i++) {
					System.out.print("Die zahl " + (i+1));
					if(this.istPrimArray[i]) {
						System.out.println(" ist prim!");
					} else {
						System.out.println(" ist nicht prim!");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Bitte gebe eine natürliche zahl ein!");
			}

		} else if(args.length == 2) {
			if(args[1].equals("--save")) {
				int maxZahl = 0;
				File file = new File("SiebDesGriechenOutPut.txt");
				FileWriter writer;
				try {
					writer = new FileWriter(file);
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				try {
					maxZahl = Integer.parseInt(args[0]);

					this.maxZahl = maxZahl;
					istPrimArray = new boolean[maxZahl];
					
					siebVomGriechen(maxZahl);
					
					for(int i = 0; i < this.istPrimArray.length; i++) {
						System.out.print("Die zahl " + (i+1));
						if(this.istPrimArray[i]) {
							writer.write((i+1)+"\n");
							System.out.println(" ist prim!");
							writer.flush();
						} else {
							System.out.println(" ist nicht prim!");
						}
					}
					writer.close();
				} catch (NumberFormatException e) {
					System.out.println("Bitte gebe eine natürliche zahl ein!");
				} catch (IOException e)  {
					System.out.println("Ein Java IO Fegler ist aufgetreten!");
					return;
				}
			}
		} else {
			System.out.println("Bitte gebe als argument nur die zahl ein!");
		}
	}

	// Implementation des Siebs von Eratosthenes
	public void siebVomGriechen(int maxZahl) {
		// Zunächste werden alle Zahlen als potentielle Primzahlen gesetzt
		setzeAllePrim(maxZahl);
		// 1 ist per Definition keine Primzahl
		setzeIstNichtPrim(1);
		// Beginne nun bei 2 mit dem Sieben.
		// Beende das Sieben bei der Wurzel der größten Zahl
		pruefGrenze = (int) Math.ceil(Math.sqrt(maxZahl));	
		siebeAlle(1);
	}

	// Rekursive Funktion die alle Zahlen als Primzahl markiert
	private void setzeAllePrim(int zahl) {
		if (zahl > 1) {
			setzeIstPrim(zahl);
			setzeAllePrim(zahl - 1);
		}
	}
	
	//Rekursive Funktion die für jede Primzahl 
	//ihre Vielfachen als nicht prim markiert
	private void siebeAlle(int zahl) {
		if (istPrim(zahl)) {
			vielfacheMarkieren(zahl, 2 * zahl);
		}
		if (zahl < pruefGrenze) {
			siebeAlle(zahl + 1);
		}
	}

	//Rekursive Funktion die für eine angegbene Zahl
	//alle ihre Vielfachen als prim markiert
	private void vielfacheMarkieren(int zahl, int vielfaches) {
		if (vielfaches <= maxZahl) {
			setzeIstNichtPrim(vielfaches);
			vielfacheMarkieren(zahl, vielfaches + zahl);
		}
	}
	
	private void setzeIstPrim(int zahl) { istPrimArray[zahl - 1] = true; }

	private void setzeIstNichtPrim(int zahl) { istPrimArray[zahl - 1] = false; }

	private boolean istPrim(int zahl) { return istPrimArray[zahl - 1]; }

}
