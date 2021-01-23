

import java.util.Scanner;

public class HotelTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Hotel Lakewood = new Hotel();
		Hotel Bridgewood = new Hotel();
		Hotel Ridgewood = new Hotel();
		Client client = new Client();

		double lakewoodFinalValue = 0;
		double bridgewoodFinalValue = 0;
		double ridgewoodFinalValue = 0;

		boolean validDate = true;
		boolean validStatus = true;

		int numWeek = 0;
		int numWeekend = 0;

		Lakewood.setRate(3);
		Lakewood.setDailyFee(110);
		Lakewood.setRewardDailyFee(80);
		Lakewood.setWeekendFee(90);
		Lakewood.setRewardWeekendFee(80);

		Bridgewood.setRate(4);
		Bridgewood.setDailyFee(160);
		Bridgewood.setRewardDailyFee(110);
		Bridgewood.setWeekendFee(60);
		Bridgewood.setRewardWeekendFee(50);

		Ridgewood.setRate(5);
		Ridgewood.setDailyFee(220);
		Ridgewood.setRewardDailyFee(100);
		Ridgewood.setWeekendFee(150);
		Ridgewood.setRewardWeekendFee(40);

		System.out.println("O cliente é Regular ou Reward?");
		String loyalty = scan.nextLine();

		if (loyalty.equalsIgnoreCase("regular") || loyalty.equalsIgnoreCase("reward")) {

			validStatus = true;

		} else {

			validStatus = false;

		}

		while (!validStatus) {
			System.out.println("Status inválido, digite regular ou reward");
			loyalty = scan.next();

			if (loyalty.equalsIgnoreCase("regular") || loyalty.equalsIgnoreCase("reward")) {
				validStatus = true;
			} else {
				validStatus = false;
			}
		}

		if (loyalty.equalsIgnoreCase("reward")) {

			client.setReward(true);

		} else if (loyalty.equalsIgnoreCase("regular")) {

			client.setReward(false);

		}

		System.out.println("Reserva para quantos dias?");
		int numberDays = scan.nextInt();

		int[] dates = new int[numberDays];

		for (int i = 0; i < dates.length; i++) {

			System.out.println("Insira a data " + (i + 1) + " [exemplo: 16Mar2009(mon)] ");
			String date = scan.next();

			if (date.contains("mon") || date.contains("tues") || date.contains("wed") || date.contains("thur")
					|| date.contains("fri") || date.contains("sat") || date.contains("sun")) {

				validDate = true;

			} else {

				validDate = false;

			}

			while (!validDate) {

				System.out.println(
						"Data invalida. Utilize o formato 16Mar2009(mon),  17Mar2009(tues),  18Mar2009(wed), etc");
				date = scan.next();

				if (date.contains("mon") || date.contains("tues") || date.contains("wed") || date.contains("thur")
						|| date.contains("fri") || date.contains("sat") || date.contains("sun")) {

					validDate = true;

				} else {

					validDate = false;

				}

			}

			if (date.contains("sat") || date.contains("sun")) {

				numWeekend++;

			} else {

				numWeek++;

			}

			if (client.getReward()) {

				lakewoodFinalValue = (numWeek * Lakewood.getRewardDailyFee())
						+ (numWeekend * Lakewood.getRewardWeekendFee());
				bridgewoodFinalValue = (numWeek * Bridgewood.getRewardDailyFee())
						+ (numWeekend * Bridgewood.getRewardWeekendFee());
				ridgewoodFinalValue = (numWeek * Ridgewood.getRewardDailyFee())
						+ (numWeekend * Ridgewood.getRewardWeekendFee());

			} else if (!client.getReward()) {

				lakewoodFinalValue = (numWeek * Lakewood.getDailyFee()) + (numWeekend * Lakewood.getWeekendFee());
				bridgewoodFinalValue = (numWeek * Bridgewood.getDailyFee()) + (numWeekend * Bridgewood.getWeekendFee());
				ridgewoodFinalValue = (numWeek * Ridgewood.getDailyFee()) + (numWeekend * Ridgewood.getWeekendFee());

			}

		}

		if (lakewoodFinalValue < bridgewoodFinalValue && lakewoodFinalValue < ridgewoodFinalValue) {

			System.out.println("hotel mais barato: Lakewood");

		} else if (bridgewoodFinalValue < lakewoodFinalValue && bridgewoodFinalValue < ridgewoodFinalValue) {

			System.out.println("hotel mais barato: Bridgewood");

		} else if (ridgewoodFinalValue < lakewoodFinalValue && ridgewoodFinalValue < bridgewoodFinalValue) {

			System.out.println("hotel mais barato: ridgewood");

		} else if (lakewoodFinalValue == bridgewoodFinalValue) {

			if (Lakewood.getRate() > Bridgewood.getRate()) {

				System.out.println("hotel mais barato: Lakewood");

			} else {

				System.out.println("hotel mais barato: Bridgewood");
			}

		} else if (bridgewoodFinalValue == ridgewoodFinalValue) {

			if (Bridgewood.getRate() > Ridgewood.getRate()) {

				System.out.println("hotel mais barato: Bridgewood");

			} else {

				System.out.println("hotel mais barato: Ridgewood");

			}

		} else if (ridgewoodFinalValue == lakewoodFinalValue) {

			if (Ridgewood.getRate() > Lakewood.getRate()) {

				System.out.println("hotel mais barato: Ridgewood");

			} else {

				System.out.println("hotel mais barato: Lakegewood");

			}

		}

	}

}
