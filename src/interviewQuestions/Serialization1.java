package interviewQuestions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 
1.  what is transient keyword in java?
2.  What do you mean by serialization and de-serialization in java?
3.  what is the significance of seriallVersionUUID in serialization?
4.	what happens when we use static or final keywords on the serialization class?
5. 	what is marker interface in java?
6.	is Runnable a marker interfece? NO	 
  
 
 
 
 */
public class Serialization1 implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		User s1 = new User(211, "ravi", 22);// creating object
		// writing object into file
		FileOutputStream f = new FileOutputStream("f.txt");
		ObjectOutputStream out = new ObjectOutputStream(f);
		out.writeObject(s1);
		out.flush();

		out.close();
		f.close();
		System.out.println("success");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
		User s = (User) in.readObject();
		System.out.println(s.id + " " + s.name + " " + s.age);
		in.close();
	}
}

class User implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	transient int age;// Now it will not be serialized

	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}