package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Where is the quiz file?");

		String path = userInput.nextLine();
		File inputFile = new File(path);

		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		String answer = "";
		int score = 0;
		int questions = 0;
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String lineInput = fileScanner.nextLine();
				String[] currentLine = lineInput.split("_");
				for(int i=0; i<currentLine.length; i++) {
					
					if (i==0) {
						System.out.println(currentLine[i]);
					}
					if(i!=0 && !currentLine[i].contains("*")) {
						System.out.println(i + ". " + currentLine[i]);
					}
					if(currentLine[i].contains("*")) {
						answer = Integer.toString(i);
						String answerMinusStar = currentLine[i].replace('*', ' ');
						System.out.println(i + ". " + answerMinusStar);
					}
				}
				Scanner inputAnswer = new Scanner(System.in);
				String userAnswer = inputAnswer.nextLine();
				questions++;
				if (userAnswer.equals(answer)) {
					score++;
					System.out.println("Correct!");
				} else { System.out.println("Sorry that isn't correct!");
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found.");

		} System.out.println("You got " + score + " out of " + questions +" questions right!"); 
	}
}

