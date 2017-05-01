package qj.algorithms;

import java.util.Arrays;

//code copy right to geeksforgeeks.org
//http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
public class KruskalGraph {

	public static void main(String[] args) {
		/* Let us create following weighted graph
		        10
		   0--------1
		   |  \     |
		  6|   5\   |15
		   |      \ |
		   2--------3
		       4       */
		int V = 4;  // Number of vertices in graph
		int E = 5;  // Number of edges in graph
		KruskalGraph graph = new KruskalGraph(V, E);
		
		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;
		
		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;
		
		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;
		
		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;
		
		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;
		
		graph.kruskalMST();

	}
	
	//A class to represent a graph edge
	public class Edge implements Comparable<Edge>{
		int src, dest, weight;
		
		//Comparator function used for sorting edges based on their weight
		public int compareTo(Edge compareEdge){
			return this.weight-compareEdge.weight;
		}
	};
	
	//A class to represent a subset for union-find
	public class subset{
		int parent, rank;
	};
	
	//V=no. of vertices
	//E-no.of edges
	int V, E; 
	// collection of all edges
	Edge edge[];

	//create a graph with V vertices and E edges
	KruskalGraph(int v, int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i = 0; i < e; i++){
			edge[i] = new Edge();
		}
	}
	
	//A utility function to find set of an element i
	//(uses path compression)
	public int find(subset subsets[], int i){
		if(subsets[i].parent !=i){
			subsets[i].parent = find(subsets, subsets[i].parent);	
		}
		
		return subsets[i].parent;
	}
	
	//A function that does union of two sets of x and y
	//(uses union by rank)
	public void union(subset subsets[], int x, int y){
		 int xroot = find(subsets, x);
		 int yroot = find(subsets, y);
		 
		 //Attach smaller rank tree under root of 
		 //high rank tree
		 if(subsets[xroot].rank < subsets[yroot].rank){
			 subsets[xroot].parent = yroot;
		 }
		 else if(subsets[xroot].rank > subsets[yroot].rank){
			 subsets[yroot].parent = xroot;
		 }
		 else{
			 subsets[yroot].parent = xroot;
			 subsets[xroot].rank++;
		 }
	}
	
	public void kruskalMST(){
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for(i = 0; i < V; i++){
			result[i] = new Edge();
		}
		
		Arrays.sort(edge);
		
		subset subsets[] = new subset[V];
		for(i = 0; i < V; i++){
			subsets[i] = new subset();
		}
		
		for(int v = 0; v < V; v++){
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		
		i = 0;
		
		while(e < V-1){
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			
			int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
		}
		
		System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                               result[i].weight);
	}
	
	
}
