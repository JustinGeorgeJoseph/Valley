package com.justin.valley.utils

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class HomeViewModelUtilsKtTest : TestCase() {

    @Test
    fun `Test getSublist with empty list`() {
        val list = emptyList<String>()
        assertEquals(0, getSublist(list, 2).size)
    }

    @Test
    fun `Test getSublist with less than 6 item`() {
        val list = arrayListOf(0, 1, 2)
        assertEquals(2, getSublist(list, 2).size)
    }

    @Test
    fun `Test getSublist with more than 6 item`() {
        val list = arrayListOf(0, 1, 2,3,4,5,6,7,8)
        assertEquals(6, getSublist(list, 6).size)
    }


    @Test
    fun `Test getSublist with less than max item`() {
        val list = arrayListOf(0, 1, 2,3,4,5,6,7,8)
        assertEquals(9, getSublist(list, 10).size)
    }


}