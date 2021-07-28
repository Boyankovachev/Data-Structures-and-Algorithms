import java.io.*;

import java.util.*;



class Result {

    public static int formingMagicSquare(List<List<Integer>> originalMatrix) {

        int maxCost = 81;

        int c1; // 0 0
        int c2; // 0 1
        int c3; // 0 2
        int c4; // 1 0
        int c5; // 1 1
        int c6; // 1 2
        int c7; // 2 0
        int c8; // 2 1
        int c9; // 2 2

        for(c1=1; c1<=9; c1++){
            for(c2=1; c2<=9; c2++){
                for(c3=1; c3<=9; c3++){
                    for(c4=1; c4<=9; c4++){
                        for(c5=1; c5<=9; c5++){
                            for(c6=1; c6<=9; c6++){
                                for(c7=1; c7<=9; c7++){
                                    for(c8=1; c8<=9; c8++){
                                        for(c9=1; c9<=9; c9++){
                                            List<List<Integer>> newMatrix = Arrays.asList(Arrays.asList(c1,c2,c3), Arrays.asList(c4,c5,c6), Arrays.asList(c7,c8,c9));
                                            if(checkIfMagic(newMatrix)){
                                                int cost = calculateCost(originalMatrix, newMatrix);
                                                if(cost < maxCost){
                                                    maxCost = cost;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return maxCost;
    }

    private static boolean checkIfMagic(List<List<Integer>> s){
        return s.get(0).get(0) + s.get(0).get(1) + s.get(0).get(2) == 15
                && s.get(1).get(0) + s.get(1).get(1) + s.get(1).get(2) == 15
                && s.get(2).get(0) + s.get(2).get(1) + s.get(2).get(2) == 15
                && s.get(0).get(0) + s.get(1).get(0) + s.get(2).get(0) == 15
                && s.get(0).get(1) + s.get(1).get(1) + s.get(2).get(1) == 15
                && s.get(0).get(2) + s.get(1).get(2) + s.get(2).get(2) == 15
                && s.get(0).get(0) + s.get(1).get(1) + s.get(2).get(2) == 15
                && s.get(0).get(2) + s.get(1).get(1) + s.get(2).get(0) == 15;
    }

    private static int calculateCost(List<List<Integer>> original, List<List<Integer>> magic){
        int i,j;
        int cost = 0;
        int temp;
        for(i=0; i<3; i++){
            for(j=0; j<3; j++){
                temp = original.get(i).get(j) - magic.get(i).get(j);
                if(temp < 0){
                    temp = -temp;
                }
                cost = cost + temp;
            }
        }
        return cost;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> matrix = Arrays.asList(Arrays.asList(4,9,2), Arrays.asList(3,5,7), Arrays.asList(8,1,5));
        System.out.println(Result.formingMagicSquare(matrix));

    }

}
