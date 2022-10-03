Car Insurance Application

The goal is to define the value of the compensation to be paid by the insurer.
We have three things initially:

1. car: Audi A6, registration number: ABC 1234, insurance date: March 2021,
claim date: June 2021, car value at the time of insurance: PLN 40,000, damage assessment: PLN 4,500

2. car: VW Passat, registration number: DEF 567, insurance date: January 2021,
claim date: September 2021, car value at the time of insurance: PLN 12,000, damage assessment: PLN 7,730

3. car: Skoda Octavia, registration number: GHI 8910, insurance date: January
2020, date of reporting the damage: May 2021, value of the car at the time of insurance: PLN 25,000, loss assessment: PLN 7,000

The insurance period is one year.
The current value of a car drops by 1% of its value every month. Example:
If the value of the car was set at PLN 15,000 in January 2021, its current value in March
the value will be PLN 14 700.
If the value of the damage exceeds 70% of the CURRENT value of the car, then the damage
is considered as total and the value of the compensation to be paid is just 70% the current value of the car.
If the car insurance period has expired, the amount of compensation to be paid is PLN 0.
Otherwise, the value of the compensation to be paid is equal to the value of the damage.

In addition to this functionality, the user login/register option has been introduced. After logging in, we gain access to remove any insurance offer. 
Additionally, the option to filter the results by car name and registration number has been added.

Methods from the services have been unit tested.

In the file "SQLcarinsurance.txt" there is a query that needs to be entered into the h2 database to add the above 3 cases. 
Data for logging into the h2 database can be found in the file "src / main / resources / application.properties" in the lines with username and password.

Tools and Technologies Used:

Java, JSP, CSS, JS, Spring Boot, H2 Database, SQL.