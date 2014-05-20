import java.util.*;
public class Dfs {   
  private int NBR_OF_VERTICES;
  private int SINK;
  private Edge[] edges;
  private ArrayList<ArrayList<Integer>> vertices;
  private HashSet<Integer> tree;
 
  enum State{
      Visited, Not_Visited;
  }
  

  //the last element is added with a null edge
  public LinkedList<Pair> dfs(ArrayList<ArrayList<Integer>> vertices, Edge[] edges, int source, int sink){
    tree = new HashSet<Integer>();
    LinkedList<Pair> path = new LinkedList<Pair>();
    this.edges = edges;
    this.vertices = vertices;
    SINK = sink;
  
    NBR_OF_VERTICES = vertices.size();
    State vertexState[] = new State[NBR_OF_VERTICES];
    for (int i = 0; i < NBR_OF_VERTICES; i++){
      vertexState[i] = State.Not_Visited;
    }
      path.add(new Pair(Integer.MAX_VALUE, null)); //fejk the first check, blajigt...
        return runDfs(source, vertexState, path);
  }

  public LinkedList<Pair> runDfs(int city, State[] vertexState, LinkedList<Pair> path){
    if (city == SINK) {
        return path;
    } else {
      vertexState[city] = State.Visited;
      tree.add(city);
      if(path.getLast().getCity() == Integer.MAX_VALUE){
        //do nothing
      } else if(path.getLast().getCity() != city){
            path.add(new Pair(city, null));
      }


      Edge edge = findAvaibleEdge(city, vertices.get(city), vertexState);
      if(edge!=null){
        path.removeLast();
        path.add(new Pair(city, edge));
        return runDfs(edge.getOtherCity(city), vertexState, path);
      }
      path.removeLast();

      return path.size()==0 ? null : runDfs(path.getLast().getCity(), vertexState, path);
  }
}

  private Edge findAvaibleEdge(int city, ArrayList<Integer> posToEdges, State[] vertexState){ 
    for(int i=0; i<posToEdges.size(); i++) {
      Edge edge = edges[posToEdges.get(i)];
      int otherCity = edge.getOtherCity(city);
      if(edge.canUseEdge(city) && cityNotVisited(vertexState, otherCity)) {
        return edge;
      }
    }
    return null;   
  }

  public HashSet<Integer> getTree(){
        return tree;
  }

  private boolean cityNotVisited(State vertexState[], int otherCity){
        return vertexState[otherCity] == State.Not_Visited;
      }
}
