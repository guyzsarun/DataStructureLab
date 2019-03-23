public class TestStack {
	
	public static void main(String [] args)throws Exception {
		StackArray s=new StackArray();
		
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(1);



		StackArray temp= new StackArray();
		int num=s.top();
		s.pop();

		temp.push(num);
		while (!s.isEmpty()){
			if (temp.top()!=s.top()){
				temp.push(s.top());
				s.pop();
			}
			else s.pop();
		}

		while (!temp.isEmpty()){
			System.out.println(temp.top());
			temp.pop();
		}

	}
}
