package com.company;

public class Main {

    public static void main(String[] args)
    {
        Port port=new Port();
        Ship[] ships=new Ship[100];
        for (int i = 0;i<ships.length;i++){
            ships[i] = new Ship(i,port);
        }
        for (int i = 0;i<ships.length;i++)
            ships[i].start();
        for(int i=0;i<ships.length;i++)
            try {
                ships[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
