Name: Jonathan Yu
NetID: jy178
Hours Spent: 3.5
Consulted With: NONE
Resources Used: NONE 
Impressions: 
I liked the assignment. The problem was interesting, and the animations were a pretty cool idea.
I thought the wording on the assignment was a bit confusing. One part in the FAQ said not to do
all the physics calculations in one loop, but you ultimately had to have one master for loop to keep track of t.

Question 1: What is the final position of the planets after 1,000,000
seconds with a timestep of 25,000?
1.4657072579675333E11 2.9603571820026024E10 
2.265919409244593E11 2.4055025673504623E10 
3.863596759797241E10 4.2569286276404396E10 
26826.758124022024 2979.2451384889378 
1.0243682251001347E11 3.4391417962295876E10 

Question 2: For what values of timeStep, does the simulation no longer behave correctly? 
The simulation no longer behaves correctly when the value of timeStep is the same as the value of totalTime.
This makes sense since the orbital motion is based off the updating of the forces, velocities, and positions after
multiple increments of time. If the values are the same, there is a single increment, which only allows for straight-line
motion, not orbital.