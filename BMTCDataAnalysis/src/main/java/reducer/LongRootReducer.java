package reducer;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LongRootReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

	public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException{

		float result = (float) 0.0;
		
		for(FloatWritable value : values){
			
			if (result < value.get())
				result =  value.get();								
		}		
		context.write(key, new FloatWritable(result));

	}
}
