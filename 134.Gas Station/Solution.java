//134.Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int currentGas = 0;
        int globalGas = 0;
        int startIdx = 0;
        
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            globalGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startIdx = i + 1;
            }
        }
        
        if (globalGas < 0) {
            return -1;
        }
        return startIdx;
    }
}