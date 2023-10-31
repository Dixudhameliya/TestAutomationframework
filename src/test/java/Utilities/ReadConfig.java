package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
		File src= new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			try {
				pro.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername() {
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromepath() {
		String chormepath=pro.getProperty("chormepath");
		return chormepath;
	}
	public String getIEpath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getFirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getExcelpath() {
		String excelpath =pro.getProperty("excelpath");
		return excelpath;
	}
	public String getSheetname() {
		String sheetname=pro.getProperty("sheetname");
		return sheetname;
	}
	

}
