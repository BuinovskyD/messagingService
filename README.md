Publisher/Subscriber service application. Publisher (package ru.buinovsky.publisher) create json for request and send it to the Subscriber by POST via HTTP using HttpClient and HttpRequest.
Subscriber (package ru.buinovsky.subscriber) recieve post HTTP request from Publisher via RestController, 
parses data and saves it to the database (Postgers).
