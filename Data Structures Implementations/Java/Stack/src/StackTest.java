import org.junit.jupiter.api.*;

public class StackTest {

    @Test
    public void testStack(){
        Stack stack = new Stack(3);
        assert stack.isEmpty();

        stack.push(1);
        assert stack.peek() == 1;

        stack.push(2);
        assert stack.peek() == 2;

        assert stack.pop() == 2;

        assert stack.peek() == 1;

        stack.push(2);
        stack.push(3);

        assert stack.isFull();
    }
}
