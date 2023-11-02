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
                <Route path="/" exact component={LandingPage} />
                <Route path="/search/:keyword" component={SearchResultsPage} />
                <Route path="/profile" component={UserProfilePage} />
                <Route path="/book/:id" component={BookDetailPage} />
            </Routes>
        </Router>
    );
}

export default App;
