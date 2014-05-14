import sys
import fileinput

class Vertex(object):
    def __init__(self, name):
        self.name = name
        self.edges = []

    def find(self, sink, path):
        if(self == sink):
            return path
        for edge in self.edges:
            residual = edge.capacity - edge.flow
            if(residual > 0 or edge.inf):
                if(edge not in path and edge.oppositeEdge not in path):
                    toVertex = edge.toVertex
                    path.append(edge)
                    result = toVertex.find(sink, path)
                    if result != None:
                        return result

class Edge(object):
    def __init__(self, fromVertex, toVertex, capacity):
        self.fromVertex = fromVertex
        self.toVertex = toVertex
        self.capacity = capacity
        self.flow = 0
        self.inf = False
        if(capacity == -1):
            self.inf = True
    def __repr__(self):
        return self.fromVertex.name.strip() + " - " + self.toVertex.name.strip()

def buildGraph(vertices, edges):
    for edge in edges:
        sourceVertex = vertices[int(edge[0])]
        sinkVertex = vertices[int(edge[1])]
        capacity = int(edge[2])
        edge1 = Edge(sourceVertex, sinkVertex, capacity)
        edge2 = Edge(sinkVertex, sourceVertex, capacity)
        sourceVertex.edges.append(edge1)
        sinkVertex.edges.append(edge2)
        edge1.oppositeEdge = edge2
        edge2.oppositeEdge = edge1

def maxFlow(source, sink):
    path = source.find(sink, [])
    while path != None:
        minCap = sys.maxint
        for e in path:
            if(e.capacity < minCap and not e.inf):
                minCap = e.capacity

        for edge in path:
            edge.flow += minCap
            edge.oppositeEdge.flow -= minCap
        path = source.find(sink, [])

    return sum(e.flow for e in source.edges)

vertices, edges = parse()
buildGraph(vertices, edges)
source = vertices[0]
sink = vertices[len(vertices)-1]
maxFlow = maxFlow(source, sink)