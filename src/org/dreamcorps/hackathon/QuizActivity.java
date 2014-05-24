package org.dreamcorps.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuizActivity extends Activity {

	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	
	private int rightAnswerID = -1;
	private String rightAnswerStr = new String("");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		btn1 = (Button) this.findViewById(R.id.button1);
		btn2 = (Button) this.findViewById(R.id.button2);
		btn3 = (Button) this.findViewById(R.id.button3);
		btn4 = (Button) this.findViewById(R.id.button4);
		
		
		//set choices and right answer ID
		setChoices();
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startFeedbackActivity(1);
			}
		});

		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startFeedbackActivity(2);
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startFeedbackActivity(3);
			}
		});

		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startFeedbackActivity(4);
			}
		});
	}

	/*
	 * setChoices Sets Choices randomly and records right answer ID and answer string。
	 * <p>Right answer ID is saved in rightAnswerID. <br>
	 * Right Answer String is saved in rightAnswerStr.<br>
	 * 
	 * @return void
	 */
	protected void setChoices() {
		//TODO Here set four choices in the button text
		btn1.setText("choice-1 from DB");
		btn2.setText("choice-2 from DB");
		btn3.setText("choice-3 from DB");
		btn4.setText("choice-4 from DB");
		
		//TODO Here set rightAnswer
		rightAnswerID = 0;
		rightAnswerStr = "";
	}
	
	
	/*
	 * startFeedbackActivity starts a FeedbackActivity with answer information.
	 * <p>This method will judge whether selectedID equals answerID, and refresh the count variable<br>
	 * In FeedbackActivity, the right answer, the right choice ID and a result will be presented<br>
	 * If right answer has been selected, a Next button and a StopQuiz button will appear;<br>
	 * or a ReQuize button will appear.
	 * 
	 * @param selectedID: user seleceted choice ID. 
	 * 
	 * @return void
	 */
	protected void startFeedbackActivity(int selectedID) {
		
		//get current count before judge user's answer
		Intent previousIntent = getIntent();
		Bundle previousBundle = previousIntent.getExtras();
		int count = previousBundle.getInt("count");
		
		//parse bundle and judge answer 
		Bundle bundle = new Bundle();
		bundle.putInt("count", count = selectedID == rightAnswerID? ++count: count);
		bundle.putInt("selectedID", selectedID);
		bundle.putInt("answerID", rightAnswerID);
		bundle.putString("answerText", rightAnswerStr);
		
		//create new intent for communication with FeedbackActivity
		Intent intent = new Intent(QuizActivity.this, FeedbackActivity.class);
		intent.putExtras(bundle);
		
		//start FeedbackActivity
		startActivity(intent);
		
		//stop QuizActivity
		finish();
		
	}
}
