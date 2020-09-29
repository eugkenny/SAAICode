import java.util.LinkedList;

public class Queue<E> {

    LinkedList<E> q;

    public Queue(){
        q = new LinkedList<>();
    }

    public void enqueue(E e){
        q.addLast(e);
    }

    public E dequeue(){
        return q.removeFirst();
    }

    public boolean isEmpty(){
        return q.size() == 0;
    }
}
