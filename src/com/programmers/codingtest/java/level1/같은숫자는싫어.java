package com.programmers.codingtest.java.level1;

import java.util.*;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);
        for(int a:result) System.out.println(a);
    }

    /*
     같은 숫자는 싫어
    문제 설명
    배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

    arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
    arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
    배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

    제한사항
    배열 arr의 크기 : 1,000,000 이하의 자연수
    배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    입출력 예
    arr	            answer
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3] 	[4,3]
    입출력 예 설명
    입출력 예 #1,2
    문제의 예시와 같습니다.
    */

    public static int[] solution(int []arr) {
        int compVal = arr[0];
        for(int x=1; x < arr.length; x++) {
            if(compVal == arr[x]) arr[x] = -1;
            else compVal = arr[x];
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int x=0; x < arr.length; x++) if(arr[x] > -1) res.add(arr[x]);
        int[] answer = new int[res.size()];
        for(int x=0; x < res.size(); x++)  answer[x] = res.get(x);
        return answer;
    }

}
