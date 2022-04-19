import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  //imgae declaration
  PImage imgBackground;
  PImage imgWallet;


  float fltWalletx = 300;
  float fltWallety = 20;
  float fltWalletSpeedx = 1;
  float fltWalletSpeedy = 1;

  float fltCircleX = 20;
  float fltCircley = 100;
  float fltCircleSpeedX = 2;
  float fltCircleSpeedY = 2;



	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgBackground = loadImage("background.jpeg");
    
    imgWallet = loadImage("wallet.png");

    imgWallet.resize(50, 50);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    image(imgBackground, 0, -100);
	  
  
    image(imgWallet, fltWalletx, fltWallety);
    fltWallety += fltWalletSpeedy;
    fltWalletx += fltWalletSpeedx;

    if (fltWalletx < 0 + 3 || fltWalletx > width - 45) {
      fltWalletSpeedx *= -1;
    }

    if (fltWallety < 0 + 3 || fltWallety > height - 50) {
      fltWalletSpeedy *= -1;
    }



  }
  
  // define other methods down here.
}