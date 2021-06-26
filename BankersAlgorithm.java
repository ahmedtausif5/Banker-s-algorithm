package bankers.algorithm;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BankersAlgorithm {

    public static void main(String[] args) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter number of processes");
        int p = scanner.nextInt();
        System.out.println("please enter number of resources");
        int r = scanner.nextInt();
        int[][] arrAllocation = new int[p][r];
        int[][] arrMax = new int[p][r];
        int[][] arrNeed = new int[p][r];
        int[][] arrAvailable = new int[1][r];
        int[] safeSequence = new int[p];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        //Populating ALLOCATION matrix
        for (int i = 0; i < p; i++) {
            System.out.println("Please enter Allocation of Process " + i);
            for (int j = 0; j < r; j++) {
                arrAllocation[i][j] = scanner.nextInt();
            }
        }
        //Populating MAX matrix
        for (int i = 0; i < p; i++) {
            System.out.println("Please enter Max of Process " + i);
            for (int j = 0; j < r; j++) {
                arrMax[i][j] = scanner.nextInt();
            }
        }
        //Populating AVAILABLE matrix
        for (int i = 0; i < 1; i++) {
            System.out.println("Please enter the initial Availablility of resources");
            for (int j = 0; j < r; j++) {
                arrAvailable[i][j] = scanner.nextInt();
            }
        }
        //Calculating NEED matrix
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                arrNeed[i][j] = (arrMax[i][j]) - (arrAllocation[i][j]);
            }
        }
        printer pr = new printer(r);
        process[] processArray = new process[p];

        for (int j = 0; j < p; j++) {
            int[][] newAllocationArray = new int[1][r];
            int[][] newMaxArray = new int[1][r];
            int[][] newNeedArray = new int[1][r];

            for (int i = 0; i < r; i++) {
                newAllocationArray[0][i] = arrAllocation[j][i];
                newMaxArray[0][i] = arrMax[j][i];
                newNeedArray[0][i] = arrNeed[j][i];
            }

            process p1 = new process(j, newAllocationArray, newMaxArray, newNeedArray, false, r, 0);
            processArray[j] = p1;

        }

        /*
        pr.printArray(processArray[0].arrAllocation);
        pr.printArray(processArray[1].arrMax);
        pr.printArray(processArray[2].arrNeed);
        pr.printArray(processArray[3].arrMax);
        pr.printArray(processArray[4].arrNeed);
         */
        int x = 0;

        while (x != p) {

            for (int c = 0; c < p; c++) {

                //check need<=available
                for (int i = 0; i < r; i++) {

                    if (processArray[c].arrNeed[0][i] <= arrAvailable[0][i]) {

                        processArray[c].flag = 1;

                    } else {

                        processArray[c].flag = 0;

                        break;

                    }

                }

                if (processArray[c].status == false && processArray[c].flag == 1) {

                    //update available
                    for (int i = 0; i < r; i++) {
                        arrAvailable[0][i] = arrAvailable[0][i] + processArray[c].arrAllocation[0][i];
                    }
                    q.add(processArray[c].num);
                    processArray[c].status = true;
                    x++;

                }

            }

        }

        System.out.println("The Safe Sequence is:" + q);


        /*
        //-------------PRINTING MATRICES----------------
        System.out.println("Printing ALLOCATION matrix");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(arrAllocation[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Printing MAX matrix");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(arrMax[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Printing NEED matrix");
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(arrNeed[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Printing AVAILABLE matrix");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(arrAvailable[i][j] + " ");
            }
            System.out.println();
        }
         */
    }

}
