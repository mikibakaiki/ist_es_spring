package pt.ulisboa.tecnico.softeng.bank.domain;

public class Client {
	private Bank bank;
	private String id;
	private String name;
	private String age;

	public Client() {
	}

	public Client(Bank bank, String id, String name, String age) {
		this.bank = bank;
		this.id = id;
		this.name = name;
		this.age = age;

		bank.addClient(this);
	}

	public Bank getBank() {
		return this.bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
