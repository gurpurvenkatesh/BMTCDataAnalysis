package reducer;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import CustomData.CustomValue;

public class LongRootReducer extends Reducer<NullWritable, CustomValue, Text, FloatWritable> {

	public void reduce(Text key, Iterable<CustomValue> values, Context context) throws IOException, InterruptedException{

		float result = (float) 0.0;
		CustomValue resultValue = new CustomValue();
		
		for(CustomValue value : values){
			
			if (result <  value.getDistance().get()){
				result =  value.getDistance().get();
				resultValue.setDistance(value.getDistance());
				resultValue.setRoute_no(value.getRoute_no());
			}
								
		}		
		context.write(resultValue.getRoute_no(), resultValue.getDistance());

	}
}
