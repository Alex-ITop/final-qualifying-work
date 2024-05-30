import React from "react";
import "./blog.css";
import { blog01, blog02, blog03, blog04, blog05 } from "./imports";
import Article from "../../components/article/Article";
const Blog = () => {
  return (
    <div className="gpt3_blog section_padding" id="blog">
      <div className="gpt3_blog-heading">
      <p className="gradient_text">
          Добавить блок с командой проекта (должность, роль)
        </p>
        <br/>
        <br/>
        <br/>
        <br/>
      <p className="gradient_text">
          Добавить блок с примерами работы сервиса (скрины или видео) /
          или подгрузить выпад.списки, чтобы прямо на сайте можно было протестить
          функционал в деле. 
        </p>
        <br/>
        <br/>
        <br/>
        <br/>
        <h1 className="gradient_text">
          Вы можете ознакомиться с нашими достижениями
          <br/> (или следить за нашими новостями)
        </h1>
      </div>
      <div className="gpt3_blog-container">
        <div className="gpt3_blog-container_groupA">
          <Article
            imgUrl={blog01}
            date="Дек. 06, 2022"
            text="Свидетельство о государственной регистрации программы для ЭВМ"
          />
        </div>
        <div className="gpt3_blog-container_groupB">
          <Article
            imgUrl={blog02}
            date="2023"
            text="Публикация в Научно-техническом вестнике Поволжья. (ВАК)"
          />
          <Article
            imgUrl={blog03}
            date="2023"
            text="Лауреатство на международной научной конференции"
          />
          <Article
            imgUrl={blog04}
            date="Фев. 26, 2022"
            text="Реализована Desktop-версия сервиса"
          />
          <Article
            imgUrl={blog05}
            date="Июнь, 2024"
            text="Релиз веб-сервиса, тестирование"
          />
        </div>
      </div>
    </div>
  );
};

export default Blog;
