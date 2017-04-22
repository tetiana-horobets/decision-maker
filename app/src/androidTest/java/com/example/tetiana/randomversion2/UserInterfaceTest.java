package com.example.tetiana.randomversion2;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


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
    public void singleChoiceWithRotate() {
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

    @Test
    public void showsOptionsSingleList() {
        input.perform(typeText("Kate"), closeSoftKeyboard());
        addToListButton.perform(click());

        onView(allOf(withId(R.id.textViewDynamic), withText("Kate\n"))).check(matches(isDisplayed()));
    }

    @Test
    public void showsOptionsTwoLists() {
        input.perform(typeText("Kate"), closeSoftKeyboard());
        addToListButton.perform(click());

        input.perform(typeText("John"), closeSoftKeyboard());
        addToListButton.perform(click());

        newListButton.perform(click());

        input.perform(typeText("washes dishes"), closeSoftKeyboard());
        addToListButton.perform(click());
        input.perform(typeText("cleans up apartment"), closeSoftKeyboard());
        addToListButton.perform(click());

        onView(allOf(withId(R.id.textViewDynamic), withText("Kate\nJohn\n"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.textViewDynamic), withText("washes dishes\ncleans up apartment\n"))).check(matches(isDisplayed()));
    }

    @Test

    public void showsOptionsWithRotate() throws InterruptedException {
        input.perform(typeText("Kate"), closeSoftKeyboard());
        addToListButton.perform(click());

        input.perform(typeText("John"), closeSoftKeyboard());
        addToListButton.perform(click());

        newListButton.perform(click());

        input.perform(typeText("washes dishes"), closeSoftKeyboard());
        addToListButton.perform(click());
        input.perform(typeText("cleans up apartment"), closeSoftKeyboard());
        addToListButton.perform(click());
        rotateScreen();


        onView(allOf(withId(R.id.textViewDynamic), withText("Kate\nJohn\n"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.textViewDynamic), withText("washes dishes\ncleans up apartment\n"))).check(matches(isDisplayed()));
    }


}