
/**
 * 
 * 
 * @author (Yousaf Khan) 
 * @version (.001)
 * 
 * A class useful for converting numbers of type int or String into any base. 
 */

import java.lang.Math; 

public class BaseConversion
{
    
   private static final String symbols = "0123456789ABCDEF";
   
   /**
    * Default Constructor
    */
   
   public BaseConversion( )
   {

   }
   
   /**
    * lookUp()
    * @param String        s      input literal
    * @return  int         value of the String param 
    * 
    * Return the value of the String literal up to base 16
    */
   
   public int lookUp (String s)
   {
       //Test for error cases
       
     
       // String s is null
       if ( s == null )     
       {
           System.out.println("string2int - Error. Null input");
           System.exit(1);
       }     
       // String is not single digit.
       if ( s.length() != 1 )
       {
           System.out.println("string2Int - Error. Input too long. " + s);
           System.exit(1);
       }
            
        // String s not in symbols.
        //Handled below
       
        // String in wrong case
                //Handled with .equalsIgnoreCase
       
       //Find s in symbol list
       for ( int i = 0; i < symbols.length(); i++ )
       {
           // symbols.substring(i, i+1 ) --> gives us a single symbol in symbols list
           if ( symbols.substring( i , i +1 ).equalsIgnoreCase( s ) )
           {
               //Found correct value, return it
               return i;
           }
           
       }
       
       //Inputted string not found -- error
       System.out.println("string2Int - Error. Input not found in symbol. " + s);
       System.exit(1);
       return -1;
   }
   
   /**
    * int2string()
    * Integer -> Stringdigit conversion
    * @param int    input   Input value
    * @return String        Converted value
    */
   public String lookUp (int input) 
   {
       // Error Check
       if ( input >= 0 && input < symbols.length() )
       { // Convert
           return symbols.substring(input, input + 1);
       }
       // Return 
       return "Unable to find value";
   }
   
   /**
    * Any2Ten()
    * @param String     input    literal string
    * @param int        inputBase  Base of string
    * @return  int      value of input
    */
   
   public int Any2Ten( String input, int inputBase )
   {
       //Error Check
       
       if ( input == null )
       {
           System.out.println("Input is a NULL!" );
           System.exit(1);
       }
       
       int outputValue = 0;
       // Calculations
       for ( int i = 0; i < input.length(); i++ )
       {
           String symbol = input.substring( i, i + 1);
           int value = lookUp(symbol);
           
           if (value >= inputBase)
           {
               System.out.println("The symbols calculated to a value that is out of the range of the base. Error!");
               System.exit(1);
           }
           
            outputValue = outputValue * inputBase;
            outputValue += value; 
       }
       
       return outputValue;
   }
   
   /**
    * Ten2Any()
    * @param int      input     value to convert
    * @param int      base      base to convert to
    * @return String            value of int in the base
    */
   
   public String Ten2Any (int input, int base)
   {
       int pow = 1;
       int i = 0;
       
       //Error Check
            //Negative Numbers
       if ( input < 0 )
       {
           return "No negative numbers please!";
       }
            //Base must be available in the symbols
       if (base > symbols.length() )
       {
           return "BaseOutOfIndex";
       }
       
       while ( Math.pow( base, pow ) <= input )
       {
          pow++;
       }
       
       pow--;
       
       String output = "";
       
       for (; pow >= 0; pow--)
       {
           int value = input / (int) Math.pow( base, pow );
           String symbol = lookUp( value );
           
           output += symbol;
           
           input = input % (int) (Math.pow( base, pow));
       }
       
       return output;
   }
   /**
    * Any2Any()
    * 
    * @param input     String literal to be converted
    * @param inputBase    int literal specifying the base of the String literal
    * @param outputBase   the base to convert to
    * 
    * Converts any String literal in the symbols up to base 16 from the base it is in to any up to base 16 and greater than 0.  
    */
   public String Any2Any ( String input, int inputBase, int outputBase )
   {
       return Ten2Any( Any2Ten( input, inputBase ), outputBase );
   }
}

