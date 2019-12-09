package algorithm;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int kx = king[0];
        int ky = king[1];
        //for the same row, check if there is queue
        int up = -1;
        int down = 8;
        //for the same column, check if there is queue
        int left = -1;
        int right = 8;
        //for the same pie, check if there is queue
        int rightup = -1;
        int leftdown = 8;
        //for the same na, check if there is queue
        int leftup = -1;
        int rightdown = 8;
        
        for (int i = 0; i < queens.length; i ++ ) {
            int x = queens[i][0];
            int y = queens[i][1];   
            System.out.println("x = " + x + " y = " + y);         
            //row
            if ( x == kx ) {
                int div = y-ky;
                System.out.println("div = " + div);    
                if (div > 0 && div < (right - ky) ) {
                    right = y;
                }
                if (div < 0 && -div < (ky - left) ) {
                    left = y;
                }
            }
            //column
            if ( y == ky ) {
                int div = x-kx;
                System.out.println("div = " + div);
                if (div > 0 && div < (down - kx) ) {
                    down = x;
                }
                if (div < 0 && -div < (kx - up) ) {
                    up = x;
                }
            }
            //pie
            if ( kx + ky == x + y ) {
                int div = x-kx;
                System.out.println("div = " + div);
                if (div > 0 && div < (leftdown - kx) ) {
                    leftdown = x;
                }
                if (div < 0 && -div < (kx - rightup) ) {
                    rightup = x;
                }
            }
            //na
            if ( kx - ky == x - y ) {
                int div = x-kx;                
                System.out.println("div = " + div);
                if (div > 0 && div < (rightdown - kx) ) {
                    rightdown = x;
                }
                if (div < 0 && -div < (kx - leftup) ) {
                    leftup = x;
                }
            }
        }
        
        if (left > -1) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(kx);
            ans.add(left);
            result.add(ans);     
        }
        if (right < 8) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(kx);
            ans.add(right);
            result.add(ans);     
        }
        if (up > -1) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(up);
            ans.add(ky);
            result.add(ans);     
        }
        if (down < 8) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(down);
            ans.add(ky);
            result.add(ans);     
        }
        if (leftup > -1) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(leftup);
            ans.add(leftup - kx + ky);
            result.add(ans);     
        }
        if (rightdown < 8) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(rightdown);
            ans.add(rightdown - kx + ky);
            result.add(ans);     
        }
        if (leftdown < 8) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(leftdown);
            ans.add(kx + ky - leftdown);
            result.add(ans);     
        }
        if (rightup > -1) {
            List<Integer> ans = new LinkedList<Integer>();
            ans.add(rightup);
            ans.add(kx + ky - rightup);
            result.add(ans);     
        }       
        return result;
    }

}