package com.example.wallpaperapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.wallpaperapp.ui.fragment.LatestFragment
import com.example.wallpaperapp.ui.fragment.PopularFragment
import com.example.wallpaperapp.ui.fragment.RandomFragment

class ViewPagerAdapter(
    fm: FragmentManager,
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0)
            fragment = LatestFragment()
        else if (position == 1)
            fragment = PopularFragment()
        else if (position == 2)
            fragment = RandomFragment()
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0)
            title = "Latest"
        else if (position == 1)
            title = "Popular"
        else if (position == 2)
            title = "Random"
        return title
    }
}