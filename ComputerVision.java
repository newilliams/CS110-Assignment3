import java.awt.Color;
import java.util.Scanner;

public class ComputerVision {
	public static Color[][] custom (Color[][] Custom) {
		Color[][] custom = ImageUtils.cloneArray(Custom);
		Color[][] copy = ImageUtils.cloneArray(Custom);
		int r = 0;
		int g = 0;
		int b = 0;
		Scanner in = new Scanner(System.in);

			
		
		System.out.println("Lets create a custom photo ");
		
		
		System.out.print(" Enter a value from 0-255 for red ");
		r = in.nextInt();
		
		System.out.print(" Enter a value from 0-255 for green ");
		g = in.nextInt();
		
		System.out.print(" Enter a value from 0-255 for blue ");
		b = in.nextInt();
				

		
		for (int row = 0; row < custom.length; row++) {
			for (int col = 0; col < custom[row].length; col++) {
				Color pixel = custom[row][col];
				
				if (pixel.getRed() == 0 && pixel.getGreen() == 0 && pixel.getBlue() == 0 ) {
					copy[row][col] = new Color(r,g,b);
				}
				
			}
		}
		return copy;
	}
	

	
	public static Color[][] BlackAndGreen (Color[][] Image) 
	{
		Color[][] copy = ImageUtils.cloneArray(Image);
		Color[][] BlackAndGreen = ImageUtils.cloneArray(Image);

		for (int row = 0; row < BlackAndGreen.length; row++) 
		{
			for (int col = 0; col < BlackAndGreen[row].length; col++) 
			{
				Color pixel = BlackAndGreen[row][col];

				if (pixel.getRed() >  100 || pixel.getRed() < 100)
				{
				copy[row][col] = new Color(30,255,30);
			
				}

				if (pixel.getGreen() < 100 || pixel.getBlue() < 100 || pixel.getRed() < 100) {
					copy[row][col] = new Color(0,0,0);
				}
				
			}
		}
		return copy;
	
}
	
	public static Color[][] BlackAndWhite(Color[][] Image) 
	{
		Color[][] copy = ImageUtils.cloneArray(Image);
		Color[][] BlackAndWhite = ImageUtils.cloneArray(Image);


		for (int row = 0; row < BlackAndWhite.length; row++) 
		{
			for (int col = 0; col < BlackAndWhite[row].length; col++) 
			{
				Color pixel = BlackAndWhite[row][col];
				
				if (pixel.getGreen() >  100 || pixel.getBlue() > 100 || pixel.getRed() >100) 
				{
					copy[row][col] = new Color(255,255,255);

				}

				if (pixel.getGreen() < 100 || pixel.getBlue() < 100 || pixel.getRed() < 100 ) 
				{
					copy[row][col] = new Color(0,0,0);
				}
				
			}
		}
		return copy;
	
	}
	
	

	
	
	public static void main(String[] args) {
	

		ImageUtils utils = new ImageUtils();
		Color[][] originalImg = utils.loadImage("LennaCV.png");
		Color[][] Custom = utils.loadImage("TrollFace.jpg");
	
		utils.addImage(originalImg, "Original");
		utils.addImage(BlackAndGreen(originalImg), "Black and Green");
		utils.addImage(BlackAndWhite(originalImg), "Black and White");
		utils.display();
		

		utils.addImage(custom(Custom), " This is your custom photo: You have Been Trolled");
		utils.display();
	}

	
	
	
}
