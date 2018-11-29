package store;

public class LatlonsParser {

	private String lat;
	private String longtd;
	
	public LatlonsParser(String lat, String longtd) {
		super();
		this.lat = lat;
		this.longtd = longtd;
	}
	
	public String getLongtd() {
		return longtd;
	}
	public void setLongtd(String longtd) {
		this.longtd = longtd;
	}
	
	
}
