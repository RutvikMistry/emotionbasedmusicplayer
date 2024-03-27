import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class mainfile {
	public static void main(String[] args) {

		String ss = "rutvik";

		// User
		List<User> usersDataList = new ArrayList<User>();

		User u1 = new User(1, "Rutvik", "Mistry", "rutvik", false);
		User u2 = new User(2, "parth", "Mistry", "rutvikmistry2", true);
		User u3 = new User(3, "abc", "Mistry", "rutvikmistry3", false);
		User u4 = new User(4, "gasd", "Mistry", "rutvikmistry4", true);
		User u5 = new User(5, "Rhfgh", "Mistry", "rutvikmistry", false);

		usersDataList.add(u1);
		usersDataList.add(u2);
		usersDataList.add(u3);
		usersDataList.add(u4);
		usersDataList.add(u5);

		Optional<User> getUser = usersDataList.stream().filter(s -> s.getUsername().equals(ss)).findFirst();
		String userName = getUser.map(s -> s.getUsername()).get();
		String fName = getUser.map(s -> s.getFirstName()).get();
		String lName = getUser.map(s -> s.getLastName()).get();
		Boolean brokerage = getUser.map(s -> s.isBrokerage()).get();

		// Discount
		List<Discount> discountList = new LinkedList<Discount>();

		Discount d1 = new Discount(1, 20, "rutvikmistry");
		Discount d2 = new Discount(2, 30, "rutvikmistry1");
		Discount d3 = new Discount(3, 40, "rutvik");
		Discount d4 = new Discount(4, 10, "rutvikmistry3");
		Discount d5 = new Discount(5, 22, "rutvikmistry4");

		discountList.add(d1);
		discountList.add(d2);
		discountList.add(d3);
		discountList.add(d4);
		discountList.add(d5);

		Optional<Discount> getDiscount = discountList.stream().filter(s -> s.getUsername().equals(ss)).findFirst();

		Double dis = getDiscount.map(s -> s.getDiscount()).get();

//		int id = getDiscount.map(s -> s.getId()).get();
//		System.out.println(dis);

		// StoneData
		List<StoneData> stoneDataList = new ArrayList<StoneData>();

		StoneData s1 = new StoneData(1, "1", true, 25, 10, 8);
		StoneData s2 = new StoneData(2, "2", false, 15, 11, 9);
		StoneData s3 = new StoneData(3, "3", true, 35, 12, 10);
		StoneData s4 = new StoneData(4, "4", false, 45, 13, 5);
		StoneData s5 = new StoneData(5, "5", true, 55, 14, 4);

		stoneDataList.add(s1);
		stoneDataList.add(s2);
		stoneDataList.add(s3);
		stoneDataList.add(s4);
		stoneDataList.add(s5);

		List<Double> stoneDiscount1 = new ArrayList<Double>();
		List<Boolean> stonefancy = new ArrayList<Boolean>();
		List<Integer> stoneId = new ArrayList<Integer>();
		List<Double> stonegRap = new ArrayList<Double>();
		List<Double> stoneCarat = new ArrayList<Double>();

		for (StoneData d : stoneDataList) {

			stoneDiscount1.add(d.discount);
			stonefancy.add(d.isFancy);
			stoneId.add(d.id);
			stonegRap.add(d.gRap);
			stoneCarat.add(d.carat);

		}

//		System.out.println(stoneDiscount1);
//		System.out.println(stonefancy);
//		System.out.println(stoneId);
//		System.out.println(stoneCarat);

//		Optional<StoneData> getData = stoneDataList.stream().filter(s -> s.getId() == id).findFirst();
//		List<Object> getData1 = Stream.concat(stoneDataList.stream(), discountList.stream()).collect(Collectors.toList());

//		double stoneDiscount = getData.map(s -> s.getDiscount()).get();
//		boolean fancy = getData.map(s -> s.isFancy()).get();
//		double carat = getData.map(s -> s.getCarat()).get();
//		double grap = getData.map(s -> s.getgRap()).get();
//		String stoneid = getData.map(s -> s.getStoneId()).get();
//		double stonegRap = getData.map(s -> s.getgRap()).get();
//		double stoneCarat = getData.map(s -> s.getCarat()).get();

		// input/output
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("update discount(yes or no)");
			String choice = sc.nextLine();
			String choiceCheck = choice.toLowerCase();

			double dis1;
			if (choiceCheck.equals("yes")) {

				System.out.print("Enter discount = ");
				dis1 = sc.nextDouble();
				dis = dis1;
//			System.out.println(dis1);
			}
		}

		System.out.println("\nUsername = " + userName);
		System.out.println("First Name = " + fName);
		System.out.println("Last Name = " + lName);
		System.out.println("isBrokerage = " + brokerage);

		for (int i = 0; i < stoneDiscount1.size(); i++) {

			System.out.println("\nStone Id = " + stoneId.get(i));
			System.out.println("isFancy = " + stonefancy.get(i));
			System.out.println("Carat = " + stoneCarat.get(i));
			System.out.println("gRap = " + stonegRap.get(i));

			if (stonefancy.get(i).equals(true)) {
//			System.out.println("Discount = " + stoneDiscount);
//				dis = (double) 0;

				double disc = stoneDiscount1.get(i);
				double pricePerCarat = (stonegRap.get(i) * (100 - disc)) / 100;
				double total = pricePerCarat * stoneCarat.get(i);

				if (brokerage.equals(true)) {

					total = total + (total * 0.10);
					pricePerCarat = total / stoneCarat.get(i);
					disc = 100 - ((pricePerCarat / stonegRap.get(i)) * 100);
				}

				System.out.println("Discount = " + disc);
				System.out.println("Price per carat = " + pricePerCarat);
				System.out.println("Total = " + total);

			} else {
//				System.out.println(dis);
				double disc = dis + stoneDiscount1.get(i);
				double pricePerCarat = (stonegRap.get(i) * (100 - disc)) / 100;
				double total = pricePerCarat * stoneCarat.get(i);

				if (brokerage.equals(true)) {

					total = total + (total * 0.10);
					pricePerCarat = total / stoneCarat.get(i);
					disc = 100 - ((pricePerCarat / stonegRap.get(i)) * 100);
				}

				System.out.println("Discount = " + disc);
				System.out.println("Price per carat = " + pricePerCarat);
				System.out.println("Total = " + total);

			}
		}
	}
}