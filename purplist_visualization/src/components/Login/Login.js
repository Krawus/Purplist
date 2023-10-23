import React,{useState} from "react"
export const Login = (props) =>{
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(email,password);
    }

    return(
        <>
        <h1>Purplist</h1>
        <form onSubmit={handleSubmit}>
            <label htmlFor="email">email</label>
            <input value={email} onChange={(e)=>setEmail(e.target.value)} type="email" placeholder="youremail@mail.com" name="email" id="email"/>

            <label htmlFor="password">password</label>
            <input value={password} onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password"/>
            <button type="submit">Log In</button>
        </form>
        <button onClick={()=>props.onFormSwitch('register')}>Don't have an account? Register here.</button>
        </>            
    )
}