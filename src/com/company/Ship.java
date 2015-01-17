package com.company;

import java.util.Random;

/**
 * Created by Михаил on 6.11.2014.
 */
public class Ship extends Thread{

    private int ShipNumber;
    private int Gruz;
    private Port port;
    private int mod;

    public Ship(int ShipNum,  Port port)
    {
        this.ShipNumber=ShipNum;
        Random rnd = new Random();
        this.Gruz=rnd.nextInt(25)+10;
        this.port=port;
        this.mod=rnd.nextInt(2);
    }

    @Override
    public void run()
    {
        Random rnd=new Random();
        boolean flag=false;
        super.run();
        System.out.println("Корабль "+this.ShipNumber+" прибыл в порт.");
        try
        {
            while (!flag)
            {
                if (!port.prichal.tryAcquire())
                {
                    sleep(1000);
                }
                else
                    flag=true;
            }
            System.out.println("Корабль "+ShipNumber+" пришвартовался.");
            switch (mod)
            {
                case 0:
                    for(int i=0;i<Gruz;i++)
                        sleep(250);
                    System.out.println("Корабль "+ShipNumber+" выгрузил "+Gruz+" контейнеров.");
                    break;
                case 1:
                    Gruz=rnd.nextInt(25)+10;
                    for(int i=0;i<Gruz;i++)
                        sleep(250);
                    System.out.println("Корабль "+ShipNumber+" поднял на борт "+Gruz+" контейнеров.");
                    break;
                case 2:
                    for(int i=0;i<Gruz;i++)
                        sleep(250);
                    System.out.println("Корабль "+ShipNumber+" выгрузил "+Gruz+" контейнеров.");
                    Gruz=rnd.nextInt(25)+10;
                    for(int i=0;i<Gruz;i++)
                        sleep(250);
                    System.out.println("Корабль "+ShipNumber+" поднял на борт "+Gruz+" контейнеров.");
                    break;
            }
            System.out.println("Корабль "+ShipNumber+" вышел в море.");
            port.prichal.release();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
