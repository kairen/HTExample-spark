package a.b;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class SSmain {

	
	public static void main(String ar[]) throws Exception{
		Configuration conf = new Configuration();
		Job jc = Job.getInstance(conf);
		jc.setJarByClass(SSmain.class);
		jc.setNumReduceTasks(1);
		jc.setMapperClass(SSmapper.class);
		jc.setMapOutputKeyClass(mapperKey.class);
		jc.setMapOutputValueClass(Text.class);
		jc.setPartitionerClass(SSp.class);
		jc.setGroupingComparatorClass(SSgroupby.class);
		jc.setReducerClass(SSreducer.class);
		jc.setOutputKeyClass(Text.class);
		jc.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(jc, new Path("/input/" + ar[0] + ".txt"));
		FileOutputFormat.setOutputPath(jc, new Path("/output/" + ar[0]));
		jc.waitForCompletion(true);
	}
}
