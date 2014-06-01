package org.dreamcorps.hackathon;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*setContentView(R.layout.main);
		 */
		DBDAO db = new DBDAO(this);
		db.addSampleQuestions();
		setContentView(R.layout.activity_main);
		
		/*if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
			
		}*/
		
		
		
		Button btn = (Button) this.findViewById(R.id.startQuizBtn);
		//set the click event of start quiz button
		btn.setOnClickListener(new OnClickListener() { 
			public void onClick(View v) { 
			//create new intent to start quiz activity
			Intent it = new Intent(MainActivity.this, QuizActivity.class);
			Bundle bundle = new Bundle();
			//pass "count=0" to bundle
			bundle.putInt("Count", 0);
			it.putExtras(bundle);
			//execute the intent
			startActivity(it);
			

		} 
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	  @Override
	  protected void onPause() {
	   	    super.onPause();
	  }


	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	


}
