import React,{useState} from "react"
export const Login = (props) =>{
    const [login,setLogin] = useState('');
    const [password,setPassword] = useState('');

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(login,password);
    }

    return(
        <div className="auth-form-container">
        <h1>Purplist</h1>
        <form onSubmit={handleSubmit} className="login-form">
            <label htmlFor="login">login</label>
            <input value={login} onChange={(e)=>setLogin(e.target.value)} type="login" placeholder="yourlogin" name="login" id="login"/>

            <label htmlFor="password">password</label>
            <input value={password} onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password"/>
            <button className="submit-btn" type="submit">Log In</button>
        </form>
        <button className="link-btn" onClick={()=>props.onFormSwitch('register')}>Don't have an account? Register here.</button>
        </div>            
    )
}