import './App.css';
import React,{useState} from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import Dashboard from './components/Dashboard/Dashboard';
import Preferences from './components/Preferences/Preferences';
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';

const FIRST_PAGE_OPTIONS = {
  "login" :0,
  "register" :1
}

function App() {

  const [currentForm,setCurrentForm] = useState(0);


  const toggleForm = (formName)=>{
    setCurrentForm(FIRST_PAGE_OPTIONS[formName]);
}


  return (
    <div className='wrapper'>
      {
        
        currentForm === FIRST_PAGE_OPTIONS["login"] ? <Login onFormSwitch={toggleForm}/> : <Register onFormSwitch={toggleForm}/>
      }
      {/* <Login path='/' /> */}

      {/* <BrowserRouter>
      <Routes>
        <Route path='/dashboard'>
          <Dashboard/>
        </Route>
        <Route>
          <Preferences/>
        </Route>
        <Route>
          <Login path='/' />
        </Route>
      </Routes>
      </BrowserRouter> */}
    </div>
  );
}

export default App;
