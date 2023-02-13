import java.util.*;

import javax.xml.catalog.Catalog;

class info {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String name, grade;

        System.out.printf("\n -------NEW STUDENT DETAILS----- ");
        System.out.printf("\n Enter Student Name : ");
        name = sc.nextLine();
        System.out.printf(" Enter your grade : ");
        System.out.printf("\n  A -> 4 Points \n  B -> 3 Points \n  C -> 3 Points \n  D -> 4 Points \n");
        System.out.printf("\n Enter Here : ");
        grade = sc.nextLine();
        cal a = new cal(name);
        System.out.printf(a.calgpa(grade));
        a.upgpa();
    }
}

class MultipleEditException extends Exception {

}

class cal {
    int gpa = 0;
    int count = 0;
    String name, grade;
    Scanner sc = new Scanner(System.in);

    cal(String name) {
        this.name = name;
        System.out.printf("\n Details added successfully!!!\n");
    }

    String calgpa(String grade) {
        switch (grade) {
            case "A": {
                gpa = 4;
            }
                break;
            case "B": {
                gpa = 3;
            }
                break;
            case "C": {
                gpa = 2;
            }
                break;
            case "D": {
                gpa = 1;
            }
                break;
            default:
                System.out.printf("\n Enter the valid grade A to D");
                break;
        }
        return ("\n " + name + " has " + gpa + " GPA.");
    }

    void upgpa() {

        int ch;

        Scanner sc = new Scanner(System.in);
        try {
            System.out.printf("\n ------ Want to Update ------ \n YES=1\t\tNO=0 \n");
            System.out.printf("\n Enter Your Choice : ");
            ch = sc.nextInt();
            if (ch == 1) {
                count++;
                if (count > 2)
                    throw new MultipleEditException();
                gpa = 0;
                System.out.print("\n Enter your new grade: ");
                String newgrade = sc.next();
                System.out.printf(calgpa(newgrade));
            } else {
                System.out.printf("\n Exiting.....");
                System.exit(0);
            }
        } catch (MultipleEditException e) {
            System.out.printf("\n\t\t EXCEPTION ERROR --> \t You Have Edited Many Times ..... \n");
            System.exit(0);
        }
        upgpa();
    }

}