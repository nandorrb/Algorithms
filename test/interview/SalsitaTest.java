/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package test.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SalsitaTest {

    // boolean isSorted(int[] array)

    /**
     * Checks if the array is sorted in non-decreasing order.
     */
    boolean isSorted(int[] integersArray) {
        int sizeOfArray = integersArray.length;
        for (int i = 1; i < sizeOfArray; i++) {
            if (integersArray[i] < integersArray[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // compress: 'abcab' => ['a', 'b', 'c'], [0, 1, 2, 0, 1], ['b', 'a', 'c'], [1, 0, 2, 1, 0]

    /**
     * Compresses a string into unique characters and their positions.
     * Example: 'abcab' => ['a', 'b', 'c'], [0, 1, 2, 0, 1]
     */
    public CompressedString compress(String compressable) {
        if (compressable == null || compressable.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        int sizeOfArray = compressable.length();
        int[] encriptedValues = new int[sizeOfArray];
        Set<Character> characters = new HashSet<>();

        // Fill set with unique values, maintaining insertion order
        for (char character : compressable.toCharArray()) {
            characters.add(character);
        }

        // Create a list from the set to access index positions
        List<Character> characterList = new ArrayList<>(characters);

        // Map each character in the string to its position in the unique characters list
        for (int i = 0; i < sizeOfArray; i++) {
            encriptedValues[i] = characterList.indexOf(compressable.charAt(i));
        }

        CompressedString result = new CompressedString();
        result.setCharacters(characterList);
        result.setLegend(encriptedValues);
        return result;
    }

    class CompressedString {
        private List<Character> characters;
        private int[] legend;

        public void setCharacters(List<Character> characters) {
            this.characters = characters;
        }

        public void setLegend(int[] legend) {
            this.legend = legend;
        }

        public List<Character> getCharacters() {
            return characters;
        }

        public int[] getLegend() {
            return legend;
        }
    }

    public static void main(String[] args) {
        SalsitaTest test = new SalsitaTest();

        // Test cases for isSorted
        System.out.println(test.isSorted(new int[] { })); // true
        System.out.println(test.isSorted(new int[] { 1, 1, 1, 1, 1, 1 })); // true
        System.out.println(test.isSorted(new int[] { 1, 2 })); // true
        System.out.println(test.isSorted(new int[] { 3, 2, 1 })); // false
        System.out.println(test.isSorted(new int[] { 3, 30, 3000, 4, 41, 400 })); // false

        // Test case for compress
        CompressedString compressed = test.compress("abcab");
        System.out.println("Characters: " + compressed.getCharacters());
        System.out.println("Legend: " + Arrays.toString(compressed.getLegend()));
    }
}
