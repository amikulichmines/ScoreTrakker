package scoreTrakker;


public class Student {
	String name;
	int score;
	public Student(String _name, int _score) {
		this.name = _name;
		this.score = _score;
	}
	
	@Override
	public String toString() {
		return (name + " " + score);
	}
	
	
}