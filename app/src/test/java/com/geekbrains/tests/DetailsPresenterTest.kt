package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    @Mock
    private lateinit var viewContractTest: ViewDetailsContract

    private lateinit var detailsPresenterTest : DetailsPresenter

    private val COUNT_TEST = 5

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        detailsPresenterTest = DetailsPresenter(viewContractTest)
    }

    @Test
    fun testMethodOnIncrement() {
        detailsPresenterTest.onIncrement()
        assertEquals(1, detailsPresenterTest.count)
        verify(viewContractTest, times(1)).setCount(Mockito.anyInt())
    }

    @Test
    fun testMethodOnDecrement() {
        detailsPresenterTest.onDecrement()
        assertEquals(-1, detailsPresenterTest.count)
        verify(viewContractTest, times(1)).setCount(Mockito.anyInt())
    }

    @Test
    fun testSetCounter() {
        detailsPresenterTest.setCounter(COUNT_TEST)
        assertEquals(COUNT_TEST, detailsPresenterTest.count)
    }
}