public class Queue {

    private int arr[];
    private int capacity;
    private int front;
    private int back;
    private int count;

    public Queue(int queueSize){
        this.arr = new int[queueSize];
        this.capacity = queueSize;
        this.front = 0;
        this.back = -1;
        this.count = 0;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        if(getSize()==0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull(){
        if(getSize() == capacity) {
            return true;
        }else {
            return false;
        }
    }

    public int peak(){
        if(isEmpty()){
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
        return this.arr[front];
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting: " + value);

        this.back = (this.back + 1) % capacity;
        arr[back] = value;
        count++;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing:" + arr[front]);

        int temp = arr[front];
        front = (front + 1) % capacity;
        count--;
        return temp;
    }

}
