package qj.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	public static void main(String[] args) {
		int[][] test1 = {{0,1},{1,2}};
		System.out.println(canFinish2(3, test1));
		int[][] test2 = {{0,1},{1,0}};
		System.out.println(canFinish2(2, test2));
		

	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites){
		if(numCourses <=1){
			return true;
		}
		if(prerequisites.length == 0 || prerequisites[0].length == 0){
			return true;
		}
		
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		
		//eg: create map with courses: {0=[], 1=[], 2=[]}
		for(int i = 0; i < numCourses; i++){
			graph.put(i, new HashSet<Integer>());
		}
		
		//put dependency to map
		//eg: {0=[1], 1=[2], 2=[]}
		for(int i = 0; i < prerequisites.length; i++){
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int courseRemaining = numCourses;
		
		//find the course with no dependency, put it to queue
		//one course can be taken
		for(Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()){
			if(entry.getValue().size() == 0){
				queue.offer(entry.getKey());
				courseRemaining--;
			}
		}
		
		while(!queue.isEmpty()){
			int key = queue.poll();
			
			for(Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()){
				if(entry.getValue().contains(key)){
					entry.getValue().remove(key);
					if(entry.getValue().size()==0){
						queue.offer(entry.getKey());
						courseRemaining--;
					}
				}
			}
		}
		return courseRemaining == 0;
		
	}
	
	public static boolean canFinish1(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0)
						queue.offer(prerequisites[i][1]);
				}
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] != 0)
				return false;
		}
		return true;
	}
	
	public static boolean canFinish2(int numCourses, int[][] prere) {
		if(numCourses < 0){
			return false;
		}
		if(numCourses <= 1){
			return true;
		}
		if(prere.length == 0 && prere[0].length == 0){
			return true;
		}	
		int[] courses = new int[numCourses];	
		//find how many dependencies each course has
		//eg. 3 courses: {0,1},{1,2}
		//0 depends on 1, 1 depends on 2
		//then courses[0]=0, courses[1]=1, courses[2]=1
		for(int i = 0; i < prere.length; i++){
			courses[prere[i][1]]++;
		}
		
		//find a course that no other course depends on
		//if cant find one, false, meaning there is cylic 
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0; i < courses.length; i++){
			if(courses[i]==0){
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()){
			int key = queue.poll();
			for(int i = 0; i < prere.length; i++){
				if(prere[i][0] == key){
					courses[prere[i][1]]--;
					if(courses[prere[i][1]] == 0){
						queue.offer(prere[i][1]);
					}
				}
			}
		}
		
		for(int i = 0; i < courses.length; i++){
			if(courses[i] > 0){
				return false;
			}
		}
		
		return true;		
	}

}
