/**
 * Created by Arkadeep on 03-Jul-17.
 */

package tk.hobbyp;

import com.github.iarks.RandomOrgAPI.InvalidMethodCallException;
import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import com.github.iarks.RandomOrgAPI.RandomNumber;

public class Main
{
    public static void main(String args[])
    {
        int number=0, bitsLeft, bitsUsed, requestsLeft;
        try
        {
            // checked exception InvalidResponseException
            RandomNumber rn = new RandomNumber("YOUR API KEY HERE");
            rn.generate(5, 10, 5, false,"method1");

            // unchecked exception InvalidMethodCallException
            System.out.println("Obtained random numbers:");

            // obtaining random numbers one at a time using getElementAt(int i) function
            System.out.println("obtaining random numbers one at a time using getElementAt(int i) function");
            for (int i=0; i<5 ; i++)
            {
                number = rn.getElementAt(i);
                System.out.print(number+"\t");
            }
            System.out.println();

            // obtaining random numbers together as an integer array
            System.out.println("obtaining random numbers together as an integer array");
            int array[]=rn.getElementAsArray();
            for (int i=0; i<5 ; i++)
            {
                number = array[i];
                System.out.print(number+"\t");
            }
            System.out.println();

            // obtaining other metadata about the request
            bitsLeft=rn.getBitsLeft();
            bitsUsed=rn.getBitsUsed();
            requestsLeft=rn.getRequestsLeft();
            System.out.println("Bits Used = " + bitsUsed);
            System.out.println("Bits Left = " + bitsLeft);
            System.out.println("Requests Left = " + requestsLeft);
        }
        catch (InvalidResponseException invalidResponseException)
        {
            System.out.println(invalidResponseException.getMessage());
            invalidResponseException.printStackTrace();
        }
        catch(InvalidMethodCallException invalidMethodCallException)
        {
            System.out.println(invalidMethodCallException.getMessage());
            invalidMethodCallException.printStackTrace();
        }
    }
}