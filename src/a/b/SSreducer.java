package a.b;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class SSreducer extends Reducer<mapperKey, Text, Text, Text>{

	/**
a 02 abcd
a 05 aqe
a 08 def         key:a  value:list<02 abcd,05 aqe,08 def>
b 02 kms
b 05 aqr         key:b  value:list<02 kms,05 aqr>
                 2 reduce function
	 */
	
	protected void reduce(mapperKey arg0, Iterable<Text> arg1,
			org.apache.hadoop.mapreduce.Reducer.Context arg2)
			throws IOException, InterruptedException {
		super.reduce(arg0, arg1, arg2);
		Text rk = new Text();
		rk.set(arg0.id + " " +arg0.time);
		for(Text rv : arg1){
			arg2.write(arg0, rv);
		}
	}
}
