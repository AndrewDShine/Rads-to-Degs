import java.util.Scanner;
import java.util.ArrayList;

public class RadsToDegs 
	{
		static Scanner userStringput = new Scanner(System.in);
		
		public static void main(String[] args)
		{
//			System.out.println("");
			System.out.println(radsToDegs(userStringput.nextLine()));
			
		}
		public static double radsToDegs(String rads)
		{
			ArrayList<String> splitRads = new ArrayList<String>();
			double conversionFactor = (180 / Math.PI);
			
			String[] divRads = rads.split("(?=/)");
			for(String s: divRads)
			{
				if(s.contains("pi"))
				{
					String[] piRads = s.split("pi");
					if(piRads.length > 0)
					{
						splitRads.add(piRads[0]);
					}
					splitRads.add("pi");
				}
				else
				{
					splitRads.add(s);
				}
			}
			
			double numerator = 1;
			double denominator = 1;
			boolean onTop = true;
			for(String s: splitRads)
			{
				if(s.contains("/"))
				{
					onTop = false;
				}
				if(onTop)
				{
					if(s.equals("pi"))
					{
						numerator *= Math.PI;
					}
					else
					{
						numerator *= Double.parseDouble(s);
					}
				}
				else
				{
					if(s.equals("pi"))
					{
						denominator *= Math.PI;
					}
					else if(s.contains("/"))
					{
						denominator *= Double.parseDouble(s.substring(1));
					}
				}
			}
			double result = (numerator / denominator);
			result *= conversionFactor;
			return result;
		}
	}
