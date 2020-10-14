import java.util.*;

public class Vertex<T>
{	
	interface GoalFunction<T> {
	    boolean evaluate(Vertex<T> o);
	}

	private final T data;
	private final List<Vertex<T>> _successors = new ArrayList<Vertex<T>>();
    
	public Vertex(T data) { this.data = data; }
	public T getData() { return data; }
	public List<Vertex<T>> successors() { return _successors; }

	public static List<Vertex<Integer>> petersenGraph()
	{
		int[][] edges =
	    {{0,1}, {1,0}, {1,2}, {2,1}, {2,3}, {3,2}, {3,4}, {4,3}, {4,0}, {0,4},
	     {5,6}, {6,5}, {6,7}, {7,6}, {7,8}, {8,7}, {8,9}, {9,8}, {9,5}, {5,9},
	     {5,0}, {0,5}, {6,2}, {2,6}, {7,4}, {4,7}, {8,1}, {1,8}, {9,3}, {3,9}};
		
		List<Vertex<Integer>> v = new ArrayList<Vertex<Integer>>();
		for (int i = 0; i < 10; i++) {
			v.add(new Vertex<Integer>(i));
		}
		
		for (int[] e : edges) {
		    v.get(e[0]).successors().add(v.get(e[1]));
		}
		return v;	
	}

	public static void main(String[] args)
	{
	    List<Vertex<Integer>> v = petersenGraph();
	    Stack<Vertex<Integer>> path = new Stack<Vertex<Integer>>();
	    if (depthFirstSearch(v.get(0), new GoalFunction<Integer>() {
	        public boolean evaluate(Vertex<Integer> v)
	        {
	            return v.getData() == 7;
	        }
	    }, path))
	    {
	        System.out.print("Found path: ");
	        for (Vertex<Integer> u : path)
	        {
	            System.out.print(u.getData() + " ");
	        }
	        System.out.println();
	    }
	    else
	    {
	        System.out.println("No path found");
	    }
	}
	
	public static <T> boolean depthFirstSearch(Vertex<T> start, GoalFunction<T> isGoal, Stack<Vertex<T>> result) {
		if (result.contains(start)) {
			return false;
		}
		
		result.push(start);

		if (isGoal.evaluate(start)) {
			return true;
		}
			
		for (Vertex<T> v : start.successors()) {
			if (depthFirstSearch(v, isGoal, result)) {
				return true;
			}
		}

		// No path was found
		result.pop();
		return false; 
	}
}

