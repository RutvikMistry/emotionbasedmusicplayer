class User{
		int id;
		public String firstName,lastName,username;
		boolean isBrokerage;
		
		public User(int id,String firstName,String lastName,String username,boolean isBrokerage) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.isBrokerage = isBrokerage;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public boolean isBrokerage() {
			return isBrokerage;
		}

		public void setBrokerage(boolean isBrokerage) {
			this.isBrokerage = isBrokerage;
		}

	}