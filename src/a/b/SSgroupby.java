package a.b;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SSgroupby extends WritableComparator {
	public int compare(WritableComparable w1, WritableComparable w2) {
		mapperKey ip1 = (mapperKey) w1;
		mapperKey ip2 = (mapperKey) w2;
		int l = ip1.id.toString().hashCode();
		int r = ip2.id.toString().hashCode();
		return l == r ? 0 : (l < r ? -1 : 1);
	}
}
