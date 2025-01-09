<h1>Тестове завдання: "Футбольний менеджер"</h1>
<h3>Опис завдання</h3>
<p>Реалізувати систему керування футбольними командами/гравцями з використанням <strong>Java 8</strong> (мінімум), <strong>Spring Boot</strong>, <strong>Hibernate/JDBC Template</strong>.</p>
<h3>Система повинна підтримувати такий функціонал:</h3>
<ol>
    <li><strong>Базові CRUD операції</strong> для роботи з командами та гравцями (відповідно до REST стилю).</li>
    <li><strong>Операція трансферу гравця</strong> з однієї команди в іншу:
            <ul>
                <li><strong>Формула розрахунку вартості трансферу:</strong>
                    <pre>Вартість трансферу = (Кількість місяців досвіду гравця * 100000) / Вік гравця у роках</pre>
                </li>
                <li><strong>Комісія зі сторони команди</strong> (від 0% до 10% від вартості трансферу) - вказується в інформації про команду.</li>
                <li><strong>Повна сума</strong> (вартість трансферу + комісія) повинна зніматись з рахунку команди, яка купує гравця, і переходити на рахунок команди, яка продає.</li>
            </ul>
    </li>
    <li>Реалізувати <strong>початкове наповнення бази даних</strong> гравців та команд.</li>
</ol>
<h3>Вимоги до валідації:</h3>
    <ul>
        <li>Операції з гравцями та командами повинні <strong>валідуватися на сервері</strong>.</li>
        <li>У разі помилок сервер повертає відповідний HTTP статус.</li>
    </ul>
<h3>Додаткові вимоги:</h3>
    <ul>
        <li>Створити <strong>Postman колекцію</strong> з запитами відповідно до реалізованого REST API.</li>
        <li>Розмістити проект у <strong>публічному GitHub репозиторії</strong> (або іншому репозиторії на вибір).</li>
        <li>Проект повинен <strong>запускатися однією командою</strong>.</li>
    </ul>
<h3>Postman</h3>
<p>Сформований у Postman <a href="https://github.com/yanna-stepanova/SoccerManager/blob/master/postman_collection.json" target="_blank">json-файл коллекції запитів</a>.</p>
