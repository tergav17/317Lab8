package unit;

import com.StringObserver;

public class DisplayMonitor implements StringObserver {

	@Override
	public void update(String d) {
		content = d;
	}
	
	private String content = "";

	public String getContent() {
		return content;
	}

}
