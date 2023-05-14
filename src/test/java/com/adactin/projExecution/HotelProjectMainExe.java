package com.adactin.projExecution;

import com.adactin.pageExecution.BookHotelExe;

public class HotelProjectMainExe extends BookHotelExe{

	public static void main(String[] args) throws InterruptedException {
		browserLaunch("webdriver.chrome.driver",
				"C:\\Users\\VAISHNAVI\\Downloads\\chromedriver_win32\\chromedriver.exe");
getUrl(readProp("url"));
windowsMax();
username();
password();
login();
hotelLocation();
hotelName();
roomType();
numOfRooms();
adultsPerRoom();
childrenPerRoom();
search();
select();
continueBox();
firstName();
lastName();
billingAddress();
creditCardNo();
creditCardType();
expiryMonth();
expiryYear();
cvvNo();
book();
waitIMP(30);
String val = getAttribute("order_no");
System.out.println(val);
excelWrite("order number", 2, 2, val);
Thread.sleep(10000);
driver.quit();

	}

}
