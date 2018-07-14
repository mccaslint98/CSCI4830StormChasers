package weather;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weatherid",
    "Name",
    "coord",
    "country"

})

public class location extends Date {
	
    @JsonProperty("weatherid")
    private int weatherid;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("country")
    private String country;
	
	 @JsonProperty("weatherId")
	    public int getweatherId() {
	        return weatherId;
	    }

	    @JsonProperty("weatherId")
	    public void setweatherId(int getweatherId) {
	        this.weatherId = weatherId;
	    }	

	    @JsonProperty("Name")
	    public String getName() {
	        return Name;
	    }

	    @JsonProperty("Name")
	    public void setName(String Name) {
	        this.Name = Name;
	    }
	    @JsonProperty("coord")
	    public Coord getCoord() {
	        return coord;
	    }

	    @JsonProperty("coord")
	    public void setCoord(Coord coord) {
	        this.coord = coord;
	    }

	    @JsonProperty("country")
	    public String getCountry() {
	        return country;
	    }

	    @JsonProperty("country")
	    public void setCountry(String country) {
	        this.country = country;
	    }
	    
}
