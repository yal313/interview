package qj.amazon;

public class IslandGridMap {

	static int y;          // The height of the given grid
    static int x;          // The width of the given grid
    static char[][] g;     // The given grid, stored to reduce recursion memory usage
    
    public static void main(String[] args){
    	char[][] grid = new char[5][4];
    	grid[0][0]='1';
    	grid[0][1]='1';
    	grid[0][2]='1';
    	grid[0][3]='0';

    	grid[1][0]='1';
    	grid[1][1]='1';
    	grid[1][2]='1';
    	grid[1][3]='0';
    	
    	grid[2][0]='1';
    	grid[2][1]='0';
    	grid[2][2]='0';
    	grid[2][3]='0';
    	
    	grid[3][0]='1';
    	grid[3][1]='1';
    	grid[3][2]='0';
    	grid[3][3]='0';
    	
    	grid[4][0]='0';
    	grid[4][1]='0';
    	grid[4][2]='0';
    	grid[4][3]='0';
    	
    	System.out.println(numIslands(grid));

    	
    	
    }
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * 
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public static int numIslands(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = grid;
        // Our count to return
        int c = 0;      
        // Dimensions of the given graph
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;
        
        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }
    
    public static int numIslands1(char[][] grid) {
        //copy grid
    	g = grid;
    	
    	//two dimensional array, length = second[] = y = height
    	y = g.length;
    	if(y <= 0){
    		return 0;
    	}
    	x = g[0].length;
    	int count = 0;
    	
    	for(int i = 0; i < y; i++){
    		for(int j = 0; j < x; j++){
    			if(g[i][j] == '1'){
    				dfs1(i,j);
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private static void dfs(int i, int j) {
        
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        
        // Mark the site as visited
        g[i][j] = '0';
        
        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
    
    
    
    
	private static void dfs1(int i, int j) {
		if(i < 0 || j < 0 || i >=y || j >= x || g[i][j]!='1') return;
		
		//set the island as already counted
		g[i][j] = '0';
		
		//check surround island/water
		dfs1(i-1,j);
		dfs1(i+1,j);
		dfs1(i,j-1);
		dfs1(i,j+1);
	}
    
}
