package com.systelab.kata;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        
        int northsouth = 0, eastwest = 0;

        for (String dir : arr) {
            switch (dir) {
                case "NORTH" :
                    northsouth++;
                 break;
                case "EAST":
                    eastwest++;
                 break;
                case "SOUTH":
                    northsouth--;
                 break;
                case "WEST" :
                    eastwest--;
                 break;
            }
        }
        int size = Math.abs(northsouth) + Math.abs(eastwest);

        String[] result = new String[size];

        if(result.length > 0){
            if (northsouth > 0) {
                Arrays.fill(result, 0, northsouth, "NORTH");
            } else {
                Arrays.fill(result, 0, -northsouth, "SOUTH");
            }
            if (eastwest > 0) {
                Arrays.fill(result, size-eastwest, size, "EAST");
            } else {
                Arrays.fill(result,  size+eastwest, size, "WEST");
            }
        }

        return result;
    }
}