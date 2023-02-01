package edu.eci.arsw.math;

public class Thread extends java.lang.Thread {
    private final int A;
    private final int B;
    private String finalr;
<<<<<<< HEAD
    public Thread(String nombre, int entrada, int salida){
        this.A = entrada;
        this.B = salida;
=======
    public Thread(String name, int in, int out){
        this.A = in;
        this.B = out;
>>>>>>> 9b6133a0b6f9647c5d84de902c9d2d3fbaee878b
        this.finalr = "";
    }
    @Override
    public void run() {
        byte[] digits;
        digits = PiDigits.getDigits(A, B);
        finalr = Parallel.bytesToHex(digits);
    }
    public String getValue() {
        return finalr;
    }
}
