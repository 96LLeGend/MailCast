import React, { useState, useEffect } from 'react';
import './main.css';

export function Newsletters() {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [newsletters, setNewsletters] = useState([]);
  
    // Note: the empty deps array [] means
    // this useEffect will run once
    // similar to componentDidMount()
    useEffect(() => {
      fetch("http://localhost:8080/mailing/newsletters")
        .then(res => res.json())
        //.then(data => console.log(data))
        .then(
          (result) => {
            setIsLoaded(true);
            setNewsletters(result);
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
            <th>Title</th>
            <th>Content</th>
            <th>Added date and time</th>
          </tr>
          {newsletters.map(newsletter => (
            <tr key={newsletter.id}>
              <th>{newsletter.id}</th>
              <th>{newsletter.title}</th>
              <th>{newsletter.content}</th>
              <th>{newsletter.postDateTime}</th>
            </tr>
          ))}
        </table>
      );
    }
  }