package com.programmers.codingtest.java.level2;

import javafx.scene.layout.Priority;

import java.util.*;

public class 더맵게 {

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.print(" 음식 스코빌 지수 : ");
        for(int a:scoville) System.out.print(a+", ");
        int result = solution(scoville, K);
        System.out.print(" 기준 지수 : "+K+" (정답: 2) ===>> solution 결과(우선순위큐 이용) : "+result);
        System.out.println();

        scoville = new int[]{1, 2, 3, 9, 10, 12};
        System.out.print(" 음식 스코빌 지수 : ");
        for(int a:scoville) System.out.print(a+", ");
        result = solution1(scoville, K);
        System.out.print(" 기준 지수 : "+K+" (정답: 2) ===>> solution1 결과(최소힙정렬 만들어서) : "+result);
        System.out.println();

        scoville = new int[]{1, 2, 3, 9, 10, 12};
        System.out.print(" 음식 스코빌 지수 : ");
        for(int a:scoville) System.out.print(a+", ");
        result = solution2(scoville, K);
        System.out.print(" 기준 지수 : "+K+" (정답: 2) ===>> solution2(그냥막품) 결과 : "+result);
        System.out.println();

    }

    /*
    더 맵게 (힙(Heap))
    문제 설명
    매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
    모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
    Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

    섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
    모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    scoville의 길이는 1 이상 1,000,000 이하입니다.
    K는 0 이상 1,000,000,000 이하입니다.
    scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
    모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
    입출력     예
    scoville	            K	return
    [1, 2, 3, 9, 10, 12]	7	2
    입출력 예 설명
    스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
    가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

    스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
    새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
    가진 음식의 스코빌 지수 = [13, 9, 10, 12]

    모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
    */

    //Solution start  -- 실패함 / 인터넷좀 보니 Priority Queue를 이용해서 문제를 풀었음
    public static int solution(int[] scoville, int K){
        /*
        Priority Queue : 우선순위큐 - 일반큐와 다름 일반큐(=FirstInFirstOut) / 우선순위큐는 우선순위가 높은 데이터가 가장 먼저 나옴 - 기본값은 최소힙

        //최대힙으로 구현하려면 아래와 같이 Comparator를 이용하여 한다
        PriorityQueue pq = new PriorityQueue(new Comparator(){
          @Override
          public int compare(Integer o1, Integer o2) {
            return o2-o1;
          }
        });
        */

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int x:scoville) q.add(x);   //큐에 배열 담아주기
        int mixCnt = 0;
        int min1,min2;
        int newScoville = 0;
        while (q.peek() < K){
            if(q.size()<2) return -1;   //큐사이즈가 2보다 작으면 새로 만들수 없어서 -1 리턴
            min1 = q.poll();
            min2 = q.poll();
            newScoville = min1 + (min2*2);
            mixCnt++;
            q.add(newScoville);
        }


        return mixCnt;
    }
    //Solution End



    //Solution1 Start - 힙정렬을 직접 만들어서 사용해 봅시다   -->>> 직접만든 힙정렬(최소힙) 이용 하니까 시간 초과 발생   정확성 100% / 효율성 0%
    public static int solution1(int[] scoville, int K) {
        int mixCnt = 0;

        int heapSize = scoville.length;   //힙사이즈
        int parentNode = heapSize/2;    //정렬 기준 루트 = 배열크기/2

        for(int x = parentNode; x >=0; x--) scoville = minHeap(x, scoville, heapSize);  //최소힙으로 정렬

        int min1 = 0;
        int min2 = 0;

        int newScoville=0;
        while (scoville[0]<K){
            min1 = scoville[0];
            scoville[0] = scoville[heapSize-1];
            heapSize--;
            if(heapSize<1){
                mixCnt = -1;
                break;
            }
            scoville = minHeap(0, scoville, heapSize);
            min2 = scoville[0];

            newScoville = min1 + (min2*2);
            mixCnt++;
            scoville[0] = newScoville;
            for(int x = parentNode; x >=0; x--) scoville = minHeap(x, scoville, heapSize);  //최소힙으로 정렬
        }
        return mixCnt;

        /*
        //최대힙 정렬 후 큰수순으로 뽑기

                for(int x = parentNode; x >=0; x--) scoville = maxHeap(x, scoville, heapSize);  //최대힙으로 정렬
                System.out.println("최대힙 정렬후");
                for (int x: scoville) System.out.print(x+" ");
                System.out.println();

                //큰 순서로 뽑기
                System.out.println("큰 순서로 뽑기");
                int max = 0;
                while (heapSize > 0){
                    max = scoville[0];
                    scoville[0] = scoville[heapSize-1];   //말단노드를 루트로 올린다
                    heapSize--;
                    System.out.println("max : "+max+" "+" min : "+scoville[0]);
                    scoville = maxHeap(0, scoville, heapSize);  //루트에 대해 최대힙으로 정렬

                }
                System.out.println();
        */
        /*

        //최소힙 정렬 후 작은 수 순으로 뽑기
                for(int x = parentNode; x >=0; x--) scoville = minHeap(x, scoville, heapSize);  //최소힙으로 정렬
                System.out.println("최소힙 정렬후");
                for (int x: scoville) System.out.print(x+" ");
                System.out.println();

                //작은 순서로 뽑기
                System.out.println("작은 순서로 뽑기");
                int min = 0;
                while (heapSize > 0){
                    min = scoville[0];
                    scoville[0] = scoville[heapSize-1];   //말단노드를 루트로 올린다
                    heapSize--;
                    System.out.print(min+" ");
                    scoville = minHeap(0, scoville, heapSize);  //루트에 대해 최소힙으로 정렬
                }

        */
    }

    private static int[] minHeap(int parentNode, int[] arr, int heapSize){  //최소힙 정렬

        int leftNode = 0;   //왼쪽 노드 = index(기준노드)*2+1
        int rightNode = 0;  //오른쪽 노드 = index(기준노드)*2+2
        leftNode = parentNode*2+1;
        rightNode = parentNode*2+2;

        int minIdx = parentNode;

        //왼쪽노드 비교
        if(heapSize > leftNode){  //힙 크기보다 작아야 비교하죠
            if(arr[parentNode] > arr[leftNode]){
                minIdx = leftNode;
            }

        }else{  //완전이진트리는 데이터 공백이 없으므로 왼쪽값이 없으면 오른쪽 값 체크할 필요가 없음
            return arr;
        }
        //오른쪽 노드 비교
        if(heapSize > rightNode){  //현재 최대 사이즈인 아이와 비교
            if(arr[minIdx] > arr[rightNode]){
                minIdx = rightNode;
            }
        }

        if(parentNode!=minIdx){ //정렬 변경
            int min = arr[parentNode];   //임시 저장값
            min = arr[minIdx];
            arr[minIdx] = arr[parentNode];
            arr[parentNode] = min;
            arr = minHeap(minIdx, arr, heapSize);    //아빠노드가 최소값이 아니라면 다시한번더 정렬
        }
        return arr;
    }

    private static int[] maxHeap(int parentNode, int[] arr, int heapSize){  //최대힙 정렬
        int leftNode = 0;   //왼쪽 노드 = index(기준노드)*2+1
        int rightNode = 0;  //오른쪽 노드 = index(기준노드)*2+2
        leftNode = parentNode*2+1;
        rightNode = parentNode*2+2;

        int maxIdx = parentNode;

        //왼쪽노드 비교
        if(heapSize > leftNode){  //힙 크기보다 작아야 비교하죠
            if(arr[parentNode] < arr[leftNode]){
                maxIdx = leftNode;
            }
        }else{  //완전이진트리는 데이터 공백이 없으므로 왼쪽값이 없으면 오른쪽 값 체크할 필요가 없음
            return arr;
        }
        //오른쪽 노드 비교
        if(heapSize > rightNode){  //현재 최대 사이즈인 아이와 비교
            if(arr[maxIdx] < arr[rightNode]){
                maxIdx = rightNode;
            }
        }

        if(parentNode!=maxIdx){ //정렬 변경
            int max = arr[maxIdx];
            arr[maxIdx] = arr[parentNode];
            arr[parentNode] = max;
            arr = maxHeap(maxIdx, arr, heapSize);    //아빠노드가 최대값이 아니라면 다시한번더 정렬
        }
        return arr;
    }

    //Solution1 End




    //Solution2 Start 처음푼것 - 정확성 100% / 효율성 0% ㅋㅋㅋ 속도 처리해야함 - 힙을 이용안했으므로 다시 해보자
    public static int solution2(int[] scoville, int K) {
        int mixCnt = 0;
        boolean isOk = true;
        int secIdx = 0; //두번째 아이 순번
        int min1 = -1;    //제일 작은 수
        int min2 = -1;   //두번째 작은 수
        int newScoville = 0;
        while (true){
            for (int i : scoville) {    //전부다 코스빌 지수가 넘는지 체크
                if(i==-1 || i >= K) isOk = true;
                else{
                    isOk = false;
                    break;
                }
            }
            if(isOk) break;

            //첫번째 두번째 작은 수 찾기
            min1 = -1; min2 = -1;
            Arrays.sort(scoville);  //작은순 정렬
            for (int x=0; x<scoville.length; x++) {
                if(scoville[x]==-1) continue;   //사용된 값이라면 패스
                if(min1==-1) {
                    min1 = scoville[x];
                    scoville[x] = -1;
                }else if(min2==-1) {
                    min2 = scoville[x];
                    secIdx = x;
                    scoville[x] = -1;
                    break;
                }
            }
            if(min1==-1 || min2==-1) return -1; // 믹스할 수 없다면 -1 리턴

            //섞어 주기 - 섞어준 첫번째 값은 -1 처리 할것 And -1인 값은 섞지 않음
            //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            newScoville = min1 + (min2*2);
            scoville[secIdx] = newScoville;
            mixCnt++;
        }

        return mixCnt;
    }
    //Solution2 End

}
