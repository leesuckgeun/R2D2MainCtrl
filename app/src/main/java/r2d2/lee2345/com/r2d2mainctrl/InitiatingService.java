package r2d2.lee2345.com.r2d2mainctrl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * This is the face of r2d2. this service displays R2D2's face
 * at System_alert_layer. Hopefully it can initiate the audio recorder..
 * Created by leesuckgeun on 15/08/13.
 */
public class InitiatingService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);



        return START_NOT_STICKY;
    }
}
