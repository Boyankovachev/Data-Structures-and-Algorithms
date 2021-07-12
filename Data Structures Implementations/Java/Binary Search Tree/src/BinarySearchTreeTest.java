import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testBST(){

        BST bst = new BST();

        bst.insert(15);
        bst.insert(56);
        assert(bst.isKeyPresent(15));
        assert(bst.isKeyPresent(56));
        bst.deleteKey(56);
        assert(!bst.isKeyPresent(56));

    }

}
