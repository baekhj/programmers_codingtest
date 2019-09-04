package com.programmers.codingtest.java.level1;

import java.util.*;

public class 직사각형별찍기 {

    /*
    직사각형 별찍기
    문제 설명
    이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
    별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

    제한 조건
    n과 m은 각각 1000 이하인 자연수입니다.
    예시
    입력

    5 3
    출력

    *****
    *****
    *****
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String out = "";
        for(int y=0; y<a; y++) out+="*";
        for(int x=0; x<b; x++) System.out.println(out);
    }
}
