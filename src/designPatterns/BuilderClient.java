package designPatterns;

public class BuilderClient {

	public static void main(String [] args) {
		BuilderPattern builderPattern1 = new BuilderPattern.Builder("a", "b" ,"C").build();
		BuilderPattern builderPattern2 = new BuilderPattern.Builder("a", "b" ,"C").setBluetoothEnabled(true).build();
		BuilderPattern builderPattern3 = new BuilderPattern.Builder("a", "b" ,"C").setGraphicCardEnabled(true).build();
		BuilderPattern builderPattern4 = new BuilderPattern.Builder("a", "b", "C").setGraphicCardEnabled(true)
																				.setBluetoothEnabled(true)
																				.build();
		BuilderPattern builderPattern5 = new BuilderPattern.Builder("a", "b", "C").setGraphicCardEnabled(true)
				.setBluetoothEnabled(true).setTable("chandan")
				.build();
		
		System.out.println(builderPattern1);
		System.out.println(builderPattern2);
		System.out.println(builderPattern3);
		System.out.println(builderPattern4);
		System.out.println(builderPattern5);
	}
}
