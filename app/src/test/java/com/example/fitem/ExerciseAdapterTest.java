package com.example.fitem;




import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

@RunWith(RobolectricTestRunner.class)
public class ExerciseAdapterTest {

    private ExerciseAdapter exerciseAdapter;

    @Before
    public void setUp() {
        Context context = Mockito.mock(Context.class);
        TrainingDBHelper dbHelper = Mockito.mock(TrainingDBHelper.class);
        List<Exercise> exercises = new ArrayList<>();

        exerciseAdapter = new ExerciseAdapter(context, exercises, dbHelper);
    }

    @Test
    public void setEditModeTest() {
        // Test the initial state
        assertFalse(exerciseAdapter.isInEditMode());

        // Set edit mode to true and test
        exerciseAdapter.setEditMode(true);
        assertTrue(exerciseAdapter.isInEditMode());

        // Set edit mode back to false and test
        exerciseAdapter.setEditMode(false);
        assertFalse(exerciseAdapter.isInEditMode());
    }
}