
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		ArrayListStack b = new ArrayListStack();
		ArrayListStack input = (ArrayListStack)s;
		while (!input.isEmpty()) {
			int temp=input.top();
			input.pop();
			while(!b.isEmpty() && b.top()<temp) {
				input.push(b.top());
				b.pop();
			}
			b.push(temp);
		}
		
		return b;
	}
}
