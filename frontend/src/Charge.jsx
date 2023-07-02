import React, { useState } from "react";
import axios from 'axios';

export const Charge = (props) => {
    const [id, setId] = useState("");
    const [amount, setAmount] = useState("");

    async function createCharge(event) {
        event.preventDefault();
        const reqBody = {
            id: id,
            amount: amount,
        };
        const body = JSON.stringify(reqBody);
        const headers = {
            'Content-Type': 'application/json',
            'Authorization': 'fbf61361-d7f0-4a85-a880-e58566edec42'
            };
        var response;
        var response2;
        try {
            response = await axios.post('https://dev-api.opennode.com/v1/charges', body, { headers });
        } catch(exception) {
            alert("Request failed");
        }
        try {
            response2 = await axios.post('http://localhost:8080/opennode/charge', body, { headers });
        } catch (exception) {
            alert("Request failed");}

        alert("Order successfully created! Payment window will open in a new tab.");
        window.open(response.data.data.hosted_checkout_url, '_blank');
        props.onFormSwitch('home');

    }

    return (
        <div className="auth-form-container">
            <h2>OpenNode Charge Button</h2>
            <form className="login-form" onSubmit={(event) => createCharge(event)}>
                <label htmlFor="id">Order ID for testing: </label>
                <input
                    value={id}
                    onChange={(event) => setId(event.target.value)}
                    type="id"
                    placeholder="Enter the Order ID"
                    id="id"
                    name="id" />
                <label htmlFor="amount">Amount: </label>
                <input
                    value={amount}
                    onChange={(event) => setAmount(event.target.value)}
                    type="amount"
                    placeholder="Enter the amount"
                    id="amount"
                    name="amount" />
                <button type="submit">Submit</button>
            </form>
        </div>
    )
}