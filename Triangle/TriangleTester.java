class TriangleTester {

    public static void main(String [] args) {

	long x = 0, y = 0, z = 0; 

	if (args.length != 3) {
	    System.out.println("Please enter exactly 3 positive values for the sides of the triangle."); 
	    return; 
	} else {
	    try {
	        x = Long.parseLong(args[0]); 
	    } catch (NumberFormatException e) {
		System.out.println("Please enter a numeric value for the first side of the triangle.");
		return; 
	    }
	    
	    try {
	        y = Long.parseLong(args[1]); 
	    } catch (NumberFormatException e) {
		System.out.println("Please enter a numeric value for the second side of the triangle.");
		return; 
	    }
	    
	    try {
	        z = Long.parseLong(args[2]); 
	    } catch (NumberFormatException e) {
		System.out.println("Please enter a numeric value for the third side of the triangle.");
		return; 
	    }

	    if ((x <= 0) || (y <= 0) || (z <= 0)) {
		System.out.println("Please enter positive values for the sides of the triangle."); 
		return; 
	    } else {
		Triangle t1 = new Triangle(x, y, z);
		t1.printTriangleType(); 
	    }
	}
    }
}