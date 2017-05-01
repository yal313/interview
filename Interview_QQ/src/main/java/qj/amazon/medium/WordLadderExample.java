package qj.amazon.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderExample {

	public static void main(String[] args){
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList1 = Arrays.asList(wordList);
		//System.out.println(ladderLength(beginWord,endWord,wordList1));
		System.out.println(findWordLadder(beginWord,endWord,wordList1));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> beginSet = new ArrayList<String>(), endSet = new ArrayList<String>();
		int len = 1;
		List<String> visited = new ArrayList<String>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				List<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			List<String> temp = new ArrayList<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);
						if (endSet.contains(target)) {
							return len + 1;
						}
						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}
			beginSet = temp;
			len++;
		}
		return 0;
	}
	
	public static int findWordLadder(String begin, String end, List<String> dict){
		long start = System.nanoTime();
		List<String> beginList = new ArrayList<String>();
		List<String> endList = new ArrayList<String>();
		beginList.add(begin);
		endList.add(end);
		
		List<String> visited = new ArrayList<String>();
		
		int step = 1;
		while(beginList.size()!=0 && endList.size()!=0){
			//if there is more elements in beginList then endList
			//swap the two
			//save some time
			if(beginList.size() > endList.size()){
				List<String> temp = beginList;
				beginList = endList;
				endList = temp;
			}
			List<String> tempList = new ArrayList<String>();
			//for each string in begin list
			for(String s: beginList){				
				char[] cc = s.toCharArray();
				//for each character in begin string
				//replace it with a-z, and try to find a match with the word in dict or endList
				for(int i = 0; i < cc.length; i++){
					char tmp = cc[i];
					for(char j = 'a'; j < 'z' ; j++){
						cc[i]=j;
						String newS = String.valueOf(cc);
						if(endList.contains(newS)){
							System.out.println(System.nanoTime()-start);
							return step + 1;
						}
						if(!visited.contains(newS) && dict.contains(newS)){
							visited.add(newS);
							tempList.add(newS);
						}
						cc[i] = tmp;
					}
				}				
			}
			beginList = tempList;
			step++;
		}
		
		System.out.println(System.nanoTime()-start);
		return step;
	}
}
