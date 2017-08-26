package session01.exceptions02;

import java.util.ArrayList;

public class TestStudent {

	public static void main(String[] args) {
		Students student01=new Students();
		student01.setName("Linh Già");
		student01.setAge("30");
		student01.setAddress("Láng Thượng, Đống Đa");
		
		Students student02=new Students();
		student02.setName("Quang Linh");
		student02.setAge("20");
		student02.setAddress("Đống Đa, Hà Nội");
		
		ArrayList<Students> listStudent=new ArrayList<Students>();
		listStudent.add(student01);
		listStudent.add(student02);
		
	}

}
