package com.example.application;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static long t_finish;
    int CounterUp = 12000;
    private Button calcBut, makeIterationBut, ReqThreeBut;

    double number_sec = 0.969565;

    public static long t_start;
    public static long next;

    public static long test_time;
    private int timerCount;

    CountDownTimer downTimer = null;

    Timer timer = null;
    int TIMER_PERIOD = 2000;
    int timerValue = 0;


    Double p1 = 500.0; // Task A
    Double p2 = 500.0; // Task B
    Double p3 = 1000.0; // Task C

    //deadlines
    private int d1 = 2000, d2 = 3000, d3 = 4000;

    //periods
    private int T1 = 2000, T2 = 3000, T3 = 4000;

    // frame_length
    private int frame_length = 2000;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();


        calcBut.setOnClickListener(v -> {

            FunctionRequired();


        });


        makeIterationBut.setOnClickListener(v ->
                makeLoop(10)
        );

        ReqThreeBut.setOnClickListener(v -> {

                    long next = clock();
                    while (true) {

                        while (clock() < next){}

                        Task1();
                        Task2();
                        Task3();
                        next=next+frame_length;
//                        next:=next+T;
//                        x:= next – clock();




                    }
//                    final Handler ha = new Handler();
//                    ha.postDelayed(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            for (int i = 1; i <= 6; i++) {
//
//
//                                int nextDeadLine = i * frame_length;
//
//                                System.out.println("Log i  " + i);
//
//
//                                boolean flagA = false, flagB = false, flagC = false;
//
//                                if (nextDeadLine <= d1) {
//
//                                    try {
//                                        Task1();
//                                        Thread.sleep((long) (0.5 * 1000));
//                                        flagA = true;
//                                        d1 = d1 * i;
//
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//
//
//                                }
//                                if (nextDeadLine <= d2) {
//                                    try {
//                                        Task2();
//                                        Thread.sleep((long) (0.5 * 1000));
//                                        flagB = true;
//                                        d2 = d2 * i;
//
//
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//
//
//                                }
//                                if (nextDeadLine <= d3) {
//                                    try {
//                                        Task3();
//                                        Thread.sleep((1000));
//                                        flagC = true;
//                                        d3 = d3 * i;
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//
//
//                                }
//                            }
//
//                            ha.postDelayed(this, 2000);
//                            ha.removeCallbacks(this);
//                        }
//                    }, 2000);


                }
        );


    }

    private long clock() {
        return System.currentTimeMillis();
    }

    private void FunctionRequired() {
        t_start = System.currentTimeMillis();

        Task();

        t_finish = System.currentTimeMillis();

        test_time = t_finish - t_start;


        System.out.println("Log test_time in Milliseconds " + test_time);
        System.out.println("Log test_time in seconds " + test_time / 1000.0);
    }


    public void cyclicFunction() {

        for (int i = 1; i <= 6; i++) {

            int nextDeadLine = i * frame_length;

            System.out.println("Log i  " + i);
            System.out.println("Log time in for  " + timerCount);


            boolean flagA = false, flagB = false, flagC = false;

            if (nextDeadLine <= d1) {

                try {
                    Task1();
                    Thread.sleep((long) (0.5 * 1000));
                    flagA = true;
                    d1 = d1 * i;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            if (nextDeadLine <= d2) {
                try {
                    Task2();
                    Thread.sleep((long) (0.5 * 1000));
                    flagB = true;
                    d2 = d2 * i;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            if (nextDeadLine <= d3) {
                try {
                    Task3();
                    Thread.sleep((long) (1000));
                    flagC = true;
                    d3 = d3 * i;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            timer.cancel();


        }


    }


    private void Task() {

        Toast.makeText(this, "Log Task display  message", Toast.LENGTH_SHORT).show();

        delay(number_sec);

    }


    public static void delay(double secs) {
        try {
            Thread.sleep((long) (secs * 1000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void initView() {

        calcBut = (Button) findViewById(R.id.calcTimeBut);
        makeIterationBut = (Button) findViewById(R.id.makeIterationBut);
        ReqThreeBut = (Button) findViewById(R.id.ReqThreeBut);


    }


    private void makeLoop(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Log i Value" + i);
            FunctionRequired();


        }

    }


    private void Task1() {
        System.out.println("Log Now Task A Executed   ");


    }


    private void Task2() {
        System.out.println("Log Now Task B Executed  ");
    }


    private void Task3() {
        System.out.println("Log Now Task C  Executed  ");

    }


    private void StartTime1() {

        timer = new Timer();
        timer.schedule(new ProgressUpdate(), 0, TIMER_PERIOD);


    }


    class ProgressUpdate extends TimerTask {

        ProgressUpdate() {
            super();
        }

        @Override
        public void run() {

            timerValue += TIMER_PERIOD;

            System.out.println("Log timer value1 = " + timerValue);


//
//            cyclicFunction();
//            System.out.println("Log timer value = " + timerValue);
//
//


        }
    }


//    private void StartTimer() {
//
//        downTimer = new CountDownTimer((12000) * 1000, 1000) {
//
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            public void onTick(long millisUntilFinished) {
//
//                int counterDown = (int) (millisUntilFinished / 1000);
//                timerCount = CounterUp - counterDown;
//                System.out.println("Log timerCount tick "+timerCount);
//
//               // cyclicFunction();
//
//
//            }
//
//            public void onFinish() {
//                System.out.println("Log Done ");
//
//            }
//        }.start();
//
//    }


}