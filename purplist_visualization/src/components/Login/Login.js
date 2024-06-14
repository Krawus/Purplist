import './Login.css';
import React, {useState} from "react"
import {GoogleLogin} from '@react-oauth/google';

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
        <div className="flex flex-col bg-white p-3 rounded-xl m-2 sm:w-[50vw] w-screen sm: shadow-xl sm:aspect-1">
            <h1 className={"text-5xl my-6 font-semibold justify-center flex grow-[2]"}>
                Purplist
            </h1>
            <form id={"login-form"} className={"flex flex-col grow-[4] mt-6 mb-6"}>
                <span className={"flex flex-col my-6 mx-6 text-left"}>
                    <label for="email">Your email</label>
                    <input type="email" id="email" name="email" placeholder="youremail@mail.com" value={email}></input>
                </span>
                <span className={"flex flex-col my-6 mx-6 text-left"}>
                    <label for="password">Password</label>
                    <input type="password" name="password" placeholder={"password"} value={password}></input>
                </span>
                <button className={"bg-red-500"} type="submit">Submit</button>
            </form>
            {/*<h1 className={"font-black text-5xl font-semibold mb-[60px] bg-[size:400%_400%] bg-[color:var(--gradient)] bg-clip-text animate-auth-text-anim"}>Purplist</h1>*/}
            {/*<form onSubmit={handleSubmit} className="flex flex-col">*/}
            {/*    <label className={"text-left pt-1 pb-1 uppercase font-semibold text-sm"} htmlFor="email">email</label>*/}
            {/*    <input value={email} onChange={(e) => setEmail(e.target.value)} type="email"*/}
            {/*           placeholder="youremail@mail.com" name="email" id="email"/>*/}

            {/*    <label className={"text-left pt-1 pb-1 uppercase font-semibold text-sm"}*/}
            {/*           htmlFor="password">password</label>*/}
            {/*    <input value={password} onChange={(e) => setPassword(e.target.value)} type="password"*/}
            {/*           placeholder="********" name="password" id="password"/>*/}
            {/*    <button*/}
            {/*        className="text-white bg-btn-gradient hover:border-[1px] hover:border-amber-500 hover:rounded-[10px] shadow-md"*/}
            {/*        type="submit">Log In*/}
            {/*    </button>*/}
            {/*</form>*/}
            {/*<div className='google-login-btn-wrapper'>*/}
            {/*    <GoogleLogin onSuccess={responseMessage} onError={errorMessage} useOneTap className="google-login-btn"/>*/}
            {/*</div>*/}
            {/*<button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register*/}
            {/*    here.*/}
            {/*</button>*/}
        </div>
    )
}