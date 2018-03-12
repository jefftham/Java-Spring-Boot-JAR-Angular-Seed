let ws;

function connect(){
  ws = new WebSocket('ws://localhost:8080/ws');

  ws.onmessage = (ret)=>{
      console.log(JSON.parse(ret.data));
  }

}

connect();

ws.send(JSON.stringify({type:'name', payload:'Jeff'}));
