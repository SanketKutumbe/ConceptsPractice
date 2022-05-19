package LinkedList.Abstract;

import LinkedList.SinglyLinkedList;

public interface MyList<T> {
    public boolean isEmpty();
    public void insertAtHead(T data);
    public void insertAtEnd(T data);
    public void insertAfter(T data, T previous);
    public void printList();
    public boolean searchNode(T data) ;
    public void deleteAtHead() ;
    public void deleteAtEnd();
    public void deleteByValue(T data);
}
