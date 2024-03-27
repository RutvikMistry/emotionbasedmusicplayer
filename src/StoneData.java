class StoneData {

	int id;
	String stoneId;
	boolean isFancy;
	double discount, gRap, carat;

	public StoneData(int id, String stoneId, boolean isFancy, double discount, double gRap, double carat) {

		this.id = id;
		this.stoneId = stoneId;
		this.isFancy = isFancy;
		this.discount = discount;
		this.gRap = gRap;
		this.carat = carat;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoneId() {
		return stoneId;
	}

	public void setStoneId(String stoneId) {
		this.stoneId = stoneId;
	}

	public boolean isFancy() {
		return isFancy;
	}

	public void setFancy(boolean isFancy) {
		this.isFancy = isFancy;
	}

	public double getgRap() {
		return gRap;
	}

	public void setgRap(double gRap) {
		this.gRap = gRap;
	}

	public double getCarat() {
		return carat;
	}

	public void setCarat(double carat) {
		this.carat = carat;
	}

	public double getDiscount() {
		return discount;
	}

}
