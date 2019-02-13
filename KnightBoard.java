public class KnightBoard{
  private int[][] board;


  public KnightBoard(int m, int n){
    if(m <= 0 || n <= 0){
      throw new IllegalArgumentException("Dimensions must be greater than 0");
    }
    board = new int[m][n];
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        board[i][j] = 0;
      }
    }
  }




  public String toString(){
    String str = "";
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j] < 10){
          str = str + " " + board[i][j] + " ";
        }
        if(board[i][j] >= 10){
          str = str + board[i][j] + " ";
        }
      }
      str = str + "\n";
    }
    return str;
  }



  public boolean solve(int startingRow, int startingCol){
    return solveh(startingRow, startingCol, 1);
  }


  private boolean solveh(int row, int col, int level){
    
  }














  public static void main(String[] args){
    KnightBoard one = new KnightBoard(6,7);
    System.out.println(one);

  }


}
