package kz.edu.sdu.galix.loshadki;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb1,pb2,pb3;
    Button btn;
    Loshadki l1;
    Loshadki2 l2;
    Loshadki3 l3;
    Boolean q1=false,q2=false,q3=false;
    LinearLayout ll;
    LinearLayout.LayoutParams llp;
    ArrayList<Integer> ls = new ArrayList<>();
    TextView tv,tv2;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = new Loshadki();
        l2 = new Loshadki2();
        l3 = new Loshadki3();
        ll = (LinearLayout)findViewById(R.id.ll);
        llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btn = (Button)findViewById(R.id.btn);
        pb1 = (ProgressBar)findViewById(R.id.pb1);
        pb2 = (ProgressBar)findViewById(R.id.pb2);
        pb3 = (ProgressBar)findViewById(R.id.pb3);
        pb1.setMax(100);

       

        Log.d("q",""+q1);
    }
    public void onClick(View v) {

        l1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 1);
        l2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 2);
        l3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 3);
        Toast.makeText(this, l1.getStatus().toString(), Toast.LENGTH_SHORT).show();

    }

    public class Loshadki extends AsyncTask<Integer,Integer,Void>{
        Random rnd = new Random();
        int speed=0;
        Integer[] id;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            speed = rnd.nextInt(10)+5;
        }
        @Override
        protected Void doInBackground(Integer... params) {
            try {
                id=params;
                int i=0;
                while(i<100) {
                    speed = rnd.nextInt(10)+5;
                    sleep();
                    publishProgress(i);
                    i+=speed;

                }
                if(i>100) publishProgress(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb1.setProgress(values[0]);
            Log.d("something",""+values[0]);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ls.add(id[0]);
            q1=true;
            tv2 = new TextView(MainActivity.this);
            tv2.setText("1");
            ll.addView(tv2,llp);
        }

        private void sleep() throws InterruptedException {
            Thread.sleep(1000);
        }
    }
    public class Loshadki2 extends AsyncTask<Integer,Integer,Void>{
        Random rnd = new Random();
        int speed=0;
        Integer[] id;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            speed = rnd.nextInt(10)+5;
        }

        @Override
        protected Void doInBackground(Integer... params) {
            try {
                id = params;
                int i=0;
                while(i<100) {
                    speed = rnd.nextInt(10)+5;
                    sleep();
                    publishProgress(i);
                    i+=speed;
                }
                if(i>100) publishProgress(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb2.setProgress(values[0]);
            Log.d("something2",""+values[0]);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ls.add(id[0]);

            Log.d("someth",""+id[0]);
            q2=true;
            tv2 = new TextView(MainActivity.this);
            tv2.setText("2");
            ll.addView(tv2,llp);
        }

        private void sleep() throws InterruptedException {
            Thread.sleep(1000);
        }
    }
    public class Loshadki3 extends AsyncTask<Integer,Integer,Void>{
        Random rnd = new Random();
        int speed=0;
        Integer[] id;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            speed = rnd.nextInt(10)+5;
        }

        @Override
        protected Void doInBackground(Integer... params) {
            try {
                id = params;
                int i=0;
                while(i<100) {
                    speed = rnd.nextInt(10)+5;
                    sleep();
                    publishProgress(i);
                    i+=speed;
                }
                if(i>100) publishProgress(100);
                sleep();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pb3.setProgress(values[0]);
            Log.d("something3",""+values[0]);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ls.add(id[0]);
            q3=true;
            Log.d("something2",""+id[0]);
            tv2 = new TextView(MainActivity.this);
            tv2.setText("3");
            ll.addView(tv2,llp);
            q();
        }

        private void sleep() throws InterruptedException {
            Thread.sleep(1000);
        }
        private void q() {
            tv.setText("askdjas");
        }
   }
}
