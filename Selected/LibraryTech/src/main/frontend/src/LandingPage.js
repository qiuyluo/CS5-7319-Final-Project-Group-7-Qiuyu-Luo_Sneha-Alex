import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

function LandingPage() {
    const [searchTerm, setSearchTerm] = useState('');
    const history = useHistory();

    function handleSearch() {
        history.push(`/search/${searchTerm}`);
    }

    return (
        <div>
            <h1>Welcome to Library System</h1>

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
            <button onClick={() => history.push('/profile')}>Profile</button>
        </div>
    );
}

export default LandingPage;
