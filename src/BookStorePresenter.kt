import org.w3c.xhr.XMLHttpRequest

class BookStorePresenter : BookStoreContract.Presenter {

    private lateinit var view: BookStoreContract.View

    override fun attach(view: BookStoreContract.View) {
        this.view = view
    }

    override fun loadBook() {
        view.showLoader()
        getAsync(API_URL) { response ->
            val books = JSON.parse<Array<Book>>(response)
            view.hideLoader()
            view.showBook(books.toList())
            books.forEach {
                println(it.title)
            }
        }
    }

    // 1
    private fun getAsync(url: String, callback: (String) -> Unit) {
        // 2
        val xmlHttp = XMLHttpRequest()
        // 3
        xmlHttp.open("GET", url)
        // 4
        xmlHttp.onload = {
            // 5
            if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
                // 6
                callback.invoke(xmlHttp.responseText)
            }
        }
        // 7
        xmlHttp.send()
    }
}