import java.util.*;

public class Dic {

    private Map<Character, List<String>> DictionaryMap;

    public Dic() {
        DictionaryMap = new HashMap<>();
    }

    public void addWord(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        if (!DictionaryMap.containsKey(firstChar)) {
            DictionaryMap.put(firstChar, new ArrayList<>());
        }
        DictionaryMap.get(firstChar).add(word);
    }

    public void sortAllWords() {
        DictionaryMap.forEach((key, list) -> Collections.sort(list));
    }

    public void printAllWords() {
        sortAllWords();
        DictionaryMap.forEach((key, words) -> printWords(key, words));
    }

    public void printWordsOfLetter(char letter) {
        char findChar = Character.toLowerCase(letter);
        List<String> words = DictionaryMap.get(findChar);
        if (words != null && !words.isEmpty()) {
            printWords(findChar, words);
        } else {
            System.out.println("No words found for letter " + findChar);
        }
    }

    private void printWords(char key, List<String> words) {
        System.out.print(key + ": [ ");
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i));
            if (i < words.size() - 1) {
                System.out.print(" , ");
            }
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Dic dictionary = new Dic();

        dictionary.addWord("doha");
        dictionary.addWord("doaa");
        dictionary.addWord("shymaa");
        dictionary.addWord("Marim");
        dictionary.addWord("habiba");
        dictionary.addWord("omar");
        dictionary.addWord("ali");
        dictionary.addWord("mohamed");
        dictionary.addWord("ahmed");
        dictionary.addWord("osama");

        System.out.println("\nAll:");
        dictionary.printAllWords();
        System.out.println("\nWords starting with 'd':");
        dictionary.printWordsOfLetter('d');
        
    }
}
