
public class StudentList extends CDLinkedList{
	public void removeStudent(String id )throws Exception{
		DListIterator i = new DListIterator(header);
		for (int n =0 ;n<size();n++) {
			Student stu = (Student)i.next();
			if (stu.getId()==id) {
				removeAt(i);
			}
		}
	}
	public void append(CDLinkedList list2)throws Exception {
		
	}
	
	public void appendQuick(CDLinkedList list2)throws Exception{
		if (list2==null) return;
		this.header.previousNode.nextNode=list2.header.nextNode;
		list2.header.nextNode.previousNode=this.header.previousNode;
		this.header.previousNode=list2.header.previousNode;
		list2.header.previousNode.nextNode=this.header;
		
		
		
		
	}
	public CDLinkedList gender(int i )throws Exception{
		CDLinkedList ret=new CDLinkedList();
		DListIterator d = new DListIterator (header);
		DListIterator s=new DListIterator(ret.header);
		String sex="";
		if(i==0) sex="male";
		else if (i==1) sex="female";
		else return null;
		
		for (int n=0;n<size();n++) {
			Student stu = (Student)d.next();
			if (stu.getSex()==sex) {
				System.out.println(stu);
				insert(stu,s);
				s.next();
			
			}
		}
		return ret;
	}
}