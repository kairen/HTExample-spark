package a.b;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class mapperKey implements WritableComparable<mapperKey> {

	String id;
	String time;

	public void set(String row) {
		id = new String(row.split(" ")[0]);
		time = new String(row.split(" ")[1]);
	}

	public void readFields(DataInput arg0) throws IOException {
		id = arg0.readUTF();
		time = arg0.readUTF();
	}

	public void write(DataOutput arg0) throws IOException {
		arg0.writeUTF(id);
		arg0.writeUTF(time);
	}

	public int compareTo(mapperKey arg0) {
		if (id.toString().hashCode() != arg0.id.toString().hashCode()) {
			return id.toString().hashCode() < arg0.id.toString().hashCode() ? -1
					: 1;
		} else if (time.toString().hashCode() != arg0.time.toString().hashCode()) {
			return time.toString().hashCode() < arg0.time.toString().hashCode() ? -1
					: 1;
		} else {
			return 0;
		}
	}

}
