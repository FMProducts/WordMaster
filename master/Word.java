/**
 * Work on the String
 * @author Fariz Mamedow
 * @version 1.0
 */
public class Word {
    private static String string;

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    /**
     * Generate random String(password)
     * @param digit
     * @param length
     * @return String
     */
    public static String StringGenerate(Boolean digit, Integer length){
        StringBuilder result = new StringBuilder();
        if(length <= 0) result.append(String.valueOf(length));
        for(int i = length;i>0;i--){
            result.append(WordBuilder.getChar(WordBuilder.random(100,300) , digit));
        }
        return result.toString();
    }

    private static WordBuilder instance;

    public static WordBuilder getInstance(String str) {
        if (instance == null) instance = new WordBuilder(str);
        return instance;
    }

    /**
     * String Builder
     * @version 1.0
     */
    public static class WordBuilder {

        private WordBuilder(String str){
            string = str;
        }

        /**
         * return result
         * @return String
         */
        public String string(){
            return string;
        }

        /**
         * String to Camel Case
         * firstWordToLowerCase = true
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder toCamelCase() {
            return toCamelCase(true);
        }

        /**
         * String to Camel Case
         * return this instance
         * @param firstWordToLowerCase
         * @return WordBuilder
         */
        public WordBuilder toCamelCase(boolean firstWordToLowerCase) {
            if(string == null) throw new NullPointerException();
            String str = string;
            StringBuilder result = new StringBuilder();
            Boolean isUpper = false;
            char currentChar;

            for (int i = 0; i < str.length(); i++) {
                currentChar = str.charAt(i);
                if(i==0){
                    if(firstWordToLowerCase) result.append(Character.toLowerCase(currentChar));
                    else result.append(Character.toUpperCase(currentChar));
                    continue;
                }

                if(Character.isSpaceChar(currentChar)){
                    isUpper = true;
                    continue;
                }
                if(isUpper) result.append(Character.toUpperCase(currentChar));
                else result.append(Character.toLowerCase(currentChar));
                isUpper = false;
            }

            string = result.toString();
            return instance;
        }

        /**
         * String to Snake Case
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder SnakeCase() {
            if(string == null) throw new NullPointerException();
            String str = string;
            char currentChar;
            StringBuilder result = new StringBuilder();
            boolean special = false;
            for (int i = 0; i < str.length(); i++) {
                currentChar = str.charAt(i);

                if(Character.isUpperCase(currentChar)){
                    if(!special && i != 0){
                        result.append('_');
                        special = false;
                    }
                    result.append(Character.toLowerCase(currentChar));
                    continue;
                }
                if(Character.isSpaceChar(currentChar)) {
                    result.append('_');
                    special = true;
                    continue;
                }
                result.append(currentChar);
            }
            string = result.toString();
            return instance;
        }

        /**
         * String to Java Constance
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder JavaConst(){
            if(string == null) throw new NullPointerException();
            String str = string;

            char currentChar;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                currentChar = str.charAt(i);
                if(Character.isLowerCase(currentChar)){
                    result.append(Character.toUpperCase(currentChar));
                    continue;
                }
                if(Character.isSpaceChar(currentChar)){
                    result.append('_');
                    continue;
                }

                result.append(currentChar);
            }
            string = result.toString();
            return instance;
        }

        /**
         * String to Up Case
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder UpCase(){
            if(string == null) throw new NullPointerException();
            String str = string;
            char currentChar;
            StringBuilder result = new StringBuilder();
            for(int i=0; i < str.length();i++){
                currentChar = str.charAt(i);
                if(Character.isLowerCase(currentChar)){
                    result.append(Character.toUpperCase(currentChar));
                    continue;
                }
                result.append(currentChar);
            }
            string = result.toString();
            return instance;
        }

        /**
         * String to Low Case
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder LowCase(){
            if(string == null) throw new NullPointerException();
            String str = string;
            char currentChar;
            StringBuilder result = new StringBuilder();
            for(int i=0; i < str.length();i++){
                currentChar = str.charAt(i);
                if(Character.isUpperCase(currentChar)){
                    result.append(Character.toLowerCase(currentChar));
                    continue;
                }
                result.append(currentChar);
            }
            string = result.toString();
            return instance;
        }

        /**
         * Get digit from String
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder getDigit(){
            if (string == null) throw new NullPointerException();
            String str = string;
            StringBuilder result = new StringBuilder();
            char currentChar;
            for(int i=0;i < str.length();i++){
                currentChar = str.charAt(i);
                if(Character.isDigit(currentChar)){
                    result.append(currentChar);
                }
            }

            string = result.toString();
            return instance;
        }

        /**
         * Get char from string
         * Delete digit in String
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder getChars(){
            if (string == null) throw new NullPointerException();
            String str = string;
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < str.length();i++){
                char currentChar = str.charAt(i);
                if(Character.isAlphabetic(currentChar)){
                    result.append(currentChar);
                }
            }
            string = result.toString();
            return instance;
        }

        /**
         * String in reverse order
         * return this instance
         * @return WordBuilder
         */
        public WordBuilder Reverse(){
            if (string == null) throw new NullPointerException();
            StringBuilder result = new StringBuilder();
            for(int i = string.length()-1;i>-1;i--){
                result.append(string.charAt(i));
            }
            string = result.toString();
            return instance;
        }

        /**
         * @param code
         * @param digit
         * @return char
         */
        private static char getChar(Integer code , Boolean digit){
            if(code >= 100 && code <= 200) return UPPER.charAt(range(UPPER.length(), code));
            if(code >= 200 && digit && code <= 250) return DIGITS.charAt(range(DIGITS.length(), code));
            return LOWER.charAt(range(LOWER.length() , code));
        }

        /**
         * @param strLenght
         * @param code
         * @return int
         */
        private static int range(Integer strLenght, Integer code){
            Integer result = Math.abs(code);
            while(result > strLenght){
                result = result / 2;
            }
            return Math.abs(result - 1);
        }

        /**
         * @param min
         * @param max
         * @return int
         */
        private static int random(Integer min, Integer max){
            double range = Math.abs(max - min);
            double result = (Math.random() * range) + (min <= max ? min : max);
            return (int) result;
        }
    }
}
