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
      
      ![{3422DA9B-926B-4FBC-A180-8560891ACF9E}](https://github.com/user-attachments/assets/d42ca939-8714-48ae-b1f5-e03b41413bd4)

      Negative Scenario Testing
      ![{2CC7D278-B3FD-4EDA-B993-1F7C8B71F456}](https://github.com/user-attachments/assets/984abe39-9993-404f-81a0-d27e12b87e14)



