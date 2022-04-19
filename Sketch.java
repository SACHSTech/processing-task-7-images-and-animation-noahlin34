import javax.swing.text.FlowView.FlowStrategy;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * @author  Noah Lin
 * 
 * This program animates a wallet and a circle against a background of a mountain
 * 
 */
public class Sketch extends PApplet {
	
  //imgae declaration
  PImage imgBackground;
  PImage imgWallet;

  //float values for the wallet
  float fltWalletx = 300;
  float fltWallety = 20;
  float fltWalletSpeedx = 3;
  float fltWalletSpeedy = 3;

  //float values for the circle
  float fltCircleX = 100;
  float fltCircley = width/10;
  float fltCircleSpeedX = 2;
  float fltCircleSpeedY = 2;

  //float value for the waves
  float fltWave;



	
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

    //load image for background
    imgBackground = loadImage("background.jpeg");
    
    //load image for wallet
    imgWallet = loadImage("wallet.png");

    //resizes the wallet image
    imgWallet.resize(50, 50);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //computes the new value for the waves
    fltWave += (Math.PI/12);

    //draws the background image
    image(imgBackground, 0, -100);
	
    //draws the wallet image 
    image(imgWallet, fltWalletx, fltWallety);

    //moves the wallet along a sine wave
    fltWallety += (float)(Math.sin(fltWave)) + fltWalletSpeedy;
    fltWalletx += (float)(Math.sin(fltWave)) + fltWalletSpeedx;

    //if statements to reverse the wallets speed if it comes too close to the boundary
    if (fltWalletx < 0 + 3 || fltWalletx > width - 45) {
      fltWalletSpeedx *= -1;
    }

    if (fltWallety < 0 + 3 || fltWallety > height - 50) {
      fltWalletSpeedy *= -1;
    }

    //draws the circle
    circle(fltCircleX, fltCircley, 20);

    //moves the circle along a cosine wave
    fltCircleX += (float)(Math.cos(fltWave)) + fltCircleSpeedX;
    fltCircley += (float)(Math.cos(fltWave)) + fltCircleSpeedY;

    //if statements to reverse the circles speed if it comes too close to the boundary
    if (fltCircleX < 0 + 10 || fltCircleX > width - 10); {
      fltCircleSpeedX *= -1;
    }

    if (fltCircley < 0 + 10 || fltCircley > height - 10) {
      fltCircleSpeedY *= -1;
    }

  }
  
  // define other methods down here.
}