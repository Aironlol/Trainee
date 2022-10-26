package com.collections;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        System.out.println("\nКонсольное приложение перемножения квадратных матриц.\n");

        try {
            int[][] matrix = readMatrix();
            int[][] transMatrix = transposeMatrix(matrix);
            int[][] multiMatrix = multiplyMatrices(matrix, transMatrix);

            outMatrix(matrix, "Исходная матрица:");
            outMatrix(transMatrix, "Транспонированная матрица:");
            outMatrix(multiMatrix, "Результат умножения:");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int[] readRows() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] arrString = scanner.nextLine().split(" ");
        int[] result = new int[arrString.length];

        for (int i = 0; i < arrString.length; i++) {
            try {
                result[i] = Integer.parseInt(arrString[i]);
            } catch (Exception invalidType) {
                throw new NumberFormatException("Элементами матрицы могут быть только целые числа.");
            }
        }
        return result;
    }

    public static int[][] readMatrix() throws Exception {
        System.out.println("Введите матрицу:");

        int[] row = readRows();
        int lengthFirstRow = row.length;
        int[][] fullMatrix = new int[lengthFirstRow][lengthFirstRow];
        fullMatrix[0] = row;

        for (int i = 1; i < lengthFirstRow; i++) {
            int [] nextRowMatrix = readRows();

            if (nextRowMatrix.length != lengthFirstRow) {
                throw new ArrayIndexOutOfBoundsException(
                        String.format("Введено %d элементов в строке при вводе матрицы {%d}x{%d}.",
                        nextRowMatrix.length, lengthFirstRow, lengthFirstRow));
            } else {
                fullMatrix[i] = nextRowMatrix;
            }
        }
        return fullMatrix;
    }

    /**
     * Транспонирование матрицы
     *
     * @param sourceMatrix Исходная матрица
     * @return Результирующая матрица
     */
    public static int[][] transposeMatrix(int[][] sourceMatrix) {
        int lengthMatrix = sourceMatrix.length;
        int[][] transpositionMatrix = new int[lengthMatrix][lengthMatrix];

        for (int i = 0; i < lengthMatrix; i++) {
            for (int j = 0; j < lengthMatrix; j++) {
                transpositionMatrix[j][i] = sourceMatrix[i][j];
            }
        }
        return transpositionMatrix;
    }

    /**
     * Перемножение двух матриц
     *
     * @param matrixOne Исходная матрица
     * @param matrixTwo  Транспонированная матрица
     * @return Результирующая матрица
     */
    public static int[][] multiplyMatrices(int[][] matrixOne, int[][] matrixTwo) {
        int lengthMatrix = matrixOne.length;
        int[][] multiplicationMatrix = new int[lengthMatrix][lengthMatrix];

        for (int i = 0; i < lengthMatrix; i++) {
            for (int j = 0; j < lengthMatrix; j++) {
                for (int k = 0; k < lengthMatrix; k++) {
                    multiplicationMatrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
        return multiplicationMatrix;
    }

    /**
     * Вывод матрицы на экран
     *
     * @param matrix     Матрица которую нужно вывести
     * @param matrixName Имя выводимой матрицы
     */
    public static void outMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName);
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];

            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
