public class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void insert(int data){
        Node newNode = new Node(data);

        if(this.head == null){
            this.head = newNode;
        }
        else{

            Node last = this.head;
            while (last.next != null){
                last = last.next;
            }

            last.next = newNode;
        }

    }

    public void printList(){

        if (this.head != null){
            Node currentNode = this.head;

            while(currentNode != null){
                System.out.print(currentNode.data + " ");

                currentNode = currentNode.next;
            }
        }
    }

    public void deleteByKey(int key){

        Node currentNode = this.head;
        Node previousNode = null;

        //if list not empty and key is in the head
        if(currentNode != null && currentNode.data == key){
            this.head = currentNode.next;
        }

        //if list is not empty and key is not at the head
        while (currentNode != null && currentNode.data != key){
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode != null){
            previousNode.next = currentNode.next;
        }
        /*
        if key not present
        while statement should have itererated so
        that currentNode should be null
        */

    }

    public void deleteAtPosition(int index){
        Node currentNode = this.head;
        Node previousNode = null;

        if(index == 0 && currentNode != null){
            this.head = currentNode.next;
            return;
        }

        //index > 0 but < size of list
        int counter = 0;
        while(currentNode != null){
            if(counter == index){
                previousNode.next = currentNode.next;
                break;
            }
            else {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }
    }

    public boolean isKeyPresent(int key){

        if(this.head == null){
            return false;
        }
        else {
            Node currentNode = this.head;
            while(currentNode != null){
                if(currentNode.data == key){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public Integer keyAtIndex(int index){

        if(this.head == null){
            return null;
        }
        else {
            Node currentNode = this.head;
            int counter = 0;
            while(currentNode != null){
                if(counter == index){
                    return currentNode.data;
                }
                currentNode = currentNode.next;
                counter++;
            }
        }
        return null;
    }

    public void reverseLinkedList(){
        Node current = this.head;
        Node prev = null;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

}





