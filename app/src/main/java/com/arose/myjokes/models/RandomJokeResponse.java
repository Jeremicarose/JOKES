
package com.arose.myjokes.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomJokeResponse implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private Value value;
    private final static long serialVersionUID = 5912593529770857813L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RandomJokeResponse() {
    }

    /**
     * 
     * @param value
     * @param type
     */
    public RandomJokeResponse(String type, Value value) {
        super();
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}
