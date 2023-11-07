import React,{useState} from "react"
import Button from "../Common/Button";
export const Login = (props) =>{
    const [login,setLogin] = useState('');
    const [password,setPassword] = useState('');

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(login,password);

        const requestBody = new FormData()
        requestBody.append('username',login)
        requestBody.append('password',password)

        fetch('http://localhost:8080/login',{
            method:"POST",
            mode:"no-cors",
            headers:{
              'Content-Type': 'multipart/form-data'
              //   'Content-Type': 'application/json',
            },
            body:requestBody,
        }).then(response => console.log(response))
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