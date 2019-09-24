package com.programmers.codingtest.java.level2;

import java.util.*;

//걍 커밋안할 문제 풀기용 파일

public class 숫자야구 {

    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1},{356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        //int[][] baseball = {{123, 1, 1},{356, 1, 0}, {327, 2, 0}, {489, 0, 1}, {328, 2, 0}};
        //int[][] baseball = {{123, 0, 0},{456, 0, 0}};
        int result = solution(baseball);
        System.out.println(result);

    }
    /*
       숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

    각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

    * 숫자는 맞지만, 위치가 틀렸을 때는 볼
    * 숫자와 위치가 모두 맞을 때는 스트라이크
    * 숫자와 위치가 모두 틀렸을 때는 아웃
    예를 들어, 아래의 경우가 있으면

    A : 123
    B : 1스트라이크 1볼.
    A : 356
    B : 1스트라이크 0볼.
    A : 327
    B : 2스트라이크 0볼.
    A : 489
    B : 0스트라이크 1볼.
    이때 가능한 답은 324와 328 두 가지입니다.

    질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

    제한사항
    질문의 수는 1 이상 100 이하의 자연수입니다.
    baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
    입출력 예
    baseball	return
    [[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2

    */
    public static int solution(int[][] baseball) {
        int ableCnt = 0;
        List<int[]> ableNoList = new ArrayList<int[]>();    //나올수 있는 숫자
        for(int x=1; x<=9; x++){
            for(int y=1; y<=9; y++){
                if(x==y) continue;
                for(int z=1; z<=9; z++){
                    if(z==x || z==y) continue;
                    ableNoList.add(new int[]{x, y, z});
                }
            }
        }

        boolean isAble;
        int ballCnt;
        int strikeCnt;
        int[] no;
        int[] compareNo = {0, 0, 0};    //상대가 정한 숫자
        int[] ask={0, 0, 0};    //숫자, 스트라이크,볼
        for (int i = 0; i < ableNoList.size(); i++) {   //가능한 숫자중 맞지 않는 아이들 삭제
            isAble = true;
            no = ableNoList.get(i); //현재 체크할 숫자
            for (int j = 0; j < baseball.length; j++) { // 정한숫자 및 결과로 체크
                ballCnt = 0; strikeCnt = 0;
                ask[0] = baseball[j][0];    //숫자
                ask[1] = baseball[j][1];    //스트라이크
                ask[2] = baseball[j][2];    //볼
                compareNo[0] = ask[0]/100;
                compareNo[1] = (ask[0]-(compareNo[0]*100))/10;
                compareNo[2] = (ask[0]-(compareNo[0]*100)-(compareNo[1]*10));

                //no(가능한숫자) 가  ask(숫자, 스트라이크, 볼) 와 가능한 숫자에포함되지는 체크
                for (int k=0; k<3; k++) if(no[k] == compareNo[k]) strikeCnt++;  //스트라이크 체크
                for (int l=0; l<3; l++){    //볼 체크
                    for (int m=0; m<3; m++){
                        if(l!=m && no[l] == compareNo[m]) ballCnt++;
                    }
                }
                if(strikeCnt != ask[1] || ballCnt != ask[2]) isAble = false;
                if(!isAble) break;  //불가능한 숫자라면 스탑
            }
            if(!isAble) {   //불가능한 숫자라면 제거
                ableNoList.remove(i);
                i--;
            }
        }
        ableCnt = ableNoList.size();
        return ableCnt;
    }
}
