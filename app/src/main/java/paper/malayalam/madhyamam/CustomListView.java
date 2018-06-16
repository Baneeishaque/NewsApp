package paper.malayalam.madhyamam;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ListView;;

public class CustomListView extends ListView {

	public CustomListView(Context context) {
		super(context);
		setFont();
	}

	public CustomListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFont();
	}

	public CustomListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setFont();
	}

	private void setFont() {
		Typeface font = Typeface.createFromAsset(getContext().getAssets(),
				"fonts/Maximum.ttf");
		//setTypeface(font, Typeface.NORMAL);
	}
}