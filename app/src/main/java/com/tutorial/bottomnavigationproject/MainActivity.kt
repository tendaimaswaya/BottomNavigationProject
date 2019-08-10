package com.tutorial.bottomnavigationproject

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.tutorial.bottomnavigationproject.fragments.FragmentOne
import com.tutorial.bottomnavigationproject.fragments.FragmentThree
import com.tutorial.bottomnavigationproject.fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.util.ArrayList
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setupViewPager(pager)
        }

        private fun setupViewPager(viewPager: ViewPager){
            val adapter = ViewPagerAdapter(supportFragmentManager)
            setTabs(adapter)
           // viewPager.offscreenPageLimit = 3
            viewPager.adapter = adapter
            initTabLayout()
        }

        @SuppressLint("NewApi")
        fun setTabIcons(){
            tabLayout.getTabAt(0)!!.setIcon(ContextCompat.getDrawable(applicationContext,R.mipmap.ic_launcher))

            tabLayout.getTabAt(1)!!.setIcon(ContextCompat.getDrawable(applicationContext,R.mipmap.ic_launcher))

            tabLayout.getTabAt(2)!!.setIcon(ContextCompat.getDrawable(applicationContext,R.mipmap.ic_launcher))
        }

        @SuppressLint("NewApi")
        fun initTabLayout(){
            tabLayout!!.setupWithViewPager(pager)
            setTabIcons()

        }

        private fun setTabs(adapter:ViewPagerAdapter){
            adapter.addFragment(FragmentOne(), "")
            adapter.addFragment(FragmentTwo(), "")
            adapter.addFragment(FragmentThree(), "")
        }
}

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position:Int): CharSequence{
        return mFragmentTitleList.get(position)
    }

}
