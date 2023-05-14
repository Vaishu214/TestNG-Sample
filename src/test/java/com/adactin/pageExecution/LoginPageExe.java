package com.adactin.pageExecution;

import com.adactin.locators.BookHotelLocators;
import com.adactin.locators.LoginPageLocators;

import ins.aiite.baseClass.BaseClass;

public class LoginPageExe extends BookHotelLocators{

	public static void username() {
	BaseClass.typedata(BaseClass.findElementbyId(LoginPageLocators.username), readProp("username"));
	}
	
	public static void password() {
		BaseClass.typedata(BaseClass.findElementbyId(LoginPageLocators.password), readProp("password"));
			}
	
	public static void login() {
		BaseClass.click(BaseClass.findElementbyId(LoginPageLocators.login));
	}

}
