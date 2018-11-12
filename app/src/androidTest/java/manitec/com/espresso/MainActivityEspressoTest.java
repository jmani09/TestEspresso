package manitec.com.espresso;

import android.app.Activity;
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

/**
 * Created by mani on 7/10/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivitiesRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork(){
        onView(withId(R.id.texto))
                .perform(typeText("HOLA"), closeSoftKeyboard());

        onView(withId(R.id.cambiarTextView))
                .perform(click());

        onView(withId(R.id.texto))
                .check(matches(withText("HOLA")));
    }

    @Test
    public void ensureResetWork(){
        onView(withId(R.id.texto))
                .perform(typeText("HOLA") , closeSoftKeyboard());
        onView(withId(R.id.reset)).perform(click());

        onView(withId(R.id.texto))
                .check(matches(withText("Texto")));
    }

    @Test
    public void changeNewActivity(){
        onView(withId(R.id.texto))
                .perform(typeText("HOLA"), closeSoftKeyboard());

        onView(withId(R.id.cambiarActivity)).perform(click());

        onView(withId(R.id.texto2))
                .check(matches(withText("HOLA")));

    }

}
