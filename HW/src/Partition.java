public class Partition extends CDLinkedList{
    public static void main(String [] args)throws Exception{
        CDLinkedList test=new CDLinkedList();
        DListIterator dl=new DListIterator(test.header);
        test.insert(3,dl);

        while (true){
            test.printList();
            if (dl.currentNode.nextNode==HEADERVALUE) break;
        }
        
    }
}