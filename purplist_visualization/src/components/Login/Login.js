import './Login.css';
import React, { useState } from "react"
import { GoogleLogin } from '@react-oauth/google';
export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email, password);
        alert("no datsa")
    }

    const responseMessage = (response) => {
        console.log(response);
    };
    const errorMessage = (error) => {
        console.log(error);
    };

    return (
        <div className="auth-form-container">
            <h1>Purplist</h1>
            <form onSubmit={handleSubmit} className="login-form">
                <label htmlFor="email">email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="youremail@mail.com" name="email" id="email" />

                <label htmlFor="password">password</label>
                <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password" />
                <button className="submit-btn" type="submit">Log In</button>
            </form>
            <div className='google-login-btn-wrapper'>
                <GoogleLogin onSuccess={responseMessage} onError={errorMessage} useOneTap className="google-login-btn" />
            </div>
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register here.</button>
        </div>
    )
}