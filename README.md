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
