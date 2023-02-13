import java.util.*;

class OutRangeException extends Exception {

}

class shapecal {

    int breadth, length, hypo, width, radius;
    String s;

    // triangle
    shapecal(String shape, int b, int l, int h) {
        breadth = b;
        length = l;
        hypo = h;
        s = shape;
        System.out.println("\n Triangle Created ...");
    }

    shapecal(String shape, int l, int w) {
        length = l;
        width = w;
        s = shape;
        System.out.println("\n Rectangle Created ...");
    }

    shapecal(String shape, int r) {
        radius = r;
        s = shape;
        System.out.println("\n Circle Created ...");
    }

    void area(int b, int h) {
        double area = 0.5 * b * h;
        System.out.printf("\n Area Of Triangle  = " + area);
    }

    void perimeter(int a, int b, int c) {
        int perimeter = a + b + c;
        System.out.printf("\n Perimeter Of Circle = " + perimeter);
    }
    // rectangle

    void rarea(int l, int h) {
        int area = l * h;
        System.out.printf("\n Area Of Rectangle  = " + area);
    }

    void rperimeter(int l, int h) {
        int perimeter = 2 * (l + h);
        System.out.printf("\n Perimeter Of Rectangle  = " + perimeter);
    }

    // Circle

    void area(int r) {
        double area = 3.14 * r * r;
        System.out.printf("\n Area Of Circle = " + area);
    }

    void perimeter(int r) {
        double perimeter = 2 * 3.14 * r;
        System.out.printf("\n Perimeter Of Circle = " + perimeter);
    }
}

class A2_with_EX {
    public static void main(String args[]) {
        int ch = 0;
        int base, length, hypo, Length, width, radius;
        Scanner sc = new Scanner(System.in);
        while (ch != 4) {
            System.out.print(
                    "\n\n\t\t\t...... Shapes Availabel ......\n 1.Triangle \n 2.Rectangle \n 3.Circle \n 4.Exit ");
            System.out.printf("\n\n Enter Your Choice : ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: // Triangle
                {
                    try {
                        System.out.printf("\n Enter the Base Value : ");
                        base = sc.nextInt();
                        System.out.printf(" Enter the Lenth value : ");
                        length = sc.nextInt();
                        System.out.printf(" Enter the Hypoteneous of Triangle : ");
                        hypo = sc.nextInt();
                        if (base > 100 || length > 100 || hypo > 100)
                            throw new OutRangeException();
                        else {
                            shapecal obj = new shapecal("Triangle", base, length, hypo);
                            obj.area(base, length); // area of triangle
                            obj.perimeter(base, length, hypo); // perimeter f triangle
                        }
                    } catch (OutRangeException e) {
                        System.out.printf("\n\t\t EXCEPTION ERROR --> \tValues Are Out Of Range ..... \n");
                    }
                }
                    break;

                case 2: // Rectangle
                {
                    try {
                        System.out.printf("\n Enter the Length Value : ");
                        Length = sc.nextInt();
                        System.out.printf(" Enter the Width Value : ");
                        width = sc.nextInt();
                        if (width > 100 || Length > 100)
                            throw new OutRangeException();
                        else {
                            shapecal obj = new shapecal("Rectangle", Length, width);
                            obj.rarea(Length, width); // area of rectangle
                            obj.rperimeter(Length, width); // perimeter of rectangle
                        }
                    } catch (OutRangeException e) {
                        System.out.printf("\n\t\t EXCEPTION ERROR --> \tValues Are Out Of Range ..... \n");
                    }
                }
                    break;

                case 3: // Circle
                {
                    try {
                        System.out.printf("\n Enter the Radius Value : ");
                        radius = sc.nextInt();
                        if (radius > 100)
                            throw new OutRangeException();
                        else {
                            shapecal obj = new shapecal("Circle", radius);
                            obj.area(radius); // area of circle
                            obj.perimeter(radius); // perimeter of circle
                        }
                    } catch (OutRangeException e) {
                        System.out.printf("\n\t\t EXCEPTION ERROR --> \tValues Are Out Of Range ..... \n");
                    }
                }
                    break;

                case 4:
                    System.out.printf("\n Exiting.....");
                    break;

                default:
                    System.out.println("\n Invalid Choice ....");
                    break;

            }
        }
    }
}