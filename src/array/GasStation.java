package array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int sum = 0; // 当前油量
        int total = 0; // 总油量
        int index = -1; // 油量剩余最小位置
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                index = i;
                sum = 0;
            }
        }

        return total < 0 ? -1 : index + 1;
    }

    // bad
    public int badCcanCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            res += gas[i];
            int cur = i;
            int next = (i + 1) % n;
            while (res >= 0 && next != i) {
                if (res < cost[cur]) {
                    res = -1;
                    break;
                }
                res = res - cost[cur] + gas[next];
                cur = next;
                next = (next + 1) % n;
            }
            if (res >= cost[cur])
                return i;
            res = 0;
        }
        return -1;
    }
}
