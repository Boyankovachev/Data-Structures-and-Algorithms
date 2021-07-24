import org.junit.Test;

public class LinkedListTest {

    private LinkedList list;

    public LinkedListTest(){
        list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
    }

    @Test
    public void testLinkedList(){

        for(int i=1; i<=10; i++){
            assert (list.isKeyPresent(i));
        }

        list.deleteAtPosition(4);
        assert (!list.isKeyPresent(5));

        list.deleteByKey(8);
        assert (!list.isKeyPresent(8));

    }

    @Test
    public void testReverseLinkedList(){
        LinkedList listToReverse = new LinkedList();
        listToReverse.insert(1);
        listToReverse.insert(2);
        listToReverse.insert(3);

        listToReverse.reverseLinkedList();

        assert (listToReverse.keyAtIndex(0) == 3);
        assert (listToReverse.keyAtIndex(1) == 2);
        assert (listToReverse.keyAtIndex(2) == 1);
    }

}
