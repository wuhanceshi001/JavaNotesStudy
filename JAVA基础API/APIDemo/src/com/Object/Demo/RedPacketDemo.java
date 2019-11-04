package com.Object.Demo;

import com.red.OpenMode;
import com.red.RedPacketFrame;

public class RedPacketDemo {
    public static void main(String[] args) {

        RedPacketFrame redPacketFrame = new MyRedPacketFrame("大财主");

        redPacketFrame.setOwnerName("我们家领导");

//        OpenMode mode = new AvgPacket();
        OpenMode mode = new RandomPacket();
        redPacketFrame.setOpenWay(mode);
    }
}
