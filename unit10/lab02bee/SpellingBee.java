import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    public SpellingBee (char[] letters, char mustUse) {
        this.letters = letters;
        this.mustUse = mustUse;
    }

    public boolean checkWord(String word) {
        if(word.length() < 4 || word.indexOf(mustUse) == -1) {
            return false;
        }
        char[] chars = word.toCharArray();
        for(char character : chars) {
            if(!characterInLetters(character)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a character is one in letters[].
     * @param character     The character to check.
     * @return              Returns true if character is in letters[], false if not.
     */
    public boolean characterInLetters(char character) {
        for(char letter : letters) {
            if(character == letter) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    private static void find(String findMe, String[] words) {
        int start = 0;
        int end = words.length-1;
        int guess = (start + end)/2;
        int check = words[guess].compareTo(findMe);
        System.out.println("word is " + words[guess]);
        System.out.println("check is " + check);
        
        while(check != 0) {
            if(check < 0) {
                start = guess+1;
            } else if(check > 0) {
                end = guess-1;
            }
            guess = (start + end)/2;
            check = words[guess].compareTo(findMe);
            System.out.println("word is " + words[guess]);
        }
        System.out.println("Location is " + guess);
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");

        SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');
        // SpellingBee bee = new SpellingBee("lvuoarf".toCharArray(), 'o');

        for(String word : words) {
            if(bee.checkWord(word))
                System.out.println(word);
        }
        
        Arrays.sort(words);
        find("potato", words);
    }
}
