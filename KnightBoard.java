public class KnightBoard{
  private int[][] board;
  private static int[] rw = [2, 1, -1, -2, -2, -1, 1, 2];
  private static int[] cl = [1, 2, 2, 1, -1, -2, -2, -1];



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

  public boolean isValidMove(int r, int c){
    if(r > board.length || r < 0
    || c > board[0].length || c < 0
    || board[r][c] != 0){
      return false;
    }
    else{
      return true;
    }
  }

  public boolean canMove(int r, int c){
    for(int i = 0; i < rw.length; i++){
      if(isValidMove(r + rw[i], c + cl[i])){
        return true;
      }
    }
    return false;
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

  private boolean addKnight(int row, int col, int label){
    if(board[row][col] == 0){
      board[row][col] = label;
      return true;
    }
    else{
      return false;
    }
  }



  private boolean removeKnight (int row, int col, int label){
    if(board[row][col] != 0){
      board[row][col] = 0;
      return true;
    }
    else{
      return false;
    }
  }


















  public boolean solve(int startingRow, int startingCol){
    return solveh(startingRow, startingCol, 1);
  }


  private boolean solveh(int row, int col, int level){
    if(!canMove(row, col) && level == board.length * board[0].length){
      return true;
    }
    if(!canMove(row, col) && level != board.length * board[0].length){
      return false;
    }
    if(level == 1){
      for(int i = 0; i < rw.length; i++){
        board[row][col] = level;
        solveh(row + rw[i], col + cl[i], level + 1);
      }
    }
    else{
      for(int i = 0; i < rw.length; i++){
        if(isValidMove(row + rw[i], col + cl[i])){
          board[row][col] = level;
          solveh(row + rw[i], col + cl[i], level + 1);
        }
      }
    }
  }














  public static void main(String[] args){
    KnightBoard one = new KnightBoard(6,7);
    System.out.println(one);

  }


}
