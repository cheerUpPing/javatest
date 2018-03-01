package extend;

public class ExtendTest {

	public static void main(String[] args) {
		Parent parent = new Parent();
		ChildrenOne one = (ChildrenOne) parent;
		one.childrenOneSay();
	}
	
	
}
