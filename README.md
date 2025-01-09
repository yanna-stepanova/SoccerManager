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

<p>Сформований у Postman <a href="https://github.com/yanna-stepanova/SoccerManager/blob/master/postman_collection.json" target="_blank">json-файл коллекції запитів</a>.</p>

<h3>Team (Postman)</h3>
<h6>GET - get all teams</h6>
<pre>http://localhost:8080/api/teams</pre>
<p>Response (200 Ok)</p>
<pre>[
    {
        "id":1,
        "name":"Team One",
        "balance":9000000000.00,
        "commission":10.0
    },
    {
        "id":2,
        "name":"Team Two",
        "balance":100000000.00,
        "commission":7.5
    },
    {
        "id":3,
        "name":"Team Three",
        "balance":100000.00,
        "commission":2.0
    }   
]</pre>

<h6>POST - create team</h6>
<pre>http://localhost:8080/api/teams</pre>
<p>Body raw (json)</p>
<pre>{
    "name": "School team",
    "balance": 5000,
    "commission": 0.5
}</pre>
<p>Response (200 Ok)</p>
<pre>
{
    "id":4,
    "name":"School team",
    "balance":5000.00,
    "commission":0.5
}</pre>

<h6>GET - get team by id</h6>
<pre>http://localhost:8080/api/teams/4</pre>
<p>Response (200 Ok)</p>
<pre>
{
    "id":4,
    "name":"School team",
    "balance":5000.00,
    "commission":0.5
}</pre>

<h6>PUT - update team by id</h6>
<pre>http://localhost:8080/api/teams/4</pre>
<p>Body raw (json)</p>
<pre>{
    "name": "Bro-Team",
    "balance": 1000,
    "commission": 1
}</pre>
<p>Response (200 Ok)</p>
<pre>
{
    "id": 4,
    "name": "Bro-Team",
    "balance": 1000,
    "commission": 1.0
}</pre>

<h6>DELETE - delete team by id</h6>
<pre>http://localhost:8080/api/teams/4</pre>
<p>Response (200 Ok)</p>

<h3>Player (Postman)</h3>

<h6>POST - create player</h6>
<pre>http://localhost:8080/api/players</pre>
<p>Body raw (json)</p>
<pre>{
    "name": "Player for removing",
    "experienceInMonths": 300,
    "age": 40,
    "teamId": 1
}</pre>
<p>Response (200 Ok)</p>
<pre>{
    "id": 13,
    "name": "Player for removing",
    "experienceInMonths": 300,
    "age": 40,
    "teamId": 1
}</pre>

<h6>GET - get all players</h6>
<pre>http://localhost:8080/api/players</pre>
<p>Response (200 Ok)</p>
<pre>[
    {
        "id": 1,
        "name": "Player_1",
        "experienceInMonths": 156,
        "age": 30,
        "teamId": 1
    },
    ........
    {
        "id": 13,
        "name": "Player for removing",
        "experienceInMonths": 300,
        "age": 40,
        "teamId": 1
    }
]</pre>

<h6>GET - get all players by teamId</h6>
<pre>http://localhost:8080/api/players/by-team?teamId=3</pre>
<p>Response (200 Ok)</p>
<pre>[
    {
        "id": 9,
        "name": "A.A",
        "experienceInMonths": 36,
        "age": 19,
        "teamId": 3
    },
    ........
    {
        "id": 12,
        "name": "D.D",
        "experienceInMonths": 30,
        "age": 19,
        "teamId": 3
    }
]</pre>

<h6>GET - get player by id</h6>
<pre>http://localhost:8080/api/players/13</pre>
<p>Response (200 Ok)</p>
<pre>{
        "id": 13,
        "name": "Player for removing",
        "experienceInMonths": 300,
        "age": 40,
        "teamId": 1
}</pre>

<h6>PUT - update player by id</h6>
<pre>http://localhost:8080/api/players/13</pre>
<p>Body raw (json)</p>
<pre>{
    "name": "Bob Older",
    "experienceInMonths": 300,
    "age": 40,
    "teamId": 4
}</pre>
<p>Response (200 Ok)</p>
<pre>{
    "id": 13,
    "name": "Bob Older",
    "experienceInMonths": 300,
    "age": 40,
    "teamId": 4
}</pre>

<h6>DELETE - delete player by id</h6>
<pre>http://localhost:8080/api/players/13</pre>
<p>Response (200 Ok)</p>

<h3>Transfer (Postman)</h3>

<h6>POST - transfer</h6>
<pre>http://localhost:8080/api/transfer/9/to/2</pre>
<p>Response (200 Ok)</p>
<pre>{
    "player": {
        "id": 9,
        "name": "A.A",
        "experienceInMonths": 36,
        "age": 19,
        "teamId": 2
    },
    "sumOfTransfer": 193263.16,
    "oldTeam": {
        "id": 3,
        "name": "Team Three",
        "balance": 293263.16,
        "commission": 2.0
    },
    "newTeam": {
        "id": 2,
        "name": "Team Two",
        "balance": 99806736.84,
        "commission": 7.5
    }
}</pre>

