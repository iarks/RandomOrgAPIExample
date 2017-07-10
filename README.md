# RandomOrgAPIExample

## What is this repo or project?

Example program for using the random.org java api by iarks to generate random integers within a given range. Note that the library code is still under development and as such this example may be subject to change.
To know more about the library source, click [here](https://bitbucket.org/iarks/randomorgapi)

## What do I do with this?

This library makes it easy to integrate random.org's 'true randomness' into java projects by getting rid of underlaying http requests and making things as simple as making a method call. Use this library to generate random integer numbers using [random.org](https://www.random.org/)'s true random numbers generators.

## How do I use this?
### Pre-requisites to setup this library
1. To get started all you need is an API key. To get your API key click [here](https://api.random.org/api-keys/beta).<br>The key should be sent to your email address and is of the format **00000000-0000-0000-0000-000000000000**</br>

2. Next you need the jar file itself. Click [here](https://raw.githubusercontent.com/iarks/RandomOrgAPIExample/master/lib/RandomNumberGenerator.jar) to obtain that.

### You can now proceed to use the library in your projects
1. Add the downloaded jar file to your project. This process may differ depending on the IDE being used.<br>For example, [this](https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project) is the way to do it in Intellij. To know how to do it for your project ask Google.

2. Once the library is set up for use import the required classes by typing in the following codes into your project:
```
import com.github.iarks.RandomOrgAPI.InvalidMethodCallException;
import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import com.github.iarks.RandomOrgAPI.RandomNumber;
```
(Check out the example for more details)

### Documentation and usage:
(Check out the example project for a better understanding of this section)

* Initialise a **RandomNumber** object and pass in your API key as follows. In place of **"YOUR API KEY HERE"** type in the API key obtained earlier.
```
RandomNumber rn = new RandomNumber("YOUR API KEY HERE");
```
<br><br>
* `void generate(int n, int max, int min, boolean replacement, String id)`<br>
The `generate()` method calls the underlaying API on the **RandomNumber** object and generates `n` random numbers.<br>
Example code snippet to call the `generate()` method on the **rn** object created in step 1
```
rn.generate(5, 10, 2, false, "method")
```
**Meaning of parameters:**<br>

`n`
<br>How many random integers you need. Must be within the [1,1e4] range.<br><br>
`min`
<br>The lower boundary for the range from which the random numbers will be picked. Must be within the [-1e9,1e9] range.<br><br>
`max`<br>The upper boundary for the range from which the random numbers will be picked. Must be within the [-1e9,1e9] range.<br><br>
`replacement`<br>Specifies whether the random numbers should be picked with replacement.
<br>Passing `true` will cause the numbers to be picked with replacement, i.e., the resulting set of numbers may contain duplicate values (like a series of dice rolls).
<br>If you want the set of numbers picked to be unique (like raffle tickets drawn from a container), set this value to `false`.
<br><br>
* `int[] getElementAsArray()`<br>
Returns an integer array containing the generated random numbers. Always call this method **after** calling `generate()` method, otherwise it will throw an `InvalidMethodCallException`, because the numbers have not been generated as yet.
<br>Use the following code snippet to obtain the array of generated numbers.
```
int arrayOfRandoms[]=rn.getElementAsArray();
```
<br><br>
* `int getElementAt(int index)`
<br>Accepts an integer `index` and returns the generated random number at that index. Use this method to individually adress the generated numbers. Always call this method **after** calling  `generate()`, otherwise it will throw an `InvalidMethodCallException`, because the numbers have not been generated as yet.
Example code snippet:
```
int firstRandomNumber=rn.getElementAt(0);
```
<br><br>
* `int getBitsLeft()`
By default random.org only allows upto 250,000 bits per API key daily. This function returns an integer containing the (estimated) number of remaining true random bits available to the client.
<br>
Example code snippet,
```
int bitsLeft = rn.getBitsLeft();
```
<br><br>
* `int getBitsUsed()`
<br>By default random.org only allows upto 250,000 bits per API key daily. This function returns an integer containing the number of true random bits used to complete the current request.
<br>
Example code snippet
```
int bitsUsed = rn.getBitsUsed();
```
<br><br>
* `int getRequestsLeft()`
<br>
By default random.org only allows upto 1000 API calls per key daily. This function returns an integer containing the (estimated) number of remaining API requests available to the client after the current request.
<br>
Example code snippet,
```
int requestsLeft = rn.getRequestsLeft();
```
