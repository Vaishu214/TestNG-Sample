package com.adactin.pageExecution;

import com.adactin.locators.SelectHotelLocators;

import ins.aiite.baseClass.BaseClass;

public class SelectHotelExe extends SearchHotelExe{
	public static void select() {
		BaseClass.click(BaseClass.findElementbyId(SelectHotelLocators.select));
	}
	public static void continueBox() {
		BaseClass.click(BaseClass.findElementbyId(SelectHotelLocators.continueBox));
	}

	

}
