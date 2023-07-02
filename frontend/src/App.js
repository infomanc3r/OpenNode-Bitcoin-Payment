import React, { useState } from "react";
import logo from './logo.svg';
import './App.css';
import { Charge } from "./Charge";
import { Home } from "./Home";

function App() {
    const [currentForm, setCurrentForm] = useState('charge');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    return (
        <div className="App">
        {
            {
                'charge': <Charge onFormSwitch={toggleForm} />,
                'home': <Home onFormSwitch={toggleForm} />,

            }[currentForm]
        }
        </div>
    );
}

export default App;
