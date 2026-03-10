import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class linkedList {    

    public static Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next;
        }
        return prev;
    }
    public static void printLinkedList(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter number of data for linked list: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        for(int i = 0; i<n; i++){
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        System.out.println("Original Linked List: ");
        printLinkedList(head);
        head = reverseList(head);
        System.out.println("\nReversed Linked List: ");
        printLinkedList(head);
        sc.close();
    }
}
