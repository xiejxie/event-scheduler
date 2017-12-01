# Plannable

## Iteration 03 - Review & Retrospect

 * When: December 1, 2017
 * Where: Bahen 2nd Floor

## Process - Reflection

#### Decisions that turned out well

1) Meeting Structure

We believe that using the same meeting structure as iteration 2 was a good decision. Once again we were able to resolve issues quickly and as they arose instead of waiting until the end of the iteration. We were also able to efficiently plan our tasks to ensure that development was moving forward and code was consistently being written. This led to timely development and so we were able to meet our deadlines and complete most tasks by the end of the iteration. Artifact_01 is an image of our meeting minutes. Artifact_02 is an image of our task board towards the end of the sprint.

2) Merging Pull Requests

Another good decision we made was having two individuals responsible for merging pull requests. This was a successful decision since it ensured that we were constantly building our application towards the final goal. These two individuals had a clear idea of what our final application should look like and so they could immediately tell if some code changes were aligned with our main goal or not. As a result, we had very few issues relating to one aspect of the application being designed for a certain understanding and another aspect being designed for another understanding. Artifact_03 is an image of pull requests only being merged by one of the two reviewers. 

3) Code Documentation and Slack Update

Encouraging everyone to document their code and provide synopses of their pull requests was another good decision. This process change greatly improved collaboration as team members could easily hand off parts of code to other members to complete. As a result, very little time was spent trying to figure what had been implemented and how. Instead the focus transitioned to improving code that had already been written. Overall, this resulted in greater team involvement and understanding for all team members and a stronger application. Artifact_04 is an image of a Javadoc and Artifact_05 is an example of a synopses posted to Slack after a team member filed a pull request.

#### Decisions that did not turn out as well as we hoped

1) Assigning code tasks due dates

In our planning document, we stated that since this is our last iteration, we wanted to focus on completing code tasks in a timely manner. We suggested that we would assign each task a due date (during the week) to be completed by so we could move on to newer tasks. We started this at the beginning of the sprint but quickly found that due dates were being missed. We were all getting busier with other tests and assignments. Instead, we decided to fall back on our original process and instead have a set of tasks that need to be completed by the end of each week. 

2) Updating of Project Task Board

In iteration two, after a team member completed a task, they would move the task note into the “Completed” column in the GitHub Project Task Board. We were hoping that this would continue into iteration three. However, for this iteration, team members forgot to update the task board as they completed tasks. Instead, the task board was updated weekly to reflect what was discussed in the Friday meeting and what was being planned for the following week. This was usually done by the same individual who wrote the meeting minutes.  Thus the task board was not an accurate representation of the status of tasks during the week. Team members should have been reminded more frequently to do this updating. 

#### Planned changes

We feel that over the past two iterations, we were able to take a very good process and work out all the bugs in it very early on. Thus, if there was going to be another sprint, we do not feel that we would need to make any major changes. The way our process was structured ensured that there was a strong sense of time management and prioritization. Code was continuously being written every week instead of just at the end of the sprint (the fact that we completed most of the tasks we set out to exemplifies this). Prioritized tasks were also being completed early on in the sprint ensuring that development could continue smoothly. As well, the process ensured there was transparency so members in the frontEnd still knew what was happening in the backEnd and vice versa. This occurred through updates provided during meetings, posts on Slack and comments in code. Thus, everyone had a general sense of the direction the entire application was headed which meant very few conflicts in design understanding. Lastly, roles and task assignments were very clearly set out. Thus, we did not have any team members who were consistently contributing to all aspects of the application. Instead, each team member could focus in one aspect of the code and ensure that it was written to the best of their ability. This led to a stronger final product.

## Product - Review

#### Goals and/or tasks that were met/completed:

1) Connecting frontEnd with backEnd

The main product goal set out for this iteration was connecting the backEnd with the frontEnd. The solution we are proposing to the problem of student time management is implemented in the backEnd. However, the frontEnd brings this solution to the user in an easy to read format. Both of these aspects need to be connected in order for our application to be considered an effective solution to the main problem. Artifact_06 is an image of the backEnd algorithm splitting the study time according to the tasks the user has entered. This time allocation is then printed to the user in the frontEnd in an easy to read manner. 

2) Increasing user input for tasks and improving scheduling algorithm

For this iteration, we also asked the user to enter more information about the tasks that they have to complete (eg. assignment weighting, course difficulty). This was in order to make our algorithm as realistic as possible. Previously, the algorithm only based study time allocation on task due dates. However, in practical terms, we often use other factors in order to determine how much time to spend on a task. Thus, the algorithm was updated in order to reflect this. Artifact_07 is the page where users are asked to input information about the tasks they must complete. Artifact_08 is the code for the scheduling algorithm located in Plannable/src/backEnd/TODOManager.java.

3) Exporting calendar as image

After the user receives their final calendar output from the application, they can export the image as a .png file. We implemented this feature so that there is some sort of persistence for the final calendar. This way, the user does not have to keep the application screen open for the entire week. Instead, they can print out the image file or save it and thus have access to it at any time and place. The image file is the same as Artifact_06. 

4) Creating video

The last task completed was creating the video. We used the video for iteration 2 as our base and added extra demos of newly implemented functionality. The video provided a brief introduction of what our initial problem was and how we planned on solving it. It then performed a demonstration of what functionality has been implemented. Thus, we were able to compare what we had initially set out to do with what has already been done. We can now use the few days left before our final demo to bridge these two sides and ensure that they match up with each other. Artifact_09 is our video.

#### Goals and/or tasks that were planned but not met/completed:

1) Serializing calendar object for storage

We did not have enough time to serialize the calendar object to ensure that the a user’s data persists over multiple application runs. When assigning tasks priority, we all agreed that improving the scheduling algorithm was more important than serializing the calendar object. Thus, most of the backEnd team’s time was spent on improving the algorithm. If we had another full sprint remaining in our project, we would implement serialization. However, we only have a couple of days left before our final demo and the calendar can be exported as an image file. Thus, it is likely we will not be implementing any serialization.

## Meeting Highlights

Going into the next iteration, our main insights are:

1) Planning our presentation

For the days leading up to the final demo, we will stop work on the code and instead focus entirely on our final demo. This will include deciding how to organize the flow of the presentation, who says what and when and how we present our product and process. We will also spend some time figuring out the logistical details such as if we want to create a powerpoint.

2) Compiling artifacts from previous iterations to show process/product progression

We need to go through our review.md files for the last few iterations. We need to figure out which artifacts exemplify process and product decisions we had to make over the course of the project. Along with each artifact, we also need to be able to justify the design decision we made behind the artifact and the consequences that it had on our project.
