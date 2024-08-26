'use client'

import {useState, useEffect} from 'react';

export default function HousePricesComponent() {
    const [housePrices, setHousePrices] = useState(null); // State to store the fetched data
    const [loading, setLoading] = useState(true); // State to manage loading state
    const [error, setError] = useState(null); // State to manage errors

    useEffect(() => {
        // Fetch data from the API when the component mounts
        const retrieveHousePrices = async () => {
            fetch('http://localhost:8080/housePrices')
                .then((response) => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then((data) => {
                    setHousePrices(data);
                })
                .catch((error) => {
                    setError(error.message);
                });
        };
        retrieveHousePrices().finally(() => setLoading(false));
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Fetched Data:</h1>
            <pre>{JSON.stringify(housePrices, null, 2)}</pre>
        </div>
    );
}