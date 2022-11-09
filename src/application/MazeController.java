package application;

import java.awt.Point;


import searches.BFS;
import searches.DFS;
import searches.Greedy;
import searches.Magic;
import searches.RandomWalk;
import searches.SearchAlgorithm;

public class MazeController {
	/* 
	 * Logic of the program
	 */
	// The search algorithms
//	private Greedy greedy;				
//	private BFS bfs;
//	private DFS dfs;
//	private RandomWalk rand;
//	private Magic magic;
	private SearchAlgorithm search;		// This string tells which algorithm is currently chosen.  Anything other than 
	// the implemented search class names will result in no search happening.
	// Where to start and stop the search
	private Point start;
	private Point goal;

	// The maze to search
	private Maze maze;
	
	// MazeDisplay
	private MazeDisplay myDisplay;
	
	public MazeController(int numRows, int numColumns, MazeDisplay mazeDisplay) {
		start = new Point(1,1);
		goal = new Point(numRows-2, numColumns-2);
		maze = new Maze(numRows, numColumns);
		myDisplay = mazeDisplay;
	}
	
	/*
	 * Re-create the maze from scratch.
	 * When this happens, we should also stop the search.
	 */
	public void newMaze() {
		maze.createMaze(maze.getNumRows(),maze.getNumCols());
		//search = "";
		myDisplay.redraw();
	}
	/*
	 * Does a step in the search regardless of pause status
	 */
	public void doOneStep(double elapsedTime){
		if(search != null) search.step();
		myDisplay.redraw();
	}
	
	public void startSearch(String searchType) {
		maze.reColorMaze();
		//search = searchType;
		
		// Restart the search.  Since I don't know 
		// which one, I'll restart all of them.
		if(searchType.equals("BFS")) {
			search = new BFS(maze, start, goal);
		}
		else if(searchType.equals("DFS")) {
			search = new DFS(maze, start, goal);

		}
		else if(searchType.equals("Greedy")) {
			//alg = new Greedy(maze, start, goal);

		}
		else if(searchType.equals("Random")) {
			search = new RandomWalk(maze, start, goal);

		}
		else if(searchType.equals("Magic")) {
			//alg = new Magic(maze, start, goal);

		}
			// start in upper left and end in lower right corner
	}
	
	public int getCellState(Point position) {
		return maze.get(position);
	}
	
}
