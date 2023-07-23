import React, { useState, useEffect } from "react";
import axios from 'axios';
import ConfettiExplosion, { ConfettiProps } from 'react-confetti-explosion';

export const Congrats = (props) => {

    useEffect(() => {
        setIsLargeExploding(!isLargeExploding);
    }, []);

    const largeProps: ConfettiProps = {
        force: 0.8,
        duration: 3000,
        particleCount: 300,
        width: 1600,
        colors: ['#041E43', '#1471BF', '#5BB4DC', '#FC027B', '#66D805'],
    };

    const [isLargeExploding, setIsLargeExploding] = React.useState(false);

    return (
        <div className="auth-form-container" onMouseEnter={() => setIsLargeExploding(!isLargeExploding)}>
            {isLargeExploding && <ConfettiExplosion {...largeProps} />}
            <h2>CONGRATULATIONS!</h2>
            Your download link is: <a href="https://imgur.com/1Yjowxi" target="_blank">https://imgur.com/1Yjowxi</a>
        </div>
    )
}