package r2d2.lee2345.com.r2d2mainctrl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * this receiver listens to user presents, then starts initiatingService that displays
 * r2d2 face at System_Alert layer
 *
 * Created by leesuckgeun on 15/08/13.
 */
public class StarterReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Intent serviceIntent = new Intent(context, InitiatingService.class);
            context.startService(serviceIntent);
        }
    }
}
