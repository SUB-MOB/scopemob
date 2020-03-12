package com.github.mustafaozhan.scopemob.scope

import org.junit.Assert
import org.junit.Test

class WhetherScopeTest : MainScopeTest() {

    @Test
    fun `whether true`() {
        subjectFunction
            ?.whether { it.trueCondition }
            ?.whether { trueCondition }
            ?.let { Assert.assertTrue(Companion.EXPECTED, true) }
            ?: run { Assert.fail(Companion.UN_EXPECTED) }

        // vararg
        subjectFunction
            ?.whether({ it.trueCondition }, { trueCondition })
            ?.let { Assert.assertTrue(Companion.EXPECTED, true) }
            ?: run { Assert.fail(Companion.UN_EXPECTED) }
    }

    @Test
    fun `whether  false`() {
        subjectFunction
            ?.whether { it.falseCondition }
            ?.whether { falseCondition }
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }

        // vararg
        subjectFunction
            ?.whether({ it.falseCondition }, { falseCondition })
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }
    }

    @Test
    fun `whether mix`() {
        subjectFunction
            ?.whether { it.trueCondition }
            ?.whether { falseCondition }
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }

        // vararg
        subjectFunction
            ?.whether({ it.trueCondition }, { falseCondition })
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }
    }

    @Test
    fun `whetherNot false`() {
        subjectFunction
            ?.whetherNot { it.falseCondition }
            ?.whetherNot { falseCondition }
            ?.let { Assert.assertTrue(Companion.EXPECTED, true) }
            ?: run { Assert.fail(Companion.UN_EXPECTED) }

        // vararg
        subjectFunction
            ?.whetherNot({ it.falseCondition }, { falseCondition })
            ?.let { Assert.assertTrue(Companion.EXPECTED, true) }
            ?: run { Assert.fail(Companion.UN_EXPECTED) }
    }

    @Test
    fun `whetherNot true`() {
        subjectFunction
            ?.whetherNot { it.trueCondition }
            ?.whetherNot { trueCondition }
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }

        // vararg
        subjectFunction
            ?.whetherNot({ it.trueCondition }, { trueCondition })
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }
    }

    @Test
    fun `whetherNot mix`() {
        subjectFunction
            ?.whetherNot { it.falseCondition }
            ?.whetherNot { trueCondition }
            ?.let { Assert.fail(Companion.UN_EXPECTED) }
            ?: run { Assert.assertTrue(Companion.EXPECTED, true) }

        // vararg
        subjectFunction
            ?.whetherNot({ it.falseCondition }, { trueCondition })
            ?.let { Assert.assertTrue(Companion.EXPECTED, true) }
            ?: run { Assert.fail(Companion.UN_EXPECTED) }
    }
}
