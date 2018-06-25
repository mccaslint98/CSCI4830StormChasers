package view;

public class Weather {
	private String city;
	private String time;
	private String day;
	private String Source;
	private double Centigrade;
	private double Fahrenheit;
	private int low;
	private int high;
	private int precip;
	
	public Weather(String city, String time, String day, String source,
			double fahrenheit, int low, int high,
			int precip) {
		super();
		this.city = city;
		this.time = time;
		this.day = day;
		Source = source;
		Fahrenheit = fahrenheit;
		this.low = low;
		this.high = high;
		this.precip = precip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public double getCentigrade() {
		return Centigrade;
	}
	public void setCentigrade(double centigrade) {
		Centigrade = centigrade;
	}
	public double getFahrenheit() {
		return Fahrenheit;
	}
	public void setFahrenheit(double fahrenheit) {
		Fahrenheit = fahrenheit;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getPrecip() {
		return precip;
	}
	public void setPrecip(int precip) {
		this.precip = precip;
	}
	
}
