function getAllTodos() {
  console.log("Getting all the todos.");

  var TodoThingy = new HttpClient();
  TodoThingy.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getFilteredTodos() {
  console.log("Sending request for filtered todos.");
  var url = "/api/todos?";
  var HttpThingy2 = new HttpClient();

  //string building ifs

  //Handle status
  if(document.getElementById("status").value != ""){
    url += "status=" + document.getElementById("status").value;
  }

  //handle content
  if(document.getElementById("content").value != ""){
    url += "&content=" + document.getElementById("content").value;
  }


  if(url == "/api/todos?"){
    url = "api/todos";
  }
  alert(url);
  HttpThingy2.get(url, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}



/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function(aUrl, aCallback){
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function(){

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
