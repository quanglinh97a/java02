package session01.exceptions02;

public class Students {
	private String name;
	private String age;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Students(String name, String age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Students() {
		super();
	}
	
}
