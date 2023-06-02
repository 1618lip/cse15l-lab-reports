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
            num = (num + 1) % 3;
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
