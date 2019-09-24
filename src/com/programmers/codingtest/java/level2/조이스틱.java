package com.programmers.codingtest.java.level2;

import java.util.Arrays;

public class 조이스틱 {

    public static void main(String[] args) {

        /*
        결과가 성공이 되긴 했는데 뭔가 찝찝하다...
        */
        String name = "JAZ";
        int res = solution(name);
        System.out.println(name+"의 결과는(11) : "+res);
        System.out.println();
        name = "JEROEN";
        res = solution(name);
        System.out.println(name+"의 결과는(56) : "+res);
        System.out.println();
        name = "JAN";
        res = solution(name);
        System.out.println(name+"의 결과는(23) : "+res);
        System.out.println();
        name = "AABAAAAAAABBB";
        res = solution(name);
        System.out.println(name+"의 결과는(12) : "+res);
        System.out.println();
        name = "ABAAAAAAABA";
        res = solution(name);
        System.out.println(name+"의 결과는(6) : "+res);
        System.out.println();
        name = "ZZZ";
        res = solution(name);
        System.out.println(name+"의 결과는(5) : "+res);
        System.out.println();
        name = "BBBBAAAAAB";
        res = solution(name);
        System.out.println(name+"의 결과는(12) : "+res);
        System.out.println();
    }

    /*
    조이스틱 - 탐욕법(Greedy)
    문제 설명
    조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
    ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

    조이스틱을 각 방향으로 움직이면 아래와 같습니다.

    ▲ - 다음 알파벳
    ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    ▶ - 커서를 오른쪽으로 이동
    예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

    - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
    - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
    - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
    따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
    만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

    제한 사항
    name은 알파벳 대문자로만 이루어져 있습니다.
    name의 길이는 1 이상 20 이하입니다.
    입출력 예
    name	return
    JEROEN	56
    JAN	    23
    출처
    ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
    */

    private static String alphabat = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //알파벳 순서

    public static int solution(String name){
        /*
        최초 문제 이해를 잘못했다  ... 입력된 순서로 이해함..  J -> J에서 가깝게 갈수 있는 A찾고 -> Z 찾고 이런식으로 이해함.. 입력된 순서로..
        그러나 이 문제는 JAZ 일때 기본값은 AAA이며 AAA 를 JAZ 로 바꾸는 문제였다! ex) 네자리 숫자면 최초 값이 AAAA
        */

        int move = 0;
        String[] nameArr = name.split("");
        String[] arr = new String[name.length()];
        int[] idxArr = new int[name.replaceAll("A","").length()];
        int idx = -1;
        for (int i = 0; i < arr.length; i++) arr[i] = "A";
        for(int x=0; x<nameArr.length; x++){
            if(!"A".equals(nameArr[x])){ //현재 문자가 A가 A로 바꾸는데 드는 클릭 횟수 구하기
                idx++;
                idxArr[idx] = x;
            }
        }

        //변경 되어야할 문자의 초소 이동거리 구하기
        String base = "";
        for(int i=0; i<name.length(); i++) base+="A";
        int moveIdx = 0;
        int curIdx = 0; //현재 커서 위치
        int min = 0;
        for(int x=0; x<idxArr.length; x++){
            if(nameArr[idxArr[x]].equals("A")) continue;
            min = 0;
            for(int y=0; y<idxArr.length; y++){
                if(curIdx==idxArr[y] || nameArr[idxArr[y]].equals("A")) continue;
                if(min==0 || min > move2(curIdx, idxArr[y], name.length())){
                    moveIdx = idxArr[y];
                    min = move2(curIdx, idxArr[y], name.length());
                    x=0;
                }
            }

            move += min;
            move += move("A", nameArr[curIdx]);
            nameArr[curIdx] = "A";
            curIdx = moveIdx;
        }

        //마지막 글자수 증가
        move += move("A", nameArr[moveIdx]);
        return move;
    }

    public static int move(String s, String e){ //다음알파벳(위로) / 이전알파벳(아래) 이용 했을때 클릭 횟수
        int case1 = alphabat.indexOf(s) - alphabat.indexOf(e);
        case1 = case1 < 0 ?26+case1:case1;
        int case2 = alphabat.indexOf(e) - alphabat.indexOf(s);
        case2 = case2 < 0 ?26+case2:case2;
        int res = case1<case2?case1:case2;
        return res;
    }

    public static int move2(int s, int e, int defaultLength){
        int case1 = s-e;
        case1 = case1 < 0 ?defaultLength+case1:case1;
        int case2 = e-s;
        case2 = case2 < 0 ?defaultLength+case2:case2;
        int res = case1<case2?case1:case2;
        return res;
    }

}
