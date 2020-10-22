import java.util.*;

class Point 
{ 
	double x; 
	double y; 
	
	public Point(double x, double y) 
	{ 
		this.x = x; 
		this.y = y; 
	} 
};

public class Sunlightonbuildings {
	
	//if slope of line between source and upper-right point on each building is less than 0,then light on roof top is not possible
	
	
	 double slopecalculation(Point p,Point source)
	{
		double slope=Math.atan(source.y-p.y/source.x-p.x);
		
		return slope;
	}

	double lengthcalculation(Point[] building,Point source)
	{
		double lengthexposed=0;
		
		for(int i=0;i<building.length;i=i+4)
		{
			double slope1p3p=slopecalculation(building[i+3],source);
			
			if(slope1p3p>=0)
			{
				lengthexposed=lengthexposed+building[i+3].x-building[i].x;//roof-top
				
				
			}
			
			if(slope1p3p>=0 && i>=4)
			{
				double frontpart=(building[i].x-source.x)*slope1p3p-(building[i].y-source.y); //front-part
				lengthexposed=lengthexposed+frontpart;
			}
			if(i<4)
			{
				lengthexposed=lengthexposed+building[i+1].y-building[i].y;
			}
		}
		
		return lengthexposed;
	}
	
	

}
