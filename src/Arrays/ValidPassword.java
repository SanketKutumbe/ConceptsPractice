package Arrays;

// Password should be more than 8 chars, with atleast 2 digits and chars

public class ValidPassword {

    public static void main(String[] args) {

        char[] password = { 'H','j', 'w', '@', '6', '1','7','g' };
        int cap = password.length;
        boolean first=false, sec=false, third=false;

        if( cap >= 8 )
            first = true;

        int digits = 0;
        int alpha = 0;

        for(int i = 0; i < cap; i++)
        {
            if(password[i]>='0' && password[i]<='9')
                digits++;
            else if(password[i]>='A' && password[i]<='Z')
                alpha++;
            else if(password[i]>='a' && password[i]<='z')
                alpha++;
        }

        if(digits>=1) sec = true;
        if(alpha>=1) third = true;
        if( first && sec && third ) {
            if (alpha + digits == cap)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
