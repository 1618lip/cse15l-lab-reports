# Lab 2 Report 
*Created by Philip Pincencia*
---

## Part 1

Code for  ```StringServer``` 
  ![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/LabReport2/LabRep2_Images/StringServer_Code.png?raw=true)
<br>
<br>

#### First use of  ```/add-message```
  ![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/LabReport2/LabRep2_Images/add-message1st.png?raw=true) 

**Methods called:** ```public String handleRequest(URI url)``` <br/>
<br>
**Relevant Arguments:** 
* ```url = [http://localhost:1618/add-message?s=The%20biggest%20lie%20in%20CS:](http://localhost:1618/add-message?s=The%20biggest%20lie%20in%20CS:)``` 
* ```parameters = {"s", "The%20biggest%20lie%20in%20CS:](http://localhost:1618/add-message?s=The%20biggest%20lie%20in%20CS:"}```
* ```record = "The biggest lie in CS:\n"```

 **Changes in fields:**
* ```url.getPath()=/add-message?s=The%20biggest%20lie%20in%20CS:```. ```get.Path()``` gets the path of ```url```, and checks if it contains ```/add-message```
* The Strings in ```String[] parameters``` is obtained by splitting the query of ```url``` at ```"="```
* ```record``` field in  ```class Handler``` changes from an empty string ```""``` to ```record = "The biggest lie in CS:\n"```
<br>

Second use of ```/add-message```
  ![Image]()
<br>
<br>
## Part 2


## Part 3
