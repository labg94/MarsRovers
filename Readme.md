# Mars Rovers

Hi interviewer I did this project using hexagonal architecture, due I found it fascinating and helps a lot with maintainability issues, I also attached a UML diagram to show the structure (I created it using Intellij IDEA).


## Assumptions

1. It only mentioned the limits of the plateau and that's it, so if the rover exceeds the limits should be count as lost

2. also if the rover starts in a position out of the bounds counts as lost

3. in case the coordinates where given in a bad way the rover will have the default position  0 0 N

## Comments

 it took me a bit longer than 3 hours (around 5) due I focus on the best practices using TDD and clean code then trying 
 to refactor some code, I think it will explain itself better than any comment that I can make.


## how to run it

first you should run inside the main folder (where is this file ✌🏻)

```maven
mvn clean install
```

then when it finishes run the following command

```bash
java -cp target/MarsRovers-1.0-SNAPSHOT.jar me.lbenavides.App
```

finally, when the program ask you for a file, you can use any you want (following the format explained in the task),
but I let you example.txt to try.

