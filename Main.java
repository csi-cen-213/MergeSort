public class Main{
  public static void main(String [ ] args) {
    SinglyLinkedList ll = new SinglyLinkedList();
    ll.append(new Node(13));
    ll.append(new Node(15));
    ll.append(new Node(11));
    ll.append(new Node(12));
    ll.append(new Node(6));
    ll.append(new Node(7));
    ll.append(new Node(3));
    ll.append(new Node(5));
    ll.print();
    
    ll.mergeSort();
    ll.print();
    /*ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    ll.pop().print();
    System.out.println();
    ll.print();
    System.out.println(ll.pop());
    ll.print();*/
    // test tail
    /*ll.print();
    ll.getTail().print();*/
    
  }
}