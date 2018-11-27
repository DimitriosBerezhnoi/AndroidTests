package com.mycompany.myapp;
import android.support.v4.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;

public class ContentFragment extends Fragment
{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_content, container, false);
		Button  btn = view.findViewById(R.id.updateButton);
		btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					Toast.makeText(getContext(), "Heey", Toast.LENGTH_SHORT).show();
				}
			});
		
		return view;
	}
	
}
