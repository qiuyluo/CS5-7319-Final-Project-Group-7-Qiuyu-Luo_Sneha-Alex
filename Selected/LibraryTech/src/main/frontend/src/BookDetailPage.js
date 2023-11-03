import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

function BookDetailPage() {
    const { id } = useParams();
    const navigate = useNavigate();

    const [book, setBook] = useState(null);
    const [holds, setHolds] = useState([]);
    const [isHeldByUser, setIsHeldByUser] = useState(false); // This should be determined based on the hold info and current user
    const userId = 1;

    useEffect(() => {
        // Fetch book details
        axios.get(`/api/books/${id}`)
            .then(response => {
                setBook(response.data);
                // 简单起见，不再返回hold info
            })
            .catch(error => {
                console.error("There was an error fetching the book details:", error);
            });
    }, [id, userId]);

    const handlePlaceHold = () => {
        axios.post(`/api/holds`, { userId: userId, bookId: book.id })
            .then(response => {
                setHolds(prevHolds => [...prevHolds, response.data]);
                setIsHeldByUser(true);
            })
            .catch(error => {
                console.error('Error placing a hold on the book', error);
            });
    };

    const handleCancelHold = () => {
        const holdId = holds.find(hold => hold.userId === userId).id;
        axios.delete(`/api/holds/${holdId}`)
            .then(() => {
                setHolds(prevHolds => prevHolds.filter(hold => hold.userId !== userId));
                setIsHeldByUser(false);
            })
            .catch(error => {
                console.error('Error canceling the hold on the book', error);
            });
    };

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
                            User ID: {hold.user}, Date: {new Date(hold.holdDate).toLocaleDateString()}
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

export default BookDetailPage;
