package jp.ac.st.originalaso_2014_002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnC = (Button)findViewById(R.id.btnch);
		btnC.setOnClickListener(this);
		Button btnM = (Button)findViewById(R.id.btnment);
		btnM.setOnClickListener(this);
		Button btnT = (Button)findViewById(R.id.btntou);
		btnT.setOnClickListener(this);
		
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
			
			
		try{	
			sdb = helper.getWritableDatabase();
			}catch(SQLiteException e){
				//異常終了
				return;
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v){
		switch(v.getId()){
		case R.id.btnch:
			
			String strHitokoto = helper.selectRandomHitokoto(sdb);
			
			Intent intent = new Intent(MainActivity.this, HitokotoActivity.class);
			intent.putExtra("hitokoto", strHitokoto);
			
			
			
			startActivity(intent);
			break;

		case R.id.btnment:
			Intent intent2 = new Intent(MainActivity.this, MaintenanceActivity.class);
			startActivity(intent2);
			break;
		
		case R.id.btntou:
			EditText etv = (EditText)findViewById(R.id.editMsg);
			String inputMsg = etv.getText().toString();
			
			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb,  inputMsg);
			}
			etv.setText("");
			break;
		}
	}

}


