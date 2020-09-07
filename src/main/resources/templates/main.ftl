<#import "lib/common.ftl" as lib>

<@lib.page>
    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Введите сообщение"/>
            <input type="text" name="tag" placeholder="Тэг"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <form method="post" action="filter">
        <input type="text" name="tag"/>
        <button type="submit">Найти</button>
    </form>
    <div>Список сообщений</div>
    <#list messages as mess>
        <div>
            <b>${mess.id}</b>
            <span>${mess.text}</span>
            <i>${mess.tag}</i>
        </div>
    </#list>
</@lib.page>
