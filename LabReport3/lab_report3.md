# Lab Report 3 - All About ```grep```


### 1. ```grep -i <pattern> <path-to-file>```
> `-i` option tells us that `grep` will ignore case distinctions in patterns and input data

#### Example 1: ```$ grep -i 'this' ./technical/911report/preface.txt```
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
#### Example 2: ```grep -i '[zq]' ./technical/911report/preface.txt```
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
> `-n` option tells us the line number in the file of the given search string

#### Example 1: ```grep -n  'given' ucsd-cse15l-s23/stringsearch-data/technical/biomed/1471-2105-3-2.txt```
* Command & Output: 
* What is it doing? 
* Why useful?

#### Example 2: ```grep -n '^[aeiou]*$' ucsd-cse15l-s23/stringsearch-data/technical/911report/preface.txt```
* Command & Output: 
* What is it doing? 
* Why useful?

---
### 3. ```grep -E 'A[0-9]{8}' <path-to-file>```
> `-E` option tells us that `grep` interprets `<PATTERNS>` as extended regular expressions (EREs)

### 4. ```grep --max-count=<integer> <pattern> <path-to-file>```
> 
