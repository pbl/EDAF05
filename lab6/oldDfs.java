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
          
            return runDfs(source, vertexState, path);
      }

      public LinkedList<Pair> runDfs(int city, State[] vertexState, LinkedList<Pair> path){
              if (city == SINK) {
                  return path;
              } else {
                  vertexState[city] = State.Visited;
                  tree.add(city);

                  ArrayList<Integer> verticeEdge = vertices.get(city);
                  // Edge = findAvaibleEdge();
                  for(int i = 0; i < verticeEdge.size(); i++) {
                      Edge edge = edges[verticeEdge.get(i)];
                      int otherCity = edge.getOtherCity(city);

                      if (edge.canUseEdge(city) && cityNotVisited(vertexState, otherCity)) { //
                          path.add(new Pair(city, edge));
                          runDfs(otherCity, vertexState, path);
                      }
                  }
                  path.removeLast();
//                  if (path.size() == 0) {
//                      return false;
//                  }
                  runDfs(path.getLast().getCity(), vertexState, path);
              }
              return path;
      }

      public HashSet<Integer> getTree(){
            return tree;
      }

      private boolean cityNotVisited(State vertexState[], int otherCity){
            return vertexState[otherCity] == State.Not_Visited;
      }
}
