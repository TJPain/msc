import java.util.*;

public class BFS {

	public static void main(String[] args) {
		
		// create an adjacency list of all states in the problem
		ArrayList<Integer>[] adjacency = new ArrayList[9]; 
		// initialise the adjacency list
        for (int i = 0; i < 9; i++) { 
        	adjacency[i] = new ArrayList<Integer>(); 
        } 
		// add the nodes
        adjacency[1].add(2);
        adjacency[1].add(3);
        adjacency[2].add(1);
        adjacency[2].add(6);
        adjacency[3].add(4);
        adjacency[4].add(3);
        adjacency[4].add(8);
        adjacency[5].add(6);
        adjacency[5].add(7);
        adjacency[6].add(5);
        adjacency[7].add(8);
        adjacency[8].add(7);
        
        
		// initialise FIFO queue
		LinkedList<Integer> frontier = new LinkedList<Integer>();
		
		// initialise hash set for explored data structure
		HashSet<Integer> explored = new HashSet();  
		
		// add start to the search 
		frontier.add(1);
		
		// while loop 
		while (frontier.size() != 0) {
			// choose shallowest node in the frontier
			Integer current = frontier.poll();
					// if the node isn't in seen, add it to seen and print it to show it is processed 
					if(!explored.contains(current)) {
						explored.add(current);
						System.out.println();
						System.out.println("node "+current+" being explored");
					}
					// Get all adjacent vertices of the dequeued vertex. If a adjacent has not been visited, then mark it visited and enqueue it
					Iterator<Integer> i = adjacency[current].listIterator();
		            while (i.hasNext())
		            {
		            	int n = i.next();
		            	System.out.println("Child of "+current+" being tested is "+n);
		            	if (!explored.contains(n) && !frontier.contains(n)) {
		            		if (n == 7 || n == 8) {
		            			System.out.println("Goal state reached: "+n);
		            		} else {
		            			System.out.println("Adding "+n+" to the frontier");
		            			frontier.add(n);
		            		}
		            		
		            	}
		            }
		}
	}
}
