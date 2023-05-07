package day26Assignment;

public class Hotel {

	String hotelName;
	int rating;
	int weekDayRate;
	int weekendRate;
	int weekDayRewardRate;
	int weekendRewardRate;

	public Hotel(String hotelName, int rating, int weekDayRate, int weekendRate, int weekDayRewardRate,
			int weekendRewardRate) {

		this.hotelName = hotelName;
		this.rating = rating;
		this.weekDayRate = weekDayRate;
		this.weekendRate = weekendRate;
		this.weekDayRewardRate = weekDayRewardRate;
		this.weekendRewardRate = weekendRewardRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWeekDayRate() {
		return weekDayRate;
	}

	public void setWeekDayRate(int weekDayRate) {
		this.weekDayRate = weekDayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public int getWeekDayRewardRate() {
		return weekDayRewardRate;
	}

	public void setWeekDayRewardRate(int weekDayRewardRate) {
		this.weekDayRewardRate = weekDayRewardRate;
	}

	public int getWeekendRewardRate() {
		return weekendRewardRate;
	}

	public void setWeekendRewardRate(int weekendRewardRate) {
		this.weekendRewardRate = weekendRewardRate;
	}

//	@Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", emailId='" + emailId + '\'' +
//                '}';
//    }
	@Override
	public String toString() {
		return "Hotel hotelName=" + hotelName + 
				", rating=" + rating + 
				", weekDayRate=" + weekDayRate + 
				", weekendRate="+ weekendRate + 
				" weekDayRewardRate=" + weekDayRewardRate + 
				" weekendRewardRate=" + weekendRewardRate+ 
				"\n" + "";
	}

}
