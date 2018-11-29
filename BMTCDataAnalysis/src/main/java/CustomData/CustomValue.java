package CustomData;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;

public class CustomValue {

	private Text route_no;
	private FloatWritable distance;
	
	public CustomValue(Text route_no, FloatWritable distance) {
		super();
		this.route_no = route_no;
		this.distance = distance;
	}
	
	public CustomValue() {
		// TODO Auto-generated constructor stub
	}

	public Text getRoute_no() {
		return route_no;
	}
	public void setRoute_no(Text route_no) {
		this.route_no = route_no;
	}
	public FloatWritable getDistance() {
		return distance;
	}
	public void setDistance(FloatWritable distance) {
		this.distance = distance;
	}
	
	
}
