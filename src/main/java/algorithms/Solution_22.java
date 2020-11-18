package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 1.初始化加油站
        List<GasStation> gasStationList = new ArrayList<GasStation>();
        for (int i = 0; i < gas.length; i++) {
            GasStation gasStation = null;
            if (i == gas.length - 1) {
                gasStation = new GasStation(gas[i], i, 0, cost[i]);
            } else {
                gasStation = new GasStation(gas[i], i, i + 1, cost[i]);
            }
            gasStationList.add(gasStation);
        }
        // 2.初始化汽车，让它前进。
        for (int i = 0; i < gasStationList.size(); i++) {
            GasStation gasStation = gasStationList.get(i);
            Car car = new Car(gasStation);
            int nextIndex = car.nextIndex();
            GasStation nextGasStation = gasStationList.get(nextIndex);
            while (car.runNextIndex(nextGasStation)) {
                if (nextIndex == car.startIndex) {
                    return i;
                }
                nextIndex = car.nextIndex();
                nextGasStation = gasStationList.get(nextIndex);
            }
        }

        return -1;
    }
}

class Car {
    // 起始加油站
    int startIndex;
    // 当前在哪个加油站
    GasStation curGasStation;
    // 当前油量
    int curGas;

    public Car() {
    }

    public Car(GasStation gasStation) {
        this.curGasStation = gasStation;
        this.curGas = gasStation.gasCount;
        this.startIndex = gasStation.gasIndex;
    }

    public int nextIndex() {
        return curGasStation.nextGasIndex;
    }

    public boolean runNextIndex(GasStation gasStation) {
        if (curGas >= curGasStation.nextGasNeed) {
            // 当前油量
            curGas = curGas - curGasStation.nextGasNeed + gasStation.gasCount;
            // 当前在哪个加油站
            curGasStation = gasStation;
            return true;
        }
        return false;
    }

}

class GasStation {
    // 油量
    int gasCount;
    // 加油站编号
    int gasIndex;
    // 下一个加油站编号
    int nextGasIndex;
    // 到下一个加油站所需油量
    int nextGasNeed;

    public GasStation(int gasCount, int gasIndex, int nextGasIndex, int nextGasNeed) {
        this.gasCount = gasCount;
        this.gasIndex = gasIndex;
        this.nextGasIndex = nextGasIndex;
        this.nextGasNeed = nextGasNeed;
    }
}