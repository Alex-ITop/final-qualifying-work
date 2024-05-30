import React from "react";
import "./headers.css";
import people from "../../assets/people.png";
import ai from "../../assets/ai.png";

const Headers = () => {
  return (
    <div className="gpt3_header section_padding " id="home">
      <div className="gpt3_header-content">
        <h1 className="gradient_text">
        NumVis Automate - помогу вам провести анализ 
        результатов математического моделирования
        </h1>
        <p>
        "NumVis Automate" - это инновационный сервис, разработанный 
        для автоматизации обработки и визуализации результатов 
        численного моделирования. Мы предлагаем уникальное решение, которое 
        позволяет вам с легкостью анализировать и визуализировать 
        данные из моделей любой сложности.
        </p>
        <div className="gpt3_header-content-input">
          <input type="email" placeholder="Ваш email" />
          <button type="button">Узнать больше</button>
        </div>
        {/* <div className="gpt3_header-content-people">
          <img src={people} alt="people" />
          <p>70+ людей пользовались сервисом в последние 24 часа</p>
        </div> */}
      </div>
      <div className="gpt3_header-image">
        <img src={ai} alt="header" />
      </div>
    </div>
  );
};

export default Headers;
