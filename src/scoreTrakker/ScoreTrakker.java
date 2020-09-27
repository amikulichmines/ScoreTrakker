package scoreTrakker;
//Authors: Alex Mikulich, Owen Waldron, Chantal Wang all in section c

import java.util.ArrayList;
import java.io.*;  
import java.util.Scanner;

public class ScoreTrakker {
	public static ArrayList<Student> student = new ArrayList<Student>();

	private static String[] files = {"scores.txt", "badScore.txt", "nofile.txt" };

	public static void main(String[] args) {
		processFiles();
	}

	public static void loadDataFromFile(String fileName) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String stdnt = "";
		String score = "";
		while (stdnt != null) {
			stdnt = reader.readLine(); // Gets student
			score = reader.readLine(); // Gets score from the next line, advances line
			if(stdnt != null || score != null) { // if it's not a blank line
				try {
					student.add(new Student(stdnt, Integer.parseInt(score))); // add name and number to arraylisr via s
				}catch(NumberFormatException nE){
					System.out.println("Incorrect format for '" + stdnt + "', not a valid score for: " + score + "\n");
				}

			}
		}

		reader.close();

	}

	public static void printInOrder() {
		System.out.println("Student Score List:"); //printing score list using student toString method
		for(Student element : student) 
			System.out.println(element.toString());
		System.out.println("\n");
	}
	
	public static void processFiles(){ //tests all three files in order
		for(String file : files) {
			System.out.println("Now reading through file '" + file+"'\n");
			try {
				loadDataFromFile(file);
				printInOrder();
			} catch(FileNotFoundException fN) { //exception catches for files and IO
				System.out.println("Can't open file: " + file + "\n");
			} catch (IOException e) {
				System.out.println(e.getClass());
			}

			student = new ArrayList<Student>(); //resets arraylist between files
		}
	}

}
