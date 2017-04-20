public class SinglyLinkedList{
  // Properties
  private Node head = null;
  private Node tail = null;
  private int size = 0;

  // Constructor: Using default constructor
  
  // Getter/Setter Methods
  
  public Node getHead() {
    return this.head;
  }
  
  public Node getTail() {
    return this.tail;
  }
  
  public void setHead(Node newNode) {
    this.head = newNode;
    // TEST: will this work in all circumstances?
    this.size = 1;
  }

  public int getSize() {
    return this.size;
  }
  
  /* Traverses & prints list */
  public void print() {
    if (this.isEmpty()) {
      System.out.println("List is empty.");
    }
    else {
      Node tmp = this.head;
      while (tmp != null) {
        tmp.print();
        tmp = tmp.getNext();
      }
      System.out.println("");
    }
  }
  
  public boolean isEmpty() {
    return this.head==null;
  }
  
  public void add(int index, int data) {
    Node newNode = new Node(data);
    
    if( index > this.size)
      //error
      System.out.println("Index " + index + " does not exist.");
    else {
      // if list is empty, newNode is head
      if (this.isEmpty()) {
        this.head = newNode;
        this.tail = newNode;
      }
      // adds to front of list
      else if (index == 0) {
        newNode.setNext(head);
        this.head = newNode;
      }
      else if (index == this.size) {
        // adds to end of list
        Node current = this.head;
        while (current.getNext() != null) {
          current = current.getNext();
        }
        current.setNext(newNode);
        this.tail = newNode;
      }
      else {
        // adds to middle of list
        Node current = this.head;
        for(int i = 0; i < index - 1; i++) {
          current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
      }
    this.size++;
    }
  }
  
  public void addNode(int index, Node newNode) { 
    if( index > this.size)
      //error
      System.out.println("Index " + index + " does not exist.");
    else {
      // if list is empty, newNode is head
      if (this.isEmpty()) {
        this.head = newNode;
        this.tail = newNode;
      }
      // adds to front of list
      else if (index == 0) {
        newNode.setNext(head);
        this.head = newNode;
      }
      else if (index == this.size) {
        // adds to end of list
        Node current = this.head;
        while (current.getNext() != null) {
          current = current.getNext();
        }
        current.setNext(newNode);
        this.tail = newNode;
      }
      else {
        // adds to middle of list
        Node current = this.head;
        for(int i = 0; i < index - 1; i++) {
          current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
      }
    this.size++;
    }
  }
    
  // Finds a node and returns its reference
  public Node find(int index) {
    // BUG: null pointer exception when index < 0
    Node tmp = head;
    if (index < 0 || index > size) {
      //System.out.println("Find: " + index);
      return null;
    }
    else {
      for (int i = 0; i < index; i++)
        tmp = tmp.getNext();
      return tmp;
    }
  }
  
  // Deletes node at index if it exists
  public void delete(int index) {
    Node tmp = this.head;
    int i = 0;
    // delete head
    if (index == 0) {
      this.head = this.head.getNext();
    }
    // delete nodes later in list
    while (tmp.getNext() != null 
             && i < index-1) {
      //System.out.println("Delete: " + i);
      tmp = tmp.getNext();
      i++;
    }
    if (index < 0) {
      System.out.println("Index can't be negative.");
    }
    else {
      try {
        // update tail if end of list
        if (tmp.getNext().getNext() == null)
          this.tail = tmp;
        tmp.setNext(tmp.getNext().getNext());
        size--;
      }
      catch (Exception e) {
        System.out.println("That index does not exist.");
      }
    }
  }
  
  public void destroy() {
    this.head = null;
    this.tail = null;
  }
  
  public Node pop() {
    if (this.isEmpty())
      return null;
    Node tmp = this.head;
    this.head = this.head.getNext();
    tmp.setNext(null);
    this.size--;
    return tmp;
  }
  
  public void append(Node newNode) {
    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    }
    else{
      this.tail.setNext(newNode);
      this.tail = newNode;
    }
    this.size++;
  }
  
  public void mergeSort() {
    System.out.println("mergeSort");
    this.print();
    System.out.println("Size: " + this.getSize());
    SinglyLinkedList left = new SinglyLinkedList();
    SinglyLinkedList right = new SinglyLinkedList();
    SinglyLinkedList result = new SinglyLinkedList();
    if (this.size > 1) {
      int middle = this.size / 2;
      System.out.println("middle: " + middle);
      for (int i = 0; i < middle; i++)  
        left.append(this.pop());
      right = this;
      System.out.print(".");
      left.mergeSort();
      System.out.print(".");
      right.mergeSort();
      System.out.print(".");
      left.merge(right);
      left.print();
      System.out.print(".");
      this.head = left.getHead();
    }
    System.out.print("end mergeSort: ");
    this.print();
  }
  
  public void merge(SinglyLinkedList other) {
    System.out.println("merge");
    System.out.print("this: ");
    this.print();
    System.out.print("other: ");
    other.print();
    SinglyLinkedList result = new SinglyLinkedList();
    while (!this.isEmpty() || !other.isEmpty()) {
      if (this.isEmpty()) 
        while (!other.isEmpty())
          result.append(other.pop());
      else if (other.isEmpty()) 
        while (!this.isEmpty())
          result.append(this.pop());
      else if (this.getHead().getData() < other.getHead().getData()) {
        result.append(this.pop());
      }
    }
    this.head = result.head;
  }
}