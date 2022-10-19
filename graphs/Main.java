package graphs;

public class Main {
    public static void main(String[] args) {
        /*
         * Scanner scanner = new Scanner(System.in); System.out.print("Enter no. of vertices: ");
         * int n = scanner.nextInt(); scanner.nextLine(); int costMatrix[][] = new int[n][n]; for
         * (int i = 0; i < costMatrix.length; i++) { for (int j = 0; j < costMatrix[i].length; j++)
         * { System.out.print("Enter weight for(" + (i + 1) + ',' + (j + 1) + "): ");
         * costMatrix[i][j] = scanner.nextInt(); if(costMatrix[i][j] == 0) costMatrix[i][j] =
         * Integer.MAX_VALUE;
         * 
         * scanner.nextLine(); } } scanner.close();
         */

        int costMatrix[][] = {

                {Integer.MAX_VALUE, 4, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {4, Integer.MAX_VALUE, 2, 1, 2}, {1, 2, Integer.MAX_VALUE, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 3, Integer.MAX_VALUE, 3},
                {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 3, Integer.MAX_VALUE}};
        Prims prims = new Prims(Utils.costMatrixToGraph(costMatrix));
        prims.run();

        Kruskals kruskals = new Kruskals(Utils.costMatrixToGraph(costMatrix));
        kruskals.run();
    }
    
}
