package newsapp.ui;

/**
 * This code encapsulates RSS item data.
 * Our application needs title and link data.
 * 
 * @author ITCuties
 *
 */
public class RssItem {
	
	// item title
	private String title;
	// item link
	private String link;
	private String description;

	public String getTitle() {
		return title;
	}
	
	public String getdescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return title;
	}
	
}
