class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        //DFS - Depth First Search 깊이 우선 탐색
        // 1) Stack 2) recursive function 재귀함수
        //BFS - Breadth First Search 넓이 우선 탐색
        // 1) Queue

        boolean[] visited = new boolean[n]; //false

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, computers);
                answer++;
                //System.out.println("answer "+answer);
            }
        }

        return answer;
    }

    public void dfs(int n, boolean[] visited, int[][] computers){
        visited[n] = true;
        for(int j=0; j<computers.length; j++){
            //System.out.println("n : "+n+" j : "+j +" visited["+n+"] "+visited[n]);
            if(computers[n][j] == 1 && visited[j] != true){
                dfs(j, visited, computers);
            }
        }
    }
}