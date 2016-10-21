
package com.model.javaaptitude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "answerID",
    "answer"
})
@JsonIgnoreProperties(ignoreUnknown = true)
/*@Entity
@Table(name = "Option")*/
public class Option implements Serializable {

	@Override
	public String toString() {
		return "Option [answerID=" + answerID + ", answer=" + answer + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("answerID")
    private String answerID;
  
	@JsonProperty("answer")
     
    //@Column(name = "answer")
    private String answer;
 
	
	
	
	 //@OneToMany(mappedBy = "Option", cascade = CascadeType.ALL)
	
    /**
     * 
     * @return
     *     The answerID
     */
    @JsonProperty("answerID")
    public String getAnswerID() {
        return answerID;
    }


	/**
     * 
     * @param answerID
     *     The answerID
     */
    @JsonProperty("answerID")
    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    /**
     * 
     * @return
     *     The answer
     */
    @JsonProperty("answer")
    public String getAnswer() {
        return answer;
    }

    /**
     * 
     * @param answer
     *     The answer
     */
    @JsonProperty("answer")
    public void setAnswer(String answer) {
        this.answer = answer;
    }

  

}
