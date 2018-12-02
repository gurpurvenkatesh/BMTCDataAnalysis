package CustomData;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class CustomValue implements WritableComparable<CustomValue> {

	private Text route_no;
	private FloatWritable distance;
	
	public CustomValue(Text route_no, FloatWritable distance) {
		super();
		this.route_no = route_no;
		this.distance = distance;
	}
	
	public CustomValue(String route_no, Float distance) {
		super();
		this.route_no = new Text(route_no);
		this.distance = new FloatWritable(distance);
	}
	
	public CustomValue() {
		// TODO Auto-generated constructor stub
		super();
		this.route_no = new Text();;
		this.distance = new FloatWritable();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((route_no == null) ? 0 : route_no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomValue other = (CustomValue) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (route_no == null) {
			if (other.route_no != null)
				return false;
		} else if (!route_no.equals(other.route_no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Longest Route Route_no:" + route_no + ", distance:" + distance;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		this.distance.write(out);
		this.route_no.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		
		this.distance.readFields(in);
		this.route_no.readFields(in);
	}

	@Override
	public int compareTo(CustomValue arg0) {
		// TODO Auto-generated method stub
		
		int cmp = this.distance.compareTo(arg0.distance); // Compares the Year & month field in the input text. If its equal returns zero or returns -1 or +1..
		
		if(cmp!=0)
			return cmp;
		else
			return this.route_no.compareTo(arg0.route_no);
	}
}
