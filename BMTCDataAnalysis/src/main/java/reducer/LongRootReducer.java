package reducer;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import CustomData.CustomValue;

public class LongRootReducer extends Reducer<CustomValue, CustomValue, CustomValue, NullWritable> {
	
	private static CustomValue resultValue = new CustomValue();

	public void reduce(Iterable<CustomValue> keys, CustomValue values, Context context) throws IOException, InterruptedException{

		resultValue.setDistance(null);
		resultValue.setRoute_no(null);
		
		for(CustomValue key : keys){
			
			if(resultValue.getDistance().compareTo(key.getDistance())<0) {
				resultValue.setDistance(key.getDistance());
				resultValue.setRoute_no(key.getRoute_no());
			}										
		}		
		context.write(resultValue, null);

	}
}
