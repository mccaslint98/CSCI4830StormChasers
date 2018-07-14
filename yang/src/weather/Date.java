package weather;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Daily",
    "Weekly"

})


public class Date {

	   @JsonProperty("Daily")
	    private Float Daily;
	    @JsonProperty("Weekly")
	    private Float Weekly;
	    
	    
	    @JsonProperty("Daily")
	    public Float getDaily() {
	        return Daily;
	    }

	    @JsonProperty("Daily")
	    public void setDaily(Float Daily) {
	        this.Daily = Daily;
	    }

	    @JsonProperty("Weekly")
	    public Float getWeekly() {
	        return Weekly;
	    }

	    @JsonProperty("Weekly")
	    public void setWeekly(Float Weekly) {
	        this.Weekly = Weekly;
	    }
	
}
