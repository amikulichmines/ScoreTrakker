package scoreTrakker;

import java.util.ArrayList;
import java.io.*;  
import java.util.Scanner;

public class ScoreTrakker {
	public static ArrayList<Student> student = new ArrayList<Student>();

	private static String[] files = {"scores.txt", "badScore.txt", "nofile.txt" };

	public static void main(String[] args) {
		for(String file : files) {
			System.out.println("Now reading through file '" + file+"'\n");
			loadDataFromFile(file);
			printInOrder();
			student = new ArrayList<Student>();
		}
		
		
		
	}
	
	public static void loadDataFromFile(String fileName){
		try {

			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));

			String stdnt = "";
			String score = "";
			while (stdnt != null) {
				stdnt = reader.readLine();
				score = reader.readLine();
				if(stdnt != null || score != null) {
					try {
						student.add(new Student(stdnt, Integer.parseInt(score)));
					}catch(NumberFormatException nE){
						System.out.println("Incorrect format for " + stdnt + " not a valid score for: " + score + "\n");
					}
					
				}
			}
			
			reader.close();
			}catch(FileNotFoundException fN) {
				System.out.println("Can't open file: " + fileName + "\n");
			}
		} catch (IOException e) {
			  System.out.println(e.getClass());
		}
	}
	
	public static void printInOrder() {
		System.out.println("Student Score List:");
		for(Student element : student) 
			System.out.println(element.toString());
		System.out.println("\n");
	}
	void processFiles(){
		
	}
	
}
