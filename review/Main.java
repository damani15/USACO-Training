import java.util.*;

class Main {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(4);
        hs.add(2);
        hs.add(3);
        hs.add(3);
        hs.remove(3);
        hs.add(5);
        hs.add(8);
        hs.add(9);
        System.out.println(hs.contains(3));
        System.out.println(hs.isEmpty());
        System.out.println(hs.size());

    }
}

// 1. Save a word of your choice in a string. Then, use a set to print out all
// of the unique letters in the word and the number of unique letters in the
// word.
// 2. Save a second word of your choice in another string. Print out the letters
// these two word have in common.
// 3. Write a method that takes in a HashSet of numbers and returns a HashSet
// with only the even numbers from that set.
// 4. Write a method that takes in a HashSet of words and returns a HashSet with
// only the words that have 3 letters in them.
// 1. Create a HashMap where the keys are the numbers 1 to 25 and the values are
// their factorials. Then, print out the HashMap.
// 2. Save a word of your choice in a string. Then, create a HashMap where the
// keys are the letters in the word and the values are the number of times each
// letter appears in the word. Then, print out the HashMap.
