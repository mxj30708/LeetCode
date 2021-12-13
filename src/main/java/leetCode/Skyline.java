package leetCode;

/**
 * @author mengxijie
 * @since 2021/12/13 3:19 下午
 * 807. 保持城市天际线
 */
public class Skyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] cowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        int length = 0;
        for(int i=0;i<grid.length;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++){
                max = Math.max(max,grid[i][j]);
            }
            cowMax[i]=max;
        }
        for(int i=0;i<grid[0].length;i++){
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            colMax[i] =max;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                length+= Math.min(cowMax[i],colMax[j]) -grid[i][j];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Skyline skyline = new Skyline();
        System.out.println(skyline.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
    }
}
