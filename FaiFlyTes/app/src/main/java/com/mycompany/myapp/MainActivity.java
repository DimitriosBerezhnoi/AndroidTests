package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.view.View.*;
import android.view.*;
import android.text.*;

public class MainActivity extends Activity implements OnClickListener
{
	public static final int N = 4;
	
	TextView tv;
	EditText et;
	Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		init();
    }

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putString("result", tv.getText().toString());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		super.onRestoreInstanceState(savedInstanceState);
		
		if(!TextUtils.isEmpty(et.getText().toString())) {
			tv.setVisibility(View.VISIBLE);
			tv.setText(savedInstanceState.getString("result"));
		}
	}

	@Override
	public void onClick(View p1)
	{
		if(p1.getId() == R.id.mainButton1) {
			String text = et.getText().toString();
			String arr[];
			if (!TextUtils.isEmpty(text))
			{
				text.trim();
				arr = text.split(" ");
				setText(arr);
			}
			else
			{
				Toast.makeText(MainActivity.this, "Your text is null :(", Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void setText(String[] arr)
	{
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
		{
			result.append(" ").append(arr[i]);

			if ((i + 1) % N == 0)
			{
				result.append("\n");
			}
		}
		tv.setVisibility(View.VISIBLE);
		tv.setText(result.toString());
		
	}

	private void init()
	{
		tv = (TextView) findViewById(R.id.mainTextView1);
		et = (EditText) findViewById(R.id.mainEditText1);
		btn = (Button) findViewById(R.id.mainButton1);
		et.getBackground().mutate().setColorFilter(getResources().getColor(R.color.AppColor), PorterDuff.Mode.SRC_ATOP);
		btn.setOnClickListener(this);
		tv.setVisibility(View.GONE);
	}
}
