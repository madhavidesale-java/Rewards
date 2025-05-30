__#Customer Reward Application__  
  This is a spring boot-based RESTful API that calculates reward points for customers based on their purchase transactions over a selected time frame.

__#Assignment__    
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.   
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).   
  
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.  


  
__#API Endpoint__  
    GET /api/rewards/customer/{customerId}?from=date&to=date

    Example - http://localhost:8080/api/rewards/custumer/3?from=2024-01-01&to=2026-02-02

        Sample Response - 
      {
        "customerId": 3,
        "customerName": "Tam",
        "customerAge": 61,
        "monthlyTransactions": {
          "MARCH": 120
        },
        "totalRewardPoints": 90
      }

__H2 Database__   
        ![{F0D20AB0-2788-4573-8D68-EBF869E08B5A}](https://github.com/user-attachments/assets/aeb5b5bc-a118-4ad7-86f9-cd5dacca218b)

__GET API Testing__  
        ![{EE3B5CC4-B840-487D-8C5E-61D59AE140BC}](https://github.com/user-attachments/assets/2d431afe-d3eb-4031-afe9-832d9fb60e28)  

__Multiple Transactions__  
        ![{3747E80D-C423-4227-91C1-819EC354AAB4}](https://github.com/user-attachments/assets/c9d60b85-23be-4c48-921f-4f42cf756f18)

 __Negative Scenario__  
         
      ![{7C674EFC-E4BF-42A0-AC0A-DD853849D4E3}](https://github.com/user-attachments/assets/4130dae6-591c-4aac-89ca-32b3c82eabfd)




