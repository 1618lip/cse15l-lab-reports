
# LAB REPORT 1: Tutorial for Incoming 15L Students (Windows User)
## Created by Philip Pincencia


## Installing VSCode 
---
* Go to this [link](https://code.visualstudio.com/download) to download vscode. Let the settings be default. 
* Open VSCode and you should see something like this: ![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/Screenshot%202023-04-06%20193104.png?raw=true) 
* Create new file and make sure to include the file type (i.e. .java, .py, .html) 
> To add jar files, make sure the jar files is in the same directory/same path. To do that, `ctrl+shift+p` and then choose "Configure Class Path". 
</br>
</br>

## Remotely Connecting
---
* If you don't have `git` installed, go to this [link](https://git-scm.com/download/win) to download it 
* Open VScode, then `ctrl + (backtick)` to open new terminal. Then `ctrl+shift+p` and type select default profile. 
* Select Git Bash from the options and then click on the `+` icon in the terminal window
* Then, type `$ ssh cs15lwi23zz@ieng6.ucsd.edu` where "zz" is the leters specific to your account. _(No need to type the dollar $ sign)_
* It will then prompt you to enter your password 
* To set up your password, go to this [link](https://sdacs.ucsd.edu/~icc/index.php) and follow this [tutorial](https://docs.google.com/document/d/1hs7CyQeh-MdUfM9uv99i8tqfneos6Y8bDU0uhn1wqho/edit) to set it up correctly. After changing, wait for about 15 minutes.
* Then, type your password
> When you type your password, it will not show up! just like when you type password you'll see it hidden. 
* If done correctly, you should see this: ![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/LabReport1/LabRep1_Images/sshLogin.png?raw=true)
</br>
</br>

## Trying Some Commands
---
Some commands to try out: 
* `pwd`     (prints the current working directory path, starting from the root `/`)
* `cd ~`  or  `cd`     (changes back to the default working directory) 
* `ls -lat`     (displays all files and directories in the current directory, including hidden files, in a long format)
* `ls -a`     (just like `ls -lat` but less information displayed)
* `ls <directory>`     (displays all files and directories in the specified directory)
* `exit`     (logs you out of the remote server) 
* etc...
> You can use `Ctrl + C` as an alternative to `exit`

* Here is the example commands and their outputs (in the remote server):![Image](https://github.com/1618lip/cse15l-lab-reports/blob/main/Screenshot%202023-04-07%20080156.png?raw=true)

---
## That's it. Feel free to explore more!



