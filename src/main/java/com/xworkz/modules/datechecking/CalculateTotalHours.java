package main.java.com.xworkz.modules.datechecking;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CalculateTotalHours {

	public int retunTotalHour(Date newDate) {
		int totalHourOfYear = (newDate.getYear() - 1) * 365 * 24;
		int totalHourOfMonth = returnTotalDays(newDate.getMonth()) * 24;
		int totalhourOfDays = (newDate.getDate() - 1) * 24;
		int totalHour = newDate.getHours();

		totalHour = totalHourOfYear + totalHourOfMonth + totalhourOfDays + totalHour;

		return totalHour;

	}

	public int returnTotalDays(int monthNumber) {

		switch (monthNumber) {
		case 0:
			return 0;
		case 1:
			return 31;
		case 2:
			return 59;
		case 3:
			return 96;
		case 4:
			return 126;
		case 5:
			return 157;
		case 6:
			return 187;
		case 7:
			return 218;
		case 8:
			return 249;
		case 9:
			return 279;
		case 10:
			return 310;
		case 11:
			return 340;
		default:
			return -1;

		}

	}

}
