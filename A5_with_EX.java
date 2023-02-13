import java.util.*;

class NegativeException extends Exception {

}

class putpoint implements Cloneable {
    int x1, y1;

    putpoint(int x, int y) {
        x1 = x;
        y1 = y;
    }

    public Object clone() throws CloneNotSupportedException

    {
        System.out.printf("Object has been Cloned Successfully ....\n");
        return super.clone();
    }

    boolean equals(int x, int y) {
        boolean result = ((x1 == x) && (y1 == y)) ? true : false;
        return result;
    }

    void display() {
        System.out.println("  x = " + x1 + "\tY = " + y1);
    }

}

class a5_with_EH {
    public static void main(String args[]) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);
        int x, y, x1, y1;
        System.out.printf(" Enter 1st Coordinates : \n");
        try {
            System.out.printf("\n Enter X - Coordinate : ");
            x = sc.nextInt();
            System.out.printf(" Enter Y - Coordinate : ");
            y = sc.nextInt();

            putpoint obj = new putpoint(x, y);
            putpoint obj1 = (putpoint) obj.clone();
            System.out.printf("\n Members of Cloned Object ->  ");
            obj1.display();
            System.out.printf("\n Enter 2nd Coordinates : \n");
            System.out.printf("\n Enter X - Coordinate : ");
            x1 = sc.nextInt();
            System.out.printf(" Enter Y - Coordinate : ");
            y1 = sc.nextInt();
            if ((x <= 0) || (y <= 0) || (x1 <= 0) || (y1 <= 0))
                throw new NegativeException();
            putpoint obj2 = new putpoint(x1, y1);
            System.out.printf("\n Members of Object - 2 -> ");
            obj2.display();
            boolean ans = obj1.equals(x1, y1);
            if (ans)
                System.out.printf("\n Both are Same ");
            else
                System.out.printf("\n Both are Not Same");
        } catch (NegativeException e) {
            System.out.printf("\n\t ----- Points Less than or Equal to zero is not accepted ----- ");
        }

    }
}