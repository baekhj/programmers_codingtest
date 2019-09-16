package com.programmers.codingtest.java.level2;

public class 쇠막대기 {

    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";
        int result = solution(arrangement);
        System.out.println("arrangement = \"()(((()())(())()))(())\" / result : "+result);

    }

    /*
    쇠막대기
    문제 설명
    여러 개의 쇠막대기를 레이저로 절단하려고 합니다.
    효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
    레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다.
    쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.

    - 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
    - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
    - 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
    - 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
    아래 그림은 위 조건을 만족하는 예를 보여줍니다.
    수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향입니다.

    [이미지 - 쇠막대기.png 참고]

    이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있습니다.

    (a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현합니다. 또한 모든 '()'는 반드시 레이저를 표현합니다.
    (b) 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현됩니다.
    위 예의 괄호 표현은 그림 위에 주어져 있습니다.
    쇠막대기는 레이저에 의해 몇 개의 조각으로 잘리는데,
    위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘리고,
    이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘립니다.

    쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때,
    잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.

    제한사항
    arrangement의 길이는 최대 100,000입니다.
    arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.
    입출력 예
    arrangement	                return
    ()(((()())(())()))(())	    17
    입출력 예 설명
    문제에 나온 예와 같습니다.
    */

    //이건 테스트1번 시간 초과 발생 / 나머지 테스트 2~20번 통과
    public static int solution3(String arrangement){
        int answer = 0;
        arrangement = arrangement.replaceAll("\\(\\)", "|");
        int isEnd = 1;  //괄호 인덱스 찾기용  +-를 해서 0이 되면 이게 끝점임
        int startIdx = 0; //막대기 시작점 위치
        int endIdx = 0; //막대기 끝점 위치
        int laserCnt = 0;   //범위내 레이져 갯수
        String[] arr = arrangement.split("");
        startIdx = 0;
        for(String ii : arr){
            startIdx++;
            if(!ii.equals("(")) continue;  //현재인덱스가 괄호 시작이 아니면 넘기기
            isEnd = 1;
            for(int y=startIdx; y<arr.length; y++){    //마지막 인덱스 찾기
                if(arr[y].equals("("))  isEnd++;
                else if(arr[y].equals(")")) isEnd--;
                if(isEnd==0){   //끝점찾아으면 끝
                    endIdx = y;
                    break;
                }
            }
            laserCnt= arrangement.substring(startIdx-1, endIdx+1).split("\\|").length-1;    //범위내 레이저 갯수
            answer +=laserCnt+1;
        }
        return answer;
    }

    //이것도 테스트1번 시간 초과 발생 / 나머지 테스트 2~20번 통과
    public static int solution2(String arrangement){
        int answer = 0;
        arrangement = arrangement.replaceAll("\\(\\)", "|");
        int stickCnt = arrangement.split("\\(").length-1;
        int laserCnt = 0;   //범위내 레이져 갯수
        int endIdx = 0; //막대기 끝점 위치
        int isEnd = 1;  //괄호 인덱스 찾기용  +-를 해서 0이 되면 이게 끝점임
        for(int x=1; x<=stickCnt; x++){  //스틱 수만큼 반복
            if(!(arrangement.charAt(0)+"").equals("("))   arrangement = arrangement.substring(arrangement.indexOf("("));
            isEnd = 1;
            for(int y=1; y<arrangement.length(); y++){    //마지막 인덱스 찾기
                if((arrangement.charAt(y)+"").equals("("))  isEnd++;
                else if((arrangement.charAt(y)+"").equals(")")) isEnd--;
                if(isEnd==0){   //끝점찾아으면 끝
                    endIdx = y;
                    break;
                }
            }
            laserCnt= arrangement.substring(0, endIdx+1).split("\\|").length-1;    //범위내 레이저 갯수
            arrangement = arrangement.substring(1); //뒷부분잘라내기
            answer +=laserCnt+1;
        }
        return answer;
    }

    //최종 성공결과
    public static int solution(String arrangement){
        int answer = 0;
        arrangement = arrangement.replaceAll("\\(\\)", "|");    //레이져
        int plusCnt = 0;
        String[] arr = arrangement.split("");
        for(int x = 0; x < arr.length; x++){
            if(arr[x].equals("|")) answer+=plusCnt; // 레이져만나면 plusCnt만큼 플러스
            else if(arr[x].equals("(")) plusCnt++;  //여는괄호는 plusCnt+1
            else if(arr[x].equals(")")) {   //닫는괄호일경우 plusCnt-1 / 결과값 +1
                plusCnt--;
                answer+=1;
            }
        }
        return answer;
    }
}
