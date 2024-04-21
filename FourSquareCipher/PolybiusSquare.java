import java.util.ArrayList;

public abstract class PolybiusSquare {
    private final int dimensionX = 5;
    private final int dimensionY = 5;
    private char[][] matrix;
    protected PolybiusSquare(){
        matrix = new char[dimensionX][dimensionY];

    }
    public int[] findElement(char Target){
        for (int i = 0; i < dimensionX ; i++){
            for (int j = 0; j < dimensionY; j++){
                if (this.matrix[i][j] == Target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public char[][] getMatrix() {
        return matrix;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public abstract void fillSquares();
}
