package ru.gb.jtwo.b_lesson.online;

public class StringToIntParser {

    public static String[] devideStr(String inStr, char divChar) {
        String[] tmp;
        String[] outStr = new String[10];
        outStr[0] = "";
        int indStr=0;
        int indMass=0;
        for (int i = 0; i < inStr.length(); i++) {
            if(inStr.charAt(i)==divChar){
                indMass++;
                if(indMass == outStr.length){
                    tmp = new String[outStr.length+10];
                    for (int j = 0; j < indMass; j++){
                        tmp[j] = outStr[j];
                        outStr = tmp;
                    }
                }
                outStr[indMass] = "";
                //System.out.println("Enter");
            } else {
                outStr[indMass] += inStr.charAt(i);
                //System.out.println(":"+inStr.charAt(i));
            }
        }
        tmp = new String[indMass+1];
        for (int j = 0; j < indMass+1; j++){
            tmp[j] = outStr[j];
        }
        return tmp;
    }

    public static String[][] StrToArr(String[] inStr)  throws BadFormat {
        String[][] outStr = new String[4][4];
        String[] tmp;
        int indX=0;
        int indY=0;
        if (inStr.length > 4) throw new BadFormat();
        for (int i = 0; i < inStr.length; i++) {
            tmp = devideStr(inStr[i],' ');
            if (tmp.length > 4) throw new BadFormat();
            for (int j = 0; j <tmp.length ; j++) {
                outStr[i][j] = tmp[j];
            }
        }
        return outStr;
    }

    public static float Calculate(String[][] inArr)  throws BadDigit {
        float fResult=0.0f;
        int tmp=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    tmp = Integer.parseInt(inArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new BadDigit();
                }
                fResult += tmp;
            }
        }
        return fResult / 2;
    }


    public static void main(String[] args) {
        String inStr = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[] outStr;
        String[][]  resultStr;
        try{
            outStr = devideStr(inStr, '\n');
//          for (int i = 0; i < outStr.length; i++) {            System.out.println(i+": " +outStr[i]);        }
            resultStr = StrToArr(outStr);
/*          for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(resultStr[i][j]+"\t");
                }
                System.out.println();
            }*/
            float R = Calculate(resultStr);
            System.out.println("Rezult = " + R);
        } catch (BadFormat | BadDigit e){
            System.out.println(e);
        }
    }

}
