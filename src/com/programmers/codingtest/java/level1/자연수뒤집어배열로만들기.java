package com.programmers.codingtest.java.level1;

public class 자연수뒤집어배열로만들기 {

    public static void main(String[] args) {
        long n = 12345;
        int[] result = solution(n);
        for(int a: result) System.out.println(a);
    }

    /*
    자연수 뒤집어 배열로 만들기
    문제 설명
    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

    제한 조건
    n은 10,000,000,000이하인 자연수입니다.
    입출력 예
    n	    return
    12345	[5,4,3,2,1]
    */
    public static int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];
        for(int x=str.length-1; x>-1; x-- ){
            answer[str.length-x-1] = Integer.parseInt(str[x]);
        }
        return answer;
    }


}
