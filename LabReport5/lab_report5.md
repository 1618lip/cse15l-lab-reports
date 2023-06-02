# Lab Report 5: Debugging

## Part 1: Debugging Scenario

### 1. Student's Post:

> **What environment are you using (computer, operating system, web browser, terminal/editor, and so on)?**
>
> I am using Windows, and I use 'curl' to open the URL.
>
> **Detail the symptom you're seeing. Be specific; include both what you're seeing and what you expected to see instead. Screenshots are great, copy-pasted terminal output is also great. Avoid saying “it doesn't work”.**
>
> So, I have run the URL `http://localhost:1618/change` two times, which means the status should be at 2. At this point, it worked as expected. But when I ran the URL again, I expected the status to go back to being healthy (status = 0). However, instead, it still says "It ran out of memory".
>
> **Detail the failure-inducing input and context. That might mean any or all of the command you're running, a test case, command-line arguments, working directory, even the last few commands you ran. Do your best to provide as much context as you can.**
>
> I start the Server using the usual `javac` and `java` commands. Then, in Git Bash, I use `curl http://localhost:1618/change` to change the status of the server and `bash GetStatus.sh` to print out messages based on the status of the server. *(As you can see in the screenshot, I alternate between those two commands to see the change in action)*.

![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1114312296806764554/image.png)
### 2. TA's Response

> "Does the status rotate between three status or four status? If there are only three status, you should change **line 23** of `StatusServer.java` to be `% 3` instead of `% 4`. Try restarting the server again and do the exact same thing you did." 

### 3. Student Tries TA's Advice
> "Yes, it works now. Thank you so much for your help!" 

![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1114317721585336452/image.png)

### 4. Setup Information

* **File & Directory Structure:**
 ```
 | +-- /15L_Final_Lab_Report 
      | +-- GetStatus.sh          				
      | +-- Server.java   
      | +-- StatusServer.java
 ```
* **Contents of each file before fixing:**

  **`GetStatus.sh`:**
  ```
  #!/bin/bash

  SERVER_URL="http://localhost:1618/status"

  # Get server status
  status=$(curl -s $SERVER_URL)

  echo "Server Status: $status"

  # Check for specific issues
  if [[ $status == "Server is healthy" ]]; then
    echo "Everything is fine!"
  elif [[ $status == *"Warning"* ]]; then
    echo "Warning: High CPU usage detected!"
    echo "Sending alert..."
    # Send alert to admin
    # ...
  elif [[ $status == *"Error"* ]]; then
    echo "Error: Out of memory!"
    echo "Restarting server..."
    # Restart server
    # ...
  fi
  ```
  
  **`StatusServer.java`:**
  ```
  import java.io.IOException;
  import java.net.URI;

  class Handler implements URLHandler {
      // The one bit of state on the server: a number that will be manipulated by
      // various requests.
      int num = 0;

      public String handleRequest(URI url) {
          if (url.getPath().equals("/status")) {
              if (num == 0) {
                  return String.format("Server is healthy");
              } 
              else if (num == 1) {
                  return String.format("Warning: High CPU usage");
              } 
              else {
                  return String.format("Error: Out of memory");
              }
          } 
          else if (url.getPath().equals("/change")) {
              // remove parantheses for debugging
              num = (num + 1) % 4;
              return String.format("Status Changed");
          }
          else {
              return "Invalid Path";
          } 
      }
  }

  class StatusServer {
      public static void main(String[] args) throws IOException {
          if(args.length == 0){
              System.out.println("Missing port number! Try any number between 1024 to 49151");
              return;
          }

          int port = Integer.parseInt(args[0]);

          Server.start(port, new Handler());
      }
  }
  ```
  
  **`Server.java`:**
  ```
  // A simple web server using Java's built-in HttpServer

  // Examples from https://dzone.com/articles/simple-http-server-in-java were useful references

  import java.io.IOException;
  import java.io.OutputStream;
  import java.net.InetSocketAddress;
  import java.net.URI;

  import com.sun.net.httpserver.HttpExchange;
  import com.sun.net.httpserver.HttpHandler;
  import com.sun.net.httpserver.HttpServer;

  interface URLHandler {
      String handleRequest(URI url);
  }

  class ServerHttpHandler implements HttpHandler {
      URLHandler handler;
      ServerHttpHandler(URLHandler handler) {
        this.handler = handler;
      }
      public void handle(final HttpExchange exchange) throws IOException {
          // form return body after being handled by program
          try {
              String ret = handler.handleRequest(exchange.getRequestURI());
              // form the return string and write it on the browser
              exchange.sendResponseHeaders(200, ret.getBytes().length);
              OutputStream os = exchange.getResponseBody();
              os.write(ret.getBytes());
              os.close();
          } catch(Exception e) {
              String response = e.toString();
              exchange.sendResponseHeaders(500, response.getBytes().length);
              OutputStream os = exchange.getResponseBody();
              os.write(response.getBytes());
              os.close();
          }
      }
  }

  public class Server {
      public static void start(int port, URLHandler handler) throws IOException {
          HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

          //create request entrypoint
          server.createContext("/", new ServerHttpHandler(handler));

          //start the server
          server.start();
          System.out.println("Server Started! Visit http://localhost:" + port + " to visit.");
      }
  }

  ```
* **Command lines that trigger the bug:**
  ```
  $ bash GetStatus.sh
  $ curl http://localhost:1618/change
  $ bash GetStatus.sh
  $ curl http://localhost:1618/change
  $ bash GetStatus.sh
  $ curl http://localhost:1618/change
  $ bash GetStatus.sh  <-- Outputs the wrong message 
  ```
* **What to edit?** At **line 23** of `StatusServer.java`, change from `num = (num + 1) % 4;` to `num = (num + 1) % 3;`

---
## Part 2: Reflection
> I really like this topic of building servers, which is why I chose the debugging scenario to be about servers & URLs. Vim is also cool because I like weird & wacky stuff, but hot take: Vim is better than writing a bash script. 
