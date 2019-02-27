public class KnightBoard{
  public int[][] board;
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
    if(this.isValidMove(row, col)){
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
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException("Board must be cleared before finding a solution");
        }
      }
    }
    if(startingRow >= board.length || startingRow < 0 ||
    startingCol >= board[0].length || startingCol < 0){
      throw new IllegalArgumentException("One of the parameters is negative or out of bounds");
    }
    return solveh(startingRow, startingCol, 1);
  }


  private boolean solveh(int row, int col, int level){
    if(level == board.length * board[0].length){
      addKnight(row, col, level);
      return true;
    }
    if(isValidMove(row, col) && canMove(row, col)
    && level < board.length * board[0].length){
      if(addKnight(row, col, level)){
        for(int i = 0; i < rw.length; i++){
          if(solveh(row + rw[i], col + cl[i], level + 1)){
            return true;
          }
        }
      }
      removeKnight(row, col, level);
    }
    return false;
  }








  public int countSolutions(int startingRow, int startingCol){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException("Board must be cleared before finding a solution");
        }
      }
    }
    if(startingRow >= board.length || startingRow < 0 ||
    startingCol >= board[0].length || startingCol < 0){
      throw new IllegalArgumentException("One of the parameters is negative or out of bounds");
    }
    return help(startingRow, startingCol, 0);
  }


  private int help(int row, int col, int level){
    if(level == board.length * board[0].length){
      return 1;
    }
    int sum = 0;
    if(isValidMove(row, col) && canMove(row, col)
    && level < board.length * board[0].length){
      for(int i = 0; i < rw.length; i++){
        if(addKnight(row, col, level)){
          sum += help(row + rw[i], col + cl[i], level + 1);
          removeKnight(row, col, level); 
        }
      }
    }
    return sum;
  }











  public static void main(String[] args){
    KnightBoard one = new KnightBoard(6,7);
    System.out.println(one);
    one.addKnight(4,4, 4);
    System.out.println(one);
    System.out.println(one.canMove(4,4));
    one.addKnight(1,2,3);
    System.out.println(one.isValidMove(1, 2));
    one.clear();
    one.addKnight(5, 0, 1);
    one.addKnight(3, 1, 2);
    one.addKnight(4, 2, 3);
    System.out.println(one);
    System.out.println(one.canMove(5, 0));
    System.out.println(rw[0]);
    System.out.println(cl[0]);
    System.out.println("------------------------");
    System.out.println();
    KnightBoard two = new KnightBoard(8, 8);
    System.out.println(two.isValidMove(8,8));
    System.out.println(two.isValidMove(-1, 0));
    System.out.println(two.isValidMove(0, -1));
    System.out.println(two.isValidMove(10, 0));
    System.out.println(two.isValidMove(0, 10));
    System.out.println(two.canMove(7,7));
    System.out.println(two.canMove(8,8));
    System.out.println();
    System.out.println();
    System.out.println(two.solve(0,0));
    System.out.println(two);
    System.out.println(two.board.length);
    System.out.println(two.board[0].length);
    System.out.println();
    System.out.println();
    KnightBoard three = new KnightBoard(2, 5);
    System.out.println(three.solve(0,0));
    System.out.println(three);
    KnightBoard four = new KnightBoard(4, 4);
    System.out.println(four.countSolutions(0,0));


  }


}
