class Discount {

	int id;
	double discount;
	String username;

	public Discount(int id, double discount, String username) {

		this.id = id;
		this.discount = discount;
		this.username = username;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}