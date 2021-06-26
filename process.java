package bankers.algorithm;

public class process {

    int num;
    int[][] arrAllocation;
    int[][] arrMax;
    int[][] arrNeed;
    int resources;
    boolean status;
    int flag;

    public process(int n, int[][] arrAllo, int[][] arrMx, int[][] arrNd, boolean b, int res, int flg) {
        num = n;
        arrAllocation = arrAllo;
        arrMax = arrMx;
        arrNeed = arrNd;
        status = b;
        resources = res;
        flag = flg;

    }

    /*
    int[] arAllo= new int[resources];
    int[] arMax= new int[resources];
    int[] arNeed= new int[resources];

   public void createNewAllocationArray(int [][] ar){  
       
           for (int j=0; j<resources; j++){
               arAllo[j]=arrAllocation[0][j];
           }        
   }
   createNewAllocationArray(arrAllocation);
   
     */
}
