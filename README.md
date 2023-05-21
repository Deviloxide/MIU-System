# MIU-System
An automated solver for Hofstadter’s formal system called [MIU](https://en.wikipedia.org/wiki/MU_puzzle).

## System Description
The MU puzzle is a puzzle that was made up by Douglas Hofstadter and can be found in his book, [**Gödel, Escher, Bach**](https://en.wikipedia.org/wiki/G%C3%B6del,_Escher,_Bache). The puzzle uses a simple system called "MIU" to create new strings of symbols. 

### Characters
**M**, **I**, or **U**

### Axiom
The MIU-system only has one axiom: **MI**.

### Rules
Any string resulting from applying these rules on the single axiom or a theorem is a valid theorem. For the following rules **x** is some valid string of one or more of the character and **y** is some valid string of zero or more characters.
1. **xI** → **xIU**
2. **MI** → **Mxx**
3. **xIIIy** → **xUy**
4. **xUUy** → **xy**

### Program Description
Run the **Main** class
#### Press **1** to Generate Theorems from a Provided Theorem
The program takes in a theorem and performs any of the rules that can be applied to it, showing all possible theorems that can be derived in a single step. This does not validate the input theorem, so the results asre only valid if the input theorem is valid, but will be produced regardless.
```
What would you like to do:
1. Generate Theorems (Only Valid if the initial theorem is valid)
2. Validate Theorem
3. Exit
Choice: 1

Enter a MIU theorem: MIUUUUIIIU
Applying rule 2: MIUUUUIIIUIUUUUIIIU
Applying rule 3: MIUUUUUU 
Applying rule 4: MIUUIIIU 
New Theorems: [MIUUIIIU, MIUUUUIIIUIUUUUIIIU, MIUUUUUU]
```
```
What would you like to do:
1. Generate Theorems (Only Valid if the initial theorem is valid)
2. Validate Theorem
3. Exit
Choice: 1

Enter a MIU theorem: MIUIIUIIIIUUUIIUUI
Applying rule 1: MIUIIUIIIIUUUIIUUIU
Applying rule 2: MIUIIUIIIIUUUIIUUIIUIIUIIIIUUUIIUUI
Applying rule 3: MIUIIUIUUUUIIUUI MIUIIUUIUUUIIUUI 
Applying rule 4: MIUIIUIIIIUIIUUI MIUIIUIIIIUUUIII 
New Theorems: [MIUIIUIIIIUIIUUI, MIUIIUIIIIUUUIII, MIUIIUIIIIUUUIIUUIIUIIUIIIIUUUIIUUI, MIUIIUIIIIUUUIIUUIU, MIUIIUIUUUUIIUUI, MIUIIUUIUUUIIUUI]
```
#### Press **2** to Validate a Provided Theorem
The program takes in a desired theorem to be proven and the maximum number of steps to be performed on the axiom **MI** to find the provided theorem.
```
What would you like to do:
1. Generate Theorems (Only Valid if the initial theorem is valid)
2. Validate Theorem
3. Exit
Choice: 2

Enter a MIU theorem: MIUUI
Enter a number of steps: 5
The theorem is valid.
```
```
What would you like to do:
1. Generate Theorems (Only Valid if the initial theorem is valid)
2. Validate Theorem
3. Exit
Choice: 2

Enter a MIU theorem: MUIIIUUIU
Enter a number of steps: 6
The theorem could not be confirmed as valid.
```
