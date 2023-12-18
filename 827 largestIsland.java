class Solution {
    int m, n;
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 1;
        Map<Integer, Integer> islandMap = new HashMap<>();
        m = grid.length;
        n = grid[0].length;
        int index = 2, result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    islandMap.put(index, calIslandArea(grid, index++, i, j));
                }
            }
        }

        if(islandMap.size() == 0) return 1;

        

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    int totalArea = 1;
                    Set<Integer> areaSet = getIslandArea(grid, i, j);
                    if(areaSet.size() == 0) continue;

                    for(int area: areaSet) {
                        totalArea += islandMap.get(area);
                    }

                    result = Math.max(result, totalArea);

                }
            }
        }

        if(result == 0) return islandMap.get(2);

        return result;
    }

    public int calIslandArea(int[][] grid, int index, int i, int j) {
        if(!isLegal(grid, i, j) || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = index;
        return calIslandArea(grid, index, i - 1, j) + calIslandArea(grid, index, i + 1, j) 
               + calIslandArea(grid, index, i, j - 1) + calIslandArea(grid, index, i, j + 1) + 1;
    }

    public boolean isLegal(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public Set<Integer> getIslandArea(int[][] grid, int i, int j) {
        Set<Integer> result = new HashSet<>();
        if(isLegal(grid, i - 1, j) && grid[i - 1][j] != 0) {
            result.add(grid[i - 1][j]);
        }

        if(isLegal(grid, i + 1, j) && grid[i + 1][j] != 0) {
            result.add(grid[i + 1][j]);
        }

        if(isLegal(grid, i, j - 1) && grid[i][j - 1] != 0) {
            result.add(grid[i][j - 1]);
        }

        if(isLegal(grid, i, j + 1) && grid[i][j + 1] != 0) {
            result.add(grid[i][j + 1]);
        }

        return result;
    }
}
