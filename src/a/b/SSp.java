package a.b;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class SSp extends Partitioner<mapperKey, Text> {

	public int getPartition(mapperKey arg0, Text arg1, int arg2) {
		return Math.abs(arg0.id.toString().hashCode() * 127) % arg2;
	}
}
