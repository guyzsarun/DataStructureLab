
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		int i=0;
		int max=q.size();
		for (i=i;i<max;i++) {
			if (x<q.front()) break;
			q.insertLast(q.removeFirst());
		}
		q.insertLast(x);
		for (;i<max;i++) {
			q.insertLast(q.removeFirst());
		}
		return;
	}
	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}
	
}
