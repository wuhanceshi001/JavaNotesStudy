package com.Object.Demo;

import com.red.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class RandomPacket implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {

        ArrayList<Integer> redPacketList = new ArrayList<>();

        int leftMoney = totalMoney;
        int leftCount = totalCount;
        Random r = new Random();

        for (int i = 0; i < totalCount - 1; i++) {
            int temp = r.nextInt(leftMoney / leftCount * 2) + 1;
            leftMoney -= temp;
            redPacketList.add(temp);
            leftCount--;
        }
        redPacketList.add(leftMoney);
        return redPacketList;
    }
}
