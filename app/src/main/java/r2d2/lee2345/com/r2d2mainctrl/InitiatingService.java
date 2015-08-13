package r2d2.lee2345.com.r2d2mainctrl;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * This is the face of r2d2. this service displays R2D2's face
 * at System_alert_layer. Hopefully it can initiate the audio recorder..
 * Created by leesuckgeun on 15/08/13.
 */
public class InitiatingService extends IntentService {

    public InitiatingService() {
        super("r2d2.lee2345.com.r2d2mainctrl.InitiatingService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(getBaseContext(), "In Service", Toast.LENGTH_SHORT).show();
    }
}
