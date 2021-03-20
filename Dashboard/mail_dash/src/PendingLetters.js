import React, { useState, useEffect } from 'react';
import './main.css';

export function PendingLetters() {

  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [pendingLetters, setPendingLetters] = useState([]);

  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  useEffect(() => {
    fetch("http://localhost:8080/mailing/pendingMails")
      .then(res => res.json())
      //.then(data => console.log(data))
      .then(
        (result) => {
          setIsLoaded(true);
          setPendingLetters(result);
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
          <th>Email Address</th>
          <th>Newsletter ID</th>
          <th>Title</th>
          <th>Content</th>
          <th>Post date and time</th>
          <th>AttemptLeft</th>
        </tr>
        {pendingLetters.map(pending => (
          <tr key={pending.id}>
            <th>{pending.id}</th>
            <th>{pending.emailAddress}</th>
            <th>{pending.newsletterId}</th>
            <th>{pending.title}</th>
            <th>{pending.content}</th>
            <th>{pending.postDateTime}</th>
            <th>{pending.attemptLeft}</th>
          </tr>
        ))}
      </table>
    );
  }
}