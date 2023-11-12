import React,{useState} from "react"
import Button from "../Common/Button/Button";
export const Login = (props) =>{
    const [login,setLogin] = useState('');
    const [password,setPassword] = useState('');

    const handleSubmit = async (e) =>{
        e.preventDefault();
        // console.log(login,password);

        // const requestBody = new FormData()
        // requestBody.append('username',login)
        // requestBody.append('password',password)
        const requestBody = {
            "username": login,
            "password": password
        }
        await fetch('http://localhost:8000/login',{
            method:"POST",
            mode:"no-cors",
            headers:{
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(requestBody),
            // body:requestBody,
        }).then(response => response.json()).then(json => console.log('json',json))
    }

    return(
        <div className="auth-form-container">
        <h1>Purplist</h1>
        <form onSubmit={handleSubmit} className="login-form">
            <label htmlFor="login">login</label>
            <input value={login} onChange={(e)=>setLogin(e.target.value)} type="login" placeholder="yourlogin" name="login" id="login"/>

            <label htmlFor="password">password</label>
            <input value={password} onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password"/>
            <Button styleClass="submit-btn" type="submit" text="Log In"/>
        </form>
        <button className="link-btn" onClick={()=>props.onFormSwitch('register')}>Don't have an account? Register here.</button>
        </div>            
    )
}