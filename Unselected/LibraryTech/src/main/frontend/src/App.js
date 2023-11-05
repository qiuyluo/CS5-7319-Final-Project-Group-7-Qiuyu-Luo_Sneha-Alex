import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LandingPage from './LandingPage';
import SearchResultsPage from './SearchResultsPage';
import UserProfilePage from './UserProfilePage';
import BookDetailPage from './BookDetailPage';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LandingPage />} />
                <Route path="/search/:keyword" element={<SearchResultsPage />} />
                <Route path="/profile" element={<UserProfilePage />} />
                <Route path="/book/:id" element={<BookDetailPage />} />
            </Routes>
        </Router>
    );
}

export default App;
