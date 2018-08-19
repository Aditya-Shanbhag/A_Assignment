Basic Idea for game.

It's a simple first person exploration game.
1. On Launch one gets to create an avatar.
	- Can choose gender, clothing items and accessory.
2. Once created one can explore map by providing X, Y co-ordinates on CLI and moving to that location. (Currently limited to 100 * 100 in size).
	- As one explores there are certain valuable items to be found, and gain certain experience points.
	- There are also few location, where there are some obstacle like some warrior, with whom U'll fight. n winning one gains certain experience points.
3. Scoring
	- Currently have added 2 ways to score. Either winning a fight or by discovering valuable items.
	- You gain experience points, once you gain certain experience points your level increases.
4. The interface is currently all CLI, and currently no plan of any fancy graphics.
5. Once can save and resume a game.


Following are some details about the classes.
1. com.assignment.game - is the parent package, under which you will find 
	- Main.java which is entry point to application.
	- GameController and GameService, which get the application rolling and control application.

2. com.assignment.game.cli.service - has CliService, which handles user input and output.

3. com.assignment.game.player - model and services for Player and his/her appearence.

4. com.assignment.game.score - deals with user scoring.

5. com.assignment.game.state - deals with gmae state, saving and restoring.


General Note about design
1. In general have divided individual operations into individual packages, such that each class will have single responsibility.
2. Have designed classes in such a way that it can be easily extended to add in new feature to expand the gameplay.
3. Each package is divided into minimum 2 sub packages
	- com.assignment.game.XXXX.Model which will have all entities.
	- com.assignment.game.XXXX.Service which will have services, which operate on corresponding model.