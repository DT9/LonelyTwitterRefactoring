package ca.ualberta.cs.lonelytwitter.tweets;

import java.io.Serializable;
import java.util.Date;

public class NormalLonelyTweet extends LonelyTweet implements Serializable {

	private String thisIsntEvenMyFinalStringForm;

	public NormalLonelyTweet() {
		
	}

	public NormalLonelyTweet(String text) {
		this(text, new Date());
	}

	public NormalLonelyTweet(String text, Date date) {
		this.tweetDate = new Date();
		this.tweetBody = text;
	}

	@Override
	public String toString() {
		setThisIsntEvenMyFinalStringForm(getTweetDate() + " | " + getTweetBody());
		return getThisIsntEvenMyFinalStringForm();
	}

	public String getTweetBody() {
		return tweetBody;
	}

	private String getThisIsntEvenMyFinalStringForm() {
		return thisIsntEvenMyFinalStringForm;
	}

	private void setThisIsntEvenMyFinalStringForm(
			String thisIsntEvenMyFinalStringForm) {
		this.thisIsntEvenMyFinalStringForm = thisIsntEvenMyFinalStringForm;
	}
}
