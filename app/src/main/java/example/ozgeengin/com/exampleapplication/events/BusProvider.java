package example.ozgeengin.com.exampleapplication.events;

import com.squareup.otto.Bus;

/**
 * Created by Özge Engin on 16.06.2018.
 *
 * Bus provider class for Event bus
 */

public final class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    private BusProvider(){}
}

