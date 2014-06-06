package jp.ac.st.originalaso_2014_002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnT = (Button)findViewById(R.id.btntou);
		btnT.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v){
		switch(v.getId()){
		case R.id.btntou:
			Intent intent = new Intent(MainActivity.this, HitokotoActivity.class);
			startActivity(intent);
		
		case R.id.btnment:
			Intent intent2 = new Intent(MainActivity.this, MaintenanceActivity.class);
			startActivity(intent2);
		}
	}

}


