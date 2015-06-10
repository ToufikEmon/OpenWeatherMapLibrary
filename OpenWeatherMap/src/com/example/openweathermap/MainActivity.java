package com.example.openweathermap;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvJSONFeed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvJSONFeed = (TextView) findViewById(R.id.tvJsonfeed);
		
		new JSONFeedConsumingTask().execute(); 

	}

	public class JSONFeedConsumingTask extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {

			return WebServiceHandler
					.getJSONFeed("http://api.openweathermap.org/data/2.5/weather?q=Dhaka");
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result != null) {

				tvJSONFeed.setText(result);
			}

		}

	}
}
