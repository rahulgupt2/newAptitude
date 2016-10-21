package com.model;


import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("Succeeded")
    private String         succeeded;

    @JsonProperty("Response")
    private String         response;

    @JsonProperty("timetaken")
    private String         timeTaken;

    @JsonProperty("news")
    private NaiDuniaNews naiDuniaNews;
        
    @JsonProperty("news")
    public NaiDuniaNews getNaiDuniaNews() {
		return naiDuniaNews;
	}

    @JsonProperty("news")
	public void setNaiDuniaNews(NaiDuniaNews naiDuniaNews) {
		this.naiDuniaNews = naiDuniaNews;
	}

	@JsonProperty("Response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = response;
    }   

    @JsonProperty("timetaken")
    public String getTimeTaken() {
        return timeTaken;
    }

    @JsonProperty("timetaken")
    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

  
    @JsonProperty("Succeeded")
    public String getSucceeded() {
        return succeeded;
    }
    @JsonProperty("Succeeded")
    public void setSucceeded(String succeeded) {
        this.succeeded = succeeded;
    }

	@Override
	public String toString() {
		return "Response [succeeded=" + succeeded + ", response=" + response + ", timeTaken=" + timeTaken
				+ ", naiDuniaNews=" + naiDuniaNews + "]";
	}

	
  

  
}
