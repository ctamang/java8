package designPatterns;


/*
 When to use Builder pattern?
	Useful in creating objects with many optional properties because in factory pattern client have to pass null.
	Avoid the possibility of using an object in inconsistent state.
	when class instance creation is heavy and complex.
 
 Existing implementations in JDK
	All implementations of java.lang.Appendable are infact good example of use of Builder pattern in java. e.g.
	java.lang.StringBuilder#append() [Unsynchronized class]
	java.lang.StringBuffer#append() [Synchronized class]
	java.nio.ByteBuffer#put() (also on CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)
	Another use can be found in javax.swing.GroupLayout.Group#addComponent().
	Look how similar these implementations look like what we discussed above.
		StringBuilder builder = new StringBuilder("Temp");
		String data = builder.append(1)
                			.append(true)
                			.append("friend")
                			.toString();
		System.out.println(data);
		Output:
		Temp1truefriend
 
Benefits and Advantages of Builder Pattern
	Undoubtedly, the number of lines of code increase at least to double in builder pattern, but the effort pays off in terms of 
	design flexibility and much more readable code. The parameters to the constructor are reduced and are provided in highly readable 
	method calls.
	Builder pattern also helps minimizing the number of parameters in constructor and thus there is no need to pass in null for 
	optional parameters to the constructor. It’s really attracts me.
	Another advantage is that Object is always instantiated in a complete state rather than sitting in an incomplete state until the 
	developer calls (if ever calls) the appropriate “setter” method to set additional fields.
	And I finally I can build immutable objects without much complex logic in object building process.

Costs and Disadvantages of Builder Pattern
	Though Builder pattern reduce some line of code buy eliminating the need of setter methods, still in double up total lines by 
	introducing the Builder object. Furthermore, although client code is more readable, the client code is also more verbose. 
	Though for me, readability weighs more than lines of code 
	
 * 
 */
public class BuilderPattern {

	private String ram;
	private String HDD;
	private String CPU;
	
	private boolean isGraphicCardEnabled;
	private boolean isBluetoothEnabled;
	private String table;
	
	private BuilderPattern(Builder builder) {
		this.ram = builder.ram;
		this.HDD = builder.HDD;
		this.CPU = builder.CPU;
		this.isGraphicCardEnabled = builder.isGraphicCardEnabled;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
		this.table = builder.table;
	}
	
	public static class Builder{
		private String ram;
		private String HDD;
		private String CPU;
		
		private boolean isGraphicCardEnabled;
		private boolean isBluetoothEnabled;
		private String table;
		
		Builder(String ram, String HDD, String CPU) {
			this.ram = ram;
			this.HDD = HDD;
			this.CPU = CPU;
		}

		public Builder setGraphicCardEnabled(boolean isGraphicCardEnabled) {
			this.isGraphicCardEnabled = isGraphicCardEnabled;
			return this;
		}

		public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Builder setTable(String table) {
			this.table = table;
			return this;
		}
		
		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}

	public String getRam() {
		return ram;
	}

	public String getHDD() {
		return HDD;
	}

	public String getCPU() {
		return CPU;
	}

	public boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	@Override
	public String toString() {
		return "BuilderPattern [ram=" + ram + ", HDD=" + HDD + ", CPU=" + CPU + ", isGraphicCardEnabled="
				+ isGraphicCardEnabled + ", isBluetoothEnabled=" + isBluetoothEnabled + ", table=" + table + "]";
	}

	
	
}
