import React from 'react'
import axios from 'axios'
import { useEffect, useState } from 'react'
import '../css/Input.css'

function Container() {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [data, setData] = useState({});
    const [city, setCity] = useState("");
    const [weather, setWeather] = useState([]);

    const BASE_URL = "/rest/api/weather?city="



    const getData = async (city) => {
        setIsLoaded(false)
        setError(null)
        try {
            console.clear();
            const response = await axios.get(BASE_URL + city)
            if (response.status == 200 && response.data) {
                setData(response.data.data);
                setIsLoaded(true);
                setError(null)
                setWeather(response.data.data.hourly.temperature_2m)
                console.log(response.data.data.hourly.temperature_2m);
            } else {
                setError("Empty data");
                setIsLoaded(true);
            }

        } catch (err) {
            setError(err.message);
            setIsLoaded(true);
        }

    }
    useEffect(() => {
        getData("Ankara");
        console.log(data);
    }, [city])


    const handleChange = (e) => {
        setCity(e.target.value)
    }

    const handleSubmit = () => {
        if (city) {
            getData(city);
        }

    }

    const weatherDisplay = (weather) => {
        let days = [];
        for (let i = 0; i < weather.length; i += 24) {
            days.push(weather.slice(i, i + 24));
        }
        console.log(days)
        console.log(weather.length)
        return days
    }

    const getDayAndTime = (dayIndex, hourIndex) => {
        const day = dayIndex + 1;
        const time = getTimeLabel(hourIndex);
        const temp = weather[dayIndex * 24 + hourIndex];
        return `Day ${day} ${time}: ${temp} °C `
    }

    const getTimeLabel = (index) => {
        const hour = index % 24
        return `${hour < 10 ? '0' : ''}${hour}:00`;
    }


    return (
        <div className='container'>
            <div className="inputCity">
                <input
                    type="text"
                    onChange={handleChange}
                    placeholder='Enter the city' />
            </div>
            <div className='getButton'><button className='handleButton' onClick={handleSubmit}>Get Weather</button>
            </div>
            <div className='data'>
                {isLoaded ? (
                    <div>
                        {error ? (
                            <p>{error}</p>
                        ) : (
                            <div className='succes-data'>
                                <h1 className='latitude'> Latitude = {data.latitude}</h1>
                                <h1 className='longitude'>Longitude = {data.longitude}</h1>
                                <h1 className='timezone'>Timezone = {data.timezone}</h1>
                                <div className='weatherForecast'>
                                    <ul>
                                        {weatherDisplay(weather).map((day, dayIndex) => (
                                            <div key={dayIndex} className='day'>
                                                <h2>Day {dayIndex + 1}</h2>
                                                {day.map((temp, hourIndex) => (
                                                    <li key={hourIndex}>
                                                        {getDayAndTime(dayIndex, hourIndex)}
                                                    </li>
                                                ))}
                                            </div>
                                        ))}
                                    </ul>
                                </div>
                            </div>
                        )}
                    </div>
                ) : (<p>Veriler Yükleniyor...</p>)}
            </div>
        </div >



    )
}

export default Container