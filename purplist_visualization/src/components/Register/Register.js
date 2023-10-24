import React,{useState} from "react"
export const Register = (props) =>{
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');
    const [name,setName] = useState('');

    const handleSubmit = (e)=>{
        e.preventDefault();
        console.log(email);
    }

    return(
        <div className="auth-form-container">
        <h1>Purplist</h1>
        <form onSubmit={handleSubmit} className="register-form">
            <label htmlFor="name">Full name</label>
            <input value={name} name="name" id="name" placeholder="Jan Kowalski"></input>
            <label htmlFor="email">email</label>
            <input value={email} onChange={(e)=>setEmail(e.target.value)} type="email" placeholder="youremail@mail.com" name="email" id="email"/>

            <label htmlFor="password">password</label>
            <input value={password} onChange={(e)=>setPassword(e.target.value)} type="password" placeholder="********" name="password" id="password"/>
            <button className="submit-btn" type="submit">Log In</button>
        </form>
        <button className="link-btn" onClick={()=>props.onFormSwitch('login')}>Already have an account? Log in here.</button>
        </div>  
    )
}