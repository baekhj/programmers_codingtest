package com.programmers.codingtest.java.level2;

public class 기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution(progresses, speeds);
        System.out.println("int[] progresses = {90, 30, 55} / int[] speeds = {1, 30, 5} ");
        for(int x = 0; x< result.length; x++){
            if(x==0) System.out.print("\t 결과 : [");
            System.out.print(result[x]);
            if(x==result.length-1) System.out.print("]");
            else System.out.print(", ");
        }
    }

    /*
    기능개발
    문제 설명
    프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

    또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
    각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
    각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

    제한 사항
    작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
    작업 진도는 100 미만의 자연수입니다.
    작업 속도는 100 이하의 자연수입니다.
    배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인
    작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
    입출력 예
    progresses	speeds	    return
    [93,30,55]	[1,30,5]	[2,1]

    입출력 예 설명
    첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
    두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
    하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
    세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

    따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
    */

    public static int[] solution(int[] progresses, int[] speeds) {  //요기 - 진행중
        int[] proComDay = new int[progresses.length];   //각 프로세스별 필요한 일수
        for(int x=0; x<progresses.length; x++) {    //각 프로세스별 걸리는 일수 담아주기
            proComDay[x] = ((100-progresses[x])/speeds[x])+((100-progresses[x])%speeds[x]>0?1:0);   //잔여시간이 더 필요하다면 +1
        }

        int dayCnt = 0; //배포일수
        int max = 0;  //일수 최대값
        int dCnt = 0;   //함께 배포되는 아이들 수
        for(int x=0; x<proComDay.length; x++){  //배포일수 계산
            if(max<proComDay[x]){
                max = proComDay[x];
                dayCnt++;
            }
        }

        int[] answer = new int[dayCnt]; //패포일 자별 배열
        max = 0; dayCnt = 0;
        for(int x=0; x<proComDay.length; x++){  //배포때 함께 하는 아이들 계산
            if(max<proComDay[x]){   //배포일이 앞날짜보다 큰일자가 온다면 배포일이됨
                if(max !=0) {
                    answer[dayCnt] = dCnt;
                    dayCnt++;
                    dCnt = 0;
                }
                dCnt++;
                max = proComDay[x];
            }else if(max !=0){
                dCnt++;
            }
            if(x==proComDay.length-1) answer[dayCnt] = dCnt;    //마지막배포일 추가
        }
        return answer;
    }


}
