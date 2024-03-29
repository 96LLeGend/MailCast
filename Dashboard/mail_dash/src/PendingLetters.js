import React, { useState, useEffect } from 'react';
import './main.css';

const sendingState = {
	COMPLETE: "complete",
	COMPLETEWITHERROR: "completeWithError",
	SENDING: "sending",
	IDLE: "idle",
}

export function PendingLetters() {

  const [sendLetterState, setSendLetterState] = useState(sendingState.IDLE);
  const [sendLetterMessage, setSendLetterMessage] = useState('');
  const triggerReloadList = true;
  const [content, setContent] = useState('');
  const [title, setTitle] = useState('');

  const PostNewsletter = () => {
    setSendLetterState(sendingState.SENDING);
    setSendLetterMessage('Sending...');

    // POST request using fetch inside useEffect React hook
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ 
        title: title,
        content: content
      })
    };

    fetch('http://localhost:8080/mailing/newsletter', requestOptions)
      .then(response => response.json()
      //.then(data => console.log(data))
      .then(
        (result) => {
          if(response.status === 200){
            setSendLetterState(sendingState.COMPLETE);
            setSendLetterMessage('Sent successful!');
            setTitle('');
            setContent('');
          } else {
            setSendLetterState(sendingState.COMPLETEWITHERROR);
            setSendLetterMessage('Sent failure!');
          }
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setSendLetterState(sendingState.COMPLETEWITHERROR);
          setSendLetterMessage('Sent failure!');
        }
      )
    );
  }

  return (
    <div>
      <PendingLettersForm key={triggerReloadList}/>
      <div style = {{display : 'flex', gap : 20, marginTop : 50, marginLeft : '40%'}}>
        <div>
          {sendLetterState !== sendingState.SENDING && 
            (<form onSubmit={PostNewsletter}>       
              <label>
                Ttile:
                <input type="text" value={title} onChange={v => setTitle(v.target.value)} />        
              </label>
              <label>
                Content:
                <input type="text" value={content} onChange={v => setContent(v.target.value)} />        
              </label>
              <input type="submit" value="Submit" />
            </form>)}
        </div>
        <div>{sendLetterMessage}</div>
      </div>
    </div>
  );
}


function PendingLettersForm(triggerReloadList) {

  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [pendingLetters, setPendingLetters] = useState([]);

  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  useEffect(() => {
    console.log('data');
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
  }, [triggerReloadList])
  
  if(error){
    return <div>Error: {error.message}</div>;
  }else if(!isLoaded){
    return <div>Loading...</div>;
  }else{
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