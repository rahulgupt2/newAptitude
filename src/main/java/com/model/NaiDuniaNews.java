package com.model;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaiDuniaNews {

	/*@JsonProperty("imageUrl")
	String imageUrl;
	 @JsonProperty("newsUrl")
	String newsUrl;
	 @JsonProperty("time")
	String time;
	 @JsonProperty("paraNews")
	String paraNews;*/
	
	
	@JsonProperty("allNews")
	List<NaiDuniaOneNews> naiDuniaAllNews; 
	 
	 
	@Override
	public String toString() {
		return "NaiDuniaNews [naiDuniaAllNews=" + naiDuniaAllNews + ", pageinationUrls=" + pageinationUrls + "]";
	}
	
	
	
	
	
	@JsonProperty("pageinationUrls")
	List<String> pageinationUrls;

	 @JsonProperty("pageinationUrls")
	public List<String> getPageinationUrls() {
		return pageinationUrls;
	}
	 @JsonProperty("pageinationUrls")
	public void setPageinationUrls(List<String> pageinationUrls) {
		this.pageinationUrls = pageinationUrls;
	}
	 
		@JsonProperty("allNews")
	public List<NaiDuniaOneNews> getNaiDuniaAllNews() {
		return naiDuniaAllNews;
	}
		@JsonProperty("allNews")
	public void setNaiDuniaAllNews(List<NaiDuniaOneNews> naiDuniaAllNews) {
		this.naiDuniaAllNews = naiDuniaAllNews;
	}	
	 
	 
	 
	 
	 
	 
	/*@Override
	public String toString() {
		return "NaiDuniaNews [imageUrl=" + imageUrl + ", newsUrl=" + newsUrl + ", time=" + time + ", paraNews="
				+ paraNews + ", pageinationUrls=" + pageinationUrls + "]";
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
	}		*/
}
