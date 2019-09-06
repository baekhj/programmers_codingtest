package com.programmers.codingtest.java.level2;

public class _124나라의숫자 {

    public static void main(String[] args) {
        int n = 1;
        String result = solution(n);
        System.out.println("n = 1 / result : "+result);
        n = 2;
        result = solution(n);
        System.out.println("n = 2 / result : "+result);
        n = 3;
        result = solution(n);
        System.out.println("n = 3 / result : "+result);
        n = 4;
        result = solution(n);
        System.out.println("n = 4 / result : "+result);
        n = 5;
        result = solution(n);
        System.out.println("n = 5 / result : "+result);
        n = 6;
        result = solution(n);
        System.out.println("n = 6 / result : "+result);
        n = 7;
        result = solution(n);
        System.out.println("n = 7 / result : "+result);
        n = 8;
        result = solution(n);
        System.out.println("n = 8 / result : "+result);
        n = 9;
        result = solution(n);
        System.out.println("n = 9 / result : "+result);
        n = 10;
        result = solution(n);
        System.out.println("n = 10 / result : "+result);
        n = 11;
        result = solution(n);
        System.out.println("n = 11 / result : "+result);
        n = 12;
        result = solution(n);
        System.out.println("n = 12 / result : "+result);
        n = 13;
        result = solution(n);
        System.out.println("n = 13 / result : "+result);
        n = 14;
        result = solution(n);
        System.out.println("n = 14 / result : "+result);
        n = 15;
        result = solution(n);
        System.out.println("n = 15 / result : "+result);
        n = 16;
        result = solution(n);
        System.out.println("n = 16 / result : "+result);
        n = 17;
        result = solution(n);
        System.out.println("n = 17 / result : "+result);
        n = 18;
        result = solution(n);
        System.out.println("n = 18 / result : "+result);
        n = 19;
        result = solution(n);
        System.out.println("n = 19 / result : "+result);
        n = 20;
        result = solution(n);
        System.out.println("n = 20 / result : "+result);
        n = 21;
        result = solution(n);
        System.out.println("n = 21 / result : "+result);
        n = 22;
        result = solution(n);
        System.out.println("n = 22 / result : "+result);
        n = 23;
        result = solution(n);
        System.out.println("n = 23 / result : "+result);
        n = 24;
        result = solution(n);
        System.out.println("n = 24 / result : "+result);
        n = 25;
        result = solution(n);
        System.out.println("n = 25 / result : "+result);
        n = 26;
        result = solution(n);
        System.out.println("n = 26 / result : "+result);
        n = 27;
        result = solution(n);
        System.out.println("n = 27 / result : "+result);
        n = 28;
        result = solution(n);
        System.out.println("n = 28 / result : "+result);
        n = 29;
        result = solution(n);
        System.out.println("n = 29 / result : "+result);
        n = 500000000;
        result = solution(n);
        System.out.println("n = 500000000 / result : "+result);
    }
    /*
    124 나라의 숫자
    문제 설명
    124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

    124 나라에는 자연수만 존재합니다.
    124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
    예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

    10진법	124 나라
    1	    1
    2	    2
    3       4
    4	    11
    5	    12
    6       14
    7       21
    8       22
    9       24
    10      41
    11      42
    12      44
    13      111
    14      112
    15      114
    16      121
    자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

    제한사항
    n은 500,000,000이하의 자연수 입니다.
    입출력 예
    n	    result
    1	    1
    2	    2
    3	    4
    4	    11
    */

    public static String solution(int n){
        String answer = "";
        answer = getCurData(n);
        return answer;
    }

    private static String getCurData(int n){  //현재 자리수의 값 계산 하기
        String r = "";
        if(n/3>=3){
            if(n%3==0){
                r = "4";
                r = getCurData((n/3)-1)+r;
            }
            else{
                r = n%3+"";
                r = getCurData(n/3)+r;
            }
        }else{
            if(n%3==0)  r = ((n/3)-1)+"4";
            else r = n/3+""+n%3;
        }
        r = Long.parseLong(r)+"";
        return r;
    }

}
