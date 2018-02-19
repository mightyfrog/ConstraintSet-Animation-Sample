package org.mightyfrog.android.constraintsetsample

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var layout = R.layout.content_main

    private val constraintSet = ConstraintSet()

    private val transition = ChangeBounds().apply {
        interpolator = BounceInterpolator()
        duration = 700
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            toggle()
        }
    }

    private fun toggle() {
        layout = if (layout == R.layout.content_main) R.layout.content_main2 else R.layout.content_main
        constraintSet.clone(this, layout)
        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
