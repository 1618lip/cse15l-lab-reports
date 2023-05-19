# Lab Report 4: Vim 

## Step 1: Log into `ieng6`
### What to type? `ssh cs15lsp23oq@ieng6.ucsd.edu` &rarr; `<Enter>`
> Note: No need to type in my password anymore I have generated SSH key for `ieng6`
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109124762363498637/image.png)



## Step 2: Clone the fork
### What to type/press? `git clone` &rarr; `<space>` &rarr; `<ctrl> + v` &rarr; `<Enter>`
> Use of `<ctrl> + v`: for copy-paste the **fork** of the repository from my Github account 
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109125739485351936/image.png)



## Step 3: Run Test (Should fail)
### What to type? `bash test.sh` &rarr; `<Enter>`
> The `test.sh` compiles and run `ListExamplesTests.java`
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109126190561775687/image.png)


## Step 4: Edit the Code
### What to type/press: 
* **Open Vim: `vim ListExamples.java` &rarr; `<Enter>`**
> the `vim <path>` command opens the file path, in this case, `ListExamples.java` in `vim`
* **Getting to the desired place: `/` &rarr; `index1` &rarr; `<Enter>` &rarr; `shift + n` &rarr; `e`** 
> `/` is for searching, in this case, the string `index1`. Press `<Enter>` to confirm 
> 
> `shift + n` yields `N`, which means find the previous occurence of `index1`, which will jump to the last one since we started at the beginning when searching. And fortunately, our target `index1` is exactly the last one. 
> 
> `e` makes the cursor jumps to the last character in the word `index1`, which is `1`.

![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109131095263428628/image.png)

* **Make Edit and Save & Exit: `x` &rarr; `i` &rarr; `2` &rarr; `<Esc>` &rarr; `:wq` &rarr; `<Enter>`**
> `x` deletes what's under the cursor, which at this instance is going to be the `1`.
> 
> `i` means we enter `insert` mode, which is like editing a normal text file. Then, press `2` to add `2`at the end of `index`. 
> 
> Press `<Esc>` to exit out of `insert` mode, then `:wq` to exit out of `vim` with saving the edits.
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109131951148892311/image.png)



## Step 5: Run Test (Should pass)
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109138025822310551/image.png)
### What to type: `<up><up>` &rarr; `<Enter>`
> Press up arrow `<up>` twice to get the `bash test.sh` command, then hit `<Enter>`.



## Step 6: Commit & Push to GitHub
![Image](https://cdn.discordapp.com/attachments/1099107413803679870/1109137899808641084/image.png)
### What to type: `git add --all` &rarr; `<Enter>` &rarr; `git commit -m "Change index1 into index2"` &rarr; `<Enter>` &rarr; `git push` &rarr; `<Enter>`
> `git add --all` add the files to my GitHub. `git commit` is to commit the changes I made, with a message describing what I edited. Then I pushed to my GitHub using `git push`
