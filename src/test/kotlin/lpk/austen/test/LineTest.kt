package lpk.austen.test

import org.junit.Test
import org.junit.Assert
import lpk.austen.Line

class LineTest {
    @Test
    fun testEmpty() {
        val line = Line("")
        Assert.assertEquals(0, line.words().size)
    }

    @Test fun oneWord() {
        val line = Line("hello")
        val words = line.words()
        Assert.assertEquals(1, words.size)
        Assert.assertEquals("hello", words[0])
    }

    @Test fun twoWords() {
        val line = Line("hello there")
        val words = line.words()
        Assert.assertEquals(2, words.size)
        Assert.assertEquals("hello", words[0])
        Assert.assertEquals("there", words[1])
    }

    @Test fun doubleSpace() {
        val line = Line("a b")
        val words = line.words()
        Assert.assertEquals(2, words.size.toLong())
        Assert.assertEquals("a", words[0])
        Assert.assertEquals("b", words[1])
    }

    @Test fun wordsAreLowerCase() {
        val line = Line("Hello THERE")
        val words = line.words()
        Assert.assertEquals(2, words.size.toLong())
        Assert.assertEquals("hello", words[0])
        Assert.assertEquals("there", words[1])
    }

    @Test
    fun brackets() {
        val line = Line("(left, right)")
        val words = line.words()
        Assert.assertEquals(2, words.size)
        Assert.assertEquals("left", words[0])
        Assert.assertEquals("right", words[1])
    }

    @Test
    fun singleQuoteAfterComma() {
        val line = Line("week,' you")
        val words = line.words()
        Assert.assertEquals(2, words.size)
        Assert.assertEquals("week", words[0])
        Assert.assertEquals("you", words[1])
    }
}