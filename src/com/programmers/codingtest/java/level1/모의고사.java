package com.programmers.codingtest.java.level1;

import java.util.*;

public class 모의고사 {

    public static void main(String[] args) {
        int[] i = {1,3,2,4,2};
        int[] r = {1, 2, 3};
        int[] result = solution(i);
        for(int a:result)  System.out.println(a);
    }

    /*
    모의고사
    문제 설명
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한 조건
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    입출력 예
    answers	return
    [1,2,3,4,5]	[1]
    [1,3,2,4,2]	[1,2,3]
    입출력 예 설명
    입출력 예 #1

    수포자 1은 모든 문제를 맞혔습니다.
    수포자 2는 모든 문제를 틀렸습니다.
    수포자 3은 모든 문제를 틀렸습니다.
    따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

    입출력 예 #2

    모든 사람이 2문제씩을 맞췄습니다.

     */
    public static int[] solution(int[] answers) {
        int[] user1={1,2,3,4,5};
        int[] user2={2,1,2,3,2,4,2,5};
        int[] user3={3,1,2,4,5};
        int[] userCnt = {0, 0, 0};
        for(int x=0; x<answers.length; x++){
            if(answers[x] == user1[x%5]) userCnt[0]++;
            if(answers[x] == user2[x%8]) userCnt[1]++;
            if(answers[x] == user3[(x/2)%5]) userCnt[2]++;
        }
        int maxCnt = 0;
        if(maxCnt < userCnt[0]) maxCnt = userCnt[0];
        if(maxCnt < userCnt[1]) maxCnt = userCnt[1];
        if(maxCnt < userCnt[2]) maxCnt = userCnt[2];
        List<Integer> list = new ArrayList<Integer>();
        for(int x=0; x<userCnt.length; x++){
            if(maxCnt==userCnt[x])list.add(x+1);
        }
        int[] answer = new int[list.size()];
        for(int a=0; a < list.size() ; a++) answer[a] = list.get(a);
        return answer;
    }
}
