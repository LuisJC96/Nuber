package com.example.nuber

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class NuberPagerAdapter(fm: FragmentManager):FragmentPagerAdapter(fm){
    override fun getItem(p0: Int): Fragment
    {
        return when(p0)
        {
            0 -> NUberMapsActivity()
            1 -> NuberShoppingFragment()
            else -> NuberProductsFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence?
    {
        return when(position)
        {
            0 -> "Mapa Nuber"
            1 -> "Shopping"
            else -> "My Shopping Car"
        }
    }

    override fun getCount(): Int {
        return 3
    }

}