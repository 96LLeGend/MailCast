import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {App, Example} from './App';
import {PendingLetters} from './pendingLetters';

ReactDOM.render(
  <React.StrictMode>
    <PendingLetters />
  </React.StrictMode>,
  document.getElementById('root')
);
