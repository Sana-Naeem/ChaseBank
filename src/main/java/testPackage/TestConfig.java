package testPackage;

import java.text.DateFormat;

import chase.bank.utilities.Configurable;

public class TestConfig {
//Example of a singleton class
	public static void main(String[] args) {
		// Configurable configurableX = new Configurable();

		Configurable configurable = Configurable.getInstance();
		configurable.getUrl();
		Configurable configurable2 = Configurable.getInstance();
		System.out.println(configurable.hashCode());
		System.out.println(configurable2.hashCode());

		DateFormat dateFormat = new java.text.SimpleDateFormat("MM.dd.yyyy_HH.mm.ss");
		System.out.println(dateFormat.format(new java.util.Date()));
	}

}
