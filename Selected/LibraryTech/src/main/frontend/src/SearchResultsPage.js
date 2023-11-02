function SearchResultsPage({ match }) {
    const [books, setBooks] = useState([]);
    const history = useHistory();

    useEffect(() => {
        axios.get(`/api/books/search?keyword=${match.params.keyword}`)
            .then(response => setBooks(response.data));
    }, [match.params.keyword]);

    function handlePlaceHold(bookId) {
        axios.post(`/api/books/${bookId}/hold`)
            .then(response => {
                if(response.status === 200) {
                    alert("Hold placed successfully");
                } else {
                    alert("Failed to place hold");
                }
            })
            .catch(error => {
                console.error("There was an error placing the hold:", error);
            });
    }

    function handleCancelHold(bookId) {
        axios.delete(`/api/books/${bookId}/cancelHold`)
            .then(response => {
                if(response.status === 200) {
                    alert("Hold cancelled successfully");
                } else {
                    alert("Failed to cancel hold");
                }
            })
            .catch(error => {
                console.error("There was an error cancelling the hold:", error);
            });
    }

    return (
        <div>
            <h2>Search Results</h2>
            {books.map(book => (
                <div key={book.id}>
                    <span onClick={() => history.push(`/book/${book.id}`)}>{book.title}</span>
                    <button onClick={() => handlePlaceHold(book.id)}>Place Hold</button>
                    <button onClick={() => handleCancelHold(book.id)}>Cancel Hold</button>
                </div>
            ))}
        </div>
    );
}
