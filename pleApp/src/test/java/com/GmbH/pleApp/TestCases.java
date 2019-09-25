package com.GmbH.pleApp;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GmbH.Pages.calculator;
import com.opencsv.CSVReader;

public class TestCases extends TestBase {

	calculator calculatorObj;
	CSVReader reader;

	@Test(priority = 1, alwaysRun = true)
	public void verfiyAddNumbers() throws IOException {
		verifyOperations("Addnumbers", "Addition");
	}

	@Test(priority = 2)
	public void verfiysubtractNumbers() throws IOException {
		verifyOperations("Subtractnumbers", "Subtraction");

	}

	@Test(priority = 3)
	public void verfiymultiplNumbers() throws IOException {
		verifyOperations("Multinumbers", "Multiplication");

	}

	@Test(priority = 4)
	public void verfiyDivNumbers() throws IOException {
		verifyOperations("Divnumbers", "Division");

	}

	@Test(priority = 5)
	public void verfiyReset() throws IOException {
		calculatorObj = new calculator(AndroidDriver);
		Assert.assertTrue(calculatorObj.verfiyReset());
	}

	@Test(priority = 6)
	public void mandatory() throws IOException {
		calculatorObj = new calculator(AndroidDriver);
		Assert.assertEquals(calculatorObj.mandatory(), "Please, fill the input fields correctly");
	}

	/**
	 * 
	 * @param fileName
	 * @param OperationName
	 *            (addition , subtraction , multiplication , division)
	 * @throws IOException
	 */
	public void verifyOperations(String fileName, String OperationName) throws IOException {
		String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\com\\GmbH\\data\\" + fileName + ".csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell;
		calculatorObj = new calculator(AndroidDriver);

		// while loop will be executed till the lastvalue in CSV file .
		while ((csvCell = reader.readNext()) != null) {
			String leftVal = csvCell[0];
			String rightVal = csvCell[1];
			String result = csvCell[2];
			if (OperationName.equals("Addition")) {
				System.out.println("Verify adding two numbers.....");
				Assert.assertEquals(calculatorObj.verfiyAddNumbers(leftVal, rightVal).trim().replaceAll("\\s+", ""),
						result.trim().replaceAll("\\s+", ""));
			} else if (OperationName.equals("Subtraction")) {
				System.out.println("Verify subtracting two numbers.....");
				Assert.assertEquals(
						calculatorObj.verfiysubtractNumbers(leftVal, rightVal).trim().replaceAll("\\s+", ""),
						result.trim().replaceAll("\\s+", ""));
			}

			else if (OperationName.equals("Division")) {
				System.out.println("Verify divising two numbers.....");
				Assert.assertEquals(calculatorObj.verfiyDivNumbers(leftVal, rightVal).trim().replaceAll("\\s+", ""),
						result.trim().replaceAll("\\s+", ""));
			} else if (OperationName.equals("Multiplication"))

			{
				System.out.println("Verify multilpying two numbers.....");
				Assert.assertEquals(calculatorObj.verfiymultiplNumbers(leftVal, rightVal).trim().replaceAll("\\s+", ""),
						result.trim().replaceAll("\\s+", ""));
			}

		}
	}

}
