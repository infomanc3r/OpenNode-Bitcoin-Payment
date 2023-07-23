import React, { useState } from "react";
import logo from './logo.svg';
import './App.css';
import { Charge } from "./Charge";
import { Home } from "./Home";
import { Pending } from "./Pending";
import { Congrats } from "./Congrats";

function App() {
    const [currentForm, setCurrentForm] = useState('charge');
    const [currentId, setCurrentId] = useState('test');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    const toggleId = (id) => {
        setCurrentId(id);
    }

    return (
        <div className="App">
        {
            {
                'charge': <Charge onFormSwitch={toggleForm} updateId={toggleId} />,
                'home': <Home onFormSwitch={toggleForm} updateId={toggleId} />,
                'pending': <Pending onFormSwitch={toggleForm} updateId={toggleId} />,
                'congrats': <Congrats onFormSwitch={toggleForm} updateId={toggleId} currentId={currentId} />,

            }[currentForm]
        }
        </div>
    );
}

export default App;
