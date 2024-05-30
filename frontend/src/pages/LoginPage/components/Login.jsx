import { Form } from './Form';
import { getAuth, signInWithEmailAndPassword } from "firebase/auth";
import { useDispatch } from 'react-redux';
import {setUser} from 'store/slices/userSlice'
import { useNavigate } from 'react-router-dom';

// import { useHistory} from 'react-router-dom';


const Login = () => {
    const dispatch = useDispatch();
    const {push} = useNavigate();
    // const {push} = useHistiry();

    const handleLogin = (email, password) => {
        const auth = getAuth();
        signInWithEmailAndPassword(auth, email, password)
            .then(({user}) => {
                console.log(user);
                dispatch(setUser({
                  email: user.email,
                  id: user.uid, 
                  token: user.accessToken,
                }));
                push('/');
        })
            .catch(() => alert('Invalin user!'))
    }


    return (
        <Form
            title="Войти"
            handleClick={handleLogin}
        />
    )
}

export default Login