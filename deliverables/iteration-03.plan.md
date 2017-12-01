# Plannable


## Iteration 3

 * Start date: November 21, 2017
 * End date: December 1, 2017

## Process

#### Changes from previous iteration

In our review.md document for iteration 2, we identified two changes we were planning on making to our process: our GitHub workflow and code collaboration.

In terms of our GitHub workflow, we are planning on formally adapting the workflow we started in the middle of iteration 2. Our original plan (at the beginning of iteration 2) was that after someone pushes their work to their own fork, they file a pull request from their fork to the main repo. The next individual to work on the project reviews the pull request and merges if they consider the changes to be acceptable. However, in practice, this led to some team members merging their own pull requests without waiting for a review. As a result, the code on the main repo often did not run properly and did not reflect our best work - which is why we needed a process change. Half way through our last iteration, we identified two individuals to be in charge of merging pull requests on the frontEnd and backEnd respectively. After someone files a pull request, they send out a message on Slack. One of the reviewers looks over the pull request and either merges or provides feedback. For this iteration, we plan on formally adapting this process. This is an important change since the main repo represents the status of our application. Having a main repo that does not function reflects that our application is in disarray. As well, if we ever decide to try out some new feature which does not work, we will not have any version of the project which is functional. From this process change, we are hoping to ensure that the main repo contains the best, most recent and most functional version of our code. In other words, the main repo should be ready for a demo to a user at any time. 

Our second change is encouraging team members to document their code more extensively to improve collaboration. When many team members are working on tasks together, we found that it was difficult to build off each other’s work since it’s often not clear what has already been implemented and how. Thus, this results in a lot of wasted time trying to look through and analyze code (especially when comments could make this much easier). We are hoping that this change will make collaboration easier. We want the development process to become more continuous as pieces of code are handed off from one team member to another. The aim is to save time and create code that anyone could build off of because the thought process is very clear. 

Our success metric for both of these changes is the number of conflicts we encounter. This includes conflicts during fork updates and merging in GitHub as well as design conflicts being addressed in meetings. At the end of this iteration, we expect the number of conflicts to be reduced due to our process changes. We expect that our first process change (having two individuals in charge of merging) would reduce the number of conflicts during personal fork updates and merges to the main repo. Since team members cannot merge their own code, we expect there to be fewer conflicts as everyone is building towards one main design (approved by the reviewers) and not going off in their own direction. Our second process change (encouraging well documented code) should make it clear to each team member what is actually being done in the code and what our main design is. Thus, in meetings, we should not have any conflicts that stem from each individual having a different understanding of the design.

#### Roles & responsibilities

The roles and responsibilities section has not changed since our last iteration. In iteration two, each team member was assigned one or two roles. As a result, team members were not contributing to several different areas of the project at once but rather just a few. Thus, each team member could focus their time and effort onto one aspect of the application and ensure that it had been completed to the best of their ability. Overall, this led to effective and efficient code being written for the entire application as a whole. We can look at the commit history to confirm this information. No team member is consistently changing all of the files in the application. Each team member is, however, consistently changing a subset of files as defined by their role. This shows that each team member is focusing in on specific parts of the application and as a group, we are building a stronger application together. Roles are listed below. 

BackEnd Lead: Alisia
(This individual is in charge of keeping track of the tasks that need to be completed in the backend. This individual compiles a list of tasks they think should be completed in this iteration and assigns each task to a certain backend coder. As conflicts arise, this person speaks with the whole group and facilitates the implementation of a mutually agreed upon solution).
 
BackEnd Coders: Alisia, Julian, Wes, Charles
(These individuals are assigned tasks by their backend lead. They are responsible for writing code to accomplish their tasks and testing their code to ensure that it is functional. They are also responsible for reviewing the work of their peers and making adjustments that they feel would be beneficial. They must also communicate their changes to the rest of the group to ensure that everyone is on the same page).
 
FrontEnd Lead: Jing Yi
(This individual has the same role as the BackEnd Lead but instead deals with the development of the frontend).
 
FrontEnd Coders: Jing Yi, Alison, Egan
(These individuals have the same role as the BackEnd coders but they develop the frontend).

Merging Reviewers: Jing Yi, Alison
(These individuals review, request changes and merge pull requests made by team members: Jing Yi for frontend, Alison for backend.)
 
Video Editor: Wes
(This individual is responsible for shooting and editing the video. This individual will create the video using the agreed upon script. They will then edit the video to ensure it is of proper length and that the different sections of the video flow well into each other).
 
Script Writers: Everyone
(All group members will be working together to come up with a script to be read out during the video. We will all be contributing towards a script that we feel meets the expectations of this deliverable)

#### Events

We found that the meeting times and discussion formats established in our last iteration were very strong and focused. We felt that by following the meeting structure identified in planning2.md, we were able to ensure each meeting covered exactly what we needed in order to move forward. We also found that issues were resolved with extreme thought and team input. To measure this, we can use the number of tasks in the “Complete” column of the GitHub Project Task Board as an indicator. We found that each Friday meeting helped us plan tasks for the next week in an effective manner. Thus, a steady stream of tasks were consistently being marked as “Complete” at the end of each week instead of just at the end of the iteration. As a result, we are planning on following the same general meeting structure with very minimal changes in this iteration. 

We are still going to have two in person meetings. The first will be every tutorial on Tuesday for one hour. The purpose of this meeting will remain the same as it has been in the last iteration. Because of the short amount of time for this meeting, we will focus on conflict resolution. This could be in the format of asking other team members’ for clarification on their design or working together as a team in order to come up with a well-thought out solution to a problem. 

The second in-person meeting will occur every Friday for two hours. As in the previous iteration, this meeting will focus on summarizing what has been accomplished and looking forward to what we need to finish. The meeting will start off with every group member providing a synopsis of what they have accomplished in the last week. We will then open the floor for team members to express any issues that they might have with our design or code that has been written thus far. As a group, we will come up with mutually agreed upon solutions to these problems. Lastly, we will use this meeting to come up with new tasks that we would like to complete over the next week. 

Lastly, we will be having constant conversations with each other over Slack. In our last few iterations, we used Slack mostly for conflict resolution. Whenever someone had an issue that could not wait until Friday, they would raise it on Slack and available members would post their thoughts. Or, if anyone had come to a point in their implementation where they had to make a design decision, they would first post it on Slack to ensure that everyone was on board. However, for this iteration, we will also use Slack for providing updates. We found that after someone files a pull request, the rest of the team is unaware of the changes that have been made to the code base. Thus, after each pull request, we would like the individual to post a brief synopsis of what they implemented and what can be done to build off of it to Slack.

#### Artifacts

Since the general structure of our process has not changed, our artifacts for this iteration will also be the same. We will continue to have two process artifacts: meeting minutes and GitHub Projects.

The meeting minutes will provide a summary of our Friday meetings. It will first provide a detailed explanation of what functionality has been implemented in the frontEnd and backEnd over the past week. It will then include a brief summary of any conflicts that had been brought up and the agreed upon solutions we came to. Lastly, it will provide a list of tasks that we need to accomplish over the next week. However, for this iteration, we will deviate a bit in how we come up with the tasks that need to get done. For this iteration, we need to be more practical in terms of time management with what tasks we can complete. Since this is our last iteration, we need to be more mindful of the amount of time left for us to implement everything we’ve set out. To reflect this, as a group we will first come up with a large list of tasks that would be beneficial to our application if implemented. We will then go through each task and decide whether to keep it. This is based on whether it is feasible for this task to be completed in the next week and whether the result of the task adds significant value to our application. Once we have reduced the list of tasks to those that can be implemented within our time frame, we will assign a priority and due date to each one. As with our previous iteration, tasks with the highest number of dependencies will have the highest priority. We will also assign each task a due date in order to ensure that our code development timeline is extremely disciplined and so we can complete all our tasks on time. Tasks will be assigned to team members based on whether they have the relevant background experience and whether they would like to work on it. However, in addition for this sprint, tasks will also be assigned to team members based on their own schedules. Team members will be encouraged to work on tasks with due dates that fit into their own schedule to ensure that each task is completed on time. 

Similar to our last iteration, we will keep track of tasks by using GitHub Projects Task Board. Once again, we will have columns for BACKEND: Current sprint, FRONTEND: Current sprint, Completed and Video. We will not have a column for Backlog. Based on our process for coming up with tasks, we believe that all of our listed tasks need to be completed and so they cannot be on the backlog. All tasks must be listed as being active in the current sprint. As usual, tasks will be listed in the columns from highest to lowest priority. Each task will have added info such as a brief description of it, who is working on it and it’s due date.

#### Git / GitHub workflow

Each team member has created a fork of our main repo: project-team-15. Before anyone starts working on the code, they first update their fork to ensure that it is up to date with the most recent version of the main repo. They then write their code, while periodically making commits to their fork. Once they have decided that they are finished with their code development for that day, they push all their commits to their own fork. They then file a pull request from their fork to the main repo and send out a message on Slack stating that there is a new pull request. They also provide a brief description of what they have done and how and what further development can ensue. We have identified two individuals in charge of merging pull requests for the frontEnd and backEnd respectively. They then look over the pull request that has been filed. If they agree with the changes that have been made, they merge the pull request. If not, they go back to the individual who filed the pull request and ask them to make changes. If they come across a conflict that they cannot resolve, the rest of the group gets involved to come up with a solution. 

We chose for everyone to have their own forks of the main repo since this is very similar to the workflow of the assignments. Thus everyone has worked with this process and is aware of how code development occurs and how pull requests are filed. This was specifically chosen so that we would not have to learn a new process and would not have to work out all the related bugs of a new workflow. We can instead work effectively with a process we are already familiar with. We chose to have two team members’ in charge of merging and reviewing pull requests to ensure that only good code is being merged into the main repo. These two individuals have a clear sense of what the final product should look like (while other team member’s might be mostly familiar with their own tasks and not be as clear on all other aspects). Thus the reviewers can clearly discern whether a new piece of code builds up the product towards the final goal. If it does not, they can then suggest the appropriate revisions to be made.

## Product

#### Goals and tasks

Goals
 * Ensure that information from the frontEnd is being sent to the backEnd
 * Ensure calculated information from the backEnd is being displayed in the frontEnd
 * Improve the algorithm to better assign priorities to tasks
 * Increase user interactivity with the calendar by improving task deletion and restarting capabilities 
 * Incorporate some sort of persistence of the calendar (either through exporting the calendar or serializing the data)
 * Create a video to summarize our accomplishments
 
Tasks
1) Connect frontEnd with backEnd. Ensure frontEnd is sending appropriate arguments to backEnd methods. Ensure backEnd is sending study time allocations to frontEnd.
2) Ask users for more parameters related to tasks that need to be completed (eg. assignment weighting, difficulty). Use these parameters to create a better scheduling algorithm.
3) Implement task deletion in frontEnd calendar and ensure tasks have been removed in backEnd’s list of tasks.
4) Implement calendar export functionality as image file.
5) Persist calendar by serializing the objects inside.
6) Write script for video to show what has been accomplished thus far.
7) Film and edit the video.


#### Artifacts

Our first artifact is code and code output. This specifically pertains to the implementation of the algorithm. Since the scheduling algorithm is purely implemented in code, the only way to present its design is through its output. The code output will show a progression of the evolution of the algorithm. We will be able to see how the allocation of study time changes as the algorithm becomes more complex and asks the user for more input. 

The second artifact will be the calendar export as an image file. This will provide a representation of what we want our user to walk away with after they have used our application. We can thus orient ourselves as a user. We can ask ourselves if there is anything else that we would need or would be helpful to us once we are finished interacting with this application. 

Our last artifact is the video. It provides a good summary of what we have accomplished in this sprint. It gives us a very quick overview of our main goal, what we have accomplished thus far and what is left to do for the final demo. It serves to orient ourselves to make sure we are building a product that meets our final goal.
