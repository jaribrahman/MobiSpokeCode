class Triangle {

    long x;
    long y;
    long z;

    public Triangle(long x, long y, long z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    protected void printTriangleType() {
    
	int triangleType = triangleType(); 

	if (triangleType == 1) 
	    System.out.println("This is a scalar triangle.");
	else if (triangleType == 2)
	    System.out.println("This is an isosceles triangle."); 
	else if (triangleType == 3) 
	    System.out.println("This is an equilateral triangle."); 
	else if (triangleType == 4) 
	    System.out.println("This is not a triangle."); 
	
    }

    protected int triangleType() {
	
	if (isTriangle()) {
	    if (isScalar())
		return 1;
	    else if (isIsosceles()) 
		return 2;
	    else if (isEquilateral())
		return 3;
	
	}
	return 4; 
    }

    protected boolean isTriangle() {
	return (x + y >= z) && (y + z >= x) && (x + z >= y);
    }

    protected boolean isScalar() {
	return (x != y) && (y != z) && (x != z); 
    }

    protected boolean isIsosceles() {
	return ((x == y) && (y != z)) || ((x == z) && (z != y)) || ((y == z) && (z != x));
    }

    protected boolean isEquilateral() {
	return (x == y) && (y == z);
    }

}