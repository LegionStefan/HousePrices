'use client'

import { useState, useEffect } from 'react';

export default function HousePricesComponent() {
    const [data, setData] = useState(null); // State to store the fetched data
    const [loading, setLoading] = useState(true); // State to manage loading state
    const [error, setError] = useState(null); // State to manage errors

    useEffect(() => {
        // Fetch data from the API when the component mounts
        fetch('http://localhost:8080/housePrices')
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((data) => {
                setData(data); // Update state with the fetched data
                setLoading(false); // Set loading to false as data is fetched
            })
            .catch((error) => {
                setError(error.message); // Handle any errors
                setLoading(false); // Set loading to false as there's an error
            });
    }, []); // Empty dependency array ensures this effect runs only once when the component mounts

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Fetched Data:</h1>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </div>
    );
}