import java.io.*;
import java.util.*;

class Main{

    public static final boolean DEBUG = true;

    // Modular Arithmetic Utilities (Class: Mod)
    static class Mod {
        public static final long MOD = 1_000_000_007L;

        // Purpose: Modular Addition (a + b) % MOD | Input: long valA, long valB | Output: long
        public static long add(long a, long b) { long res = (a % MOD + b % MOD + MOD) % MOD; DBG.log("Mod.add (" + a + "+" + b + ")", res); return res; }
        // Purpose: Modular Subtraction (a - b) % MOD | Input: long valA, long valB | Output: long
        public static long sub(long a, long b) { long res = (a % MOD - b % MOD + MOD) % MOD; DBG.log("Mod.sub (" + a + "-" + b + ")", res); return res; }
        // Purpose: Modular Multiplication (a * b) % MOD | Input: long valA, long valB | Output: long
        public static long mul(long a, long b) { long res = ((a % MOD) * (b % MOD)) % MOD; DBG.log("Mod.mul (" + a + "*" + b + ")", res); return res; }
        // Purpose: Modular Inverse via Fermat's Little Theorem (a^(MOD-2) % MOD) | Input: long val | Output: long
        public static long inv(long a) { long res = Mth.pow(a, MOD - 2, MOD); DBG.log("Mod.inv (" + a + ")", res); return res; }
        // Purpose: Modular Division (a / b) % MOD via Fermat's Little Theorem | Input: long valA, long valB | Output: long
        public static long div(long a, long b) { long res = mul(a, inv(b)); DBG.log("Mod.div (" + a + "/" + b + ")", res); return res; }
    }
    // Fast Input Reader (Class: IO)
    static class IO {
        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st;

        // Purpose: Read next space-separated token | Input: none | Output: String
        public static String next() { while (st == null || !st.hasMoreTokens()) { try { String line = br.readLine(); if (line == null) return null; st = new StringTokenizer(line); } catch (IOException e) { e.printStackTrace(); } } String res = st.nextToken(); DBG.log("IO.next", res); return res; }
        // Purpose: Read next integer | Input: none | Output: int
        public static int i() { int val = Integer.parseInt(next()); DBG.log("IO.i", val); return val; }
        // Purpose: Read next long integer | Input: none | Output: long
        public static long l() { long val = Long.parseLong(next()); DBG.log("IO.l", val); return val; }
        // Purpose: Read full remaining line | Input: none | Output: String
        public static String line() { try { String res = br.readLine(); DBG.log("IO.line", res); return res; } catch (IOException e) { e.printStackTrace(); return null; } }
        // Purpose: Read 1D integer array | Input: int size | Output: int[]
        public static int[] iArr(int sz) { int[] a = new int[sz]; for (int k = 0; k < sz; k++) a[k] = i(); DBG.log("IO.iArr", a); return a; }
        // Purpose: Read 1D long array | Input: int size | Output: long[]
        public static long[] lArr(int sz) { long[] a = new long[sz]; for (int k = 0; k < sz; k++) a[k] = l(); DBG.log("IO.lArr", a); return a; }
        // Purpose: Read 1D string array | Input: int size | Output: String[]
        public static String[] sArr(int sz) { String[] a = new String[sz]; for (int k = 0; k < sz; k++) a[k] = next(); DBG.log("IO.sArr", a); return a; }
    }
// Bit Manipulation Utilities (Class: Bit)
static class Bit {

    // Purpose: Get the kth bit of a number | Input: long num, int k | Output: int (0 or 1)
    public static int get(long num, int k) {
        return (int) ((num >> k) & 1);
    }

    // Purpose: Set the kth bit to 1 | Input: long num, int k | Output: long
    public static long set(long num, int k) {
        return num | (1L << k);
    }

    // Purpose: Clear the kth bit to 0 | Input: long num, int k | Output: long
    public static long clear(long num, int k) {
        return num & ~(1L << k);
    }

    // Purpose: Toggle the kth bit | Input: long num, int k | Output: long
    public static long toggle(long num, int k) {
        return num ^ (1L << k);
    }
}
}
