public class Main {
    public static void main(String[] args){
        FourSquareCipher test = new FourSquareCipher("SECRET" , "KEYWORD");
        System.out.println(test.encrypt("HELLOWORLD"));
        System.out.println(test.decrypt(test.encrypt("HELLOWORLD")));
    }
}