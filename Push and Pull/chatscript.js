var username = prompt("What is your name");
var userheader = document.getElementById("user");
var chatpage=document.getElementById("chatpage");
var chatmsg=document.getElementById("chatmsg");
var sendmsg=document.getElementById("sendmsg");

userheader.innerHTML = `Hello ${username}`;

let mywebsocket = new WebSocket("ws://localhost:8800");
console.log(mywebsocket);

mywebsocket.onopen = function() {
    console.log("Connection open");
    data_to_send = {
        username: username,
        type: "login"
    };
    data = JSON.stringify(data_to_send);
    this.send(data);
};

mywebsocket.onerror = function() {
    console.log("Error happened");
};

mywebsocket.onmessage = function(event) {
    console.log("Message received");
    console.log(event.data,typeof data);
    msg=JSON.parse(event.data)
    chatpage.innerHTML+=msg['content']
};

sendmsg.addEventListener("click",function(){
 mymsg=chatmsg.value
 console.log(mymsg)
 msg_obj={
 type :"chat",
 username:username,
 body:mymsg+"\n"
 }
 msg_obj=JSON.stringify(msg_obj)
 mywebsocket.send(msg_obj)
})