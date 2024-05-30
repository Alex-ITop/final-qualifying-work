import React from "react";
import "./footer.css";
import gpt3Logo from "../../assets/logo_math.png";
const Footer = () => {
  return (
    <div className="gpt3_footer section_padding">
      <div className="gpt3_footer-heading">
        <h1 className="gradient_text">
          Вы бы хотели шагнуть в будущее вместе с нами?
        </h1>
      </div>
      <div className="gpt3_footer-btn">
        <p>Получить ранний доступ</p>
      </div>
      <div className="gpt3_footer-links">
        <div className="gpt3_footer-links-logo">
          <img src={gpt3Logo} alt="logo" />
          <p>
            Россия, г. Пермь, ПНИПУ, каф. ВММБ <br /> Все права защищены
          </p>
        </div>
        <div className="gpt3_footer-links_div">
          <h4>Ссылки</h4>
          <p>Социальные сети</p>
          <p>События</p>
          <p>Контакты</p>
        </div>
        <div className="gpt3_footer-links_div">
          <h4>Организация</h4>
          <p>Правила и условия </p>
          <p>Политика конфиденциальности</p>
          <p>Контакты</p>
        </div>
        <div className="gpt3_footer-links_div">
          <h4>Связаться с нами</h4>
          <p>г. Пермь, ПНИПУ, каф. ВММБ</p>
          <p>+7(342)239-15-64</p>
          <p>614013, г. Пермь, ул. Профессора Поздеева, 13,корпус Г</p>
        </div>
      </div>
      <div className="gpt3_footer-copyright">
        <p>@2024 NumVis Automate. Все права защищены.</p>
      </div>
    </div>
  );
};

export default Footer;
