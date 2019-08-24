package com.abhi.androidarchitecture.ui.Activity

import android.app.Instrumentation
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.abhi.androidarchitecture.R
import com.abhi.androidarchitecture.ui.Activity.SecondActivity.SecondActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    var mActivityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private var mainActivity: MainActivity? = null
    private var monitor:Instrumentation.ActivityMonitor = getInstrumentation().addMonitor(SecondActivity::class.java.name,null,false)

    @Before
    fun setUp() {
        mainActivity = mActivityTestRule.activity
    }

    @Test
    fun testLaunch() {
        assertNotNull(mainActivity!!.findViewById(R.id.main_btn))
        onView(withId(R.id.main_btn)).perform(click())
        var activity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000)
        assertNotNull(activity)
        activity.finish()

    }

    @After
    fun tearDown() {
        mainActivity = null
    }
}