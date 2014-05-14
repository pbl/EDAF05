import java.util.*;
public class DFS {   
      private static final int NBR_OF_VERTICES = 55;
      private static final int SINK = 54;
      private static final int NBR_OF_EDGES = 119;
      private Edge[] edges;
      private ArrayList<ArrayList<Integer>> vertices;     
     
      enum State{
          Visited, Not_Visited;
      }
     
      public LinkedList<Integer> DFS(ArrayList<ArrayList<Integer>> vertices, Edge[] edges, int source){
            LinkedList<Integer> path = new LinkedList<Integer>();
            this.edges = edges;
            this.vertices = vertices;

            State edgeState[] = new State[NBR_OF_EDGES];
            for (int i = 0; i < NBR_OF_EDGES; i++){
                  edgeState[i] = State.Not_Visited;
            }

            State vertexState[] = new State[NBR_OF_VERTICES];
            for (int i = 0; i < NBR_OF_VERTICES; i++){
                  vertexState[i] = State.Not_Visited;
            }
            
            path.add(source);
            vertexState[source] = State.Visited;
            return runDFS(source, vertexState, edgeState, path);
      }

      public LinkedList<Integer> runDFS(int city, State[] vertexState, State[] edgeState, LinkedList<Integer> path){
            if(path.getLast() == SINK){
                  return path;
            }
            vertexState[city] = State.Visited;
            ArrayList<Integer> verticeEdge = vertices.get(city);
            for(int i=0; i<verticeEdge.size(); i++){
                  edgeState[verticeEdge.get(i)] = State.Visited; //mark that edge as used so thats never used again
                  Edge edge = edges[verticeEdge.get(i)]; 
                  int otherCity = edge.getOtherCity(city); 
                  if(edge.canUseEdge(city) && vertexState[otherCity] == State.Not_Visited && !makesCircuit(path, otherCity)){ //
                        path.add(otherCity);
                        vertexState[otherCity] = State.Visited;
                        return runDFS(otherCity, vertexState, edgeState, path);      
                  }

            }
            return runDFS(path.getLast(), vertexState, edgeState, path);
      }

      private boolean makesCircuit(LinkedList<Integer> path, int possibleCity){
            for(Integer city : path){
                  ArrayList<Integer> verticeEdge = vertices.get(city);
                  for(int i=0; i<verticeEdge.size(); i++){
                        Edge edge = edges[verticeEdge.get(i)];
                        if(edge.getOtherCity(city) == possibleCity){
                              return true;
                        }
                  }
            }
            return false;
      }

}



















