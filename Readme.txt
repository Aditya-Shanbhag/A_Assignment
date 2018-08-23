Basic Idea for game.

It's a simple first person exploration game.
1. On Launch one gets to create an avatar.
	- Can choose gender, clothing items and accessory.
2. Once created one can explore map by providing X, Y co-ordinates on CLI and moving to that location. (Currently limited to map size of 10 * 10).
	- As one explores there are certain valuable items to be found, and gain certain experience points and health.
	- There are also few location, where there are some obstacle like some fighter oponents are present, with whom player will have to fight. Winning one gains certain experience points.
3. Scoring
	- Currently have added 2 ways to score. Either winning a fight or by discovering valuable items.
	- You gain experience points, once you gain certain experience points your level increases.
4. The interface is currently all CLI, and currently no fancy graphics of any kind.
5. Once can save and resume a game.

The game is very rudimentry and provides bare minimum functionality required. There is plenty of scope for enhancement.


Following are some details about the classes.
1. com.assignment.game - is the parent package, under which you will find 
	- Main.java which is entry point to application.
	- Application.java which get the application rolling and controls application.

2. com.assignment.game.cli.service - has CliService, which handles user input and output.

3. com.assignment.game.player - model and services for Player and his/her appearence.

4. com.assignment.game.score - deals with user scoring.

5. com.assignment.game.state - deals with gmae state, saving and restoring.

6. com.assignment.game.state - deals with game play.


General Note about design
1. Its a maven project, and requires JAVA 8 to compile.
2. In general have divided individual operations into individual packages, such that each class will have single responsibility and operates on corresponding model.
3. Instead of creating singleton, I have created a session factory which deals with providing corresponding services.
4. Have designed classes in such a way that it can be easily extended to add in new feature to expand the gameplay.
5. Each package is divided into minimum 2 sub packages
	- com.assignment.game.XXXX.Model which will have all entities.
	- com.assignment.game.XXXX.Service which will have services, which operate on corresponding model.
6. Classes are currently not thread safe as they currently operate only in sequential mode.
	
7. There is scope for writing Test Cases for individual service classes, to test desired behaviour. (This is pending due to time constraint.)

