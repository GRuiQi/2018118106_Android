package com.example.asynctasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);

        new AsyncPrintTask().execute(2,3,4);//启动异步任务

    }

    private class AsyncPrintTask extends AsyncTask<Integer, Integer, Integer>{

        /**
         * 所有代码都会在子线程中运行，常用来处理耗时的任务，任务一旦完成可以通过
         * return语句将任务的执行结果返回，结束后会主动调用onPostExecute()方法。
         * 并将return的信息传递给onPOStExecute()方法中的形参。
         *
         * doInBackground方法中使用到的publishProgress()方法则会
         * 调用onProgressUpdate方法，i会作为onProgressUpdate的形参。
         * @param params
         * @return
         */
        @Override
        protected Integer doInBackground(Integer... params) {
            int sum=0;
            for(int i=0;i<params.length;i++){
                int param=params[i];
                sum+=param;
            }
            for(int i=0;i<sum;i++){
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }

        /**
         * 前台处理
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.append("更新当前进度值:"+values[0]+"\n");
            super.onProgressUpdate(values);
        }

        /**
         * 后台任务开始执行前调用
         * @param result
         */
        @Override
        protected void onPostExecute(Integer result) {
            textView.append("任务执行的结果是:"+result);
            super.onPostExecute(result);
        }
    }


}
