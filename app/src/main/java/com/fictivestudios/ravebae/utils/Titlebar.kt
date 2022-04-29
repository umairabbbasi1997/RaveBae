package com.fictivestudios.ravebae.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.fictivestudios.ravebae.R
import com.fictivestudios.ravebae.activites.MainActivity
import kotlinx.android.synthetic.main.titlebar.view.*


class Titlebar : RelativeLayout {

   private lateinit var mView:View

    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initLayout(context)
    }

    fun initLayout(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mView = inflater.inflate(R.layout.titlebar, this, true)
    }

    fun hideTitleBar() {
        resetTitlebar()
    }

    fun showTitleBar()
    {
        mView?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
    }

    fun resetTitlebar() {
        mView?.rlTitlebarMainLayout?.setVisibility(View.GONE)
    }

/*    fun setHomeTitle(titleText:String,
                     leftBtnListener: OnClickListener?,
                     drawableLeft: Int,
                     rightBtnListener: OnClickListener,
                     drawableRight: Int)
    {

        mView?.tvTitle?.text = titleText

        mView?.ivBack!!.visibility = View.GONE
        mView?.ivProfile!!.visibility = View.VISIBLE
        mView?.ivProfile!!.setImageResource(drawableLeft)
        mView?.ivProfile!!.setOnClickListener(leftBtnListener)

        mView?.iv_notification!!.visibility = View.VISIBLE
        mView?.ivProfileRight!!.visibility = View.GONE
        mView?.iv_notification!!.setImageResource(drawableRight)
        mView?.iv_notification!!.setOnClickListener(rightBtnListener)
    }*/

    fun setHomeTitle(titleText:String)
    {
        mView?.tvTitle?.text = titleText
        mView?.btn_left.setImageResource(R.drawable.settings_icon)
        mView?.btn_profile.setImageResource(R.drawable.user_icon)
        mView?.btn_profile.visibility=View.VISIBLE

        mView?.btn_left!!.setOnClickListener {

            MainActivity.getMainActivity?.navController
                ?.navigate(R.id.settingsFragment)
        }
        mView?.btn_profile!!.setOnClickListener {

            MainActivity.getMainActivity?.navController
                ?.navigate(R.id.myProfileFragment)
        }

        MainActivity.getMainActivity?.showBottomBar()
    }


    fun setBtnBack( titleText:String,colorId:Int) {

        mView?.tvTitle?.text = titleText
        mView?.btn_left.setImageResource(R.drawable.back_arrow_icon)
        mView?.btn_profile.visibility=View.INVISIBLE

        MainActivity.getMainActivity?.hideBottomBar()
        mView?.btn_left!!.setOnClickListener {

            MainActivity.getMainActivity?.onBackPressed()
        }
    }


/*    fun setBtnBack( listener: OnClickListener?) {

            mView?.ivBack!!.visibility = View.VISIBLE
            mView?.ivProfile!!.visibility = View.GONE
           // mView?.ivBack!!.setImageResource(drawable)
            mView?.ivBack!!.setOnClickListener(listener)
    }

    fun setBtnProfile(*//*drawable: Int,*//* listener: OnClickListener?) {

            mView?.ivBack!!.visibility = View.GONE
            mView?.ivProfile!!.visibility = View.VISIBLE
           // mView?.ivProfile!!.setImageResource(drawable)
            mView?.ivProfile!!.setOnClickListener(listener)


    }

    fun setBtnRight(drawable: Int, listener: OnClickListener?) {
        mView?.iv_notification!!.visibility = View.VISIBLE
        mView?.ivProfileRight!!.visibility = View.GONE
        mView?.iv_notification!!.setImageResource(drawable)
        mView?.iv_notification!!.setOnClickListener(listener)

    }

    fun setBtnRightUser(drawable: Int, listener: OnClickListener?) {
        mView?.iv_notification!!.visibility = View.GONE
        mView?.ivProfileRight!!.visibility = View.VISIBLE
        mView?.ivProfileRight!!.setImageResource(drawable)
        mView?.ivProfileRight!!.setOnClickListener(listener)

    }


    fun setTitle(getActivityContext: MainActivity, title: String) {
        mView?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        mView?.tvTitle?.text = title
     *//*   mView?.ivBack?.visibility = View.GONE

        mView?.iv_notification?.visibility = View.VISIBLE*//*


    }*/



/*    fun setHideTitle() {
        resetTitlebar()
        mView?.rlTitlebarMainLayout?.setVisibility(View.VISIBLE)
        mView?.btnMenu?.visibility = View.INVISIBLE
    }*/
}