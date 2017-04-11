import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {
  
  int testBoxX;
  int testBoxY;
  String heroImage;
  
  public Board() {
    testBoxX = 0;
    testBoxY = 0;
    heroImage = "hero-down.png";
    
    // set the size of your draw board
    setPreferredSize(new Dimension(720, 792));
    setVisible(true);
  }
  
  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    // here you have a 720x720 canvas
    // you can create and draw an image using the class below e.g.
  
    int[][] map = {{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},{0, 0, 0, 1, 0, 1, 0, 1, 1, 0},{0, 1, 1, 1, 0, 1, 0, 1, 1, 0},{0,0,0,0,0,1,0,0,0,0},{1,1,1,1,0,1,1,1,1,0},{0,1,0,1,0,0,0,0,1,0},{0,1,0,1,0,1,1,0,1,0},{0,0,0,0,0,1,1,0,1,0},{0,1,1,1,0,0,0,0,1,0},{0,0,0,1,0,1,1,0,1,0},{0,1,0,1,0,1,0,0,0,0}};
    for (int j = 0; j < map.length; j++) {
      for (int i = 0; i < map[j].length; i++) {
        if (map[j][i] == 1) {
          PositionedImage wall = new PositionedImage("wall.png", i * 72, j * 72);
          wall.draw(graphics);
        } else {
          PositionedImage floor = new PositionedImage("floor.png", i * 72, j * 72);
          floor.draw(graphics);
        }
      }
  
      PositionedImage hero = new PositionedImage(heroImage, testBoxX, testBoxY);
      hero.draw(graphics);
    }
  }
  
  // To be a KeyListener the class needs to have these 3 methods in it
  @Override
  public void keyTyped(KeyEvent e) {
  
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
  
  }
  
  // But actually we can use just this one for our goals here
  @Override
  public void keyReleased(KeyEvent e) {
    // When the up or down keys hit, we change the position of our box
      if (e.getKeyCode() == KeyEvent.VK_UP && testBoxY > 0) {
        testBoxY -= 72;
        heroImage = "hero-up.png";
      } else if (e.getKeyCode() == KeyEvent.VK_DOWN && testBoxY < 720) {
        testBoxY += 72;
        heroImage = "hero-down.png";
      } else if (e.getKeyCode() == KeyEvent.VK_LEFT && testBoxX > 0) {
        testBoxX -= 72;
        heroImage = "hero-left.png";
      } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && testBoxX < 648) {
        testBoxX += 72;
        heroImage = "hero-right.png";
      }
      // and redraw to have a new picture with the new coordinates
      repaint();
    }
  }