package driver;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import CustomData.CustomValue;
import mapper.LongRootMapper;
import reducer.LongRootReducer;

public class BMTCLongRootDriver extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Job job = Job.getInstance(getConf());
		job.setJarByClass(BMTCLongRootDriver.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setInputFormatClass(CombineTextInputFormat.class);
		
		job.setMapperClass(LongRootMapper.class);
		job.setMapOutputKeyClass(CustomValue.class);
		job.setMapOutputValueClass(CustomValue.class);
		
		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(FloatWritable.class);
		
		job.setReducerClass(LongRootReducer.class);
		//job.setReducerClass(Reducer.class);
		//job.setOutputKeyClass(NullWritable.class);
		//job.setOutputValueClass(CustomValue.class);
		job.setOutputKeyClass(CustomValue.class);
		job.setOutputValueClass(NullWritable.class);
		
		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.exit(ToolRunner.run(new BMTCLongRootDriver(), args));
	}
}
