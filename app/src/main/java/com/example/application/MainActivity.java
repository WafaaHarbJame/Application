package com.example.application;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static long t_finish;
    int CounterUp = 12000;
    private Button calcBut, makeIterationBut, ReqThreeBut;

    double x = 1.0000;
    public static long t_start;
    public static long next;

    public static long test_time;
    private int timerCount;

    CountDownTimer downTimer = null;

    Timer timer = null;
    int TIMER_PERIOD = 500;
    int timerValue = 0;


    Double ExecutionTimeP1 = 500.0; // Task A
    Double ExecutionTimeP2 = 500.0; // Task B
    Double ExecutionTimeP3 = 1000.0; // Task C


    //deadlines for three task
    private int deadline1 = 2000, deadline2 = 3000, deadline3 = 4000;

    //  period  for three task
    private int periodsTA = 2000, periodsTB = 3000, periodsTC = 4000;


    // frame_length
    private int frame_length = 2000;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        calcBut.setOnClickListener(v -> {

            FirstFunction();


        });


        makeIterationBut.setOnClickListener(v ->
                makeLoop(10)
        );

        ReqThreeBut.setOnClickListener(v -> {

                    Requirement3();


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

    private void FirstFunction() {
        t_start = System.currentTimeMillis();

        Task();

        t_finish = System.currentTimeMillis();

        test_time = t_finish - t_start;

        System.out.println("Log test_time in seconds " + test_time / 1000.0);
    }


    public void cyclicFunction() {

        for (int i = 1; i <= 6; i++) {

            int nextDeadLine = i * frame_length;

            System.out.println("Log i  " + i);
            System.out.println("Log time in for  " + timerCount);


            boolean flagA = false, flagB = false, flagC = false;

            if (nextDeadLine <= deadline1) {

                try {
                    TaskA();
                    Thread.sleep((long) (0.5 * 1000));
                    flagA = true;
                    deadline1 = deadline1 * i;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            if (nextDeadLine <= deadline2) {
                try {
                    TaskB();
                    Thread.sleep((long) (0.5 * 1000));
                    flagB = true;
                    deadline2 = deadline2 * i;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            if (nextDeadLine <= deadline3) {
                try {
                    TaskC();
                    Thread.sleep((long) (1000));
                    flagC = true;
                    deadline3 = deadline3 * i;


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            timer.cancel();


        }


    }


    private void Task() {
        System.out.println("Log Task1  display  message ");
        delay(x);

    }


    public static void delay(double x) {
        try {
            Thread.sleep((long) (x * 1000));

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
            FirstFunction();


        }

    }


    private void TaskA() {

        System.out.println("Log Now Task A Executed   ");

    }


    private void TaskB() {

        System.out.println("Log Now Task B Executed  ");
    }


    private void TaskC() {

        System.out.println("Log Now Task C  Executed  ");

    }


    private void StartTimer() {

        timer = new Timer();
        timer.schedule(new ProgressUpdate(), 0, TIMER_PERIOD);


    }

    private void Requirement3() {


        for (int i = 1; i <= 6; i++) {

            StartTimer();

            Handler handler = new Handler();
            System.out.println("Log value i  " + i);

            int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    int nextDeadLine = finalI * frame_length;


                    boolean flagA = false, flagB = false, flagC = false;

                    if (nextDeadLine <= deadline1) {

                        try {
                            TaskA();
                            Thread.sleep((long) (0.5 * 1000));
                            flagA = true;
                            deadline1 = deadline1 * finalI;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                    if (nextDeadLine <= deadline2) {
                        try {
                            TaskB();
                            Thread.sleep((long) (0.5 * 1000));
                            flagB = true;
                            deadline2 = deadline2 * finalI;


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                    if (nextDeadLine <= deadline3) {
                        try {
                            TaskC();
                            Thread.sleep((1000));
                            flagC = true;
                            deadline3 = deadline3 * finalI;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }


                }
            }, 2000);


        }
    }


    class ProgressUpdate extends TimerTask {

        ProgressUpdate() {
            super();
        }

        @Override
        public void run() {

            timerValue += TIMER_PERIOD;
            if (timerValue <= deadline1) {
                TaskA();

            }
            if (timerValue == deadline2) {
                TaskB();

            }
            if (timerValue == deadline3) {
                TaskC();

            }

            System.out.println("Log timer value1 = " + timerValue);


        }
    }


}