import java.util.*;

class Solution {
    boolean[] visited;
    int strlen;
    List<String> list;
    String[] answer;
    boolean end;

    public String[] solution(String[][] tickets) {
        //1. 변수 선언
        strlen = tickets.length;
        visited = new boolean[strlen];
        String str = "ICN";
        list = new ArrayList<String>();

        //2. string 배열을 sort
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(final String[] s1, final String[] s2) {
                final String time1 = s1[1];
                final String time2 = s2[1];
                return time1.compareTo(time2);
            }
        });

        list.add(str);
        //3.dfs호출
        dfs(str, tickets, 1);

        //for(String a : answer){System.out.print(a+" ");}

        return answer;
    }

    public void dfs(String str, String[][] tickets, int n){
        if(n == strlen+1){
            end = true;
            //4.listToArray
            answer = list.toArray(new String[list.size()]);

            return;
        }

        for(int i=0; i <strlen; i++){
            if(!visited[i] && tickets[i][0].equals(str)){
                visited[i] = true;
                String str2 = tickets[i][1];
                list.add(str2);
                dfs(str2,tickets,++n);
                if(end)  return;
                --n;
                visited[i] =false;
                list.remove(list.size() - 1);
            }
        }
    }

}