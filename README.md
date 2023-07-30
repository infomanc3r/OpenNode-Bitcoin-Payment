# OpenNode Bitcoin Payment Demo
A demo integrating the [OpenNode API](https://www.opennode.com/bitcoin-api/) to enable generation/storage of an OpenNode bitcoin invoice. 

The order is managed in a persistent local database using [Spring Hibernate](https://docs.spring.io/spring-framework/reference/data-access/orm/hibernate.html). 
The backend API listens for webhooks fired by OpenNode whenever the invoice is fulfilled.
If the invoice is successfully paid, the frontend will notify you by redirecting to a "download" page and blasting confetti! 🎊🥳🎉

## Setup
1. Currently runs on OpenNode's developer network, using testnet bitcoin - you will need to add your OpenNode API key for the real network on line 19 of the "Charge.jsx" file.

2. In this demo I used [ngrok](https://ngrok.com/) to forward webhooks to the backend API locally without actually requiring webhosting. You will need to update the callback_url parameter on line 13 of "Charge.jsx" to take advantage of webhooks and update your frontend when the invoice is successfully paid. Set this parameter to the URL that points to the /webhooks/update API endpoint in your setup.
