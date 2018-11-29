package mapper;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import CustomData.CustomValue;
import store.BMTCRouteStoreParser;

public class LongRootMapper extends Mapper<LongWritable, Text, NullWritable, CustomValue> {

	private BMTCRouteStoreParser bmtcParser = new BMTCRouteStoreParser();
	private CustomValue customValue = new CustomValue();
	
	public void map(LongWritable LineOffset, Text record, Context context) throws IOException, InterruptedException{
		
		bmtcParser.parser(record.toString());	
		customValue.setRoute_no(bmtcParser.getRoute_no());
		customValue.setDistance(bmtcParser.getDistance());
		
		context.write(NullWritable.get(), customValue);		
	}
}
