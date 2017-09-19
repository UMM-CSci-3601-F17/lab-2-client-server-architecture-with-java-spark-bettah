function getAllTodos() {
  console.log("Getting all the todos.");

  var todosClient = new HttpClient();
  todosClient.get("/api/todos", function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


function getFilteredTodos() {
  console.log("Sending request for filtered todos.");
  var url = "/api/todos?";
  var filteredTodoClient = new HttpClient();

  //string building ifs

  //Handle status
  if(document.getElementById("status").value != ""){
    url += "status=" + document.getElementById("status").value;
  }

  //handle content
  if(document.getElementById("content").value != ""){
    url += "&content=" + document.getElementById("content").value;
  }

  //handle content
  if(document.getElementById("id").value != ""){
    url += "&id=" + document.getElementById("id").value;
  }


  //handle category
  if(document.getElementById("category").value != ""){
    url += "&category=" + document.getElementById("category").value;
  }

  //handle owner
  if(document.getElementById("owner").value != ""){
    url += "&owner=" + document.getElementById("owner").value;
  }

  //handle limit
  if(document.getElementById("limit").value != ""){
    url += "&limit=" + document.getElementById("limit").value;
  }

  //if we have nothing selected, make the url clean
  if(url == "/api/todos?"){
    url = "api/todos";
  }

  alert(url);
  filteredTodoClient.get(url, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function clearFilters() {
  document.getElementById("status").value = "";
  document.getElementById("content").value = "";
  document.getElementById("category").value = "";
  document.getElementById("owner").value = "";
  document.getElementById("limit").value = ""
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
