/******************************************************************************
 *  Compilation:  javac ShowEnergy.java
 *  Execution:    java ShowEnergy input.png
 *  Dependencies: SeamCarver.java SCUtility.java
 *                
 *
 *  Read image from file specified as command line argument. Show original
 *  image (only useful if image is large enough).
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

public class ShowEnergy {

    public static void main(String[] args) {
    	
    	String fileName = "C:\\Users\\minhsiang0617\\Desktop\\Algorithm\\seam carving\\seam\\HJocean.png";
        Picture picture = new Picture(fileName);
        
        StdOut.printf("image is %d columns by %d rows\n", picture.width(), picture.height());
        picture.show();        
        SeamCarver sc = new SeamCarver(picture);
        
        StdOut.printf("Displaying energy calculated for each pixel.\n");
        SCUtility.showEnergy(sc);

    }

}