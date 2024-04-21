import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Queue;

public class PSquareKeyed extends PolybiusSquare{

    private String keyword;

    public PSquareKeyed(String KeyWord){
        super();
        this.keyword = createKeyWord(KeyWord.toUpperCase());
        fillSquares();
    }
    @Override
    public void fillSquares() {

        char[][] matrix = getMatrix();
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();

        for (char c : keyword.toCharArray()) {
            charSet.add(c);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J') {
                charSet.add(c);
            }
        }

        Character[] charArray = charSet.toArray(new Character[0]);

        int index = 0;
        for (int i = 0; i < getDimensionX(); i++) {
            for (int j = 0; j < getDimensionY(); j++) {
                matrix[i][j] = charArray[index++];
            }
        }
    }

    private String createKeyWord(String keyword){
        char[] chars = keyword.toCharArray();

        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : charSet) {
            sb.append(c);
        }

        return sb.toString();
    }
}
