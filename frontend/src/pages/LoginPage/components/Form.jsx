
import { useState } from "react";

const Form = ({title, handleClick}) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    return (
        <div>
            <form action="#">
                <div className="input-box">
                    <span className="icon"></span>
                        <ion-icon className="mail"></ion-icon>
                    <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    // placeholder="email"
                    required/>
                    <label>Email</label>
                </div>

                <div className="input-box">
                    <input
                    type="password"
                    value={pass}
                    onChange={(e) => setPass(e.target.value)}
                    // placeholder="password"
                    required/>
                    <label>Password</label>
                </div>

                    <button type="submit" className="btn"
                    onClick={() => handleClick(email, pass)}
                    >
                        {title}
                    </button>
            </form>
        </div>
        
    )
}

export {Form}