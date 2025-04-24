package fr.afpa.exercices;

import org.apache.commons.text.CaseUtils;

import java.text.Normalizer;
import java.util.Arrays;

/**
 * The type Niveau deux.
 */
public class NiveauDeux {

    /**
     * Count vowels int.
     *
     * @param str the str
     * @return the int
     */
    public static int countVowels(String str) {

        str = str.toLowerCase();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // check if char[i] is vowel
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
                    || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u'
                    || str.charAt(i) == 'y') {
                // count increments if there is vowel in
                // char[i]
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    /**
     * Count upper cases int.
     *
     * @param str the str
     * @return the int
     */
    public static int countUpperCases(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i)))
                count++;
        }
        System.out.println(count);
        return count;
    }


    /**
     * Lower to upper case string.
     *
     * @param str the str
     * @return the string
     */
    public static String lowerToUpperCase(String str) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                result.append(Character.toUpperCase(str.charAt(i)));
            } else {
                result.append(str.charAt(i));
            }
        }

        String finalString = result.toString();
        System.out.println(finalString);
        return finalString;
    }

    /**
     * Invert string string.
     *
     * @param str the str
     * @return the string
     */
    public static String invertString(String str) {

        StringBuilder result = new StringBuilder();
        char temp;

        for (int i = str.length() - 1; i >= 0; i--) {
            temp = str.charAt(i);
            result.append(temp);
        }

        String finalString = result.toString();
        System.out.println(finalString);
        return finalString;
    }

    /**
     * Convert to camel case ez mode string.
     *
     * @param str       the str
     * @param delimiter the delimiter
     * @return the string
     */
    public static String convertToCamelCaseEZMode(String str, char delimiter) {
        str = CaseUtils.toCamelCase(str, false, delimiter);
        System.out.println(str);
        return str;
    }

    /**
     * Convert to camel case hard mode string.
     *
     * @param str       the str
     * @param delimiter the delimiter
     * @return the string
     */
    public static String convertToCamelCaseHardMode(String str, char delimiter) {

        StringBuilder result = new StringBuilder();

        boolean shouldConvertNextCharToLower = true;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == delimiter) {
                shouldConvertNextCharToLower = false;
            } else if (shouldConvertNextCharToLower) {
                result.append(Character.toLowerCase(currentChar));
            } else {
                result.append(Character.toUpperCase(currentChar));
                shouldConvertNextCharToLower = true;
            }
        }

        System.out.println(result);
        return result.toString();
    }

    /**
     * Localize string in string int [ ].
     *
     * @param str    the str
     * @param search the search
     * @return the int [ ]
     */
    public static int[] localizeStringInString(String str, String search) {

        int firstIndex = str.indexOf(search);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }

        int lastIndex = firstIndex + search.length() - 1;
        return new int[] {firstIndex, lastIndex};
    }

    /**
     * Binaire vers base 10 ez mode int.
     *
     * @param n the n
     * @return the int
     */
    public static int binaireVersBase10EZMode(String n) {
        return Integer.parseInt(n, 2);
    }

    /**
     * Binaire vers base 10 hard mode int.
     *
     * @param n the n
     * @return the int
     */
    public static int binaireVersBase10HardMode(String n) {
        int result = 0;
        int puissance = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            char bit = n.charAt(i);
            if (bit == '1') {
                result += Math.pow(2, puissance);
            }
            puissance++;
        }
        System.out.println(result);
        return result;
    }

    /**
     * Nombre vers binaire string.
     *
     * @param number the number
     * @return the string
     */
    public static String nombreVersBinaire(int number) {
        StringBuilder binaire = new StringBuilder();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            binaire.insert(0, number % 2);
            number = number / 2;
        }

        return binaire.toString();
    }

    /**
     * Fuse tables int [ ].
     *
     * @param array1 the array 1
     * @param array2 the array 2
     * @return the int [ ]
     */
    public static int[] fuseTables(int[] array1, int[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int[] fusion = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            if (array1[i] <= array2[j]) {
                fusion[k++] = array1[i++];
            } else {
                fusion[k++] = array2[j++];
            }
        }


        while (i < n1) {
            fusion[k++] = array1[i++];
        }


        while (j < n2) {
            fusion[k++] = array2[j++];
        }
        System.out.println(Arrays.toString(fusion));
        return fusion;
    }

    /**
     * Est palindrome boolean.
     *
     * @param texte the texte
     * @return the boolean
     */
    public static boolean estPalindrome(String texte) {

        String sansAccents = Normalizer.normalize(texte, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");


        sansAccents = sansAccents.toLowerCase();


        String nettoie = sansAccents.replaceAll("[^a-z]", "");


        String inverse = new StringBuilder(nettoie).reverse().toString();

        return nettoie.equals(inverse);
    }

    public static boolean validerCarte(long cardNumber) {
        String numero = String.valueOf(cardNumber);
        int somme = 0;
        boolean doubler = false;

        for (int i = numero.length() - 1; i >= 0; i--) {
            int chiffre = Character.getNumericValue(numero.charAt(i));

            if (doubler) {
                chiffre *= 2;
                if (chiffre > 9) {
                    chiffre -= 9;
                }
            }

            somme += chiffre;
            doubler = !doubler;
        }

        return somme % 10 == 0;
    }
}





