import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from 'react';

export function App() {
  return ( 
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export function Example() {
  // Declare a new state variable, which we'll call "count"  
  const [count, setCount] = useState(0);

  useEffect(() => {    
    document.title = `You clicked ${count} times`;  
  }, [count]);// Only re-subscribe if count changes

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </div>
  );
}
