//package com.designpatterns.pattern.objectpool;
//
//import javafx.geometry.Point2D;
//
//public class Clients {
//    public static final ObjectPool<BitMap> bitmapPool = new ObjectPool<>(() -> new BitMap("Logo.bmp"), 5);
//    public static void main(String[] args) {
//        BitMap bitMap = bitmapPool.get();
//        bitMap.setLocation(new Point2D(10, 0));
//        BitMap bitMap2 = bitmapPool.get();
//        bitMap2.setLocation(new Point2D(-10, 0));
//
//        bitMap.draw();
//        bitMap2.draw();
//
//        bitmapPool.release(bitMap);
//        bitmapPool.release(bitMap2);
//
//    }
//}
