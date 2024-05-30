import { Link } from "react-router-dom"
import Login from "./components/Login"
import "./LoginPage.css"

const LoginPage = () => {
    return (
        <div>
            <div className="wrapper">
                <div className="form-box login">
                    <h2>Авторизация</h2>
                    <Login />
                    <p>
                        Нет аккаунта? <Link to="/register">Зарегистрироваться</Link>
                    </p>
                </div>
            </div>
        </div>
    )
}

export default LoginPage