package weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all"
})
public class Coord {

    @JsonProperty("all")
    private Float all;

    @JsonProperty("all")
    public Float getAll()) {
        return all;
    }

    @JsonProperty("all")
    public void setAll(Float all) {
        this.all = all;
    }
}