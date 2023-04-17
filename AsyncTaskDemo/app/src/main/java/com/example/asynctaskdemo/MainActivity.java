package com.example.asynctaskdemo;

import static com.example.asynctaskdemo.R.id.myTextView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.channels.AsynchronousByteChannel;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(myTextView);

    }

    public void buttonClick(View view) {
        AsyncTask task = new MyTask().execute();
    //    AsyncTask task = new MyTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

   //     int cpu_cores = Runtime.getRuntime().availableProcessors();

    }


    private class MyTask extends AsyncTask<String,Integer,String>{

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            int i = 0;
            while(i<=10)
            {
                onProgressUpdate(i);
                try {
                    Thread.sleep(1000);
                    i++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "ButtonPressed";
        }

        @Override
        protected void onPostExecute(String result) {
       //     super.onPostExecute(s);
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    // Stuff that updates the UI
                    textView.setText(result);

                }
            });
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
       //     super.onProgressUpdate(values);
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    // Stuff that updates the UI
                    textView.setText("Counter:"+values[0]);

                }
            });
        }
    }

}