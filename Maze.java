class MazeGameState {
  char[][] maze; 
  int playerX, playerY;

  MazeGameState(char[][] maze, int playerX, int playerY) {
    this.maze = maze;
    this.playerX = playerX;
    this.playerY = playerY;
  }

  String render() {
    String result = "";
    int x = 0, y = 0;
    for(char[] mbs: this.maze) {
      x = 0;
      for(char mb: mbs) {
        if(this.playerX == x && this.playerY == y) {
          result += '+';
        }
        else {
          result += mb;
        }
        x += 1;
      }
      y += 1;
      result += "\n";
    }
    return result;
  }

  void moveUp() {
    if(playerY == 0 || (this.maze[playerY - 1][playerX] != ' ')) {
      return;
    }
    else {
      this.playerY -= 1;
    }
  }
  void moveDown() {
    if(playerY == (this.maze.length - 1) || (this.maze[playerY + 1][playerX] != ' ')) {
      return;
    }
    else {
      this.playerY += 1;
    }
  }
  void moveLeft() {
    if(playerX == 0 || (this.maze[playerY][playerX - 1] != ' ')) {
      return;
    }
    else {
      this.playerX -= 1;
    }
  }
  void moveRight() {
    if(playerX == (this.maze[0].length - 1) || (this.maze[playerY][playerX + 1] != ' ')) {
      return;
    }
    else {
      this.playerX += 1;
    }
  }
}

class MazeGameMain {
  public static void main(String[] args) {
    MazeGameState mg = new MazeGameState(new char[][]{
      {'#', '#', 'S', '#', '#', '#'},
      {'#', ' ', ' ', ' ', ' ', '#'},
      {'#', '#', '#', '#', ' ', '#'},
      {'#', ' ', ' ', '#', ' ', '#'},
      {'#', '#', ' ', ' ', ' ', '#'},
      {'#', '#', '#', '#', ' ', '#'},
      {'#', ' ', ' ', ' ', ' ', '#'},
      {'#', 'F', '#', '#', '#', '#'},
    }, 2, 0);
    while(true) {
      System.out.println(mg.render());
      String s = System.console().readLine().trim();
      if(s.equals("l")) {
        mg.moveLeft();
      }
      if(s.equals("r")) {
        mg.moveRight();
      }
      if(s.equals("u")) {
        mg.moveUp();
      }
      if(s.equals("d")) {
        mg.moveDown();
      }
    }
  }
}
