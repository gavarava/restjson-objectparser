package org.restjson.json.deserialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "testIntegerProperty"
})
public class TestJSON {

    @JsonProperty("testIntegerProperty")
    private int testIntegerProperty;

    @JsonProperty("testIntegerProperty")
    public int getTestIntegerProperty() {
        return testIntegerProperty;
    }

    @JsonProperty("testIntegerProperty")
    public void setTestIntegerProperty(int testIntegerProperty) {
        this.testIntegerProperty = testIntegerProperty;
    }
}
