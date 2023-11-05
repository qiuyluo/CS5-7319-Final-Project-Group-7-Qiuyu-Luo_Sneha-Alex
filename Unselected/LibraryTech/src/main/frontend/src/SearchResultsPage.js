import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

function SearchResultsPage() {
    const { keyword } = useParams();
    const [books, setBooks] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get(`/api/books/search?keyword=${keyword}`)
            .then(response => setBooks(response.data));
    }, [keyword]);


    return (
        <div>
            <h2>Search Results</h2>
            {books.map(book => (
                <div key={book.id}>
                    <span onClick={() => navigate(`/book/${book.id}`)}>{book.title}</span>
                </div>
            ))}
        </div>
    );
}

export default SearchResultsPage;
