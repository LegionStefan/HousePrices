'use client'

import {useState, useEffect} from 'react';

import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)
import { Line } from "react-chartjs-2";

export default function HousePricesComponent() {
    type housePrice = {
        id: number,
        date: Date,
        priceFormatted: string,
        price: number,
    };
    const [housePrices, setHousePrices] = useState<Array<housePrice>>([]); // State to store the fetched data
    const [loading, setLoading] = useState<boolean>(true); // State to manage loading state
    const [error, setError] = useState<string>(''); // State to manage errors

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
            <div style={{backgroundColor: 'white'}}>
                <Line
                    data={{
                        labels: housePrices.map((housePrice: housePrice) => housePrice.date),
                        datasets: [
                            {
                                label: 'House Price',
                                data: housePrices.map((housePrice: housePrice) => housePrice.price),
                                fill: false,
                                borderColor: 'rgb(75, 192, 192)',
                                tension: 0.1
                            },
                        ],
                    }}/>
            </div>
            <pre>{JSON.stringify(housePrices, null, 2)}</pre>
        </div>
    );
}