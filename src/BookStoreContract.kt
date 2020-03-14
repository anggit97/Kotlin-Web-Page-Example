interface BookStoreContract {

    interface View{
        fun showBook(books: List<Book>)
        fun showLoader()
        fun hideLoader()
    }

    interface Presenter{
        fun attach(view: View)
        fun loadBook()
    }
}