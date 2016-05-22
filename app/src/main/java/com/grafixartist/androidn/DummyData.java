package com.grafixartist.androidn;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * AndroidN
 * Created by Suleiman19 on 5/14/16.
 * Copyright (c) 2016. Suleiman Ali Shakir. All rights reserved.
 */
public class DummyData {
    private Context context;
    private static final String[] photos = {
            "http://pixel.nymag.com/imgs/daily/vulture/2015/09/04/04-captain-america-age-of-ultron.w529.h529.jpg",
            "http://static2.hypable.com/wp-content/uploads/2015/07/iron-man-civil-war-salary-wide.jpg",
            "https://4.bp.blogspot.com/-zU7SMSekFPo/VTw00HKErsI/AAAAAAAAFXY/SjR2YQp-0Es/s1600/Hulk%2BAvengers%2BAge%2Bof%2BUltron%2B2015%2BWallpaper.jpg",
            "https://i.ytimg.com/vi/7p7rocHEecE/maxresdefault.jpg",
            "http://cdn.hitfix.com/photos/6033429/avengers-age-of-ultron-black-widow-poster.jpg",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRuLLJs9KLgI0AcB01VyFGyUTlIm5ypFyWKG1ecG1L-9H9eB0gs"
    };

    public DummyData(Context context) {
        this.context = context;
    }

    public List<Avenger> populateAvengers() {

        String[] nameArray = context.getResources().getStringArray(R.array.hero_names);

        List<Avenger> avengers = new ArrayList<>();

        for (int i = 0; i < nameArray.length; i++) {
            Avenger avenger = new Avenger(nameArray[i], photos[i]);
            avengers.add(avenger);
        }
        return avengers;
    }

}
