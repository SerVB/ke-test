import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


class GreetTest {

    @Test
    fun testName() {
        val actual = greet("abc")
        val expected = "hi abc"

        assertEquals(expected, actual)
    }

    @Test
    fun testUnnamed() {
//        assertEquals("hi unnamed", greet(""))

        assertFailsWith<IllegalArgumentException> {
            greet("")
        }
    }
}