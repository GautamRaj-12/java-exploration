package linked_list;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    LinkedList(){
        this.head = null;
    }
    void insertAtBeginning(int data){
        Node newNode = new Node(data);

        if(this.head==null){
            this.head=newNode;
        }else{
            newNode.next = this.head;
            this.head = newNode;
        }
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
        }else{
            Node current = this.head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void printList() {
        Node current = this.head;
        StringBuilder result = new StringBuilder();
        while (current != null) {
            String nextData = (current.next != null) ? Integer.toString(current.next.data) : "null";
            result.append("Data:").append(current.data).append(",Next:").append(nextData).append(" -> ");
            current = current.next;
        }
        result.append("null");
        System.out.println(result.toString());
    }
}

public class SinglyLinkedList{
    public static void main(String[] args) {
        LinkedList L1 = new LinkedList();
        LinkedList L2 = new LinkedList();
        int[] arr = {2,5,8,7};

        System.out.println("----------Adding all elements of the array to the beginning of the linked list----------");
        for(int  num:arr){
            L1.insertAtBeginning(num);
        }
        L1.printList();

        System.out.println("----------Adding all elements of the array to the end of the linked list----------");
        for(int  num:arr){
            L2.insertAtEnd(num);
        }
        L2.printList();
    }
}
