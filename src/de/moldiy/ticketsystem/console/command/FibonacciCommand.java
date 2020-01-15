package de.moldiy.ticketsystem.console.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

@ExecuteCommand({"fibonacci"})
public class FibonacciCommand extends CommandExecuter {

	@Override
	public void executeComand(String[] args) {
		if(args != null) {
			if(args.length == 1) {
				int fiboBisZahl = 0;
				try {
					fiboBisZahl = Integer.parseInt(args[0]);
				} catch(NumberFormatException e) {
					System.out.println("fibonacci <anzahl> --write");
				}
				if(fiboBisZahl != 0) {
					for(int i = 1; i <= fiboBisZahl; i++) {
						System.out.println(fibonacci(new BigInteger(i+"")));
					}
					System.out.println("Alle fibonacci Zahlen sind Generiert!");
				}
			} else if(args.length == 2) {
				if(args[1].equals("--save")) {
					System.out.println("fibonacci <anzahl> --write");
					return;
				}
				try {
					int fiboBisZahl = Integer.parseInt(args[0]);
					
					File file = new File("savedFibonacci.txt");
					FileWriter writer = new FileWriter(file);
					
					for(int i = 0; i <= fiboBisZahl; i++) {
						BigInteger bigInteger = fibonacci(new BigInteger(i+""));
						writer.write(bigInteger.byteValue() + "\n");
						System.out.println("Die zahl " + bigInteger + " Wird in die Datein Geschreiben.");
						writer.flush();
					}
					writer.close();
					System.out.println("Alle fibonacci Zahlen sind Generiert!");
				} catch(NumberFormatException e) {
					System.out.println("fibonacci <anzahl> --write");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Es gibt zwei argumente <anzahl> und optional (--safe <DateiName>)");
			}
		} else {
			System.out.println("fibonacci <anzahl> --write");
		}
		
	}
	
	public static BigInteger minusOne = new BigInteger("-1");
	public static BigInteger minusTwo = new BigInteger("-2");
	
	public BigInteger fibonacci(BigInteger zahl) {
		if(zahl.compareTo(BigInteger.ONE) == 1) {
			return fibonacci(zahl.add(minusOne)).add(fibonacci(zahl.add(minusTwo)));
		} else if(zahl.compareTo(BigInteger.ZERO) == 1) {
			return BigInteger.ONE;
		} else {
			return BigInteger.ZERO;
		}
	}

}
