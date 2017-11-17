# YOUR PRODUCT/TEAM NAME

## Iteration 02 - Review & Retrospect

 * When: November 17, 2017
 * Where: Bahen 2nd Floor

## Process - Reflection

#### Decisions that turned out well

1) Organization of Friday Meetings
As a group, we felt that we really made good use out of each of the Friday meetings that we had. Our Friday meetings were a chance for the group to discuss conflicts they had, tasks they worked on during the previous week and what to work on during the next week. We were able to efficiently analyze what was previously done and build off that to move our project forward. As well, we were also able to look into the future and foresee any issues we may come across and address them earlier rather than waiting until later. As a result, we rarely had to go back in our product, redesign a certain part of the application and then get back on track. These meetings truly helped us to use our time to work on the project efficiently. Artifact_01 is an image of the meeting minutes we had for one of our Friday meetings.

![ARTIFACT_01](/deliverables/images/deliverable_2/ARTIFACT_01.png)

2) Use of GitHub Projects
As part of review_1.md, we decided that we wanted to use Slack and GitHub projects more in iteration 2 than we did in iteration 1. We stopped using Facebook messenger completely and are now fully using Slack. As well, we started using GitHub projects to list out all the tasks for a certain week and categorize them in different columns. Being able to see tasks arranged visually like so helped us to clearly define what we needed to work on and what could wait until later. We could also easily determine our progress by looking at the number of tasks under the Completed column and decide to pick up the pace if need be. Having all the tasks clearly labeled out on this dashboard helped to ensure that everyone was working on agreed upon tasks that would lead us to meeting our end goal. Artifact_02 is an image of our GitHub project towards the end of the iteration.

![ARTIFACT_02](/deliverables/images/deliverable_2/ARTIFACT_02.png)

3) GitHub Forks
The last positive decision we made was deciding for each team member to create their own fork of the main repository. This was an extremely beneficial decision as there were very few conflicts that we had to deal with when merging code from someone’s fork to the main repo. As well, since there were no branches, group members were not confused about which ideas we would be pursuing and which we would not be. Everyone was aware that whatever was on the main repo was the idea we were going with and so we could all build the application towards one common idea. In other words, it ensured that everyone was on the same page with the idea and that group members were not building the application in several different directions.

#### Decisions that did not turn out as well as we hoped

1) GitHub Pull Requests
Our original idea was that when someone had finished working on their code, they would submit a pull request and the next person to work on the code would merge the pull request to the main repo. However, in practice, this did not occur. Instead, some team members merged their own pull requests into the main repo. As a result, the code on the main repo sometimes did not compile/run, was not documented or was poorly written. Thus our main repo did not reflect a clean and working copy of the code. 

2) Updating Group on Changes Made
We found that after an individual had filed a pull request, on Slack, they would simply let everyone know that there was a new pull request. They would not inform others about the specific changes that they had made and this information would not come to light until the Friday meeting. This was not an issue when everyone was working on their own individual tasks. However, as group members had to work on tasks together, collaboration became difficult. Group members had to manually go through all the code and find out what had been changed in order to ensure they were building the app up. However, this was quite time consuming and inefficient.

#### Planned changes

As mentioned above, our main issue was the handling of pull requests. Therefore, we have been in the process of changing how we merge pull requests. For the second half of the iteration, we shifted our initial approach and instead had one person responsible for merging pull requests for frontEnd code and another person for backEnd code. These two individuals were able to give feedback to the person who made the pull request and also ensure that the main repo represented our best version of the code.   Artifact_03 is an example of receiving feedback after filing a pull request (after our process change).  We will continue to have two individuals in charge of merging requests for frontEnd and backEnd respectively for iteration 3, as we have found that this resulted in a much better pull request process.

![ARTIFACT_03](/deliverables/images/deliverable_2/ARTIFACT_03.png)

The second major change would be adding comments to their code and writing Javadocs. Overall, this would make it much easier for team members to work on larger tasks together. It would also save lots of time as team members could clearly see what has already been implemented and how. As a result, new code can be added much more quickly helping us to meet our deadlines and goals.

## Product - Review

#### Goals and/or tasks that were met/completed:

1. Finalize UI/Control Flow of App and User Inputs
At the beginning of the iteration, we made a concrete list of items we would need as input from the user. We then had to modify our UI designs in order to incorporate the input fields into our application view. We finished this task at the beginning of the iteration so that we had a clear idea of what we were working towards. Artifact_04 are the UI mockups we created. 

![ARTIFACT_04](/deliverables/images/deliverable_2/ARTIFACT_04.png)

2. Create CRC Cards
After the first step, we had a concrete idea of what our application would look like. Next we moved onto the implementation through CRC cards. We made these cards for all the classes that we needed in both the frontEnd and backEnd. This helped us to see how different components of our code would be communicating with each other and how they would work together to fulfill the overall goal. Artifact_05 is a sample of some of the CRC cards we created. 

![ARTIFACT_05](/deliverables/images/deliverable_2/ARTIFACT_05.png)

3. Build backEnd Code to log input and create objects
Next, we implemented all the necessary classes in the backEnd. We also created a main class (StartingPoint) so we could test our application as though it was a command-line application. This helped us to ensure that user input was correctly being translated into objects and chronological order of tasks was being maintained in the calendar. Artifact_07 is the output of our WeeklyCalendar object after a user has entered their tasks for the week. It correctly schedules all the tasks at the correct times and also suggested what assignments/tests to work on during study times.

![ARTIFACT_07](/deliverables/images/deliverable_2/ARTIFACT_07.png)

4. Build frontEnd Code to display calendar and promote user interactivity
At the same time as the backEnd code was being built, the other part of our group was building the frontEnd code. They were creating a user friendly page so users could enter their assignments/tests for the week. They also created a page where tasks can be added on the side panel and the calendar for the week is shown on the main panel. Artifact_08 is our code for the frontEnd. It can be found under Plannable/src/frontEnd. Artifact_09 is an early image of the calendar at the beginning of the iteration. 

![ARTIFACT_08](/deliverables/images/deliverable_2/ARTIFACT_08.png)

![ARTIFACT_09](/deliverables/images/deliverable_2/ARTIFACT_09.png)

5. Create video 
Finally, we created a video to mainly demo our frontEnd as we did not have time to integrate the frontEnd with the backEnd. The video demonstrates how a user is able to enter the assignments/tests they have for the week as well as the tasks they have on each day. However, the main purpose of this application is to allocate sections of study time to preparing for certain tests and assignments. This functionality has already been implemented in the backEnd but we did not have enough time to connect it to the frontEnd. Thus, we added a static view to our video to show what this will look like once the backEnd has been connected. Artifact_10 is our video which demos the final product of this iteration.

#### Goals and/or tasks that were planned but not met/completed:

1. Connect frontEnd with backEnd
One main task that was not completed was the connection between the frontEnd and the backEnd. This is an extremely crucial task as it brings the value of the scheduling algorithm (in the backEnd) to a format that the user can easily decipher (the calendar in the frontEnd). We did not complete this task in this iteration simply because we did not have enough time. Planning, discussing and coding each section took up more time than we expected, so we ran behind and did not have enough time to combine the two ends. However, since this task is so crucial, it is our top priority for the next iteration. 

2. Algorithm to prioritize tasks
In our planning.md, we had said that we wanted to implement an algorithm that would schedule when and for how long to work on certain assignments/tests based on a priority. We had decided that this priority would be a culmination of the due date, the weight of the assessment and the user’s perspective on the course. However, in our current algorithm the priority of an assessment is only dependent on the due date. In this iteration, we did not have enough time to take into consideration the other factors we had initially planned. We will add onto our algorithm in the next iteration.

## Meeting Highlights

Going into the next iteration, our main insights are:

1. Combine frontEnd with backEnd
This is an important task that needs to be completed as it shows our entire solution to the problem that we are trying to solve. It takes our solution of a scheduling algorithm, which is currently implemented entirely in code, and brings its value in an easy to read and visual format that will make the life of the user easier. 

2. Improve Scheduling Algorithm
Currently the priority of an assignment/test is determined entirely by its due date. However, this is not realistic since in real life the priority is also based on the weighting of the assessment and the course difficulty. Thus, we will aim to make our algorithm more realistic by asking users for these inputs and working them into our algorithm to calculate new and better priorities. 
