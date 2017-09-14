## Answers

1. The `.gitignore` file prevents git from seeing files that match the patterns and paths inside it. This is useful because it prevents committing superfluous files, thus making history cleaner, clearer and safer.

2. Routes are a concept in Spark, they define how the server parses the messages from the client. They consist of a REST method, followed by a path as a string, and then finally the java function that will be run to create the severs response

3. The `umn.3601.server` defines the layout of the website, resolving urls and returning the relevant parts of the public folder. It also creates the mock-database's user-controller, and will handle passing requests to it. The `umn3601.user.UserController` class in turn handles selecting data from the mock database based on the arguments it is called with.
  * The `Server.java` instance receives the request, and matches it to a route, that causes it to return users.html
  * The `api.users` causes the server class to call the `UserController` instance it is maintaining.
  * This operates the same as above, except passing through a filter that the `UserController` acts on, filtering the resulting json response.

4. They are html, js and css files that provide a starting point for client-server interaction and the front-end for the user. The three html files define home, about and a users page, the last of which will likely be expanded with the full search system.

5. When the button is pressed, the `users.html` calls the function bound in the `User.js` file. This in turn uses an instance of HttpClient and an anonymous function to place the json response from the server into the displayed html.

6. The client side javascript is defined in `src/resources/javascript/users.js` and it is used in `users.hmtl` to bind the buttons on screen to get calls to the server.
