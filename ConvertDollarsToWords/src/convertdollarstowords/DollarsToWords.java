/*
 * This class was created as a coding example by Jay Silverthorn.
 */

package convertdollarstowords;

/**
 *
 * @author Jay Silverthorn
 */

import java.text.DecimalFormat;

class DollarsToWords {
    
    /* 
     * This is code that will accept an amount and convert it to the
     * appropriate string representation.
     * 
     * Example:
     * Convert 2523.04
     * to "Two thousand five hundred twenty-three and 04/100 dollars"
     */

    // Static arrays hold the string conversion values used to transition from
    // an input digit to a corresponding text string.

    private static final String[] onesArray = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    private static final String[] teensArray = { "ten", "elleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    private static final String[] tensArray = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    String wholeDollars = "";
    String fractDollars = "";

    /**
     * Create an instance to convert a dollar value starting from a Double
     *
     * @param dollars
     *            the value to conver gien as a double value
     */

    public DollarsToWords(Double dollars) {

        initDollarsCents(dollars);

    }

    /**
     * Create an instance to convert a dollar value starting as a String 
     *
     * @param dollars
     *            the value to conver gien as a double value
     */

    public DollarsToWords(String dollars) {

        Double dDollars = 0.0;

        if ((dollars != null) && (dollars.length() > 0)) {

            // Make sure input is not just a decimal place
            
            if (!((dollars.length() == 1) && (dollars.charAt(0) == '.'))) {

                dDollars = Double.valueOf(dollars);
            }
        }

        initDollarsCents(dDollars);

    }

    /*
     *
     * Split the given dollar value into a whnole number and fractional
     * component. Save as instance values for later use.
     *
     * Use a private function to hide the implementation.
     *
     */

    private void initDollarsCents(Double dollars) {

        DecimalFormat myFormatter = new DecimalFormat("0000000000.00");

        String sDollars = myFormatter.format(dollars);

        int dot = sDollars.indexOf(".");

        wholeDollars = sDollars.substring(0,dot);
        fractDollars = sDollars.substring(dot+1, sDollars.length());

    }

     /**
     *
     * Get a String representing a dollar value submitted in the constructor.
     *  
     * @return the string representing a given dollar value
     *
     */

    public String getWords() {

        return parseDollars();

    }

    /*
     *
     * Step through each digit in the given whole dollar string starting from
     * the left (most significant) value.  A switch statement is used to act on
     * each digit postion. Each found digit is converted in turn to the string
     * equivalent and concatenated onto the return value.  Static arrays keep
     * the conversion strings where each position corresponds to the
     * corresponding text value.
     *
     * Use a private function to hide the implementation of
     *
     */

    private String parseDollars() {

        String dollarsOut = "";

        if ((wholeDollars.length() <= 10) && Long.parseLong(wholeDollars) != 0) {

            // Parse out billions

            String billions = wholeDollars.substring(0, 1);

            dollarsOut += parseSegment(billions, "billion");

            // Parse out millions

            String millions = wholeDollars.substring(1, 4);

            dollarsOut += parseSegment(millions, "million");

            // Parse out thousands

            String thousands = wholeDollars.substring(4, 7);

            dollarsOut += parseSegment(thousands, "thousand");

            // Parse out hundreds

            String hundreds = wholeDollars.substring(7, 10);

            dollarsOut += parseSegment(hundreds, "");

        } else {    // Special case for zero (or bigger than 10 whole digits)

            dollarsOut += onesArray[0];
        }

        // Add fractional component

        dollarsOut += " and " + fractDollars + "/100 dollars";

        // Remove any extra white space

        dollarsOut = dollarsOut.replaceAll("\\s+", " ");

        // As a last step, Capitalize the first letter of the dollar
        // description string.

        String firstChar = dollarsOut.substring(0, 1);

        String capChar = firstChar.toUpperCase();

        dollarsOut = capChar + dollarsOut.substring(1, dollarsOut.length());

        return dollarsOut;
    }

    private String parseSegment(String segment, String moniker) {

        String outString="";

                // isTeens indicates when to use conversion array for 10-19
        boolean isTeens = false;

        // Flags to indicate when to concatenate a dash for numbers like
        // thirty-five.
        boolean isTens = false;

        // Flags to mark when to put in 'billion', 'million', 'thousand' or 'hundred'

        boolean printMoniker = false;

        int length = segment.length();

        for (int i=0, j=length; i<length ; i++, j--) {

            int dig = Character.getNumericValue(segment.charAt(i));

            switch (j) {

                case 3:
                        if (dig == 0) continue;

                        printMoniker = true;
                        outString += onesArray[dig];
                        outString += " hundred ";
                      
                        break;
                case 2:
                        if (dig == 0) continue;

                        printMoniker = true;

                        if (dig == 1) {
                            isTeens = true;
                        } else {
                            isTens = true;
                            outString += tensArray[dig];
                        }
                        break;
                case 1:
                        if (isTeens) {
                            outString += teensArray[dig];

                        } else {
                            if (dig != 0) {
                                
                                printMoniker = true;

                                if (isTens) {
                                    outString += "-";
                                }
                                outString += onesArray[dig];

                            } 
                        }

                        break;
                default:
            }
        }

        if ((moniker.length() > 0) && printMoniker) {
            outString += " " + moniker + " ";
        }

        return outString;

    }

}
