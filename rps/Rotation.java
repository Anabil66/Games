package rps;

public class Rotation {

    protected static double[][] matrixMultiplication(double[][] A, double[][] B) {

        int x = A.length;
        int y = A[0].length;
        int z = B[0].length;

        double[][] C = new double[x][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    protected static double[] rotation(double[] vector, double degree) {

        double sin = Math.sin(Math.toRadians(degree));
        double cos = Math.cos(Math.toRadians(degree));

        double A[][] = { { vector[0], 0 }, { 0, vector[1] } };

        double Transformation[][] = { { cos, -sin }, { sin, cos } };

        double[][] B = matrixMultiplication(Transformation, A);

        double result[] = { (B[0][0] + B[0][1]), (B[1][0] + B[1][1]) };

        return result;
    }

    // the dot product function is a general one, i.e. it can return the dot product
    // of vectors in n-dimensions not just 2-D

    protected static double dotProduct(double[] A, double[] B) {
        double result = 0;
        int min_dim;

        if (A.length > B.length) {
            min_dim = B.length;

        } else if (B.length > A.length) {
            min_dim = A.length;
        } else {
            min_dim = A.length;
        }

        for (int i = 0; i < min_dim; i++) {
            result += A[i] * B[i];
        }

        return result;
    }

    protected static double crossProduct(double[] A, double[] B) {
        double result = (A[0] * B[1]) - (A[1] * B[0]);
        return result;
    }

    protected static double findMag(double[] A) {
        int dimension = A.length;
        double mag_sqr = 0;
        for (int i = 0; i < dimension; i++) {
            mag_sqr += Math.pow(A[i], 2);
        }
        double result = Math.sqrt(mag_sqr);
        return result;
    }

    protected static double findAngle(double[] A, double[] B) {
        double d_prod = dotProduct(A, B);
        double c_prod = crossProduct(A, B);
        double factor = c_prod / Math.abs(c_prod);
        double cos_of_angle = d_prod / (findMag(A) * findMag(B));
        double result = Math.acos(cos_of_angle);
        result = Math.toDegrees(result) * factor;
        return result;

    }

    protected static int compare(double[] A, double[] B){
    dotProduct(A, B);
    if(findAngle(A, B) > 0){
        return 1;
    }
    else if (findAngle(A, B) < 0){
        return -1;
    }
    return 0;

    }

}
