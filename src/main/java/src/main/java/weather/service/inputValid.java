package src.main.java.weather.service;

public class inputValid {
	private String Date;
	public boolean isDateValid(String date){
		int num = 0;
		int index = 0;
		for(int i = 0; i < date.length(); i++){
			if(date.charAt(i) == '-'){
				num = 0;
				if(index == 0){
				}
				continue;
			}
			num = num * 10 + (date.charAt(i) - '0');
		}
		return true;
	}
}
