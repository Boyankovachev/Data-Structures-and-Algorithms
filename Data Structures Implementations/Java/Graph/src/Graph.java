import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    private boolean isBidirectional;

    public Graph(boolean isBidirectional){
        this.isBidirectional = isBidirectional;
    }

    //add vertex to the graph
    public void addVertex(T newVertex){
        map.put(newVertex, new LinkedList<T>());
    }

    //add edge between source and destination
    public void addEdge(T source, T destination){

        if(!map.containsKey(source)){
            addVertex(source);
        }
        if(!map.containsKey(destination)){
            addVertex(destination);
        }

        map.get(source).add(destination);
        if(this.isBidirectional){
            map.get(destination).add(source);
        }

    }

    public int getVertexCount(){
        return map.keySet().size();
    }

    public int getEdgeCount(){
        int count = 0;
        for(T vertex : map.keySet()){
            count = count + map.get(vertex).size();
        }
        if(this.isBidirectional){
            count = count / 2;
        }
        return count;
    }

    //is vertex present
    public boolean hasVertex(T input){
        return map.containsKey(input);
    }

    //is edge present
    public boolean hasEdge(T source, T destination){

        if(!map.containsKey(source) || !map.containsKey(destination)){
            return false;
        }
        else if(map.get(source).contains(destination)){
           return true;
        }
        else if(isBidirectional && map.get(destination).contains(source)){
            return true;
        }
        return false;

    }

    // Print adjacency list of each vertex
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        for(T vertex: map.keySet()){
            builder.append(vertex.toString() + ": ");
            for (T destination: map.get(vertex)){
                builder.append(destination.toString() + " ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}
