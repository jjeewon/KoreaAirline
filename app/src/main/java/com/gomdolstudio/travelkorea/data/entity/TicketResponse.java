package com.gomdolstudio.travelkorea.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketResponse {
    @SerializedName("response")
    @Expose
    private Response response;
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
    public List<Item> getItems(){
        return this.response.getBody().getItems().getItem();
    }
}