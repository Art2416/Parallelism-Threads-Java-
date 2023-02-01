package edu.eci.arsw.math;

public class Thread extends java.lang.Thread {
    private final int A;
    private final int B;
    private String finalr;
    public Thread(String nombre, int entrada, int salida){
        this.A = entrada;
        this.B = salida;
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
