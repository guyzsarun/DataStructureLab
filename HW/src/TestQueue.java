public class TestQueue{
    
    public static void main(String [] args)throws Exception{
        
    QueueArray q1=new QueueArray();
        QueueArray q2=new QueueArray();

        q1.insertLast(1);
        q1.insertLast(2);  // this one
        q1.insertLast(3);
        q1.insertLast(4); //this one
        q1.insertLast(5);
        q1.insertLast(6);
    

        //crossOver(2,3,q1,q2);
        
        q1.swap(1, 6);

        System.out.println("Q1");
        while (!q1.isEmpty()){
            int x=q1.removeFirst();
            System.out.println(x);
        }
        // System.out.println("\nQ2");
        // while (!q2.isEmpty()){
        //     int x=q2.removeFirst();
        //     System.out.println(x);
        // }
        

    }
    public static void crossOver(int i,int p , QueueArray q1,QueueArray q2)throws Exception{
        int size1 = q1.size()-i;
        int size2= q2.size()-p;
        for (int a=0;a<i;a++){
            q1.insertLast(q1.removeFirst());
        }
        for (int b=0;b<p;b++){
            q2.insertLast(q2.removeFirst());
        }

        for (int a=0;a<size1;a++){
            q2.insertLast(q1.removeFirst());
        }
         for (int b=0;b<size2;b++){
             q1.insertLast(q2.removeFirst());
         }
    }
}