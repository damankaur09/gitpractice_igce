import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Values{
        int p,q;
        public Values(int p,int q) {
            this.p = p;
            this.q = q;
            if(this.p%this.q==0){
                this.q = 1;
            }
        }
    }

    public static ArrayList<Values> mList = new ArrayList<Values>();
    
    public static Comparator<Integer> idComparator = new Comparator<Integer>(){

        @Override
        public int compare(Integer c1, Integer c2) {
            return  c1.intValue() < c2.intValue()?1:-1;
        }
    };

    static Queue<Integer> mPriorityQueue = new PriorityQueue<>(7, idComparator);
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int x =0; x<T; x++){
            int array[] = new int[3];
            int sum = 0;
            for(int i=0; i<3; i++){
                array[i] = in.nextInt();
            }
            int N = array[0];
            int p = array[1];
            int k = array[2];
            k--;

            int valArr[] = new int[N];
            for(int j=0; j<N; j++){
                valArr[j] = in.nextInt();
                sum+=valArr[j];
                if(j>=k){
                    int res = getSum(sum, p, N);
                    mPriorityQueue.add(res);
                }
            }
            mList.add(new Values(mPriorityQueue.peek(), N));
            mPriorityQueue.clear();

        }
        for(Values val: mList){
            System.out.print(val.p+" "+val.q);
            System.out.println();
        }
    }



    public static int getSum(int sum, int p, int n){
        int res = 0;

        res = sum%p;

        
        return res;
    }
}
