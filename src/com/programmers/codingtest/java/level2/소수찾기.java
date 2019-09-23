package com.programmers.codingtest.java.level2;

import java.util.*;

public class 소수찾기 {


    public static void main(String[] args) {
        String str = "17";
        int result = solution(str);
        System.out.println("문자열 17 / 결과 :" + result +"개");
        str = "011";
        result = solution(str);
        System.out.println("문자열 011 / 결과 :" + result +"개");
        str = "0123459";
        result = solution(str);
        System.out.println("문자열 0123459 / 결과 :" + result +"개");
    }

    /*
    소수찾기 - 완전탐색
    문제 설명
    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

    제한사항
    numbers는 길이 1 이상 7 이하인 문자열입니다.
    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
    입출력 예
    numbers	return
    17	    3
    011	    2
    입출력 예 설명
    예제 #1
    [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

    예제 #2
    [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

    11과 011은 같은 숫자로 취급합니다.
    */

    public static int solution(String numbers){
        int res=0;
        Set<Integer> set = getAbleList(numbers);
        for(int a:set) {
            if(checkNumber(a)) {
                res++;
            }
        }
        return res;
    }

    private static Set<Integer> getAbleList(String a){  // 나올수 있는 숫자들 고르기
        String[] arr = a.split("");
        Arrays.sort(arr);
        a="";
        for (int i = arr.length - 1; i >= 0; i--) a+=arr[i];

        Set<Integer> set = new HashSet<Integer>();
        boolean isOk = true;
        String[] tempArr;
        String aTemp;
        int idx = 0;
        for(int x=2; x<= Integer.parseInt(a); x++){
            isOk = true; aTemp = a;
            tempArr = String.valueOf(x).split("");
            for(int y=0; y<tempArr.length; y++){
                idx = aTemp.indexOf(tempArr[y]);
                if(idx < 0) {
                    isOk = false;
                    break;
                }
                aTemp = aTemp.replaceFirst(tempArr[y], "");
            }
            if(isOk) set.add(x);
        }
        return set;
    }

    private static boolean checkNumber(int checkNum){  //소수판별
        boolean res = checkNum<=1?false:true;
        for(int x = 2; res & x < checkNum; x++) if(checkNum%x==0)  res = false;
        return res;
    }

}



