package bankers.algorithm;

public class printer {

    int resources;

    public printer(int res) {
        resources = res;
    }

    public void printArray(int[][] array) {
        for (int j = 0; j < resources; j++) {
            System.out.print(array[0][j] + " ");
        }
        System.out.println();

    }

}
