package newsapp.ui;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Class implements a list listener
 * 
 * @author ITCuties
 *
 */

public class ListListener2 implements OnItemClickListener {

	// List item's reference
	List<RssItem> listItems;
	// Calling activity reference
	Activity activity;
	public static String a,b,c;
	
	public ListListener2(List<RssItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity  = anActivity;
	}
	
	/**
	 * Start a browser with url from the rss item.
	 */
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		/*Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(listItems.get(pos).getLink()));
	
		activity.startActivity(i);*/
		Intent t=new Intent(view.getContext(),Lang3.class);
		//t.putExtra("title", Uri.parse(listItems.get(pos).getLink()));
		//a=Uri.parse(listItems.get(pos).getLink()).toString();
		b=Uri.parse(listItems.get(pos).getTitle()).toString();
		c=Uri.parse(listItems.get(pos).getdescription()).toString();
		//t.putExtra("content", Uri.parse(listItems.get(pos).getLink()));
		//t.putExtra("category", Uri.parse(listItems.get(pos).getLink()));
		activity.startActivity(t);
		
	}
	
}
