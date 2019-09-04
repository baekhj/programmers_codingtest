package com.programmers.codingtest.java.level1;

public class 시저암호 {

    public static void main(String[] args) {
        String s = "aBz";
        int n = 4;
        String result = solution(s, n);
        System.out.println(result);
    }
    /*
    시저 암호
    문제 설명
    어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

    제한 조건
    공백은 아무리 밀어도 공백입니다.
    s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
    s의 길이는 8000이하입니다.
    n은 1 이상, 25이하인 자연수입니다.
    입출력 예
    s	    n	result
    AB	    1	BC
    z	    1	a
    a B z	4	e F d
    */

    public static String solution(String s, int n) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] sp = s.toCharArray();
        int num, idx = 0;
        String res = "";
        for(int x=0; x<sp.length; x++){
            sp[x] = s.charAt(x);
            num = sp[x];
            idx = abc.indexOf((sp[x]+"").toLowerCase())+n;
            if(idx>=26)idx-=26;
            if(num >=65 && num <= 90) sp[x] = (char) (abc.charAt(idx)-32); 	//대문자
            else if(num >=97 && num <= 122) sp[x] = abc.charAt(idx); 	//소문자
            res+=sp[x];
        }
        return res;
    }

}
