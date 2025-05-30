#Customer Reward Application
  This is a spring boot-based RESTful API that calculates reward points for customers based on their purchase transactions over a selected time frame.

#Assignment
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 
  
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total. 
  
#API Endpoint
    GET /api/rewards/customer/{customerId}?from=date&to=date

    Example - http://localhost:8080/api/rewards/custumer/3?from=2024-01-01&to=2026-02-02

