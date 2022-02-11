# FetchRewards

## API End Points & Documentation

|Return Type          | HTTP Method | URI               | Request Body             |
|---------------------|-------------|-------------------|--------------------------|
| Void                | POST        | /api/add          | Void                     |
| List\<Transaction\> | PUT         | /api/spend/{qty}  | Quantity of points spent |
| List\<Transaction\> | GET         | /api/balance      | Void                     |

### Add
The "add" resource allows the user to input individual instances of points and time stamps them for server side reference.

### Spend
The "spend" resource allows deduction of a certain number of points from a users local memory collection.

### Balance
The "balance" resource allows a user to retrieve their total points from the DB.
