public class KnightBoard{
  private int[][] board;
  private static int[] rw ={2, 1, -1, -2, -2, -1, 1, 2};
  private static int[] cl = {1, 2, 2, 1, -1, -2, -2, -1};



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
    if(r >= board.length || r < 0
    || c >= board[0].length || c < 0
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

  private void clear(){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        board[i][j] = 0;
      }
    }
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
    if(row >= board.length || row < 0
    || col >= board[0].length || col < 0){
      return false;
    }
    if(!canMove(row, col) && level == board.length * board[0].length){
      board[row][col] = level;
      return true;
    }
    if(canMove(row, col) && level != board.length * board[0].length){
      return solveh(row + rw[0], col + cl[0], level + 1) ||
      solveh(row + rw[1], col + cl[1], level + 1) ||
      solveh(row + rw[2], col + cl[2], level + 1) ||
      solveh(row + rw[3], col + cl[3], level + 1) ||
      solveh(row + rw[4], col + cl[4], level + 1) ||
      solveh(row + rw[5], col + cl[5], level + 1) ||
      solveh(row + rw[6], col + cl[6], level + 1) ||
      solveh(row + rw[7], col + cl[7], level + 1);
    }
    return false;
  }














  public static void main(String[] args){
    KnightBoard one = new KnightBoard(6,7);
    System.out.println(one);
    one.addKnight(4,4, 4);
    System.out.println(one);
    System.out.println(one.canMove(4,4));
    System.out.println(one.isValidMove(1, 2));
    one.clear();
    one.addKnight(5, 0, 1);
    one.addKnight(3, 1, 2);
    one.addKnight(4, 2, 3);
    System.out.println(one);
    System.out.println(one.canMove(5, 0));
    KnightBoard two = new KnightBoard(5, 5);
    two.solve(4, 4);
    System.out.println(two);


  }


}
