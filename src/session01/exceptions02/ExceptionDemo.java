package session01.exceptions02;

public class ExceptionDemo {

	public static void main(String[] args) throws TooYoungException, TooOldException {
		int age=50;
		AgeUntils.checkAge(age);
	}

}
