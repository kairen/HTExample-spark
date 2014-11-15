package a.b;
import java.io.IOException;
import java.util.TreeSet;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SSmapper extends Mapper<Text, Text, mapperKey, Text>{

	protected void map(Text key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		mapperKey mk = new mapperKey();
		mk.set(value.toString());
		context.write(mk, value.toString().split(" ")[2]);
		super.map(key, value, context);
	}
}
