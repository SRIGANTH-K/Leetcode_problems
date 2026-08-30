class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        
        // Calculate the total sum of all cards
        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }
        
        // If we take all the cards, return the total sum immediately
        if (windowSize == 0) {
            return totalSum;
        }
        
        // Calculate the sum of the first window of size (n - k)
        int currentWindowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentWindowSum += cardPoints[i];
        }
        
        int minWindowSum = currentWindowSum;
        
        // Slide the window across the array
        for (int i = windowSize; i < n; i++) {
            // Add the new element entering from the right, remove the element leaving from the left
            currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }
        
        // Maximum points is total sum minus the minimum leftover window sum
        return totalSum - minWindowSum;
    }
}
