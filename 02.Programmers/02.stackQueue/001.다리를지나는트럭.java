import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int max = 0;

        Queue<Integer> q = new LinkedList();

        for(int i : truck_weights){

            while(true){
                if(q.isEmpty()){
                    q.offer(i);
                    max += i;
                    ++answer;
                    break;
                }else if(q.size() == bridge_length){
                    max -= q.poll();
                }else{
                    if(max+i <= weight){
                        q.offer(i);
                        max += i;
                        ++answer;
                        break;
                    }else{
                        q.offer(0);
                        ++answer;
                    }
                }
            }
        }

        return answer+bridge_length;
    }
}