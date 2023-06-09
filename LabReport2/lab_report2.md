# Lab 2 Report        
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
* ```parameters = {"s", "The%20biggest%20lie%20in%20CS:"](http://localhost:1618/add-message?s=The%20biggest%20lie%20in%20CS:}```
* ```record = "The biggest lie in CS:\n"```

 **Changes in fields:**
* ```url.getPath()=/add-message?s=The%20biggest%20lie%20in%20CS:```. ```get.Path()``` gets the path of ```url```, and checks if it contains ```/add-message```
* The Strings in ```String[] parameters``` is obtained by splitting the query of ```url``` at ```"="```
* ```record``` field in  ```class Handler``` changes from an empty string ```""``` to ```record = "The biggest lie in CS:\n"```

<br>

#### Second use of ```/add-message```
  ![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/LabReport2/LabRep2_Images/add-message2nd.png?raw=true)

**Methods called:** ```public String handleRequest(URI url)``` <br/>
<br>
**Relevant Arguments:** 
* ```url = [http://localhost:1618/add-message?s="It%20works"](http://localhost:1618/add-message?s="It%20works")``` 
* ```parameters = {"s", "\"It%20works\""](http://localhost:1618/add-message?s="It%20works"}```
* ```record = "The biggest lie in CS:\nIt works\n"```

 **Changes in fields:**
* ```url.getPath()=/add-message?s="It%20works"```. ```get.Path()``` gets the path of ```url```, and checks if it contains ```/add-message```
* The Strings in ```String[] parameters``` is obtained by splitting the query of ```url``` at ```"="```
* ```record``` field in  ```class Handler``` changes from the previous value ```record = "The biggest lie in CS:\n"``` to ```record = "The biggest lie in CS:\nIt works\n"``` by concatening ```"\"It works\n\""``` to itself. 

---

## Part 2: Bugs
### Chosen Method: ```static double averageWithoutLowest(double[] arr)```

**Failure-inducing Input:**
```
@Test
  public void testaverageWithoutLowestNotPass() {
    double getMean = ArrayExamples.averageWithoutLowest(new double[]{1.0, 1.0, 3.0, 5.0});
    assertEquals(3, getMean, 0.000); // actual = 2.6666666666666665
  }
```

**Non Failure-inducing Input:**
```
@Test
  public void testaverageWithoutLowestPass() {
    double getMean = ArrayExamples.averageWithoutLowest(new double[]{1.0, 2.0, 3.0, 4.0});
    assertEquals(3, getMean, 0.001);
  }
```


**Symptoms:**
![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/LabReport2/LabRep2_Images/JUnit%20Tests.png?raw=true)
<br>
**Bug Change**
* Before: 
```
static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for (double num: arr) {
      if (num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }
```
* After: 
```
static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    boolean flag = false;
    for(double num: arr) {
      if(num == lowest && !flag) {
        flag = true;
      }
      else {
        sum += num;
      }
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    return sum / (arr.length - 1);
  }
```
Before the fix, if they are multiple lowest ```double```, we are ignoring all of them, however the number of ```double``` is still ```arr.length-1```, which is not really the definition of *mean*. The fix is introducing an indicator that once we found the lowest num in ```arr```, we are ignoring that one and then adding up all ```num``` until the end of ```arr```. That is achieved by using ```boolean flag = false;```, which will be changed to ```true``` once we find the lowest.  

## Part 3
I found making my own web servers very cool. I thought it requires some special program and machinery to actually run one. Turns out Java can do that as well. Although I have yet to understand how to make the code for creating the server itself, I know how to modify it for a specific purpose. Especially seeing that changing the urls can do a lot of different stuffs. 
