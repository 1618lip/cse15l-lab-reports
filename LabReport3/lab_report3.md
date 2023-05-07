# Lab Report 3 - All About ```grep```


### 1. ```grep -i <pattern> <path-to-file>```
> `-i` option tells us that `grep` will ignore case distinctions in patterns and input data

#### Example 1: ```grep -i '^[aeiou]*$' ucsd-cse15l-s23/stringsearch-data/technical/911report```
* Command & Output: 
* What is it doing? 
* Why useful?

#### Example 2: ```grep -i '^[aeiou]*$' ucsd-cse15l-s23/stringsearch-data/technical/911report```
* Command & Output: 
* What is it doing? 
* Why useful?

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
