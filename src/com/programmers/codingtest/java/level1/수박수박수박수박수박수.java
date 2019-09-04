package com.programmers.codingtest.java.level1;

public class 수박수박수박수박수박수 {

    public static void main(String[] args) {
        int n = 3;
        String result = solution(n);
        System.out.println(result);
    }

    /*
    수박수박수박수박수박수?
    문제 설명
    길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

    제한 조건
    n은 길이 10,000이하인 자연수입니다.
    입출력 예
    n	return
    3	수박수
    4	수박수박
    */
    public static String solution(int n){
        String resStr = "";
        for(int x=0; x < n/2; x++) resStr+= "수박";
        return resStr += n%2==0?"":"수";
    }
}
