package com.model;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaiDuniaOneNews {

	
	@JsonProperty("headingNews")
	String headingNews;
	@JsonProperty("imageUrl")
	String imageUrl;
	 @JsonProperty("newsUrl")
	String newsUrl;
	 @JsonProperty("time")
	String time;
	 @JsonProperty("paraNews")
	String paraNews;
	 
	 
	 
	 
	 
	 @Override
	public String toString() {
		return "NaiDuniaOneNews [headingNews=" + headingNews + ", imageUrl=" + imageUrl + ", newsUrl=" + newsUrl
				+ ", time=" + time + ", paraNews=" + paraNews + "]";
	}
	@JsonProperty("headingNews")
	 	public String getHeadingNews() {
		return headingNews;
	}
	 @JsonProperty("headingNews")
	public void setHeadingNews(String headingNews) {
		this.headingNews = headingNews;
	}
		@JsonProperty("imageUrl")
		public String getImageUrl() {
			return imageUrl;
		}
		 @JsonProperty("imageUrl")
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		 @JsonProperty("newsUrl")
		public String getNewsUrl() {
			return newsUrl;
		}
		 @JsonProperty("newsUrl")
		public void setNewsUrl(String newsUrl) {
			this.newsUrl = newsUrl;
		}
		 @JsonProperty("time")
		public String getTime() {
			return time;
		}
		 @JsonProperty("time")
		public void setTime(String time) {
			this.time = time;
		}
		 @JsonProperty("paraNews")
		public String getParaNews() {
			return paraNews;
		}
		 @JsonProperty("paraNews")
		public void setParaNews(String paraNews) {
			this.paraNews = paraNews;
		}		
	 
	
	
}
