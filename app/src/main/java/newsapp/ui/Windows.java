package newsapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Windows extends Fragment {
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
		    //View windows = inflater.inflate(R.layout.windows_frag, container, false);
		    View windows = inflater.inflate(R.layout.activity_about, container, false);
		    //((TextView)windows.findViewById(R.id.textView)).setText("Windows");
	        return windows;
}}
