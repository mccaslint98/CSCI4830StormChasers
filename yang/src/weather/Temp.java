package weather;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "min",
    "max",
    "night",
    "eve",
    "morn"
})
public class Temp {

    @JsonProperty("day")
    private Float day;
    @JsonProperty("min")
    private Float min;
    @JsonProperty("max")
    private Float max;
    @JsonProperty("night")
    private Float night;
    @JsonProperty("eve")
    private Float eve;
    @JsonProperty("morn")
    private Float morn;

    @JsonProperty("day")
    public Float getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Float day) {
        this.day = day;
    }

    @JsonProperty("min")
    public Float getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Float min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Float getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Float max) {
        this.max = max;
    }

    @JsonProperty("night")
    public Float getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Float night) {
        this.night = night;
    }

    @JsonProperty("eve")
    public Float getEve() {
        return eve;
    }

    @JsonProperty("eve")
    public void setEve(Float eve) {
        this.eve = eve;
    }

    @JsonProperty("morn")
    public Float getMorn() {
        return morn;
    }

    @JsonProperty("morn")
    public void setMorn(Float morn) {
        this.morn = morn;
    }

}