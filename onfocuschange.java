package com.example.mysharepref;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnFocusChangeListener{

	EditText username,password;
	Button login;
	CheckBox remember;
	SharedPreferences pref=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username=(EditText)findViewById(R.id.username);
		password=(EditText)findViewById(R.id.password);
		remember=(CheckBox)findViewById(R.id.checkBox1);
		
		pref=getSharedPreferences("LoginUser", Context.MODE_PRIVATE);
		
		username.setOnFocusChangeListener(this);
	}

	public void Login(View v){
		
		SharedPreferences.Editor e=pref.edit();
	if (remember.isChecked()){
		e.putString(username.getText().toString(), password.getText().toString());
		Toast.makeText(this, "Data Stored", Toast.LENGTH_LONG).show();
		}
		e.commit();
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		//SharedPreferences.Editor e1=pref.edit();
		
		
		
		if(!hasFocus){
								
							pref.contains(username.getText().toString());	//search
						String l= pref.getString(username.getText().toString(), "");
			
						password.setText(l);	
		}
		
		
		
	}
	
}

