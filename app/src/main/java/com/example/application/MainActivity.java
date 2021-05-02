package com.example.application;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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


    long ExecutionTimeP1 = 490; // Task A
    long ExecutionTimeP2 = 490; // Task B
    long ExecutionTimeP3 = 990; // Task C


    //deadlines for three task
    private final int deadline1 = 2000, deadline2 = 3000, deadline3 = 4000;

    //  period  for three task
    private int periodsTA = 2000, periodsTB = 3000, periodsTC = 4000;


    // frame_length
    private final int frame_length = 2000;
    private final int last_frame = 6 * 2000;


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

                }
        );


    }

    private void FirstFunction() {
        t_start = System.currentTimeMillis();

        Task();

        t_finish = System.currentTimeMillis();

        test_time = t_finish - t_start;

        System.out.println("Log test_time in seconds " + test_time / 1000.0);
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

        calcBut = findViewById(R.id.calcTimeBut);
        makeIterationBut = findViewById(R.id.makeIterationBut);
        ReqThreeBut = findViewById(R.id.ReqThreeBut);


    }


    private void makeLoop(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Log i Value" + i);
            FirstFunction();


        }

    }

    private void Requirement3() {

        next = clock();
        int minorCycle = deadline1;
        while (true) {
            while (clock() < next) {
            }
            switch (minorCycle) {
                case (frame_length):
                    TaskA();
                    TaskB();
                    TaskC();
                    break;
                case (2 * frame_length):
                    TaskA();
                    break;
                case (3 * frame_length):
                    TaskA();
                    TaskB();
                    TaskC();
                    break;
                case (4 * frame_length):
                    TaskA();
                    TaskB();
                    break;
                case (5 * frame_length):
                    TaskA();
                    break;
                case (6 * frame_length):
                    TaskA();
                    TaskB();
                    TaskC();
                    break;
            }

            if (minorCycle < last_frame)
                minorCycle += frame_length;
            else {
                minorCycle = deadline1;
                Log.w("Main", "Log ************ Repeat From Start **********");
            }

            next = next + frame_length;
            if (clock() > next) {
                Log.e("Main", "Log ************ OverRun **********");
                break;
            }
            System.out.println("Log ************ Check Next Frame **********");
        }

    }

    private long clock() {
        return System.currentTimeMillis();
    }

    private void TaskA() {

        System.out.println("Log Now Task A Executed   ");
        try {
            Thread.sleep(ExecutionTimeP1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void TaskB() {

        System.out.println("Log Now Task B Executed  ");
        try {
            Thread.sleep(ExecutionTimeP2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void TaskC() {

        System.out.println("Log Now Task C  Executed  ");
        try {
            Thread.sleep(ExecutionTimeP3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}