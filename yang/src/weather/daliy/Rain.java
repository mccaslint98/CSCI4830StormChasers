package weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "3h"
})
public class Coord {

    @JsonProperty("3h")
    private Float 3h;

    @JsonProperty("3h")
    public Float get3h()) {
        return 3h;
    }

    @JsonProperty("3h")
    public void set3h(Float 3h) {
        this.3h = 3h;
    }
}