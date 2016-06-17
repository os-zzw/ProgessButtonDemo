package company.zzw.john.progessbuttondemo;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ProgressButton pb_jindu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb_jindu = (ProgressButton) findViewById(R.id.pb_jindu);

        pb_jindu.setIsProgessEnable(true);

        pb_jindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncTask<Void, Integer, Void>() {
                    int progress = 0;

                    @Override
                    protected Void doInBackground(Void... params) {
                        while (true) {
                            SystemClock.sleep(200);
                            if (progress >= 100) {
                                break;
                            }
                            progress++;
                            publishProgress(progress);
                        }
                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        int progress = values[0];
                        pb_jindu.setProgress(progress);
                        pb_jindu.setText(progress + "%");
                    }
                }.execute();
            }
        });


    }
}
