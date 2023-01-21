package com.shallowcode.mvpexample;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Create a new class named Model to separate all string data and the methods to fetch those data.
 * This class will not know the existence of View Class.
 */
public class Model implements Contract.Model {


    // array list of strings from which random strings
    // will be selected to display in the activity
    private final List<String> arrayList = Arrays.asList("DSA Self Paced: Master the basics of Data Structures and Algorithms to solve complex problems efficiently. ",
            "Placement 100: This course will guide you for placement with theory,lecture videos, weekly assignments " + "contests and doubt assistance.",
            "Amazon SDE Test Series: Test your skill & give the final touch to your preparation before applying for " + "product based against like Amazon, Microsoft, etc.",
            "Complete Interview Preparation: Cover all the important concepts and topics required for the interviews. " + "Get placement ready before the interviews begin",
            "Low Level Design for SDE 1 Interview: Learn Object-oriented Analysis and Design to prepare for " + "SDE 1 Interviews in top companies");


    // this method will invoke when user clicks on the button
    // and it will take a delay of 1200 milliseconds to display next course detail
    @Override
    public void getNextCourse(OnFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinished(getRandomString());
            }
        }, 1200);
    }


    // method to select random string from the list of strings
    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}