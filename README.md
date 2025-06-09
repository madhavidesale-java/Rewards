## Customer Reward Application
A spring boot RESTful API that calculates reward points for Customers based on their purchase transactions over a given date range.

---
__# Overview__

This application allows user to calculate rewards based on Customer transaction. Reward points are assigned according to the amount spent:
  - $1 spent over $50 = 1 point
  - $1 spent over $100 = 2 point   
Points are calculated per transactions and aggregated over a specified date range.
---
__# Features__

- Calculate total reward points for requested customer
- Provide all transactions history for specified time range.
- Restful API Design
- Global Exception handling
- Unit and Integration Tests
- In memory database H2 with JPA repositoty
- Maven dependency management
---  
__# API Endpoint__  

    Method - GET   
    Endpoint - /api/rewards/customer/{customerId}?from=date&to=date  
    Description - Get reward point for a customer  
    Example - http://localhost:8080/api/rewards/customer/3?from=2024-01-01&to=2026-02-02  
    
    Sample Response - 
      {
        "customerId": 3,
        "customerName": "Tam",
        "customerAge": 61,
        "monthlyRewards": {
          "MARCH": 90
        },
        "totalRewardPoints": 90,
        "transactions": [
          {
            "id": 5,
            "customerId": 3,
            "customerName": "Tam",
            "customerAge": 61,
            "amount": 120,
            "transactionsDate": "2025-03-03"
          }
        ]
      }

__# H2 Database__   

  ![{F0D20AB0-2788-4573-8D68-EBF869E08B5A}](https://github.com/user-attachments/assets/aeb5b5bc-a118-4ad7-86f9-cd5dacca218b)

__# GET API Testing__  

     1. List of transactions in 5 months for Customer Id 2
  ![image](https://github.com/user-attachments/assets/4adfdc70-39f0-4c8c-b1c5-51e8ee6c5add)



      2. List of transactions in 3 months for customer Id 2
    ![image](https://github.com/user-attachments/assets/a8bb1b47-5731-45bc-af40-af90a612e712)


      
     3. List of transactions in 3 months for customer Id 5 (Negative scenario)
  ![image](https://github.com/user-attachments/assets/75041b78-9310-4bae-a69f-7fca658f67b2)






