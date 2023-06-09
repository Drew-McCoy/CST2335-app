package algonquin.cst2335.mcco0553;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);
    /**
     * Tests the password with a correct password
     */
    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText4 = onView(withId(R.id.textView));
        appCompatEditText4.perform(replaceText("@1Pass"),closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView2));
        textView.check(matches(withText("Password meets requirements")));
    }
    /**
     * Tests the password for a missing upper case letter
     */
    @Test
    public void testMissingUpperCase(){
        ViewInteraction appCompatEditText4 = onView(withId(R.id.textView));
        appCompatEditText4.perform(replaceText("@pass123"),closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView2));
        textView.check(matches(withText("You Shall not Pass")));
    }
    /**
     * Tests the password for a missing lower case letter
     */
    @Test
    public void testMissingLowerCase(){
        ViewInteraction appCompatEditText4 = onView(withId(R.id.textView));
        appCompatEditText4.perform(replaceText("@PASS123"),closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView2));
        textView.check(matches(withText("You Shall not Pass")));
    }
    /**
     * Tests the password for a missing number
     */
    @Test
    public void testMissingNumber(){
        ViewInteraction appCompatEditText4 = onView(withId(R.id.textView));
        appCompatEditText4.perform(replaceText("@Pass"),closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView2));
        textView.check(matches(withText("You Shall not Pass")));
    }

    /**
     * Tests the password for a missing special character
     */
    @Test
    public void testMissingSpecial(){
        ViewInteraction appCompatEditText4 = onView(withId(R.id.textView));
        appCompatEditText4.perform(replaceText("1Pass"),closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView2));
        textView.check(matches(withText("You Shall not Pass")));
    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
