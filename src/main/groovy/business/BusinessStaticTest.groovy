package business

import business.domain.*

class BusinessStaticTest{

    private Customer myCustomer = new Customer(name:"Bruno Veronesi",email:"endeios@gmail.com",id:1)
    List<Item> items = [
        new Item(id:1,name:"1L Dom perignoc del '54",price:1000),
        new Item(id:2,name:"2L Dom perignoc del '54",price:2000),
        new Item(id:3,name:"3L Dom perignoc del '54",price:3000)
    ]


    Invoice invoice = new Invoice(id:1,date:new Date(),items:items)

    List<Customer> customers = [myCustomer]

    public Invoice getData(){return invoice}


}
