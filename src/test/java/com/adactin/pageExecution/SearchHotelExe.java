package com.adactin.pageExecution;

import com.adactin.locators.SearchHotelLocators;

import ins.aiite.baseClass.BaseClass;

public class SearchHotelExe extends LoginPageExe{

	public static void hotelLocation() {
		BaseClass.selectindex(BaseClass.findElementbyId(SearchHotelLocators.hotelLocation), 5);
		
	}
	public static void hotelName() {
		BaseClass.selectText(BaseClass.findElementbyId(SearchHotelLocators.hotelName), readExcel("Hotel", 3, 1));
		
	}
	public static void roomType() {
		BaseClass.selectindex(BaseClass.findElementbyId(SearchHotelLocators.roomType), 3);
	}
	public static void numOfRooms() {
		BaseClass.selectindex(BaseClass.findElementbyId(SearchHotelLocators.numOfRooms), 4);
	}
	public static void adultsPerRoom() {
		BaseClass.selectindex(BaseClass.findElementbyId(SearchHotelLocators.adultsPerRoom), 2);
	}
	public static void childrenPerRoom() {
		BaseClass.selectindex(BaseClass.findElementbyId(SearchHotelLocators.childrenPerRoom), 2);
	}
	public static void search() {
		BaseClass.click(BaseClass.findElementbyId(SearchHotelLocators.search));
	}
	

}
