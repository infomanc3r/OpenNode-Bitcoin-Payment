import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Circles } from 'react-loader-spinner';

export const Pending = (props) => {
    useEffect(() => {
        const intervalCall = setInterval(() => {
          checkStatus();
        }, 20000);
        return () => {
          // clean up
          clearInterval(intervalCall);
        };
      }, []);

    const delay = ms => new Promise(
      resolve => setTimeout(resolve, ms)
    );

    async function checkStatus(event) {
        const reqBody = {
            orderId: "1200",
        };
        const body = JSON.stringify(reqBody);
        const headers = {
            'Content-Type': 'application/json',
        };
        var response;
        try {
            response = await axios.get('http://localhost:8080/webhooks/status', body, { headers });
        } catch(exception) {
            console.log("exception with post request")
            console.log(exception);
            await delay(5000);
        }
        console.log(response);
        if (response != null) {
            if (response.status != 200) {
                checkStatus(event);
            } else {
                props.onFormSwitch('congrats');
            }
        }
    }

    return (
        <div className="pending-container">
            <h1>Payment Pending</h1>
            <Circles
              height="80"
              width="80"
              color="white"
              ariaLabel="circles-loading"
              wrapperStyle={{display: 'flex', justifyContent: 'center', alignItems: 'center'}}
              wrapperClass=""
              visible={true}
            />
            <br></br>
            Waiting for payment to be completed.
            <br></br>
            Once your payment is completed, you will be automatically redirected to the download page.
        </div>

    )
}