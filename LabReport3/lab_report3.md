# Lab Report 3 - All About ```grep```


### 1. ```grep -i <pattern> <path-to-file>```
> `-i` option tells us that `grep` will ignore case distinctions in patterns and input data

#### Example 1.1: ```$ grep -i 'this' ./technical/911report/preface.txt```
* **Command & Output:** 
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -i 'this' ./technical/911report/preface.txt
            We present the narrative of this report and the recommendations that flow from it to
                partisan division-have come together to present this report without dissent.
                the United States. The nation was unprepared. How did this happen, and how can we
                individuals in ten countries. This included nearly every senior official from the
                and national security did not understand how grave this threat could be, and did not
                We hope that the terrible losses chronicled in this report can create something
                Commissioners, whose dedication to this task has been profound. We have reasoned
                together over every page, and the report has benefited from this remarkable
                Philip Zelikow, has contributed innumerable hours to the completion of this report,
                setting aside other important endeavors to take on this all-consuming assignment.
                & Company for helping to get this report to the broad public.
            We conclude this list of thanks by coming full circle: We thank the families of 9/11,
                This final report is only a summary of what we have done, citing only a fraction of
                the sources we have consulted. But in an event of this scale, touching so many
                inevitably will come to light. We present this report as a foundation for a better
                preparing to respond if it becomes necessary. We emerge from this investigation with
                this process with strong opinions about what would work. All of us have had to
  ```
* **What is it doing?**
  Finding all lines with the word 'this' regardless of case. It doesn't have to be a stand-alone word this; it can be a word with 'this' embedded inside. 
* **Why useful?**
  Sometimes you just want to find the words itself. In code, you can use this option to check if all variables are in the same case. If we didn't use this option, the ones that are in the wrong case will not be exposed. So, for debugging purposes, this is very useful. 
* **Source: [https://www.geeksforgeeks.org/grep-command-in-unixlinux/](https://www.geeksforgeeks.org/grep-command-in-unixlinux/)**
#### Example 1.2: ```grep -i '[zq]' ./technical/911report/preface.txt```
* **Command & Output:**
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -i '[zq]' ./technical/911report/preface.txt
            To answer these questions, the Congress and the President created the National
                and border control, the flow of assets to terrorist organizations, commercial
                and equal rights for women. It makes no distinction between military and civilian
                think about the way our government is organized. The massive departments and
                Philip Zelikow, has contributed innumerable hours to the completion of this report,
                of several previous Commissions, and we thank the Congressional Joint Inquiry, whose
                issues and organizations, we are conscious of our limits. We have not interviewed
                the American people and their amazing resilience and courage as they fought back. We
                for the American people. We recognize the formidable challenges that lie ahead.
                citizens to study, reflect-and act.
  ```
* **What is it doing?** 
  Finding all lines that contains the letters 'z' and 'q', regardless of capatalization.  
* **Why useful?**
  Again, finding errors in naming something, but this time we can do it all in one command
* **Source: [https://www.geeksforgeeks.org/grep-command-in-unixlinux/](https://www.geeksforgeeks.org/grep-command-in-unixlinux/)**

---
### 2. ```grep -n  <pattern> <path-to-file>```
> `-n` option tells us the line numbers in the file of the given search string

#### Example 2.1: ```grep -n  'very' ./technical/biomed/1471-2105-3-2.txt```
* **Command & Output:** 
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -n "very" ./technical/biomed/1471-2105-3-2.txt
  35:        significant findings was the discovery of the third kingdom
  60:        secondary structure for every other 5S rRNA sequence [ 12
  122:        can require very large, phylogenetically and structurally
  170:            determined very early in this methodology that the
  390:            and 23S rRNAs (see above) from this very large number
  402:            tabulating the presence or absence of every proposed
  405:            and 23S [ 19 ] rRNA models. Every base pair in each of
  425:            for 16S and 23S rRNA are very similar to one another.
  431:            This analysis produced two very large tables with
  522:            the reference sequence, for every RNA in this
  814:            sequences that are very similar, the proper
  881:            RNA sequences. Our current RNA data sets contain a very
  887:            RNA sequences are very similar to at least one sequence
  939:            that are very closely related to the organisms for
  1428:            complete information for every intron within a
  1675:            field could be very useful to identify organisms and
  1909:            This analysis, as mentioned earlier, is very accurate:
  1982:            adenosines for every A that is paired), and lowest for
  ```
* **What is it doing?**
  Find all lines that contains the string "very" and tell us the line number for each line
* **Why useful?**
  Researching text: use grep -n to quickly search for a specific keyword or phrase in all the files, and see where the matches occur along with their line numbers. This can help you get a better understanding of the context of the matches in the files.
* **Source: Use ```man grep```** 
#### Example 2.2: ```grep -n 'list' ./technical/biomed/1471-2105-3-2.txt  | awk '{print $1, substr($0, index($0,$2))}' > output.txt```
* **Command & Output:** 
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -n 'list' ./technical/biomed/1471-2105-3-2.txt  | awk '{print $1, substr($0, index($0,$2))}' > output.txt

  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ cat output.txt
  628: list of base pairs in the left frame is red in the C
  789: web-formatted list of those sequences. The lists, for
  1035: lists for each of those five phylogenetic/cell location
  1067: or modified recently are listed and available from
  1072: (black text). Diagrams are listed alphabetically by
  1089: selections are made, a list of the structure diagrams
  1114: each alignment, there is a corresponding list of
  1116: information about the sequences (see conservation list
  1139: position number listed and the following position (
  1141: position 516 and 517 are listed as 516). rRNA Introns
  1146: below and H-3E.1). The list of all publicly available
  1528: (for list- and button-driven fields) or, for text input
  1584: "coli" in this field will list all organism names that
  1650: etc. ) are listed when the
  1779: listing that can be retrieved in a new window by
  1781: listing also contains the known common names associated
  1944: these fields are listed in Table 5. The system
  1974: the structural elements listed (
  ```
* **What is it doing?** 
  It searches for the pattern "list" in the file, which then pipes the output to an `awk` command that extracts the line numbers and the matching lines and concatenates them together with a space between them. And then prints it out with `cat` command. 
* **Why useful?**
  Useful for attaching line numbers to lines that have that specific pattern, which I've seen a lot in my English Reading Assignments. So, it is useful for creating Reading Assignments. 
* **Source: use ChatGPT**
  
---
### 3. ```grep -E <pattern> <path-to-file>```
> `-E` option tells us that `grep` interprets `<PATTERNS>` as extended regular expressions (EREs)

#### Example 3.1: ```grep -E ' 6:[0-59]{2}' ./technical/911report/chapter-1.txt```
* **Command & Output:**
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -E ' 6:[0-59]{2}' ./technical/911report/chapter-1.txt
    Boston: American 11 and United 175. Atta and Omari boarded a 6:00 A.M. flight from Portland to Boston's Logan International Airport.
    Atta and Omari arrived in Boston at 6:45. Seven minutes later, Atta apparently took a call from Marwan al Shehhi, a longtime colleague who was at another     terminal at Logan Airport. They spoke for three minutes.
    Between 6:45 and 7:40, Atta and Omari, along with Satam al Suqami, Wail al Shehri, and Waleed al Shehri, checked in and boarded American Airlines Flight      11, bound for Los Angeles. The flight was scheduled to depart at 7:45.
  ```
* **What is it doing?**
  Returns all lines that contains a two-digit number between 60 and 59, preceded by the character "6:". In other words, all lines that has the time format `6:##`. 
* **Why useful?**
  This could help someone quickly identify events or incidents that occurred at specific times, which could be important for analyzing the events described     in the report. 
* **Source: use ```man grep```**

#### Example 3.2: ```grep -E '\w{15,}' ./technical/911report/chapter-7.txt```
* **Command & Output:**
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep -E '\w{15,}' ./technical/911report/chapter-7.txt
                holding extremist beliefs who have been the subject of counterterrorism
                transcontinental leg, each operative flew on the same type of aircraft he would
                nuclear facility he had seen during familiarization flights near New York-a target
                busy, as revealed by a set of contemporaneous Atta- Binalshibh communications that
                757), and on transcontinental flights that connected to Las Vegas. This time,
                counterproductive. It might draw the Americans into the war against them, just when
  ```
* **What is it doing?**
  Searches for lines that has words with 15 characters or more
* **Why useful?**
  Useful when you want to avoid long words that might make reading harder. 
* **Source: ```man grep```**

---
### 4. ```grep --max-count=<integer> <pattern> <path-to-file>```
> ```--max-count=<integer>``` means it will return at most ```<integer>``` number of matches
  
#### Example 4.1: ```grep --max-count=2 'example' ./technical/911report/preface.txt```
* **Command & Output:**
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep --max-count=3 'error' ./technical/911report/preface.txt
                Commission on Terrorist Attacks Upon the United States (Public Law 107-306, November
                relating to the terrorist attacks of September 11, 2001," including those relating
                and border control, the flow of assets to terrorist organizations, commercial
  ```
* **What is it doing?**
  Returns a maximum of 3 lines that contains the pattern 'error', even though there are more lines (there are actually 4 lines)
* **Why useful?**
  Useful when searching for a pattern that appears frequently in a file, but you only care about the first few. Or, you want to fix each error little by little without being overwhelmed by the number of errors printed to the command line. 
* **Source: use ```man grep```**

#### Example 4.2: ```grep --max-count=1 'every' ./technical/911report/preface.txt | tail -n 1```
* **Command & Output:**
  ```
  Philip@Golden-lip MINGW64 ~/stringsearch-data (main)
  $ grep --max-count=1 'every' ./technical/911report/preface.txt | tail -n 1
                individuals in ten countries. This included nearly every senior official from the
  ```
* **What is it doing?**
  Searches for the the pattern 'every' in the file, return the first match (which will be the last match since grep searches from the beginning of the file), and then use the tail command to extract the last line of output, which will be the last occurrence of the pattern in the file.
* **Why useful?**
  Useful in situations where you only care about the last occurrence of a pattern, such as when monitoring log files or tracking changes in a file over time.
* **Source: ChatGPT**
---
