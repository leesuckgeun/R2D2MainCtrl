package r2d2.lee2345.com.r2d2mainctrl;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * This is the face of r2d2. this service displays R2D2's face
 * at System_alert_layer. Hopefully it can initiate the audio recorder..
 * Created by leesuckgeun on 15/08/13.
 */
public class InitiatingService extends Service {

    private boolean isViewAttached;
    private ImageView androidImageView;
    private WindowManager windowManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isViewAttached) {
            windowManager.addView(androidImageView, androidImageView.getLayoutParams());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        WindowManager.LayoutParams params = initViewToService();
        initFloatingMotion(params);
    }


    private WindowManager.LayoutParams initViewToService() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.LEFT;


        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        androidImageView = new ImageView(this);
        androidImageView.setImageResource(R.drawable.android);
        windowManager.addView(androidImageView, params);

        isViewAttached = true;

        return params;
    }

    private void initFloatingMotion(final WindowManager.LayoutParams params) {
        androidImageView.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(androidImageView, params);
                        return true;
                }
                return false;
            }
        });
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        removeView();
    }

    private void removeView() {
        if (androidImageView != null) {
            windowManager.removeView(androidImageView);
            isViewAttached = false;
        }
    }
}
