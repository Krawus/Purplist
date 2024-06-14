import './Auth.css';
import React, { useState } from "react"
import {Login} from "../../components/Login/Login";
import {Register} from "../../components/Register/Register";

const FORMS_TYPES = {
    "login": 0,
    "register": 1
}

export const Auth = (props) => {

    const [currentForm, setCurrentForm] = useState(FORMS_TYPES["login"]);
    return (
        <div className="flex flex-row justify-around w-full">
            <div className="hidden sm:block auth-text h-full self-center">
                <h2 className={'justify-center h-full items-center align-middle'}>
                    Just <br/>
                    <span style={{"--i":0}} data-text="note"> note</span>
                    <span style={{"--i":1}} data-text="share"> share</span>
                    <span style={{"--i":2}} data-text="keep"> keep</span>
                    <br/>
                    it.
                </h2>
            </div>
            {
                currentForm === FORMS_TYPES["login"] ? <Login onFormSwitch={(formName) => setCurrentForm(FORMS_TYPES[formName])} /> : <Register onFormSwitch={(formName) => setCurrentForm(FORMS_TYPES[formName])} />
            }
        </div>
    )
}