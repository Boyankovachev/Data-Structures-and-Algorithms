import org.junit.jupiter.api.*;

public class QueueTest {

    @Test
    public void testQueue(){
        Queue queue = new Queue(3);

        assert !queue.isFull();
        assert queue.isEmpty();

        queue.enqueue(1);

        assert !queue.isEmpty();
        assert queue.peak() == 1;

        assert queue.dequeue() == 1;
        assert queue.isEmpty();

        queue.enqueue(1);
        queue.enqueue(2);

        assert queue.peak() == 1;

        queue.enqueue(3);

        assert queue.isFull();
        assert queue.dequeue() == 1;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 3;
        assert queue.isEmpty();
        assert !queue.isFull();
    }
}
