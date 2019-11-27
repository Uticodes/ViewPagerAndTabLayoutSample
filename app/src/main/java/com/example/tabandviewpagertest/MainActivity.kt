package com.example.tabandviewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.tabandviewpagertest.adapter.CustomPagerAdapter
import com.example.tabandviewpagertest.ui.fragment.FragmentOne
import com.example.tabandviewpagertest.ui.fragment.FragmentThree
import com.example.tabandviewpagertest.ui.fragment.FragmentTwo
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*

class MainActivity : AppCompatActivity() {
    var pagerAdapter: CustomPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        pagerAdapter = CustomPagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FragmentOne(),"One")
        pagerAdapter!!.addFragments(FragmentTwo(), "Two")
        pagerAdapter!!.addFragments(FragmentThree(), "Three")

        costomViewPager.adapter = pagerAdapter
        //setting up viewPager with tablayout
        costomTabLayout.setupWithViewPager(costomViewPager)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = CustomPagerAdapter(supportFragmentManager)
        adapter.addFragments(Fragment(), "ONE")
        adapter.addFragments(Fragment(), "TWO")
        adapter.addFragments(Fragment(), "THREE")
        viewPager.adapter = adapter

        //adding pagerAdapter to ViewPager
        costomViewPager.adapter = pagerAdapter
        //setting up viewPager with tablayout
        costomTabLayout.setupWithViewPager(costomViewPager)
    }

//    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
//        private val mFragmentList = ArrayList<Fragment>()
//        private val mFragmentTitleList = ArrayList<String>()
//
//        override fun getItem(position: Int): Fragment {
//            return mFragmentList[position]
//        }
//
//        override fun getCount(): Int {
//            return mFragmentList.size
//        }
//
//        fun addFragment(fragment: Fragment, title: String) {
//            mFragmentList.add(fragment)
//            mFragmentTitleList.add(title)
//        }
//
//        override fun getPageTitle(position: Int): CharSequence {
//            return mFragmentTitleList[position]
//        }
//    }
}
