package com.GmbH.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class calculator extends PageBase {

	public calculator(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"inputFieldLeft\"]")
	private WebElement leftField;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"inputFieldRight\"]")

	private WebElement rightField;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"additionButton\"]")
	private WebElement addBtn;

	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"resultTextView\"]")

	private WebElement result;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"subtractButton\"]")
	private WebElement subBtn;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"multiplicationButton\"]")
	private WebElement mulBtn;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"divisionButton\"]")
	private WebElement divBtn;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"resetButton\"]")
	private WebElement resetBtn;

	// verify adding two numbers
	public String verfiyAddNumbers(String _leftNum, String _rightNum) {
		return filltextboxes(_leftNum, _rightNum, addBtn);

	}

	// Verify subtracting two numbers
	public String verfiysubtractNumbers(String _leftNum, String _rightNum) {
		return filltextboxes(_leftNum, _rightNum, subBtn);

	}

	// Verify multiplying two numbers
	public String verfiymultiplNumbers(String _leftNum, String _rightNum) {
		return filltextboxes(_leftNum, _rightNum, mulBtn);

	}

	// Verify dividing two numbers
	public String verfiyDivNumbers(String _leftNum, String _rightNum) {
		return filltextboxes(_leftNum, _rightNum, divBtn);

	}

	// Verify "reset" button functionality
	public boolean verfiyReset() {
		// Type in the left textbox anyvalue
		typeText(leftField, "5");

		// Type in the right textbox anyvalue
		typeText(rightField, "5");

		resetBtn.click();
		if (leftField.getText().equals("") && rightField.getText().equals("") && result.getText().equals(""))
			return true;
		else
			return false;

	}

	// Verify that the fields values are mandatory
	public String mandatory() {
		addBtn.click();
		return result.getText();
	}

	/**
	 * fill the text boxes with numbers then click the operation button (* , + , - ,
	 * /)
	 */

	public String filltextboxes(String _leftNum, String _rightNum, WebElement btn) {
		typeText(leftField, _leftNum);
		typeText(rightField, _rightNum);
		btn.click();
		return result.getText();

	}
}
