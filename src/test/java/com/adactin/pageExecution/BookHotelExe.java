package com.adactin.pageExecution;

import com.adactin.locators.BookHotelLocators;
import ins.aiite.baseClass.BaseClass;

public class BookHotelExe extends SelectHotelExe{
	public static void firstName() {
		BaseClass.typedata(BaseClass.findElementbyId(BookHotelLocators.firstName), readExcel("Hotel", 4, 1));
	}
	public static void lastName() {
		BaseClass.typedata(BaseClass.findElementbyId(BookHotelLocators.lastName), readExcel("Hotel", 5, 1));
	}
	public static void billingAddress() {
		BaseClass.typedata(BaseClass.findElementbyId(BookHotelLocators.billingAddress), readExcel("Hotel", 6, 1));
	}
	public static void creditCardNo() {
		BaseClass.typedata(BaseClass.findElementbyId(BookHotelLocators.creditCardNo), readExcel("Hotel", 7, 1));
	}
	public static void creditCardType() {
		BaseClass.selectText(BaseClass.findElementbyId(BookHotelLocators.creditCardType), readExcel("Hotel", 8, 1));
	}
	public static void expiryMonth() {
		BaseClass.selectindex(BaseClass.findElementbyId(BookHotelLocators.expiryMonth), 5);
	}
	public static void expiryYear() {
		BaseClass.selectindex(BaseClass.findElementbyId(BookHotelLocators.expiryYear), 7);
	}
	public static void cvvNo() {
		BaseClass.typedata(BaseClass.findElementbyId(BookHotelLocators.cvvNo), readExcel("Hotel", 9, 1));
	}

	public static void book() {
		BaseClass.click(BaseClass.findElementbyId(BookHotelLocators.book));
	}
}
