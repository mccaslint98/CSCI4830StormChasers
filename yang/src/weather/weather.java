package weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "weatherId",
    "main"

})

public class weather extends location {
	
	  @JsonProperty("weatherId")
	    private int idweatherId;
	    @JsonProperty("main")
	    private String main;
	
	    @JsonProperty("weatherId")
	    public int getweatherId() {
	        return weatherId;
	    }

	    @JsonProperty("weatherId")
	    public void setweatherId(int weatherId) {
	        this.weatherId = weatherId;
	    }

	    @JsonProperty("main")
	    public String getMain() {
	        return main;
	    }

	    @JsonProperty("main")
	    public void setMain(String main) {
	        this.main = main;
	    }

	 


}
