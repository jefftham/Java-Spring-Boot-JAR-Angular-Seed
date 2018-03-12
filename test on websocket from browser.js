let ws;

function connect(){
  ws = new WebSocket('ws://localhost:8080/ws');

  ws.onmessage = (ret)=>{
      console.log(ret.data);
  }

}

connect();

ws.send({type:'name', payload:'Jeff'});
