import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

class BookStorePage(
        private val presenter: BookStoreContract.Presenter
) : BookStoreContract.View {

    private val loader = document.getElementById("loader") as HTMLDivElement
    private val content = document.getElementById("content") as HTMLDivElement

    private val cardBuilder = CardBuilder()

    override fun showBook(books: List<Book>) {
        books.forEach {
            val card = cardBuilder.build(it)
            content.appendChild(card)
        }
    }

    fun show() {
        presenter.attach(this)
        presenter.loadBook()
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }
}