
package com.model.javaaptitude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "questionID",
    "question",
    "options",
    "answer",
    "description",
    "_comment"
})
@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//@Table(name = "Question")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	
	//@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("questionID")
    private String questionID;
    
	//@Column(name = "question")
	@JsonProperty("question")
    private String question;
    
   /* @OneToMany
	@JoinTable(name="Option", joinColumns=@JoinColumn(name="questionID"))*/
	
	
  
  //  @OneToMany(targetEntity=Option.class, fetch = FetchType.LAZY, mappedBy = "Question")
	  @JsonProperty("options")    
      private List<Option> options;
    
	  
	  
	
	
	  private Option option;  
	  
   // @ManyToOne
    //@JoinColumn(name = "answerID")
	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

//	@Column(name = "answer")
    @JsonProperty("answer")
    private String answer;
	
	
	//@Column(name = "description")
    @JsonProperty("description")
    private String description;
    
	
	//@Column(name = "comment")
	@JsonProperty("_comment")
    private String comment;
   
    /**
     * 
     * @return
     *     The questionID
     */
    @JsonProperty("questionID")
    public String getQuestionID() {
        return questionID;
    }

    @Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + ", options=" + options + ", option="
				+ option + ", answer=" + answer + ", description=" + description + ", comment=" + comment + "]";
	}

	/**
     * 
     * @param questionID
     *     The questionID
     */
    @JsonProperty("questionID")
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    /**
     * 
     * @return
     *     The question
     */
    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    /**
     * 
     * @param question
     *     The question
     */
    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 
     * @return
     *     The options
     */
    @JsonProperty("options")
    public List<Option> getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    @JsonProperty("options")
   
    public void setOptions(List<Option> options) {
        this.options = options;
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

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The comment
     */
    @JsonProperty("_comment")
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The _comment
     */
    @JsonProperty("_comment")
    public void setComment(String comment) {
        this.comment = comment;
    }



}
