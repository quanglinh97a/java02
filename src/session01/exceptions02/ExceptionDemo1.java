package session01.exceptions02;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		try {
			int age=10;
			AgeUntils.checkAge(age);
		} catch (TooYoungException e) {
			System.out.println("TRẨU TRE!");
		}catch (TooOldException e) {
			System.out.println("DÊ CỤ!");
		}
		
		System.out.println("==========");
		int age=10;
		try {
			AgeUntils.checkAge(age);
			System.out.println("You Pass! Ahihi");
		} 
//		catch (AgeException e) {
//			System.out.println("You Not Pass!");
//			System.out.println(e.getMessage());
//		} 
		catch (TooOldException | TooYoungException e) {
			System.out.println("You Not Pass!");
			System.out.println(e.getMessage());
		}
	}

}
