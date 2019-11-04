package com.Object.Demo;

import com.red.OpenMode;

import java.util.ArrayList;

public class AvgPacket implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {

        ArrayList<Integer> redPacketList = new ArrayList<>();
        int avgMoney = totalMoney / totalCount;
        int modMoney = totalMoney % totalCount;

        for (int i = 0; i <totalCount - 1 ; i++) {
            redPacketList.add(avgMoney);
        }
        redPacketList.add(avgMoney + modMoney);
        return redPacketList;
    }
}
