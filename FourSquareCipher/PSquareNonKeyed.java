public class PSquareNonKeyed extends PolybiusSquare{
    public PSquareNonKeyed(){
        super();
        fillSquares();
    }
    @Override
    public void fillSquares() {
        char letter = 'A';
        for (int i = 0; i< this.getDimensionX(); i++){
            for (int j = 0; j <this.getDimensionY(); j++){
                this.getMatrix()[i][j] = letter;
                letter++;
                if (letter == 'J') {
                    letter++;
                }
            }
        }
    }
}
