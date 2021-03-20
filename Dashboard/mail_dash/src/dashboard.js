import React, { useState, useEffect } from 'react';
import './main.css';
import {PendingLetters} from './pendingLetters';
import {Newsletters} from './newsletters';
import {Logs} from './logs';
import {MailingList} from './mailingList';

const page = {
	PENDINGLETTERS: "pendingLetters",
	NEWSLETTERS: "newsletters",
	LOGS: "logs",
	MAILINGLIST: "mailingList",
}

export function Dashboard() {

    const [selectedPage, setSelectedPage] = useState(page.PENDINGLETTERS);
  
    return(
        <div>
            <button onClick={() => setSelectedPage(page.PENDINGLETTERS)}>Home(PendingLetters)</button>
            <button onClick={() => setSelectedPage(page.NEWSLETTERS)}>Newsletters</button>
            <button onClick={() => setSelectedPage(page.LOGS)}>Logs</button>
            <button onClick={() => setSelectedPage(page.MAILINGLIST)}>Mailing List</button>
            {selectedPage === page.PENDINGLETTERS && (<PendingLetters />)}
            {selectedPage === page.NEWSLETTERS && (<Newsletters />)}
            {selectedPage === page.LOGS && (<Logs />)}
            {selectedPage === page.MAILINGLIST && (<MailingList />)}
        </div>
    );

    
    
  }