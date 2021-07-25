import org.junit.jupiter.api.Test;

public class TestGraph {

    private Graph<Integer> graphUniDirectional;
    private Graph<Integer> graphBiDirectional;

    TestGraph(){
        graphUniDirectional = new Graph<>(false);
        graphBiDirectional = new Graph<>(true);

        for(int i=1; i<=3;i++){
            graphUniDirectional.addVertex(i);
            graphBiDirectional.addVertex(i);
        }

    }

    @Test
    public void testUniDirectionalGraph(){

        assert graphUniDirectional.getVertexCount() == 3;
        graphUniDirectional.addEdge(1,2);
        assert graphUniDirectional.getEdgeCount() == 1;
        graphUniDirectional.addEdge(1,3);
        assert graphUniDirectional.getEdgeCount() == 2;
        assert graphUniDirectional.hasEdge(1, 3);

    }

    @Test
    public void testBiDirectionalGraph(){

        assert graphBiDirectional.getVertexCount() == 3;
        graphBiDirectional.addEdge(1, 2);
        assert graphBiDirectional.getEdgeCount() == 1;
        graphBiDirectional.addEdge(1,3);
        assert graphBiDirectional.getEdgeCount() == 2;
        assert graphBiDirectional.hasEdge(1,3);

    }

}
