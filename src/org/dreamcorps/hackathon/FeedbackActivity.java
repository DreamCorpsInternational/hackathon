package org.dreamcorps.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FeedbackActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		Button btn = (Button) this.findViewById(R.id.startoverbtn);
		// set the click event of start quiz button
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// create new intent to start quiz activity
				Intent it = new Intent(FeedbackActivity.this,
						MainActivity.class);
				startActivity(it);
				
				//finish feedback Activity
				finish();
			}
		});

		Button btn2 = (Button) this.findViewById(R.id.NextBtn);
		// set the click event of start quiz button
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// get the current count
				//Intent it = getIntent();
				//Bundle bundle = it.getExtras();
				//int count = bundle.getInt("count") + 1;
				
				// create new intent to start quiz activity
				Intent new_it = new Intent(FeedbackActivity.this,
						QuizActivity.class);
				//Bundle new_bundle = new Bundle();
				//new_bundle.putInt("count", count);
				//new_it.putExtras(new_bundle);
				startActivity(new_it);
				
				//finish feedback activity
				finish();
			}
		});
	}
}
