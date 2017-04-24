package com.example.tetiana.randomversion2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class UserInterface2Test {

    @Rule
    public ActivityTestRule<InputActivity> rule = new ActivityTestRule<>(InputActivity.class);

    @Test
    public void addsOneElementToSingleList() {
        onView(withId(R.id.inputOption)).perform(typeText("Alice"), closeSoftKeyboard());
        onView(withId(R.id.buttonAddOption)).perform(click());

        onView(nthChildOf(withId(R.id.recyclerView), 0)).check(matches(hasDescendant(withText("Alice"))));
    }

    @Test
    public void clearsTypedTextAfterAddingToExistingList() {
        onView(withId(R.id.inputOption)).perform(typeText("Alice"), closeSoftKeyboard());
        onView(withId(R.id.buttonAddOption)).perform(click());
        onView(withId(R.id.inputOption)).check(matches(withText("")));
    }

    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with "+childPosition+" child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }
}