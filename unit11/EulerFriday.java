package unit11;
import unit10.Recur;

public class EulerFriday {

    public static void main(String[] args) {

        // 1
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if(i%3 == 0 || i%5 == 0)
                sum += i;
        }
        System.out.println(sum);
    
        // 2
        sum = 2;
        int a = 1;
        int b = 2;
        while(b < 4000000) {
            int temp = b;
            b = a + b;
            a = temp;
            if(b%2 == 0)
                sum += b;
        }
        System.out.println(sum);

        // 3
        //not able to get recursive function working in a timely manor.
        long factorMe = 600851475143l;
        long factor = 2l;
        long largestFactor = 1l;
        while(factor <= factorMe) {
            while(factorMe%factor == 0) {
                largestFactor = factor;
                factorMe /= factor;
            }
            factor += 1;
        }
        System.out.println(largestFactor);

        // 4
        int largestPal = -1;
        for(int i = 100; i < 1000; i++) {
            for(int j = i; j < 1000; j++) {
                int product = i*j;
                String s = Integer.toString(product);
                if(Recur.pot(s)) {
                    if((int)product > largestPal) {
                        largestPal = product;
                    }
                }
            }
        }
        System.out.println(largestPal);

        // 5
        int low = 1;
        for(int i = 2; i <= 20; i++) {
            if(LCM(low, i) > low)
                low = LCM(low, i);
        }
        System.out.println(low);
        // for(int i = 2; i <= 20; i++) {
        //     if(low%i != 0) {
        //         System.out.println("no");
        //     }
        // }
        // System.out.println(low);

        //11
        int[][] grid = twentySquared();
        long largest = 0;
        for(int r = 0; r < grid.length-3; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                long product = 1;
                for(int i = 0; i < 4; i++) {
                    product *= grid[r+i][c];
                }
                if(product > largest) largest = product;
            }
        }
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length-3; c++) {
                long product = 1;
                for(int i = 0; i < 4; i++) {
                    product *= grid[r][c+i];
                }
                if(product > largest) largest = product;
            }
        }
        for(int r = 0; r < grid.length-3; r++) {
            for(int c = 0; c < grid[0].length-3; c++) {
                long product = 1;
                for(int i = 0; i < 4; i++) {
                    product *= grid[r+i][c+i];
                }
                if(product > largest) largest = product;
            }
        }
        for(int r = 0; r < grid.length-3; r++) {
            for(int c = 3; c < grid[0].length; c++) {
                long product = 1;
                for(int i = 0; i < 4; i++) {
                    product *= grid[r+i][c-i];
                }
                if(product > largest) largest = product;
            }
        }
        System.out.println(largest);
    }

    static int[][] twentySquared() {
        String raw = """
                08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
                49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
                81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
                52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
                22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
                24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
                32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
                67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
                24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
                21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
                78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
                16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
                86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
                19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
                04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
                88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
                04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
                20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
                20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
                01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48""";
        String[] rows = raw.split("\n");
        String[][] data = new String[rows.length][];
        int[][] nums = new int[rows.length][];
        for(int i = 0; i < rows.length; i++) {
            data[i] = rows[i].split(" ");
            nums[i] = new int[data.length];
            for(int c = 0; c < data[i].length; c++) {
                nums[i][c] = Integer.valueOf(data[i][c]);
            }
        }
        return nums;
    }

    static int[] prob8scaffold() {
        // woo java 13 supports multi-line strings!
        String lines = """
                73167176531330624919225119674426574742355349194934
                96983520312774506326239578318016984801869478851843
                85861560789112949495459501737958331952853208805511
                12540698747158523863050715693290963295227443043557
                66896648950445244523161731856403098711121722383113
                62229893423380308135336276614282806444486645238749
                30358907296290491560440772390713810515859307960866
                70172427121883998797908792274921901699720888093776
                65727333001053367881220235421809751254540594752243
                52584907711670556013604839586446706324415722155397
                53697817977846174064955149290862569321978468622482
                83972241375657056057490261407972968652414535100474
                82166370484403199890008895243450658541227588666881
                16427171479924442928230863465674813919123162824586
                17866458359124566529476545682848912883142607690042
                24219022671055626321111109370544217506941658960408
                07198403850962455444362981230987879927244284909188
                84580156166097919133875499200524063689912560717606
                05886116467109405077541002256983155200055935729725
                71636269561882670428252483600823257530420752963450""";
        // remove all whitespace
        lines = lines.replaceAll("\\s", "");
        // split into digits and parse into int array
        String[] digitArr = lines.trim().split("");
        int[] nums = new int[digitArr.length];
        for (int i = 0; i < digitArr.length; i++) {
            nums[i] = Integer.parseInt(digitArr[i]);
        }
        return nums;
    }

    public static int GCD(int a, int b) {
        if(a%b == 0){
            return b;
        }
        return GCD(b, a%b);
    }

    public static int LCM(int a, int b) {
        return (a*b) / GCD(a, b);
    }
}
