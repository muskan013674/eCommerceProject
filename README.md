# eCommerceProject
APIs for eCommerc Project
This ecommerce project has been developed using JPA, MySql, SpringBoot.
This project has 4 components that are connected to respective tables in database
1 Category(Category id(PRI),Category Name)
2 Product(Product id(PRI),Product Name,Product Rate,Category id(MUL))
3 OrderDetails(Order id(PRI),Order Date, Order Delivery Date,Quantity,Product id(MUL), Customer id(MUL))
4 Customer(Customer id(PRI), Customer Name)

The API calls in each component incudes:
1.Category and Product
	a) /addCategory/{Cid}/{Cname}/{Name}/{Rate}
	b) /readAllProducts
	c) /searchByProductId/{id}
	d) /searchByCategoryId/{id}
	e) /deleteByProductId/{id}
	f) /deleteByCategoryId/{id}
	g) /searchByCategoryName/{s}
	h) /searchByProductName/{s}
	i) /listProductsByCategoryId/{id}
	j) /filterProductByRange/{low}/{high}
2.OrderDet 
	a) /createOrder
	b) /readAllOrders
	c) /searchOrderById/{id}
	d) /deleteOrder/{id}
	
3.Customer
	a) /addCustomer/{Cid}/{Cname}
	b) /readAllCustomers	
	c) /findCustomerById/{id}
	d) /findCustomerOrderById/{id}
	e) /deleteCustomerById/{id}



 
