import java.util.*;

class OutRangeException extends Exception {

}

class crd_card implements Cloneable {
    String Card_holder_name;
    String Card_Exp_Date;
    String Card_number;

    crd_card(String name, String num, String expdate) {
        Card_holder_name = name;
        Card_Exp_Date = expdate;
        Card_number = num;
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.printf("\n Object has been Cloned Successfully ....\n");
        return super.clone();
    }

    int equals(String card_num1) {
        int result = (Card_number == card_num1) ? 1 : 0;
        return result;
    }

    void display() {
        System.out.println("  Card Holder Name  :  " + Card_holder_name + "\n  Card Number       :  " + Card_number
                + "\n  Card Expirey Date :  " + Card_Exp_Date);
    }

}

class A6_with_EX {
    public static void main(String args[]) throws CloneNotSupportedException {
        String name = " ", card_num = " ", expdate = " ", name1 = " ", card_num1 = " ", expdate1 = " ";
        Scanner sc = new Scanner(System.in);
        try {
            System.out.printf("\n ----- Credit Card Using Cloning ----- \n\n");
            System.out.printf(" Enter 1st Card Details: \n");
            System.out.printf("\n Enter Card Holder Name : ");
            name = sc.next();
            System.out.printf(" Enter Card Number : ");
            card_num = sc.next();
            System.out.printf(" Enter Expery Date : ");
            expdate = sc.next();

            System.out.printf("\n Enter 2nd Card Details: \n");
            System.out.printf("\n Enter Card Holder Name : ");
            name1 = sc.next();
            System.out.printf(" Enter Card Number : ");
            card_num1 = sc.next();
            System.out.printf(" Enter Expery Date : ");
            expdate1 = sc.next();

            if (card_num.length() < 8 || card_num1.length() < 8) {
                throw new OutRangeException();
            }

        } catch (OutRangeException e) {
            System.out.printf("\n\t\t EXCEPTION ERROR --> \tCard Number Must have 8 Digits ..... \n");
        } finally {
            crd_card obj = new crd_card(name, card_num, expdate);
            crd_card obj1 = (crd_card) obj.clone();
            crd_card obj2 = new crd_card(name1, card_num1, expdate1);
            System.out.printf("\n Members of Cloned Object -> \n\n");
            obj1.display();
            System.out.printf("\n Members of Object - 2 -> \n\n");
            obj2.display();
            int ans = obj1.equals(card_num1);
            if (ans == 1)
                System.out.printf("\n Both Credit Card Numbers are Same \n\n");
            else
                System.out.printf("\n Both Credit Card Numbers are Not Same \n\n");
        }
    }
}
