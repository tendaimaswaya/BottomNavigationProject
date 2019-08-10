package com.tutorial.bottomnavigationproject

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import com.tutorial.bottomnavigationproject.fragments.FragmentOne
import com.tutorial.bottomnavigationproject.fragments.FragmentThree
import com.tutorial.bottomnavigationproject.fragments.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            setupViewPager(pager)
        }
    //the ViewPager will be responsible for navigating through your fragments even when you need to slide through them
        private fun setupViewPager(viewPager: ViewPager){
            val adapter = ViewPagerAdapter(supportFragmentManager)
            setTabs(adapter)
           // viewPager.offscreenPageLimit = 3
            viewPager.adapter = adapter
            initTabLayout()
        }
        //assign icons to the TabLayout
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

    //assign Fragments associated with a specific Tab Item
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
