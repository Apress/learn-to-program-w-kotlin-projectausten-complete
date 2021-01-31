package lpk.austen

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun main() {
    val book = Book(Paths.get("src/main/resources/books/PrideAndPrejudice.txt"))
    val histogram = book.histogram()
    val totalWords = histogram.totalWords()
    println("Total word count: $totalWords")
    val file = Paths.get("PandPWords.csv")
    histogram.toCSV(file)
}

/**
 * Reads a book from a text file and produces word usage information.
 */
class Book(bookFile : Path) {
    val histogram = Histogram()

    init {
        val lines = Files.readAllLines(bookFile)
        for (str in lines) {
            val line = Line(str)
            for (word in line.words()) {
                histogram.record(word)
            }
        }
    }

    fun histogram(): Histogram {
        return histogram;
    }
}