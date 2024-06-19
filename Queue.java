public class Queue {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(Node node){
        if(isEmpty()){
            head = node;
            tail = node;
        }else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    public Node dequeue(){
        if(isEmpty()){
            return null;
        }
        Node temp = head;
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null; // Queue is now empty
        }
        temp.setNext(null); // Clean up the node's next pointer
        return temp;
    }
}
