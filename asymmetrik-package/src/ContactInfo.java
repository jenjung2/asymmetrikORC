public class ContactInfo {

	String name;
	String phoneNumber;
	String emailAddress;

	//ContactInfo class constructor [for initializing new objects]
		public ContactInfo() {
		}
			//set object name in the business card
			public void setName(String name) {
				this.name = name;
			}
			//set object phoneNumber in the business card
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}
			//set object emailAddress in the business card
			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}
			//Next, I return each of the ContactInfo through these methods
			//This method returns the full name of an individual
			public String getName() {
				return name;
			}
			//This method returns the phone number formatting to be a sequence of digits
			public String getPhoneNumber() {
				return phoneNumber;
			}
			//This method returns the email address found
			public String getEmailAddress() {
				return emailAddress;
			}

}
