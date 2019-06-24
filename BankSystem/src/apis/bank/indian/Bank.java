package apis.bank.indian;

public class Bank {
	private String name;
	private int id;

	public Bank() {
		super();
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bank(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

}
