package project.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    int notificationId=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickme(View view)
    {
       xyz();
    }

    void xyz()
    {
        Intent intent= new Intent(this, NotificationView.class);
        intent.putExtra("notificationId", notificationId);
        PendingIntent pi= PendingIntent.getActivity(this, 0, intent, 0);
        NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification nf= new Notification(R.drawable.ic_launcher,"harish...",System.currentTimeMillis());
        nf.setLatestEventInfo(this,"LatestInfo","we will move now",pi);
        nm.notify(notificationId,nf);

//        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
