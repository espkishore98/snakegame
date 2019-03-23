package com.example.snake;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class SnakeActivity extends Activity {

    // Declare an instance of SnakeView
    SnakeView snakeView;
    // We will initialize it in onCreate
    // once we have more details about the Player's device

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //find out the width and height of the screen
        Display display = getWindowManager().getDefaultDisplay();

        // Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        // Create a new View based on the SnakeView class
        snakeView = new SnakeView(this, size);

        // Make snakeView the default view of the Activity
        setContentView(snakeView);
    }
        @Override
        protected void onResume () {
            super.onResume();
            snakeView.resume();
        }

        // Make sure the thread in snakeView is stopped
        // If this Activity is about to be closed
        @Override
        protected void onPause () {
            super.onPause();
            snakeView.pause();
        }
}
