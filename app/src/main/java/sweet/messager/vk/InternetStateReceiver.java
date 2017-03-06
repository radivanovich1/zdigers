package sweet.messager.vk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import sweet.messager.vk.services.LongPoll;

public class InternetStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getActiveNetworkInfo();//(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getActiveNetworkInfo();//(ConnectivityManager.TYPE_MOBILE);
        final Intent service = new Intent(ApplicationName.getAppContext(), LongPoll.class);
        if (wifi != null && wifi.isAvailable() || mobile != null && mobile.isAvailable()) {
           context.startService(service);
        } else {
            context.stopService(service);
        }
    }
}