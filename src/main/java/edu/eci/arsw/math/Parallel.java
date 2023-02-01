package edu.eci.arsw.math;

public class Parallel {
    private final int digitsNumber;
    private final int threadsNumber;
    private double width;
    private final int[] array;
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public Parallel(int digits, int N) {
        this.digitsNumber = digits;
        this.threadsNumber = N;
        this.array = new int[N];
        int div = digits / N;
        int mod = digits % N;
        int suma = div;
        for(int i = 0; i < N ; i++){
            if(i+1 == N){
                this.array[i]=suma+mod;
            }else{
                this.array[i]=suma;
            }
        }
    }

    public String calculate() throws InterruptedException{

        Thread threads[] = new Thread[threadsNumber];
        width = 1.0 / (double) digitsNumber;
        int[] intArray = new int[] {3,3,4};
        for (int i=0; i < threadsNumber; i++){
            long start =  i * digitsNumber/threadsNumber;
            long count =   digitsNumber/threadsNumber;
            threads[i] = new Thread(Integer.toString(i), (int)start, (int)this.array[i]);
            threads[i].start();
        }

        String res = "";
        for (int i = 0; i < threadsNumber; i++) {
            threads[i].join();
            res += threads[i].getValue();
        }

        System.out.println("\nFinal ans: "+res+"\n");
        return res;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            sb.append(hexChars[i+1]);
        }
        return sb.toString();
    }
    public static void main(String a[]) throws InterruptedException {
        System.out.println("Case with (1000): ");
        Parallel T0 = new Parallel(1000, 500);
        T0.calculate();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Execution time: " + cores);
    }
}





















