package com.example.fitem;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
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

    @Test
    public void mainActivityTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.addTrainingButton), withText("Dodaj trening"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction editText = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText.perform(replaceText("Poniedzialek"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(android.R.id.button1), withText("Dodaj"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton2.perform(scrollTo(), click());

        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction editText2 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText2.perform(replaceText("Lawka klata"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction editText3 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText3.perform(replaceText("martwy ciag"), closeSoftKeyboard());

        ViewInteraction editText4 = onView(
                allOf(withText("martwy ciag"),
                        childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText4.perform(click());

        ViewInteraction editText5 = onView(
                allOf(withText("martwy ciag"),
                        childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText5.perform(replaceText("Martwy ciag"));

        ViewInteraction editText6 = onView(
                allOf(withText("Martwy ciag"),
                        childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText6.perform(closeSoftKeyboard());

        ViewInteraction materialButton6 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton6.perform(scrollTo(), click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction editText7 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText7.perform(replaceText("Lydki"), closeSoftKeyboard());

        ViewInteraction materialButton8 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton8.perform(scrollTo(), click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction editText8 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText8.perform(replaceText("Triceps maszyna"), closeSoftKeyboard());

        ViewInteraction materialButton10 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton10.perform(scrollTo(), click());

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction editText9 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText9.perform(replaceText("bieznia"), closeSoftKeyboard());

        ViewInteraction materialButton12 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton12.perform(scrollTo(), click());

        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout2.perform(click());

        ViewInteraction materialButton13 = onView(
                allOf(withId(R.id.editExerciseDetailsButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton13.perform(click());

        ViewInteraction editText10 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText10.perform(replaceText("8"));

        ViewInteraction editText11 = onView(
                allOf(withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText11.perform(closeSoftKeyboard());

        ViewInteraction editText12 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText12.perform(replaceText("4"));

        ViewInteraction editText13 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText13.perform(closeSoftKeyboard());

        ViewInteraction editText14 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText14.perform(replaceText("12"));

        ViewInteraction editText15 = onView(
                allOf(withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText15.perform(closeSoftKeyboard());

        ViewInteraction materialButton14 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton14.perform(scrollTo(), click());

        ViewInteraction materialButton15 = onView(
                allOf(withId(R.id.startTimerButton), withText("Start Timer"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton15.perform(click());

        pressBack();

        DataInteraction linearLayout3 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        linearLayout3.perform(click());

        ViewInteraction materialButton16 = onView(
                allOf(withId(R.id.editExerciseDetailsButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton16.perform(click());

        ViewInteraction editText16 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText16.perform(replaceText("20"));

        ViewInteraction editText17 = onView(
                allOf(withText("20"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText17.perform(closeSoftKeyboard());

        ViewInteraction editText18 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText18.perform(replaceText("4"));

        ViewInteraction editText19 = onView(
                allOf(withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText19.perform(closeSoftKeyboard());

        ViewInteraction editText20 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText20.perform(replaceText("120"));

        ViewInteraction editText21 = onView(
                allOf(withText("120"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText21.perform(closeSoftKeyboard());

        ViewInteraction materialButton17 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton17.perform(scrollTo(), click());

        ViewInteraction materialButton18 = onView(
                allOf(withId(R.id.editExerciseDetailsButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton18.perform(click());

        ViewInteraction editText22 = onView(
                allOf(withText("Lydki"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                1),
                        isDisplayed()));
        editText22.perform(replaceText("Lydki step"));

        ViewInteraction editText23 = onView(
                allOf(withText("Lydki step"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                1),
                        isDisplayed()));
        editText23.perform(closeSoftKeyboard());

        ViewInteraction materialButton19 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton19.perform(scrollTo(), click());

        pressBack();

        ViewInteraction materialButton20 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton20.perform(click());

        ViewInteraction materialButton21 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton21.perform(click());

        ViewInteraction materialButton22 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton22.perform(click());

        ViewInteraction materialButton23 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton23.perform(click());

        ViewInteraction materialButton24 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton24.perform(click());

        ViewInteraction editText24 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText24.perform(replaceText("Nowe Cwiczenie"), closeSoftKeyboard());

        ViewInteraction materialButton25 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton25.perform(scrollTo(), click());

        DataInteraction linearLayout4 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(3);
        linearLayout4.perform(click());

        ViewInteraction materialButton26 = onView(
                allOf(withId(R.id.editExerciseDetailsButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton26.perform(click());

        ViewInteraction materialButton27 = onView(
                allOf(withId(android.R.id.button2), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        materialButton27.perform(scrollTo(), click());

        pressBack();

        DataInteraction linearLayout5 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(3);
        linearLayout5.perform(click());

        pressBack();

        DataInteraction linearLayout6 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        linearLayout6.perform(click());

        DataInteraction linearLayout7 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(2);
        linearLayout7.perform(click());

        DataInteraction linearLayout8 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(1);
        linearLayout8.perform(click());

        DataInteraction linearLayout9 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout9.perform(click());

        pressBack();

        ViewInteraction materialButton28 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton28.perform(click());

        ViewInteraction materialButton29 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton29.perform(click());

        ViewInteraction materialButton30 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton30.perform(click());

        ViewInteraction materialButton31 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton31.perform(click());

        ViewInteraction materialButton32 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton32.perform(click());

        ViewInteraction materialButton33 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton33.perform(click());

        ViewInteraction editText25 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText25.perform(replaceText("dodaje jeszcze nowsze"), closeSoftKeyboard());

        ViewInteraction materialButton34 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton34.perform(scrollTo(), click());

        ViewInteraction materialButton35 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton35.perform(click());

        DataInteraction linearLayout10 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout10.perform(click());

        pressBack();

        ViewInteraction materialButton36 = onView(
                allOf(withId(R.id.addTrainingButton), withText("Dodaj trening"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton36.perform(click());

        ViewInteraction editText26 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText26.perform(replaceText("Wtorek"), closeSoftKeyboard());

        ViewInteraction materialButton37 = onView(
                allOf(withId(android.R.id.button1), withText("Dodaj"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton37.perform(scrollTo(), click());

        ViewInteraction materialButton38 = onView(
                allOf(withId(R.id.editButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton38.perform(click());

        ViewInteraction materialButton39 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.listView)),
                                1),
                        isDisplayed()));
        materialButton39.perform(click());

        ViewInteraction materialButton40 = onView(
                allOf(withId(R.id.editButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton40.perform(click());

        DataInteraction linearLayout11 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout11.perform(click());

        ViewInteraction materialButton41 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton41.perform(click());

        ViewInteraction editText27 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText27.perform(replaceText("Cwiczenie Wtorek"), closeSoftKeyboard());

        ViewInteraction materialButton42 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton42.perform(scrollTo(), click());

        DataInteraction linearLayout12 = onData(anything())
                .inAdapterView(allOf(withId(R.id.exerciseListView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout12.perform(click());

        ViewInteraction materialButton43 = onView(
                allOf(withId(R.id.editExerciseDetailsButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton43.perform(click());

        ViewInteraction editText28 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText28.perform(replaceText("1"));

        ViewInteraction editText29 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                3),
                        isDisplayed()));
        editText29.perform(closeSoftKeyboard());

        ViewInteraction editText30 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText30.perform(replaceText("1"));

        ViewInteraction editText31 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                5),
                        isDisplayed()));
        editText31.perform(closeSoftKeyboard());

        ViewInteraction editText32 = onView(
                allOf(withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText32.perform(replaceText("1"));

        ViewInteraction editText33 = onView(
                allOf(withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.custom),
                                        0),
                                7),
                        isDisplayed()));
        editText33.perform(closeSoftKeyboard());

        ViewInteraction materialButton44 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton44.perform(scrollTo(), click());

        ViewInteraction materialButton45 = onView(
                allOf(withId(R.id.startTimerButton), withText("Start Timer"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton45.perform(click());

        pressBack();

        ViewInteraction materialButton46 = onView(
                allOf(withId(R.id.addExerciseButton), withText("Dodaj �wiczenie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton46.perform(click());

        ViewInteraction editText34 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText34.perform(replaceText("Moze jeszcze jakies"), closeSoftKeyboard());

        ViewInteraction materialButton47 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton47.perform(scrollTo(), click());

        ViewInteraction materialButton48 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton48.perform(click());

        ViewInteraction materialButton49 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.exerciseListView)),
                                1),
                        isDisplayed()));
        materialButton49.perform(click());

        ViewInteraction materialButton50 = onView(
                allOf(withId(R.id.editExerciseButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton50.perform(click());

        pressBack();

        ViewInteraction materialButton51 = onView(
                allOf(withId(R.id.editButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton51.perform(click());

        ViewInteraction materialButton52 = onView(
                allOf(withId(R.id.deleteButton), withText("Usu�"),
                        childAtPosition(
                                withParent(withId(R.id.listView)),
                                1),
                        isDisplayed()));
        materialButton52.perform(click());

        ViewInteraction materialButton53 = onView(
                allOf(withId(R.id.addTrainingButton), withText("Dodaj trening"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton53.perform(click());

        ViewInteraction editText35 = onView(
                allOf(childAtPosition(
                                allOf(withId(android.R.id.custom),
                                        childAtPosition(
                                                withClassName(is("android.widget.FrameLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        editText35.perform(replaceText("sroda"), closeSoftKeyboard());

        ViewInteraction materialButton54 = onView(
                allOf(withId(android.R.id.button1), withText("Dodaj"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton54.perform(scrollTo(), click());

        ViewInteraction materialButton55 = onView(
                allOf(withId(R.id.editButton), withText("Edit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton55.perform(click());

        DataInteraction linearLayout13 = onData(anything())
                .inAdapterView(allOf(withId(R.id.listView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout13.perform(click());

        pressBack();
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
