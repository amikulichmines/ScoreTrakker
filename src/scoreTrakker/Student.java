package scoreTrakker;
//Authors: Alex Mikulich, Owen Waldron, Chantal Wang, all in section c

public class Student {
	String name;
	int score;
	public Student(String _name, int _score) { //constructor
		this.name = _name;
		this.score = _score;
	}

	public String toString() { //toString method for printing name and score
		return (name + " " + score);
	}
	
	
}