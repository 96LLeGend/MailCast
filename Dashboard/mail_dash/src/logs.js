import React, { useState, useEffect } from 'react';
import './main.css';

export function Logs() {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [logs, setLogs] = useState([]);
  
    // Note: the empty deps array [] means
    // this useEffect will run once
    // similar to componentDidMount()
    useEffect(() => {
      fetch("http://localhost:8080/mailing/sendingLogs")
        .then(res => res.json())
        //.then(data => console.log(data))
        .then(
          (result) => {
            setIsLoaded(true);
            setLogs(result);
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
            <th>ID</th>
            <th>EmailAddress</th>
            <th>Success?</th>
            <th>Sent Time</th>
            <th>Newsletter ID</th>
            <th>Newsletter Title</th>
            <th>Newsletter Content</th>
            <th>Newsletter Added Time</th>
          </tr>
          {logs.map(log => (
            <tr key={log.id}>
              <th>{log.id}</th>
              <th>{log.emailAddress}</th>
              <th>{log.success ? 'Ture' : 'False'}</th>
              <th>{log.sentDateTime}</th>
              <th>{log.newsletterId}</th>
              <th>{log.newsletter.title}</th>
              <th>{log.newsletter.content}</th>
              <th>{log.newsletter.postDateTime}</th>
            </tr>
          ))}
        </table>
      );
    }
  }