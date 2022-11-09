package searches;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import application.Maze;

public class DFS extends SearchAlgorithm{

	
	public DFS(Maze mazeBlocks, Point startPoint, Point goalPoint){
		super(mazeBlocks, startPoint, goalPoint);
		// The data structure for DFS is a stack.
		Stack<Point> stack =new Stack<>();
		stack.push(startPoint);
		data = stack;
	}
	@Override
	protected void ifNextStateNull() {	
		maze.markVisited(current);
		Stack<Point> stack = (Stack<Point>)data;
		stack.pop();
	}
	/*
	 * Depth-First Search Algorithm.
	 */
//	public boolean step(){
//		// Don't keep computing after goal is reached or determined impossible.
//		if(searchOver){
//			return searchResult;
//		}
//		// Find possible next steps
//		Collection<Point> neighbors = getNeighbors();
//		// Choose one to be a part of the path
//		Point next = chooseNeighbor(neighbors);
//		// mark the next step
//		if(next!=null){
//			maze.markPath(next);
//			recordLink(next);
//		}
//		// if no next step is found
//		else{	
//			maze.markVisited(current);
//			Stack<Point> stack = (Stack<Point>)data;
//			stack.pop();
//		}
//		resetCurrent();
//		checkSearchOver();
//		return searchResult;	
//	}
	
	/*
	 * This method defines which "neighbors" or next points can be reached in the maze from
	 * the current one.  
	 * 
	 * In this method, the neighbors are defined as the four squares immediately to the north, south,
	 * east, and west of the current point, but only if they are in the bounds of the maze.  It does 
	 * NOT check to see if the point is a wall, or visited.  
	 * 
	 * Any other definition of "neighbor" indicates the search subclass should override this method.
	 */
//	protected Collection<Point> getNeighbors(){
//		List<Point> maybeNeighbors = new ArrayList<>();
//		maybeNeighbors.add(new Point(current.x-1,current.y));
//		maybeNeighbors.add(new Point(current.x+1,current.y));
//		maybeNeighbors.add(new Point(current.x,current.y+1));
//		maybeNeighbors.add(new Point(current.x,current.y-1));
//		List<Point> neighbors = new ArrayList<>();
//		for(Point p: maybeNeighbors){
//			if(maze.inBounds(p)){
//				neighbors.add(p);
//			}
//		}
//		return neighbors;
//	}
	
	/*
	 * This method defines the neighbor that gets chosen as the newest "fringe" member
	 * 
	 * It chooses the first point it finds that is empty.
	 */
//	protected Point chooseNeighbor(Collection<Point> neighbors){
//		for(Point p: neighbors){
//			if(maze.get(p)==Maze.EMPTY){
//				return p;
//			}
//		}
//		return null;
//	}
	
	// When a new node is chosen, push it on the stack
	@Override
	protected void recordLink(Point next){
		Stack<Point> stack = (Stack<Point>)data;
		// FIXME: add try/catch for ClassCastException
		try {
			stack.push(next);

		}
		catch(ClassCastException e) {
			
		}
	}
	
	/*
	 * Get the next fringe point to consider.
	 * 
	 * This implementation resets the "current" instance variable 
	 * to be the next one on the fringe data structure.
	 */
//	protected void resetCurrent(){
//		Stack<Point> stack = (Stack<Point>)data;
//		current = stack.peek();
//	}
	
	/*
	 * Search is over and unsuccessful if there are no more fringe points to consider.
	 * Search is over and successful if the current point is the same as the goal.
	 */
//	private void checkSearchOver(){
//		if(data!= null && data.isEmpty()) {
//			searchOver = true;
//			searchResult = false;
//		}
//		if(isGoal(current)){
//			searchOver = true;
//			searchResult = true;
//		}
//	}
	
//	private boolean isGoal(Point square){
//		return square!= null && square.equals(goal);
//	}
}
