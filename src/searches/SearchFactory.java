package searches;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import application.Maze;

public class SearchFactory {
	//private SearchAlgorithm search;
	
//	public SearchAlgorithm makeSearch(SearchAlgorithm search, String searchName, Maze maze, Point start, Point goal) {
//		//maze.reColorMaze();
//		
//		if(searchName.equals("BFS")) {
//			search = new BFS(maze, start, goal);
//		}
//		else if(searchName.equals("DFS")) {
//			search = new DFS(maze, start, goal);
//
//		}
//		else if(searchName.equals("Greedy")) {
//			search = new Greedy(maze, start, goal);
//
//		}
//		else if(searchName.equals("RandomWalk")) {
//			search = new RandomWalk(maze, start, goal);
//
//		}
//		else if(searchName.equals("Magic")) {
//			search = new Magic(maze, start, goal);
//
//		}
//		return search;
//	}
	public SearchAlgorithm makeSearch(String searchName, Maze maze, Point start, Point goal) {
		try {
			Class theClass = Class.forName("searches."+searchName);
			
			// Find the right Constructor
			Class[] argumentTypes = {maze.getClass(), start.getClass(), goal.getClass()};
			Object[] arguments = {maze, start, goal};
			
			Constructor theConstructor = theClass.getConstructor(argumentTypes);
			
			return (SearchAlgorithm) theConstructor.newInstance(arguments);
			
		} catch (ClassNotFoundException e) {
			System.err.println("The problem is with the class name.");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.err.println("The problem is with the method name and parameter list");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.err.println("You don't have permission to access that method.");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.println("The problem was in invoking the constructor");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("You don't have permission to access the constructor.");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.err.println("The problem is with the parameter in the method call.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.err.println("The method or constructor threw an exception.");
			e.printStackTrace();
		}
		System.out.println("I am unable to create the Search.  Returning null.");
		return null;
	}


}
