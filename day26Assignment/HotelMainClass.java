package day26Assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelMainClass {
	List<Hotel> hotellist = new ArrayList<Hotel>();
	static Scanner sc = new Scanner(System.in);

	public void add() {
		Hotel hotel1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
//		 hotelName  rating  weekDayRate weekendRate weekDayRewardRate weekendRewardRate;
		Hotel hotel2 = new Hotel("Bridgewood", 4, 160, 60, 110, 50);
		Hotel hotel3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
		hotellist.add(hotel1);
		hotellist.add(hotel2);
		hotellist.add(hotel3);
	}

	public void findCheapestHotelForWeekDay() {
		System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
		String date1 = sc.next();
		String date2 = sc.next();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate = LocalDate.parse(date1, format);
		LocalDate endDate = LocalDate.parse(date2, format);

		int totalDays = endDate.getDayOfMonth() + startDate.getDayOfMonth() - 1;

//        System.out.println(sumDays);
		List<Hotel> cheapesHotel = hotellist.stream().sorted(Comparator.comparing(Hotel::getWeekDayRate))
				.collect(Collectors.toList());
		System.out.println("The Cheapest hotel is" + " " + cheapesHotel.get(0).getHotelName() + " " + "Rating" + " "
				+ cheapesHotel.get(0).getRating() + " " + "Total Rates=$"
				+ cheapesHotel.get(0).getWeekDayRate() * totalDays);
	}

	public void findCheapestHotelForWeekend() {
		System.out.println("Enter the 2 dates in dd/mm/yyyy format");
		String date1 = sc.next();
		String date2 = sc.next();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate = LocalDate.parse(date1, format);
		LocalDate endDate = LocalDate.parse(date2, format);

		int totalDays = startDate.getDayOfMonth() + endDate.getDayOfMonth() - 1;

		List<Hotel> cheapesHotel = hotellist.stream().sorted(Comparator.comparing(Hotel::getWeekendRate))
				.collect(Collectors.toList());
		System.out.println("The Cheapest hotel is" + " " + cheapesHotel.get(0).getHotelName() + " " + "Rating" + " "
				+ cheapesHotel.get(0).getRating() + " " + "Total Rates=$"
				+ cheapesHotel.get(0).getWeekendRate() * totalDays);

	}

	public void findBestRatingHotel() {
		System.out.println("Enter the 2 dates in dd/MM/yyyy format: ");
		String date1 = sc.nextLine();
		String date2 = sc.nextLine();
		LocalDate startDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate endDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int totalDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;

		List<Hotel> chespHotel = hotellist.stream().sorted(Comparator.comparing(Hotel::getRating).reversed())
				.collect(Collectors.toList());
		System.out.println("The cheapest Best Rated Hotel is : " + " " + chespHotel.get(0).getHotelName() + " "
				+ ", Rating : " + " " + chespHotel.get(0).getRating() + " " + ", Total Rates = $" + " "
				+ chespHotel.get(0).getWeekDayRate() * totalDays);
	}

	public void findHotelBestRatingForReward() {
		System.out.println("Enter 1 for regular customer and 2 for reward Customer");

		int num = sc.nextInt();
		System.out.println("Enter the 2 dates in dd/mm/yyyy format");
		String date1 = sc.next();
		String date2 = sc.next();

		if (num == 1) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate startDate = LocalDate.parse(date1, dateTimeFormatter);
			LocalDate endDate = LocalDate.parse(date2, dateTimeFormatter);

			int totalDays = startDate.getDayOfMonth() + endDate.getDayOfMonth() + 1;

			List<Hotel> cheapsRateHotel = hotellist.stream().sorted(Comparator.comparing(Hotel::getRating).reversed())
					.collect(Collectors.toList());
			System.out.println("The cheapset Best rated Hotel is" + " " + cheapsRateHotel.get(0).getHotelName() + " "
					+ "Hotel Rating  " + " " + cheapsRateHotel.get(0).getRating() + " " + "Total Rates = $" + " "
					+ cheapsRateHotel.get(0).getWeekDayRate() * totalDays);
		} else if (num == 2) {

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate startDate = LocalDate.parse(date1, dateTimeFormatter);
			LocalDate endDate = LocalDate.parse(date2, dateTimeFormatter);

			int totalDays = startDate.getDayOfMonth() + endDate.getDayOfMonth() + 1;

			List<Hotel> cheapsRateHotel = hotellist.stream().sorted(
					Comparator.comparing(Hotel::getRating).reversed().thenComparing(Hotel::getWeekDayRewardRate))
					.collect(Collectors.toList());
			System.out.println("The cheapset Best rated hotel is : " + cheapsRateHotel.get(0).getHotelName() + " "
					+ "Rating is : " + " " + cheapsRateHotel.get(0).getRating() + " " + "Total Rates $" + " "
					+ cheapsRateHotel.get(0).getWeekDayRewardRate() * totalDays);
		} else {
			System.out.println("Yore Note a Customer Please enter the valid option");
		}

	}

	public static void main(String[] args) {

		HotelMainClass hotelMainClass = new HotelMainClass();
		hotelMainClass.add();

		while (true) {
			
			System.out.println("Please Select Options \n 1 Cheapest Rate Hotel for WeekDay \n 2 Cheapest Rate Hotel For Weekend "
					+ "\n 3 Find Best Rate Hotel \n 4.Best rated and reward.\n 5.Exit ");

			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				hotelMainClass.findCheapestHotelForWeekDay();
				break;
			case 2:
				hotelMainClass.findCheapestHotelForWeekend();
				break;
			case 3:
				hotelMainClass.findBestRatingHotel();
				break;
			case 4:
				hotelMainClass.findHotelBestRatingForReward();
				break;
			case 5:
				sc.close();
				return;
			default:
				System.out.println("You Entered InCorrect choice.......");
				break;

			}

		}

	}

}
