import SignUp from "pages/LoginPage/components/SignUp";
import { Link } from "react-router-dom";
import "../LoginPage/LoginPage.css"

const RegisterPage = () => {
    return (
        <div>
            <div className="wrapper">
                <div className="form-box login">
                    <h2>Регистрация</h2>
                    <SignUp />
                    <p>
                        Уже есть аккаунт? <Link to="/login">Войти</Link>
                    </p>
                </div>
            </div>
         </div>
        
    )
}

export default RegisterPage