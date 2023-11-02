function UserProfilePage() {
    const [holds, setHolds] = useState([]);
    const [recommendations, setRecommendations] = useState([]);
    const history = useHistory();

    useEffect(() => {
        // Assuming user ID is 1 for now
        const userId = 1;

        // Fetch holds for the user
        axios.get(`/api/users/${userId}/holds`)
            .then(response => setHolds(response.data))
            .catch(error => {
                console.error("There was an error fetching the holds:", error);
            });

        // Fetch book recommendations for the user
        axios.get(`/api/users/${userId}/recommendations`)
            .then(response => setRecommendations(response.data))
            .catch(error => {
                console.error("There was an error fetching the recommendations:", error);
            });
    }, []);

    return (
        <div>
            <h2>Your Holds</h2>
            {holds.map(hold => (
                <div key={hold.id} onClick={() => history.push(`/book/${hold.book.id}`)}>
                    {hold.book.title}
                </div>
            ))}

            <h2>Recommendations for you</h2>
            {recommendations.map(book => (
                <div key={book.id} onClick={() => history.push(`/book/${book.id}`)}>
                    {book.title}
                </div>
            ))}
        </div>
    );
}
