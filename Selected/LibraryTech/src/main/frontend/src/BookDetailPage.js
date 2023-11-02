function BookDetailPage({ match }) {
    const [book, setBook] = useState(null);
    const [holdInfo, setHoldInfo] = useState([]);
    const [isHeldByUser, setIsHeldByUser] = useState(false); // This should be determined based on the hold info and current user
    const history = useHistory();

    useEffect(() => {
        // Fetch book details
        axios.get(`/api/books/${match.params.id}`)
            .then(response => {
                setBook(response.data);
                setHoldInfo(response.data.holds); // assuming that holds are part of the book details response
                setIsHeldByUser(response.data.holds.some(hold => hold.userId === 1)); // Assuming user ID is 1 for now
            })
            .catch(error => {
                console.error("There was an error fetching the book details:", error);
            });
    }, [match.params.id]);

    function handlePlaceHold() {
        axios.post(`/api/books/${book.id}/hold`)
            .then(response => {
                if(response.status === 200) {
                    alert("Hold placed successfully");
                    setIsHeldByUser(true);
                } else {
                    alert("Failed to place hold");
                }
            })
            .catch(error => {
                console.error("There was an error placing the hold:", error);
            });
    }

    function handleCancelHold() {
        axios.delete(`/api/books/${book.id}/cancelHold`)
            .then(response => {
                if(response.status === 200) {
                    alert("Hold cancelled successfully");
                    setIsHeldByUser(false);
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
            {book ? (
                <>
                    <h2>{book.title} by {book.author}</h2>
                    <p>Genre: {book.genre}</p>
                    <p>Topic: {book.topic}</p>
                    <h3>Holds:</h3>
                    {holdInfo.map(hold => (
                        <div key={hold.id}>
                            User ID: {hold.userId}, Date: {new Date(hold.date).toLocaleDateString()}
                        </div>
                    ))}
                    {!isHeldByUser ? (
                        <button onClick={handlePlaceHold}>Place Hold</button>
                    ) : (
                        <button onClick={handleCancelHold}>Cancel Hold</button>
                    )}
                </>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}
