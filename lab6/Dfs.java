import java.util.*;
public class Dfs {   
  private int NBR_OF_VERTICES;
  private int SINK;
  private Edge[] edges;
  private ArrayList<ArrayList<Integer>> vertices;
  private HashSet<Integer> tree;
  private State[] vertexState;
 
  enum State{
      Visited, Not_Visited;
  }

  public LinkedList<Pair> dfs(ArrayList<ArrayList<Integer>> vertices, Edge[] edges, int source, int sink){
    tree = new HashSet<Integer>();
    LinkedList<Pair> path = new LinkedList<Pair>();
    this.edges = edges;
    this.vertices = vertices;
    SINK = sink;
  
    NBR_OF_VERTICES = vertices.size();
    vertexState = new State[NBR_OF_VERTICES];
    for (int i = 0; i < NBR_OF_VERTICES; i++){
      vertexState[i] = State.Not_Visited;
    }
      path.add(new Pair(source, null));
      return runDfs(source, path);
  }

  public HashSet<Integer> getTree(){
        return tree;
  }

  private LinkedList<Pair> runDfs(int city, LinkedList<Pair> path){
    if (city == SINK) {
        return path;
    }
    vertexState[city] = State.Visited;
    tree.add(city);
    if(path.getLast().getCity() != city){
          path.add(new Pair(city, null));
    }

    Edge edge = findAvailableEdge(city, vertices.get(city));
    if(edge!=null){
      path.removeLast();
      path.add(new Pair(city, edge));
      return runDfs(edge.getOtherCity(city), path);
    }
    path.removeLast();
    return path.size()==0 ? null : runDfs(path.getLast().getCity(), path);
}

  private Edge findAvailableEdge(int city, ArrayList<Integer> posToEdges){ 
    for(int i=0; i<posToEdges.size(); i++) {
      Edge edge = edges[posToEdges.get(i)];
      if(edge.canUseEdge(city) && cityNotVisited(vertexState, edge.getOtherCity(city))) return edge;
    }
    return null;   
  }

  private boolean cityNotVisited(State vertexState[], int otherCity){
        return vertexState[otherCity] == State.Not_Visited;
      }
}
