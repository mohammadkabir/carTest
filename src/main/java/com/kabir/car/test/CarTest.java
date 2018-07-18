package com.kabir.car.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;
import com.kabir.car.bin.Car;
import com.kabir.car.bin.Car_;

public class CarTest {

	Car car;

	@BeforeClass
	public void findcars() throws FileNotFoundException, IOException {

		try {
			// Create a new Gson object
			Gson gson = new Gson();

			// Read the CarResoponse.json file
			BufferedReader br = new BufferedReader(new FileReader(
					"/Users/mkabir/Documents/school-api/school-api4/school-api4/src/main/java/com/kabir/response/CarResponse.json"));

			// convert the json to Java object (car)
			car = gson.fromJson(br, Car.class);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void CarMakeTest() {

		System.out.println("****Car Details****");

		for (Car_ c : car.getCar()) {

			if (c.getMake().toString().equalsIgnoreCase("Tesla")
					&& c.getMetadata().getColor().toString().equalsIgnoreCase("Blue")) {
				System.out.println("Car Maker : " + c.getMake());
				System.out.println("Car Model : " + c.getModel());
				System.out.println("Car Color : " + c.getMetadata().getColor());
				System.out.println("Car Specific Note : " + c.getMetadata().getNotes());

			}

		}

	}

	@Test
	public void LowetRentalCar() {
		try {
			int perdayRent = 0;
			int lowestRentalPrice = 0;
			boolean initialsetup = true;
			SoftAssert softAssert = new SoftAssert();
			HashMap<Integer, Car_> carRentalcost = new HashMap<Integer, Car_>();

			for (Car_ c : car.getCar()) {

				perdayRent = c.getPerdayrent().getPrice();
				carRentalcost.put(perdayRent, c);

				if (initialsetup) {
					lowestRentalPrice = perdayRent;
					initialsetup = false;

				}

				if (lowestRentalPrice > perdayRent)
					lowestRentalPrice = perdayRent;

			}
			System.out.println("Lowest Car Rental Price :" + lowestRentalPrice);
			System.out.println("Lowest Rental  Car Maker: " + carRentalcost.get(lowestRentalPrice).getMake().toString()
					+ "  " + "Lowest Rental  Car Model: " + carRentalcost.get(lowestRentalPrice).getModel().toString()
					+ "  " + "Lowest Rental  Per day Price : " + " "
					+ carRentalcost.get(lowestRentalPrice).getPerdayrent().getPrice().toString());

			// softAssert.assertEquals("actual","expected","Message");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getMake().toString(), "Audi",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getModel().toString(), "A7",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getVin().toString(), "09AGHY64352JITEG98K",
					"Didn't match Expectation");
			softAssert.assertAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void LowetRentalCarWithDiscount() {
		try {
			int perdayRent = 0;
			int lowestRentalPrice = 0;
			boolean initialsetup = true;
			SoftAssert softAssert = new SoftAssert();
			HashMap<Integer, Car_> carRentalcost = new HashMap<Integer, Car_>();

			for (Car_ c : car.getCar()) {

				perdayRent = c.getPerdayrent().getPrice() - c.getPerdayrent().getDiscount();
				carRentalcost.put(perdayRent, c);

				if (initialsetup) {
					lowestRentalPrice = perdayRent;
					initialsetup = false;

				}

				if (lowestRentalPrice > perdayRent)
					lowestRentalPrice = perdayRent;

			}
			System.out.println("Lowest Car Rental Price with Discount :" + lowestRentalPrice);
			System.out.println(
					"Discounted Lowest Rental  Car Maker: " + carRentalcost.get(lowestRentalPrice).getMake().toString()
							+ "  " + " Discounted Lowest Rental  Car Model: "
							+ carRentalcost.get(lowestRentalPrice).getModel().toString() + "  "
							+ "Discounted Lowest Rental  Per day Price : " + " "
							+ carRentalcost.get(lowestRentalPrice).getPerdayrent().getPrice().toString());

			// softAssert.assertEquals("actual","expected","Message");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getMake().toString(), "Tesla",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getModel().toString(), "S100",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(lowestRentalPrice).getVin().toString(), "09GAHY11992JITEG98K",
					"Didn't match Expectation");
			softAssert.assertAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void highestRevenuecars() {
		try {
			double costPerRental = 0;
			double highestRev = 0;
			boolean initialsetup = true;
			SoftAssert softAssert = new SoftAssert();
			HashMap<Double, Car_> carRentalcost = new HashMap<Double, Car_>();

			for (Car_ c : car.getCar()) {

				costPerRental = (c.getMetrics().getYoymaintenancecost() + c.getMetrics().getDepreciation())
						/ c.getMetrics().getRentalcount().getYeartodate();
				carRentalcost.put(costPerRental, c);

				if (initialsetup) {
					highestRev = costPerRental;
					initialsetup = false;

				}

				if (highestRev > costPerRental)
					highestRev = costPerRental;

			}
			System.out.println("Lowest Year to Year maintanance price :" + highestRev);
			System.out.println(
					"Year to Year Highest Revenue Generating Car: " + carRentalcost.get(highestRev).getMake().toString()
							+ "  " + " Year to Year Highest Revenue Generating Car Model: "
							+ carRentalcost.get(highestRev).getModel().toString() + "  "
							+ "Year to Year Average Car Maintainance_Price/rental for the highest rev generation car : "
							+ " " + highestRev);

			// softAssert.assertEquals("actual","expected","Message");
			softAssert.assertEquals(carRentalcost.get(highestRev).getMake().toString(), "Tesla",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(highestRev).getModel().toString(), "S100",
					"Didn't match Expectation");
			softAssert.assertEquals(carRentalcost.get(highestRev).getVin().toString(), "09GAHY11992JITEG98K",
					"Didn't match Expectation");
			softAssert.assertAll();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}// end of class
