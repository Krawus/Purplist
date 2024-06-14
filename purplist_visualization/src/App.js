import './App.css';
import React, { useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { Main } from "./components/Main/Main";
import { Auth } from "./views/auth/Auth";

const FIRST_PAGE_OPTIONS = {
  "login": 0,
  "register": 1
}

function App() {

  return (
    <div className='App'>
        <Auth />
       {/*<Main></Main>*/}
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
