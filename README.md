__#Customer Reward Application__  
  This is a spring boot-based RESTful API that calculates reward points for customers based on their purchase transactions over a selected time frame.

__#Assignment__    
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.   
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).   
  
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.  


  
__#API Endpoint__  
    GET /api/rewards/customer/{customerId}?from=date&to=date

    Example - http://localhost:8080/api/rewards/customer/3?from=2024-01-01&to=2026-02-02

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
      ![image](https://github.com/user-attachments/assets/3a0a84e3-7cd0-498a-9a6e-f320661e408e)
  

__Multiple Transactions__  
       ![image](https://github.com/user-attachments/assets/2249e437-8351-478b-81d1-4bae386b14bf)


 __Negative Scenario__  
        ![image](https://github.com/user-attachments/assets/2f1a0875-8337-43d4-81a1-92656cc04785)





