package com.company;

import java.util.concurrent.Semaphore;

/**
 * Created by Михаил on 6.11.2014.
 */
public class Port {

    public Semaphore prichal;

    public Port()
    {
        this.prichal=new Semaphore(25);
    }

}
