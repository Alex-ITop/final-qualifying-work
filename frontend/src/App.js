import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"

import "./App.css"

import LoginPage from "pages/LoginPage/LoginPage";
import MainPage from "pages/MainPage/MainPage";
import RegisterPage from "pages/RegisterPage/RegisterPage";



// function App() {
const App = () => {
  return (
    // <MainPage />
    <Router>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="login" element={<LoginPage/>} />
        <Route path="/register" element={<RegisterPage />} />
      </Routes>
    </Router>
  );
}

export default App;
