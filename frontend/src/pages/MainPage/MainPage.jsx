import React from "react";
import { Navigate } from "react-router-dom"
// import { Redirect } from "react-router-dom"
// import "../../App.css" 
import {
  Footer,
  Blog,
  // Possibility,
  Headers,
  // Features,
  WhatGPT3,
} from "./container";
import { Cta, Brand, Navbar } from "./components";

import { useDispatch } from "react-redux";
import { useAuth } from 'hooks/use-auth'
import { removeUser } from "store/slices/userSlice";

const MainPage = () => {
  const dispatch = useDispatch();

  const {isAuth, email} = useAuth();

  // return  isAuth ? (
  return (
    <div className="App">
      <div className="gradient_bg">
        <Navbar/>
        <Headers />
      </div>
      <Brand />
      <WhatGPT3 />
      {/* <Features /> */}
      {/* <Possibility /> */}
      <Cta />
      <Blog />
      <Footer />
      <button>
          onClick={() => dispatch(removeUser())}
        Log out from {email}
      </button>
    </div>
  ) 
  // : (
  //   <Navigate to="/login" />
  //   // <Redirect to="/login" />
  // )
}

export default MainPage
