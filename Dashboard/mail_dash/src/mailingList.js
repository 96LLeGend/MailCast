import React, { useState, useEffect } from 'react';
import './main.css';

export function MailingList() {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [mailingList, setMailingList] = useState([]);
  
    // Note: the empty deps array [] means
    // this useEffect will run once
    // similar to componentDidMount()
    useEffect(() => {
      fetch("http://localhost:8080/subscription/mailingList")
        .then(res => res.json())
        //.then(data => console.log(data))
        .then(
          (result) => {
            setIsLoaded(true);
            setMailingList(result);
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
            setIsLoaded(true);
            setError(error);
          }
        )
    }, [])
    
    if (error){
      return <div>Error: {error.message}</div>;
    } else if(!isLoaded){
      return <div>Loading...</div>;
    } else{
      return (
        <table>
          <tr>
            <th>EmailAddress</th>
            <th>Subscription Time</th>
          </tr>
          {mailingList.map(subs => (
            <tr key={subs.emailAddress}>
              <th>{subs.emailAddress}</th>
              <th>{subs.subscriptionTimestamp}</th>
            </tr>
          ))}
        </table>
      );
    }
  }