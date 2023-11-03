import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function BookDetailPage() {
    const { id } = useParams();
    const [book, setBook] = useState(null);
    const [isHeldByUser, setIsHeldByUser] = useState(false); // 默认为false
    const userId = 4;

    useEffect(() => {
        axios.get(`/api/books/${id}`)
            .then(response => {
                setBook(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the book details:", error);
            });
    }, [id]);

    const handlePlaceHold = () => {
        axios.post(`/api/holds`, { userId: userId, bookId: id })
            .then(() => {
                setIsHeldByUser(true);
            })
            .catch(error => {
                console.error('Error placing a hold on the book', error);
            });
    };

    const handleCancelHold = () => {

        axios.delete(`/api/holds/book/${id}`)
            .then(() => {
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
                    {isHeldByUser ? (
                        <button onClick={handleCancelHold}>Cancel Hold</button>
                    ) : (
                        <button onClick={handlePlaceHold}>Place Hold</button>
                    )}
                </>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}

export default BookDetailPage;
