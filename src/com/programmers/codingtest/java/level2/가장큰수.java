package com.programmers.codingtest.java.level2;

import java.util.*;

public class 가장큰수 {

    public static void main(String[] args) {
        int[] numbers = new int[]{6, 10, 2};
        String result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 6210) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{3, 30, 34, 5, 9};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 9534330) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{998, 9, 999};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 9999998) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{0, 0, 0, 0, 1};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 10000) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{0, 0, 0, 0, 0};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 0) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{12, 121};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 12121) ===>> 결과 : "+result);
        System.out.println();

        numbers = new int[]{21, 212};
        result = solution(numbers);
        System.out.print(" 배열 : ");
        for (int number : numbers) System.out.print(number);
        System.out.println(" (올바른답 : 21221) ===>> 결과 : "+result);
        System.out.println();

    }

    /*
    가장 큰 수 - 정렬
    문제 설명
    0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

    예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

    0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    numbers의 길이는 1 이상 100,000 이하입니다.
    numbers의 원소는 0 이상 1,000 이하입니다.
    정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
    입출력 예
    numbers	            return
    [6, 10, 2]	        6210
    [3, 30, 34, 5, 9]	9534330
    */

    public static String solution(int[] bynvers){
        String maxStr = "";
        String[] arr = new String[bynvers.length];
        for (int i = 0; i < arr.length; i++)  arr[i] = String.valueOf(bynvers[i]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두문자열을 합쳤을때 더 큰쪽이 우선하도록 정렬  ex) "3"+"30" vs "30"+"3"  "330" vs "303" >> 330 우선
                int res = (o2+o1).compareTo(o1+o2);
                //int res = (o2).compareTo(o1); //이렇게 하면 문자열 정렬이 "3" vs "30" 의 경우   "30"이 우선되어 "303" 이 됨. ==> 틀린값
                return res;
            }
        });

        for (String s : arr) maxStr+=s;
        if("0".equals(maxStr.substring(0, 1))) return "0";  //첫째자리가 0이면 전부 0입니다
        return maxStr;
    }

}
