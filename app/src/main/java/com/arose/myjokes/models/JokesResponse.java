
package com.arose.myjokes.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JokesResponse implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private List<Value> value = null;
    private final static long serialVersionUID = -8735649359643022304L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public JokesResponse() {
    }

    /**
     * 
     * @param value
     * @param type
     */
    public JokesResponse(String type, List<Value> value) {
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

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

}
