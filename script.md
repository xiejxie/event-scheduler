# Script #

## Introduction (30-45s) ##

Our application, Plannable, is a time management tool for university students. However, unlike other organization
tools, Plannable allows you to enter what times you’d like to study and what tasks you need to complete. It then
assigns tasks for you to complete during each of your study times and even suggests how long should be spent on
each task. The main problem Plannable is trying to solve is the challenge of prioritizing what to work on when.
As university students, we often find that after working for some time, we haven’t finished urgent tasks or haven’t
made as much progress as we would have liked. Plannable is our solution to this problem. In this sprint, we did not
have enough time to combine the front end and the back end. Thus, in this demo, we will be demoing our progress for each
section separately.

## Front End ##

### Overview ###

The design of the front end was crafted with the primary goals of being both clean and eye catching. The application code was developed using JavaFX.
Our user information input is split into a multi step process for convenience and ease of use.

The first screen is where you enter your evaluations (in essence, what you need to get done, when you need to get it done by and how
long it will take you to finish).

Time input has four steps.
* In Step 1, we add time blocks for our courses, for example, CSC301, CSC369
* In Step 2, we add our extracurriculars (including any part time work) and any commute time if its greater than half an hour
* In Step 3, we add time that we think we will be asleep for
* In Step 4, we add study time, this is time we want dedicated to work
Our program outputs a nicely formatted calendar with all our time blocks clearly displayed. Currently, because the Front
and back end are not hooked up yet, it is currently missing the scheduled study time. So although we see the time that we have allocated, it is not yet split into different time chunks. This will be implemented as a next step.
