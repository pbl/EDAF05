import java.util.*;
public class DFS {   
      private static final int NBR_OF_VERTICES = 55;
      private HashMap<Integer, Edge> edges;
      private HashMap<Integer, ArrayList<Integer>> vertices;     
     
      enum VertexState{
          White, Gray, Black
      }
     
      public LinkedList<Integer> DFS(HashMap<Integer, ArrayList<Integer>> vertices, HashMap<Integer, Edge> edges, int city){
            // Parser parser = new Parser();
            VertexState state[] = new VertexState[NBR_OF_VERTICES];
            LinkedList<Integer> path = new LinkedList<Integer>();
            // this.edges = parser.getEdges();
            // this.vertices = parser.getVertices();
            this.edges = edges;
            this.vertices = vertices;
            path.add(city);
            for (int i = 0; i < NBR_OF_VERTICES; i++)
                  state[i] = VertexState.White;
            return runDFS(city, state, path);
      }
     
      public LinkedList<Integer> runDFS(int city, VertexState[] state, LinkedList<Integer> path){
            if(path.getLast() == 54){
                  return path;
            } 
            state[city] = VertexState.Gray;
            ArrayList<Integer> edgesKey = vertices.get(city);
            for(int i=0; i<edgesKey.size(); i++){
                  Edge edge = edges.get(edgesKey.get(i));
                  int otherCity = edge.getOtherCity(city);
                  if(edge.canUseEdge(city) && state[otherCity] == VertexState.White){
                        path.add(otherCity);
                        runDFS(otherCity, state, path);      
                  }
            }
            state[city] = VertexState.Black;
            return path;
      }

}