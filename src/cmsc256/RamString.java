package cmsc256;
/*
Minh Nguyen
CMSC 256-004
2/18/2021
 */

public class RamString implements WackyStringInterface {

    private String string;

    /**
     * first constructor sets the string variable created to
     * "Rodney, the Ram"
     */
    public RamString() {
        string = "Rodney, the Ram";
    }
    /**
     * second constructor contains an argument
     * also throws an exception if the string is null
     */
    public RamString(String s) {
        if(s == null){
            throw new IllegalArgumentException();
        }
        string = s;
    }
    /**
     * setter method that was inherited from interface
     *sets the string variable
     * also throws exception if string is null
     */
    @Override
    public void setWackyString(String s) {
        if(s == null){
            throw new IllegalArgumentException();
        }
        string = s;
    }

    /**
     * getter method
     */
    @Override
    public String getWackyString() {
        return string;
    }
    /**
     * Method gets every the fifth character of a string
     * since in java, strings start counting at 0
     * i was set to 4 to get the first character, then
     * added 5 to i to get every other 5th character
     */
    @Override
    public String getEveryFifthCharacter() {
        String fifthChar = "";
        for (int i = 4; i < string.length(); i+=5) {
            fifthChar += string.charAt(i);
        }
        return fifthChar;
    }

    /**
     *Method gets all even characters in strings.
     * starts at 1 and adds 2 to get every even number
     */
    @Override
    public String getEvenCharacters() {
        String evenChar = "";
        for (int i = 1; i < string.length(); i+=2) {
            evenChar += string.charAt(i);
        }
        return evenChar;
    }

    /**
     *Method gets every odd character in the string
     * method starts at 0 because the first value is odd, then adds 2
     * to find all other odd characters
     */
    @Override
    public String getOddCharacters() {
        String getOddCharacter = "";
        for (int i = 0; i < string.length(); i+=2) {
            getOddCharacter += string.charAt(i);
        }
        return getOddCharacter;
    }

    /**
     * Returns the number of characters that are digits in the current string
     *  if two (and no more than two) of the same digit appear side by side.
     */
    @Override
    public int countDoubleDigits() {
        int doubleDigits = 0;
        for (int i = 1; i < string.length(); i += 2) {
            if (Character.isDigit(string.charAt(i)) && (Character.isDigit(string.charAt(i + 1)) == (Character.isDigit(string.charAt(i)) &&
                    !(Character.isDigit(string.charAt(i + 2)) == (Character.isDigit(string.charAt(i))))))){
                doubleDigits += 1;
            }
        }
        return doubleDigits;
    }

    /**
     *Returns the number of characters that are either 'a' 'e' 'i' 'o' 'u' or 'y'
     * cases do not matter
     * each if statement checks the characters uppercase and lowercase letter
     */
    @Override
    public int countVowels() {
        int vowelCounter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'a') {
                vowelCounter++;
            }
            if (string.charAt(i) == 'E' || string.charAt(i) == 'e') {
                vowelCounter++;
            }
            if (string.charAt(i) == 'I' || string.charAt(i) == 'i') {
                vowelCounter++;
            }
            if (string.charAt(i) == 'O' || string.charAt(i) == 'o') {
                vowelCounter++;
            }
            if (string.charAt(i) == 'U' || string.charAt(i) == 'u') {
                vowelCounter++;
            }
            if (string.charAt(i) == 'Y' || string.charAt(i) == 'y') {
                vowelCounter++;
            }
        }
        return vowelCounter;

    }

    /**
     * Converts a string with more than 1 word into a string with
     * lastname, firstname
     * if the string is empty or the string doesnt have more than 1 word
     * an exception is thrown
     */
    @Override
    public String reformatName() {
        String lastFirst = "";
        if (string.contains(" ")==false){
            throw new UnsupportedOperationException();
        }
        if (string.isBlank()) {
            throw new UnsupportedOperationException();
        }
        else if (!(string.isEmpty())) {
            String first = string.substring(0, string.indexOf(" "));
            String last = string.substring(string.indexOf(" ") + 1);
            lastFirst = last + ", " + first;
        }
        return lastFirst;
    }

    /**
     * this method is supposed to replace all 0 with "Go VCU" or
     * 00 with "CS@VCU"
     * does not replace anything if it is "000"
     */
    @Override
    public void ramifyString() {

        string.replace("0","Go VCU");
        string.replace("00","CS@VCU");


    }

    /**
     *Method is supposed to replace digits in the string into roman numerals.
     */
    @Override
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition) throws IllegalArgumentException {
        if (startPosition > endPosition) {
            throw new IllegalArgumentException();
        }
        String newString = string;
        string = string.substring(startPosition-1,endPosition);
        for(int i = 0; i < string.length(); i++){

            if(string.charAt(i) == '1'){
                string.replace("1", "I");
            }
            else if(string.charAt(i) == '2'){
                string = string.substring(0,i) + "II" + string.substring(i+1);
            }
            else if(string.charAt(i) == '3'){
                string = string.substring(0,i) + "III" + string.substring(i+1);
            }
            else if(string.charAt(i) == '4'){
                string = string.substring(0,i) + "IV" + string.substring(i+1);
            }
            else if(string.charAt(i) == '5'){
                string = string.substring(0,i) + "V" + string.substring(i+1);
            }
            else if(string.charAt(i) == '6'){
                string = string.substring(0,i) + "VI" + string.substring(i+1);
            }
            else if(string.charAt(i) == '7'){
                string = string.substring(0,i) + "VII" + string.substring(i+1);
            }
            else if(string.charAt(i) == '8'){
                string = string.substring(0,i) + "VIII" + string.substring(i+1);
            }
            else if(string.charAt(i) == '9'){
                string = string.substring(0,i) + "IX" + string.substring(i+1);
            }
        }
        string = newString.substring(0, startPosition-1) + string + newString.substring(endPosition);

    }
}

