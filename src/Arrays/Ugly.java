package Arrays;

// prime factors should be 2,3 or 5

public class Ugly {

    public static void main(String[] args) {
        int n = 54;

        while( n%2 == 0 )
        {
            n/=2;
            if(n==0) break;
        }

        while( n%3 == 0 )
        {
            n/=3;
            if(n==0) break;
        }

        while( n%5 == 0 )
        {
            n/=5;
            if(n==0) break;
        }

        if(n==1) System.out.println("Ugly");
        else System.out.println("Not");
    }
}
