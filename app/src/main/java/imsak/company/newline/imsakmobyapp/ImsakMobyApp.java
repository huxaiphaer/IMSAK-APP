package imsak.company.newline.imsakmobyapp;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by HUZY_KAMZ on 3/11/2017.
 */

public class ImsakMobyApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
