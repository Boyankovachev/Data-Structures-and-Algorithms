public class Stack {

    private int arr[];
    private int capacity;
    private int top;

    public Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public boolean isEmpty(){

        if(this.top == -1){
            return true;
        }
        else {
            return false;
        }

    }

    public int getSize(){
        return top+1;
    }

    public boolean isFull(){
        if(getSize() >= capacity){
            return true;
        }
        else {
            return false;
        }
    }

    public int peek(){
        if(!isEmpty()){
            return arr[top];
        }
        else {
            System.exit(1);
        }
        return -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting: " + value);
        top = top + 1;
        arr[top] = value;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing: " + peek());
        int temp = peek();
        this.top = this.top - 1;
        return temp;
    }

}
