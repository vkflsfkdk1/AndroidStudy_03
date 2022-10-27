package com.example.androidstudy_03

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.roundToInt
import kotlin.random.Random

class CreateView(context: Context) {

    private val context: Context = context
    private val eggList = listOf(
        R.drawable.an_s01001_01,
        R.drawable.an_s01002_01,
        R.drawable.an_s01003_01,
    )

    private val lottieList = listOf(
        R.raw.an_s01001_01,
        R.raw.an_s01002_01,
        R.raw.an_s01003_01,
    )

    fun createUserImgLayerView(userImgTitle: View, userImg: View): View{
        var userImgLayer = ConstraintLayout(context)
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        userImgLayer.layoutParams = layoutParams
        userImgLayer.addView(userImg)
        userImgLayer.addView(userImgTitle)
        return userImgLayer
    }

    fun createUserImgTitleView(): View{
        var userImgTitle = ImageView(context).apply {
            setImageResource(R.drawable.frame_s_05)
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        userImgTitle.layoutParams = layoutParams
        return userImgTitle
    }

    fun createUserImgView(): View{
        var userImg =ImageView(context).apply {
            setImageResource(R.drawable.user_img)
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.width = changeDP(33)
        layoutParams.height = changeDP(33)
        userImg.layoutParams = layoutParams
        return userImg
    }

    fun createIdLayerView(id: View): View {
        var idLayer = ConstraintLayout(context).apply {
            setBackgroundResource(R.drawable.combo_profile_back)
            setPadding(changeDP(24.5f), changeDP(5.5f), changeDP(67.5f), changeDP(4))
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.marginStart = changeDP(16.5f)
        idLayer.layoutParams = layoutParams
        idLayer.addView(id)
        return idLayer
    }

    fun createUserIdView(): View {
        var tvUserId = TextView(context).apply {
            textSize = 9.0f
            setTextColor(Color.WHITE)
            text = "채여니입니다"
        }
        return tvUserId
    }

    fun createComboLayerView(combo: View, comboBox: View): View{
        var comboLayer = ConstraintLayout(context).apply {
            isVisible = false
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.startToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.marginStart = changeDP(-22)
        layoutParams.width = changeDP(75)
        layoutParams.height = changeDP(75)
        comboLayer.layoutParams = layoutParams
        comboLayer.addView(combo)
        comboLayer.addView(comboBox)
        return comboLayer
    }

    fun createComboBoxView(): ImageView{
        var tvComboBox = ImageView(context).apply {
            setImageResource(R.drawable.glow_circle_fx_01)
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        tvComboBox.layoutParams = layoutParams
        return tvComboBox
    }

    fun createComboView(): TextView{
        var random: Random
        var tvCombo = TextView(context).apply {
            textSize = 40f
            setTextColor(Color.WHITE)
            text = "1"
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        tvCombo.layoutParams = layoutParams
        return tvCombo
    }

    fun createEgg(
        num: Int,
        onClick: () -> Unit,
    ): ImageView{
        var ivEgg = ImageView(context).apply {
            setImageResource(eggList[num])
            setOnClickListener{
                onClick()
            }
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        return ivEgg
    }

    fun createLottieView(num: Int): LottieAnimationView{
        var lottie = LottieAnimationView(context).apply {
            setAnimation(lottieList[num])
            playAnimation()
        }
        var layoutParams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.width = changeDP(270)
        layoutParams.height = changeDP(270)
        return lottie
    }

    private fun changeDP(value: Float): Int {
        var displayMetrics = context.resources.displayMetrics
        return (value * displayMetrics.density).roundToInt()
    }

    private fun changeDP(value: Int): Int {
        var displayMetrics = context.resources.displayMetrics
        return (value * displayMetrics.density).roundToInt()
    }
}