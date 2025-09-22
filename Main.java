import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        float[] x = makingX(18, -6.0f, 12.0f);
        short[] n = makingN(10);//КАК ПРИВОДИТЬ ТИПЫ?????
        double[][] k = makingK(10, 18, x, n);

        printArray(k);


    }

    public static double[][] makingK(int row, int column, float[] x, short[] n){
        double[][] k = new double[row][column];

        for(int i=0; i<= row-1; i++){
            for(int j=0; j<= column-1; j++){

                if (n[i]==6){
                    k[i][j] = pow(cos(exp(x[j])), 1.0/3.0);
                } else if (inArray(n[i])){
                    k[i][j] = pow(pow(cos(x[j]), 2*atan((x[j]+3)/18)), (atan(exp(-abs(x[j]))))/2);
                } else{
                    k[i][j] = asin(cos(x[j]));
                }

            }
        }
        return k;
    }

    //проверка принадлежит ли элемент к множеству
    public static boolean inArray(double x){
        double[] condArray = {2, 4, 8, 10, 20};
        for (int i=0; i<=condArray.length-1; i++){
            if (x == condArray[i]){return true;}
        }
        return false;
    }

    //массив из четных элементов от 2 до 20
    public static short[] makingN(int length){
        short[] n = new short[length];
        short current = 2;
        for(int i = 0; i <= n.length-1; i++){
            n[i] = current;
            current+=2;
        }
        return n;
    }

    //массив из 18 рандомных элементов
    public static float[] makingX(int length, float min, float max){
        float[] x = new float[length];

        for(int i = 0; i <= x.length-1; i++){
            x[i] = (float)(Math.random()*(max-min) + min);
        }
        return x;
    }

    public static void printArray(double[][] k){
        for (int i = 0; i < k.length; i++){
            for (int j = 0; j < k[i].length; j++){
                System.out.printf("%10.3f", k[i][j]);
            }
            System.out.println();
        }
    }
}