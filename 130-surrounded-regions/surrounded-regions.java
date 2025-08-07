class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0;i<n;i++){
            if(!visit[i][0] && board[i][0]=='O'){
                visit[i][0] = true;
                dsf(board,visit,drow,dcol,i,0);
            }
            if(!visit[i][m-1] && board[i][m-1]=='O'){
                dsf(board,visit,drow,dcol,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(!visit[0][i] && board[0][i]=='O'){
                dsf(board,visit,drow,dcol,0,i);
            }
            if(!visit[n-1][i] && board[n-1][i]=='O'){
                dsf(board,visit,drow,dcol,n-1,i);
            }
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visit[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dsf(char[][] board,boolean[][] visit,int[] drow,int[] dcol,int ro,int co){
        int n = board.length;
        int m = board[0].length;
        visit[ro][co] = true;
        for(int i=0;i<4;i++){
            int delr = ro+drow[i];
            int delc = co+dcol[i];
            if(delr>=0 && delr<n && delc>=0 && delc<m && !visit[delr][delc] && board[delr][delc]=='O'){
                dsf(board,visit,drow,dcol,delr,delc);
            }

        }
    }
}