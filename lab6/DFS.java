import java.util.*;
public class DFS {   
      private int NBR_OF_VERTICES;
      private int SINK;
      // private int NBR_OF_EDGES;
      private Edge[] edges;
      private ArrayList<ArrayList<Integer>> vertices;     
     
      enum State{
          Visited, Not_Visited;
      }
     
      public LinkedList<Pair> DFS(ArrayList<ArrayList<Integer>> vertices, Edge[] edges, int source, int sink){
            LinkedList<Pair> path = new LinkedList<Pair>();
            this.edges = edges;
            this.vertices = vertices;
            NBR_OF_VERTICES = vertices.size();
            SINK = sink;
            State vertexState[] = new State[NBR_OF_VERTICES];
            for (int i = 0; i < NBR_OF_VERTICES; i++){
                  vertexState[i] = State.Not_Visited;
            }
                  
            return initDFS(source, vertexState, path);
            // return runDFS(source, vertexState, path);
      }

      private LinkedList<Pair> initDFS(int source, State[] vertexState, LinkedList<Pair> path){
            ArrayList<Integer> sourceEdge = vertices.get(source);
            vertexState[source] = State.Visited;
            for(int i=0; i<sourceEdge.size(); i++){
                  Edge edge = edges[sourceEdge.get(i)]; 
                  int otherCity = edge.getOtherCity(source);
                  if(edge.canUseEdge(source) && cityNotVisited(vertexState, otherCity)){ //
                        path.add(new Pair(otherCity, edge));
                        return runDFS(otherCity, vertexState, path); 
                  }
            }
            return null;
      }

      public LinkedList<Pair> runDFS(int city, State[] vertexState, LinkedList<Pair> path){
            // System.out.println("the path so far: ");
            // for(Integer cityNumber : path){
                  // System.out.println("city: " + cityNumber);
            // }

            if(city == SINK){
                  return path;
            }

            vertexState[city] = State.Visited;
            ArrayList<Integer> verticeEdge = vertices.get(city);
            for(int i=0; i<verticeEdge.size(); i++){
                  // System.out.println("in the for-loop for city: " + city + " the value of i is: " + i);
                  // edgeState[verticeEdge.get(i)] = State.Visited; //mark that edge as used so thats never used again.
                  Edge edge = edges[verticeEdge.get(i)]; 
                  int otherCity = edge.getOtherCity(city); 
                  //checks if the edge is usable if the city hasnt been used and that it doesnt make a circuit
                  // System.out.println("the answer of canUseEdge: " + edge.canUseEdge(city));
                  // System.out.println("the the answer of cityNotVisited: "+ cityNotVisited(vertexState, otherCity));
                  // System.out.println("the the answer of makesCircuit: "+ makesCircuit(path, city, otherCity));
                  // if(edge.canUseEdge(city) && cityNotVisited(vertexState, otherCity) && !makesCircuit(path, city, otherCity)){ //
                        if(edge.canUseEdge(city) && cityNotVisited(vertexState, otherCity)){ //
                        // System.out.println("the first if: ");
                        Pair pair = new Pair(otherCity, edge);      
                        path.add(pair);
                        return runDFS(otherCity, vertexState, path);      
                  }

                  //you cant continue from this city remove it from the path
                  if(i+1 == verticeEdge.size()){
                        // System.out.println("the second if: ");
                        path.removeLast();      
                  }
            }
            // System.out.println("hej");
            //backtracking. to the city before
            //noticed now that this doesnt work. Because it needs to beacktrack more than one city sometimes!
            if(path.size() == 0){
                  return null;
            }
            // System.out.println(path);
            // System.out.println(path.getLast());
            // System.out.println(vertexState);
            // System.out.println(path.getLast() + ", " + vertexState + ", " + path);
            return runDFS(path.getLast().getCity(), vertexState, path);
      }

      private boolean cityNotVisited(State vertexState[], int otherCity){
            return vertexState[otherCity] == State.Not_Visited;
      }

      // private boolean makesCircuit(LinkedList<Pair> path, int cityNow, int possibleCity){
      //       //for all cities thats has been added to the path
      //       for(Integer city : path){
      //             ArrayList<Integer> verticeEdge = vertices.get(city);
      //             //check all the cities edges to see if anyone connects to the poosibleCity
      //             for(int i=0; i<verticeEdge.size(); i++){
      //                   Edge edge = edges[verticeEdge.get(i)];
      //                   if(edge.getOtherCity(city) == possibleCity && city!=cityNow){
      //                         return true;
      //                   }
      //             }
      //       }
      //       return false;
      // }

}
