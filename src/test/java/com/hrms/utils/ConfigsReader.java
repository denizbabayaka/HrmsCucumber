package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigsReader {

	private static Properties prop;
	private static FileInputStream fis;

	// Properties cred=readProperties(credentials.properties);
	// Properties configs=readProperties(configuration.properties);
	public static Properties readProperties(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static Object[][] readXL(String filePath, String sheet) {
		Object[][] data = null;
		try {
			fis = new FileInputStream(filePath);
			Workbook wbook = new XSSFWorkbook(fis);
			Sheet sh = wbook.getSheet(sheet);
			int rows = sh.getPhysicalNumberOfRows();
			int cols = sh.getRow(0).getLastCellNum();
			data = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {

				for (int j = 0; j < cols; j++) {
					data[i - 1][j] = sh.getRow(i).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return data;
	}

}
