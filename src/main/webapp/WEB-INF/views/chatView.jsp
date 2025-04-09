<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@include file="/source/includes/header.jsp"%>

<%--        <div class="container bootstrap snippets bootdeys">--%>
<%--            <div class="wrapper">--%>
<%--                <div class="panel" id="chat">--%>
<%--                    <div class="panel-heading">--%>
<%--                        <h3 class="panel-title">--%>
<%--                            <form action="./chat" method="post">--%>
<%--                                <div class="input-group">--%>
<%--                                   we know you as:<br>--%>
<%--                                    ${user.name}--%>
<%--                                    <input type="hidden" class="form-control" name="logOut" value="logOut">--%>
<%--                                    <span class="input-group-btn">--%>
<%--                                        <button class="btn btn-primary" type="submit">Logout</button>--%>
<%--                                    </span>--%>
<%--                                </div>--%>
<%--                            </form>--%>
<%--                            <hr>--%>
<%--                        </h3>--%>
<%--                    </div>--%>
<%--                    <div class="panel-body">--%>
<%--                        <div class="chats">--%>
<%--                            <script>--%>
<%--                                user = "${user.name}";--%>
<%--                                userId = "${user.id}";--%>
<%--                                messageList = ${messageList};--%>

<%--                                for (i = 0; i < messageList.length; i++) {--%>
<%--                                    document.write('<div class="');--%>

<%--                                    if (userId == messageList[i].userId) {--%>
<%--                                        document.write('chat');--%>
<%--                                    } else {--%>
<%--                                        document.write('chat chat-left');--%>
<%--                                    }--%>

<%--                                    document.write('"><div class="chat-body"><div class="chat-content">' + messageList[i].content + '<br>by <b>' + messageList[i].userName + '</b></div></div></div>');--%>
<%--                                }--%>
<%--                            </script>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="panel-footer">--%>
<%--                        <hr>--%>
<%--                        <form action="./chat" method="post">--%>
<%--                            <div class="input-group">--%>
<%--                                <input type="text" class="form-control" placeholder="Say something" name="content" id="content">--%>
<%--                                <span class="input-group-btn">--%>
<%--                                    <button class="btn btn-primary" type="submit">Send</button>--%>

<%--                                </span>--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                        <br>--%>
<%--                        <form action="./chat" method="post">--%>
<%--                            <div class="input-group">--%>
<%--                                <input type="hidden" class="form-control" name="refresh" value="refresh">--%>
<%--                                <span class="input-group-btn">--%>
<%--                                        <button class="btn btn-primary" type="submit">REFRESH</button>--%>
<%--                                    </span>--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <label>What is your name?</label><input type="text" id="name" />
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>

<script type="text/javascript">
    var stompClient = null;

    function setConnected(connected) {
        console.log('setConnected function');
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        document.getElementById('response').innerHTML = '';
    }

    function connect() {
        console.log('connect function');
        var socket = new SockJS('/websocketchat/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/greetings', function(greeting){
                showGreeting(JSON.parse(greeting.body).content);
            });
        });
    }

    function disconnect() {
        console.log('disconnect function');
        stompClient.disconnect();
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        console.log('sendName function');
        name = document.getElementById('name').value;
        stompClient.send("/app/hello", {}, JSON.stringify({ 'name': name }));
        console.log('name = ' + name);
    }
</script>

<%@include file="/source/includes/footer.jsp"%>