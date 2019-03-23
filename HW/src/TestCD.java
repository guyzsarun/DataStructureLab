public class TestCD{
    public static void main(String [] args)throws Exception{
        CDLinkedList cd = new CDLinkedList();
        DListIterator d1= new DListIterator(cd.header);

        cd.insert(3, d1);
        d1.next();
        cd.insert(6,d1);
        d1.next();
        cd.insert(4,d1);
        d1.next();
        cd.insert(7,d1);
        
        cd.swap(4  , 3);


        d1.currentNode=cd.header;
        while (true)
        {
        System.out.println(d1.next());
        if (d1.currentNode==cd.header||d1.currentNode.nextNode==cd.header)  break;
        }

    }

}