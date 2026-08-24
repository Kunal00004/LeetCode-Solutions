class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(arr[a[0]] * arr[b[1]], arr[b[0]] * arr[a[1]])
        );
        
        for (int j = 1; j < arr.length; j++) {
            pq.offer(new int[]{0, j});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] current = pq.poll();
            int numIdx = current[0];
            int denIdx = current[1];
            
            if (numIdx + 1 < denIdx) {
                pq.offer(new int[]{numIdx + 1, denIdx});
            }
        }
        
        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}