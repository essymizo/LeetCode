/* https://leetcode.com/problems/rotting-oranges/description/
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead. */

class Solution {
    int[] dir = new int[] { 0, 1, 0, -1, 0 };
    public int orangesRotting(int[][] grid) {
        // Init: Find all rotten oranges
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) queue.add(new int[]{ i, j });
            }
        }
        
        // Start: A rotten orange starts rotting its neighbors as time goes by
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // Find its unrotten neighbors
                for(int j = 0; j < 4; j++) {
                    int x = cur[0] + dir[j], y = cur[1] + dir[j+1];
                    if(0 <= x && 0 <= y && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2; 
                        queue.add(new int[]{ x, y });
                    }
                }
            }
            if(!queue.isEmpty()) time++;
        }

        // End: Check if all oranges are rotten. If yes, return time. Otherwise, return -1.
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}
