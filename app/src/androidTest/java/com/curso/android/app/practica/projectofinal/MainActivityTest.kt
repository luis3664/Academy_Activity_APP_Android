package com.curso.android.app.practica.projectofinal

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.projectofinal.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @get: Rule
    val rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_comparatorTextsEqual() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.boton_comparar)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            matches(
                withText("Los textos son iguales")
            )
        )
    }

    @Test
    fun mainActivity_comparatorTextsNoEqual() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            typeText("hello")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            typeText("HELLO")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.boton_comparar)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            matches(
                withText("Los textos NO son iguales")
            )
        )
    }

    @Test
    fun mainActivity_comparatorTextsVoid() {
        Espresso.onView(
            ViewMatchers.withId(R.id.boton_comparar)
        ).perform(
            click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            matches(
                withText("Los textos son iguales")
            )
        )
    }
}