package com.example.androidstudy_03

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.rotationMatrix
import androidx.core.view.isVisible
import kotlinx.coroutines.delay
import org.w3c.dom.Text

object AnimatorList {
    fun upCountAnim(num: Int, textView: TextView): ValueAnimator {
        return ValueAnimator.ofInt(1, num).apply {
            addUpdateListener { valueAnimator: ValueAnimator ->
                val currentValue = valueAnimator.animatedValue as Int
                textView.text = currentValue.toString()
            }
            startDelay = 330L
            duration = 400L * num
        }
    }

    fun sizeTransAnim(num: Int, imageView: ImageView): ValueAnimator {
        return ValueAnimator.ofFloat(0.2f, 1.2f).apply {
            startDelay = 330L
            duration = 400L
            repeatCount = num - 1
            addUpdateListener { animation ->
                imageView.scaleX = animation.animatedValue as Float
                imageView.scaleY = animation.animatedValue as Float
            }
        }
    }

    fun numSizeTransAnim(num: Int, textView: TextView): ValueAnimator {
        return ValueAnimator.ofFloat(1.2f, 0.8f).apply {
            startDelay = 330L
            duration = 400L
            repeatCount = num - 1
            addUpdateListener { animation ->
                textView.scaleX = animation.animatedValue as Float
                textView.scaleY = animation.animatedValue as Float
            }
        }
    }

    fun appearAnim(num: Int, const: ConstraintLayout, layer: View): ObjectAnimator{
        return ObjectAnimator.ofFloat(const, "translationX", 325f).apply {
            duration = 330L
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    layer.isVisible = true
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}

            })
        }
    }

    fun disappearAnim(num: Int, const: ConstraintLayout): ObjectAnimator{
        return ObjectAnimator.ofFloat(const, "translationX", -325f).apply {
            startDelay = 330L + (400L * num) + 500L
            duration = 330L
        }
    }

    fun downAnim(const: ConstraintLayout): ObjectAnimator{
        return ObjectAnimator.ofFloat(const, "translationY", 1600f).apply {
            duration = 8000L
        }
    }

    fun shakeRightAnim(const: ConstraintLayout): ObjectAnimator{
        return ObjectAnimator.ofFloat(const, View.ROTATION, 0f, 60f).apply {
            startDelay = 2000L
            duration = 3000L
        }
    }

    fun shakeLeftAnim(const: ConstraintLayout): ObjectAnimator{
        return ObjectAnimator.ofFloat(const, View.ROTATION, 60f, 0f).apply {
            startDelay = 5000L
            duration = 3000L
        }
    }
}