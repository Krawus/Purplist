import React,{useState} from "react"
export const Register = (props) =>{
    const [login,setLogin] = useState('');
    const [password,setPassword] = useState('');
    const [confirmPassword,setConfirmPassword] = useState('');

    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(login);
    }

    return(
        <div className="auth-form-container">
        <h1>Purplist</h1>
        <form onSubmit={handleSubmit} className="register-form">
            <label htmlFor="login">login</label>
            <input value={login} name="login" id="login" placeholder="yourlogin"></input>
            <label htmlFor="password">password</label>
            <input value={password} onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password"/>

            <label htmlFor="confirmPassword">confirm password</label>
            <input value={confirmPassword} onChange={(e)=>setConfirmPassword(e.target.value)} type="password" placeholder="********" name="confirmPassword" id="confirmPassword"/>
            <button className="submit-btn" type="submit">Register</button>
        </form>
        <button className="link-btn" onClick={()=>props.onFormSwitch('login')}>Already have an account? Log in here.</button>
        </div>  
    )
}