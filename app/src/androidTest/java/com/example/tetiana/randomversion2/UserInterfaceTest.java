package com.example.tetiana.randomversion2;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UserInterfaceTest {

    private final ViewInteraction input = onView(withId(R.id.inputLine));
    private final ViewInteraction addToListButton = onView(withId(R.id.buttonPlus));
    private final ViewInteraction newListButton = onView(withId(R.id.button2));
    private final ViewInteraction randomButton = onView(withId(R.id.randomizeButton));
    private final ViewInteraction result = onView(withId(R.id.textViewResult));

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void singleChoice() {
        input.perform(typeText("Kate"), closeSoftKeyboard());
        addToListButton.perform(click());

        newListButton.perform(click());

        input.perform(typeText("washes dishes"), closeSoftKeyboard());
        addToListButton.perform(click());
        randomButton.perform(click());

        result.check(matches(withText("Kate washes dishes")));
    }

    @Test
    public void singleChoiceWithRotate() throws InterruptedException {
        input.perform(typeText("Kate"), closeSoftKeyboard());
        addToListButton.perform(click());

        newListButton.perform(click());

        input.perform(typeText("washes dishes"), closeSoftKeyboard());
        addToListButton.perform(click());

        rotateScreen();

        randomButton.perform(click());

        result.check(matches(withText("Kate washes dishes")));
    }

    private void rotateScreen() {
        rule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}