package LowestCharges;

public class mainFile {

	public static void main(String[] args) throws Exception {
		
		TC_1_Book_Cab obj1 = new TC_1_Book_Cab();
//		TC_2_Gift_Card obj2 = new TC_2_Gift_Card();
//		TC_3_Hotel_Booking obj3 = new TC_3_Hotel_Booking();
		obj1.DriverSetup("chrome");
		obj1.closePopup();
		obj1.bookCab();
		
//		obj2.gift_card();
//		obj3.hotel();
//		obj1.closeApp();
	}

}
