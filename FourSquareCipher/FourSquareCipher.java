import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FourSquareCipher {

    private PSquareNonKeyed firstSquare;
    private PSquareNonKeyed fourthSquare;
    private PSquareKeyed secondSquare;
    private PSquareKeyed thirdSquare;



    public FourSquareCipher(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first keyword: ");
        String KeyWord1 = input.next();
        System.out.println("Enter the second keyword: ");
        String KeyWord2 = input.next();
        firstSquare = new PSquareNonKeyed();
        secondSquare = new PSquareKeyed(KeyWord1);
        thirdSquare = new PSquareKeyed(KeyWord2);
        fourthSquare = new PSquareNonKeyed();
    }

    public void run()  {
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running){
            System.out.println("Choose a command (1,2,3)");
            System.out.printf(
                    """
                            \n
                            +--------------------+-------------------+
                            | Four Square Cipher | Keywords          |
                            +--------------------+-------------------+
                            | 1. Encrypt         | 1.%s          |
                            | 2. Decrypt          | 2.%s        |
                            | 3. Exit            |                   |
                            +--------------------+-------------------+    
                            """,secondSquare.getKeyword() , thirdSquare.getKeyword());
            int userInput = input.nextInt();
            switch (userInput){
                case 1:
                    System.out.println("What message do you want to encrypt");
                    String emsg = input.next();
                    System.out.printf("\nThe encrypted message is: %s \n", this.encrypt(emsg));
                    break;
                case 2:
                    System.out.println("What message do you want to decrypt");
                    String dmsg = input.next();
                    System.out.printf("\nThe decrypted message is: %s \n", this.decrypt(dmsg));
                    break;
                case 3: running = false;
                default:
                    System.out.println("Incorrect input, self destructing"); running = false;
            }
        }
    }

    public String encrypt(String message){
        StringBuilder m = new StringBuilder(message.toUpperCase());
        if (m.length() % 2 != 0){
            m.append("X");
        }
        Queue<Character> charQueue = stringToQueue(m.toString());
        StringBuilder encryptedMessage = new StringBuilder();
        while(!charQueue.isEmpty()){
            char charToEncrypt = charQueue.poll();
            int[] coordinates1 = firstSquare.findElement(charToEncrypt);
            charToEncrypt = charQueue.poll();
            int[] coordinates2 = fourthSquare.findElement(charToEncrypt);
            char firstLetter = secondSquare.getMatrix()[coordinates1[0]][coordinates2[1]];
            char secondLetter = thirdSquare.getMatrix()[coordinates2[0]][coordinates1[1]];
            encryptedMessage.append(firstLetter).append(secondLetter);
        }
        return encryptedMessage.toString();
    }
    public String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();
        Queue<Character> charQueue = stringToQueue(encryptedMessage);

        while (!charQueue.isEmpty()) {
            char firstLetter = charQueue.poll();
            char secondLetter = charQueue.poll();

            int[] coordinates1 = secondSquare.findElement(firstLetter);
            int[] coordinates2 = thirdSquare.findElement(secondLetter);

            char decryptedChar1 = firstSquare.getMatrix()[coordinates1[0]][coordinates2[1]];
            char decryptedChar2 = fourthSquare.getMatrix()[coordinates2[0]][coordinates1[1]];

            decryptedMessage.append(decryptedChar1).append(decryptedChar2);

        }
        return decryptedMessage.toString();
    }
    private static Queue<Character> stringToQueue(String str) {
        Queue<Character> charQueue = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            charQueue.offer(c);
        }

        return charQueue;
    }


}
