import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {App, Example} from './App';
import {Dashboard} from './dashboard'

ReactDOM.render(
  <React.StrictMode>
    <Dashboard />
  </React.StrictMode>,
  document.getElementById('root')
);
