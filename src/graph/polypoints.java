package graph;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import graph.polypoints.Polygon.PointResult;

public class polypoints {
	public static  class Point {
		Double x;
		Double y;

		public Point(Double x,Double y){
			this.x = x;
			this.y = y;
		}
		
		public Double getX() {
			return x;
		}
		public void setX(Double x) {
			this.x = x;
		}
		public Double getY() {
			return y;
		}
		public void setY(Double y) {
			this.y = y;
		}
		
		
	}
	public static class Polygon {

		Integer id;
		List<Point> polygonPoints;
		
		public Polygon(){
			
		}
		public Polygon(int id, List<Point> polygonPoints){
			this.id = id;
			this.polygonPoints = polygonPoints;
		}
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
		public List<Point> getPolygonPoints() {
			return polygonPoints;
		}
		public void setPolygonPoints(List<Point> polygonPoints) {
			this.polygonPoints = polygonPoints;
		}
		
	public class PointResult{
		String pointLocator;
		
		public PointResult(String pointLocator){
			this.pointLocator = pointLocator;
		}
	}
	}
	public static void main(String[] args) throws IOException {
		File f1 = new File("C:\\station_polygons.txt");
	    Scanner scanner = new Scanner(f1);
	    List<Polygon> polygonList = new ArrayList<>();
	    while(scanner.hasNextLine()){
	        String data[]=scanner.nextLine().split(" ");
	        Polygon polygon = new Polygon();
	        polygon.id = Integer.parseInt(data[0]);
	        String points = data[1];
	        String[] splitPoints = points.split(",");
	        List<Point> polygonPointsList = polygon.getPolygonPoints();
        	if(polygonPointsList == null) {
        		polygonPointsList = new ArrayList<Point>();
			}
			for (int i = 0; i < splitPoints.length - 2; i += 2) {
					Double x = Double.parseDouble(splitPoints[i]);
					Double y = Double.parseDouble(splitPoints[i + 1]);
					Point p = new Point(x, y);
					polygonPointsList.add(p);
			}
			polygon.setPolygonPoints(polygonPointsList);
	
	        polygonList.add(polygon);
	        
	    }
	    
	    File f2 = new File("C:\\points.txt");
	    scanner = new Scanner(f2);
	    List<Point> pointList  = new ArrayList<>();
	    while(scanner.hasNextLine()){
	    	String data[]=scanner.nextLine().split(",");
	    	Double x = Double.parseDouble(data[0]);
        	Double y = Double.parseDouble(data[1]);
        	Point p = new Point(x,y);
        	pointList.add(p);
	    }
	    scanner.close();
	   /* Point testPoint = new Point(35.254276 , -86.041489);
		    ArrayList<Point> pp = new ArrayList<>();
	    pp.add(new Point(43.689722 , -120.629883));
	    pp.add(new Point(28.745989 , -109.907227));
	    pp.add(new Point(26.645004 , -80.90332));
	    pp.add(new Point(43.689722 , -71.762695));
	    pp.add(new Point(50.217337 , -99.624023));
	    Polygon testPolygon = new Polygon(2, pp);
	    
	    System.out.println("Point P(" + testPoint.x + ", " + testPoint.y
                + ") lies inside polygon3: " + isInside(testPolygon, testPolygon.getPolygonPoints().size(), testPoint));

	    	System.out.println("real test");*/
	    	
	  String pointsInsidefilename = "C:\\InsideStation.txt";
	  String pointsOnsidefilename = "C:\\OutSideStation.txt";
	  String pointsMayBeinsidefilename = "C:\\MayBeInsideStation.txt";
	  PrintWriter insideStationfile = new PrintWriter(pointsInsidefilename);
	  PrintWriter outsideStationfile = new PrintWriter(pointsOnsidefilename);
	  PrintWriter mayBeInsidefile = new PrintWriter(pointsMayBeinsidefilename);
	  int count = 1;
	   for(Point p : pointList){
		   for(Polygon poly : polygonList){
			   String result = isInside(poly,poly.getPolygonPoints().size(),p) ;
			   if(result != null){
				   System.out.println("id :" + poly.getId() +" point : "+ p.x + " " + p.y + " counter : " + count);
				   if(result.equalsIgnoreCase("Inside")){
					   insideStationfile.print("id :" + poly.getId() +" point : "+ p.x + " " + p.y + "\n");
				   }else if(result.equalsIgnoreCase("Outside")){
					   outsideStationfile.print("id :" + poly.getId() +" point : "+ p.x + " " + p.y + "\n");
				   }else{
					   mayBeInsidefile.print("id :" + poly.getId() +" point : "+ p.x + " " + p.y + "\n");
				   }
			   }
		   }
		   count++;
	   }
	   insideStationfile.close(); 
	   outsideStationfile.close(); 
	   mayBeInsidefile.close(); 
	}
	
	public static boolean onSegment(Point p, Point q, Point r){
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
                && q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        return false;
    }
 
    public static int orientation(Point p, Point q, Point r){
        int val = (int) ((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
 
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }
 
    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2){
 
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
 
        if (o1 != o2 && o3 != o4)
            return true;
 
        if (o1 == 0 && onSegment(p1, p2, q1))
            return true;
 
        if (o2 == 0 && onSegment(p1, q2, q1))
            return true;
 
        if (o3 == 0 && onSegment(p2, p1, q2))
            return true;
 
        if (o4 == 0 && onSegment(p2, q1, q2))
            return true;
 
        return false;
    }
    
    public static String isInside(Polygon polygon, int n, Point p)
    {
        Double INF = (double) 10000;
        if (n < 3)
           return null;
 
        Point extreme = new Point(INF, p.y);
 
        int count = 0, i = 0;
        do
        {
            int next = (i + 1) % n;
            if (doIntersect(polygon.getPolygonPoints().get(i), polygon.getPolygonPoints().get(next), p, extreme))
            {
                if (orientation(polygon.getPolygonPoints().get(i), p, polygon.getPolygonPoints().get(next)) == 0)
                    if(onSegment(polygon.getPolygonPoints().get(i), p, polygon.getPolygonPoints().get(next))){
                    	return "OnTheLine";
                    }
 
                count++;
            }
            i = next;
        } while (i != 0);
 
        return (count % 2) == 1 ? "Inside" : "Outside";
    }
}
