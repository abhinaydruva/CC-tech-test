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

 class Polygon {

	    boolean line(Point a, Point b, Point c) 
		{ 
			if (b.x<=Math.max(a.x,c.x)&& b.x>=Math.min(a.x,c.x)&& b.y<=Math.max(a.y,c.y)&&b.y>=Math.min(a.y,c.y))
			{ 
				return true; 
			} 
			else
			{
			return false; 
			}
		} 

	  int poly(Point p,Point q,Point r) 
		{ 
			double v=(q.y-p.y)*(r.x-q.x)-(q.x-p.x)*(r.y-q.y);
			if (v==0) 
			{ 
				return 0;  
			} 
			
			else if(v>0)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		} 

		 
		 boolean intersection(Point x1, Point y1, 
								Point x2, Point y2) 
		{ 
			
			double t1=poly(x1,y1,x2); 
			double t2=poly(x1,y1,y2);
			
			double t3=poly(x2,y2,x1); 
			
			double t4=poly(x2,y2,y1); 

			if (t1==0 &&line(x1, x2, y1) ||t2==0 &&line(x1, y2, y1) || t3==0 && line(x2, x1, y2)|| t4==0 && line(x2, y1, y2)) 
			{ 
				return true; 
			} 
			else if(t1!=t2 && t3!=t4)
			{
				return true;
			}

			
			return false; 
		} 
		static final int max = 10000; 

		 boolean INoroutofPolygon(Point[] shape, Point p) 
		{ 
			 int edges=shape.length;
			int num = 0, k = -1; 
			int y=0;
			
			if (edges<3) 
			{ 
				return false; 
			} 
	        Point check = new Point(max, p.y); 

			while(k!=0)
			{ 
				
				if(y==0)
				{
					k=0;
					y=1;
				}
				int n=(k+1)%edges; 
				
				if (intersection(shape[k],shape[n],p,check)) 
				{ 
			     if (poly(shape[k],p,shape[n])==0) 
				 { 
						return line(shape[k],p,shape[n]);
					} 
					num++; 
				} 
				k = n; 
			}  
			if(num%2==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		} 

}
