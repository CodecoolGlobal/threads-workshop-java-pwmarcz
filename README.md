# Threads workshop

This is a simple workshop on Java threads. We will be implementing a coffee shop. Here is how it works:

- Take orders from customers using `game.takeOrder()` (this takes 1 s). There are 3 cash registers, so you can take up to 3 orders simultaneously.
- Each order is for one coffee and one sandwich.
    - Make coffee using `game.makeCoffee(order)` (this takes 1.5 s). There is only one coffee machine so you can make only 1 coffee at a time.
    - Make sandwiches using `game.makeSandwich(order)` (this takes 2 s). You can make up to 5 sandwiches simultaneously.
- We will be monitoring how many of these you are able to make per second.

## Serve orders

Open the `CoffeeShopTemplate` class. Run the main method (Ctrl-Shift-F10). 

You can see that we're trying to serve coffee orders and managing about 1 per second. Can you make it faster using threads? 

Remember that you can take oly 3 orders at a time.

## Control access to coffee machine

Now, try to actually make coffee (run `game.makeCoffee(order)`). Unfortunately, this will not work with multiple threads: there is only one coffee machine, so only 1 coffee can be made at at time :(

Try to control access so that only one thread makes coffee at a time.

## Create a task queue

Right now, we are not taking orders when we are making coffee. Try to do better:

- 5 threads will be taking orders, and putting them in a queue (use [BlockingQueue](https://docs.oracle.com/javase/9/docs/api/java/util/concurrent/BlockingQueue.html) and `LinkedBlockingQueue` class);
- 1 thread will be taking orders from a queue and making coffee.

What happens if the queue has limited capacity?

## Make a sandwich

Implement making sandwich (`game.makeSandwich(order)`). Remember that you can make several sandwiches at a time, so you'll probably need multiple threads.

## Implement a queue yourself

Finally, try to implement your own queue. See `OrderQueue` for the class skeleton. You will probably need guarded blocks/methods (`synchronized`), and `notify/wait` functions.

- First, assume that the queue is **unlimited** (`capacity == 0`). This is an easier case, because `put()` will always succeed immediately.
- After your implementation is working, implement capacity limits. This means `put()` will have to block your thread if the queue is full.
