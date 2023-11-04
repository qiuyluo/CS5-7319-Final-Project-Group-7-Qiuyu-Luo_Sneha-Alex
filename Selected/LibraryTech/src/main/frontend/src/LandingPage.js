import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function LandingPage() {
    const [searchTerm, setSearchTerm] = useState('');
    const navigate = useNavigate();

    function handleSearch() {
        navigate(`/search/${searchTerm}`);
    }

    return (
        <div>
            <h1>Welcome to LibraryTech</h1>

            {/* Search Component */}
            <input
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                placeholder="Search for a book..."
            />
            <button onClick={handleSearch}>Search</button>

            {/* Sign In Button */}
            <button>Sign In</button>

            {/* Profile Button */}
            <button onClick={() => navigate('/profile')}>Profile</button>
        </div>
    );
}

export default LandingPage;
