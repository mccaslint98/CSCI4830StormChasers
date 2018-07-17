package weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "humidity"

})
public class main {

    @JsonProperty("temp")
    private Float temp;
    @JsonProperty("temp_min")
    private Float temp_min;
    @JsonProperty("temp_max")
    private Float temp_max;
    @JsonProperty("temp_max")
    private Float temp_max;
    @JsonProperty("humidity")
    private Long humidity;
    
    @JsonProperty("temp")
    public Float getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    @JsonProperty("temp_min")
    public Float getTemp_min() {
        return temp_min;
    }

    @JsonProperty("temp_min")
    public void setTemp_min(Float temp_min) {
        this.temp_min = temp_min;
    }

    @JsonProperty("temp_max")
    public Float gettemp_max() {
        return temp_max;
    }

    @JsonProperty("temp_max")
    public void setTemp_max(Float temp_max) {
        this.temp_max = temp_max;
    }
    
    @JsonProperty("humidity")
    public Long getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }


}