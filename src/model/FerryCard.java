package model;

public class FerryCard {

    private Passenger owner;
    private int balance;

    public FerryCard() {
        balance = 0;
    }

    // getters
    public int getBalance() { return balance; }
    public Passenger getOwner() { return owner; }

    //MODIFIES: this
    //EFFECTS: sets owner to parameter
    public void setOwner(Passenger owner) {
        this.owner = owner;
    }

    //MODIFIES: this
    //EFFECTS: sets balance to parameter
    public void setBalance(int balance) {
        this.balance = balance;
    }

    // TODO: CLEAN UP STARTER AND SOLUTION VERSIONS
    // REQUIRES: balanceAdded > 0
    // MODIFIES: this
    // EFFECTS: adds balanceAdded to balance available on this card
    public void topUp(int balanceAdded) {
        //balance += balanceAdded; //correct way
        balance = balanceAdded; //added bug where we don't add balance, just reset it
    }

    // TODO: CLEAN UP STARTER AND SOLUTION VERSIONS
    // MODIFIES: this
    // EFFECTS: if this does not have at least ticketPrice available on balance,
    // returns false; otherwise creates a new ticket, adds the ticket to ticket
    // and subtracts ticketPrice from balance.
    public boolean buyTicket(Ferry ferry) {

        int ticketPrice = ferry.getTicketPrice();

        if(balance < ticketPrice) {
            return false;
        }

        Ticket ticket = new Ticket(ferry, owner);
        ferry.addTicket(ticket);
        //balance -= ticketPrice; //added bug where we don't subtract the ticket price from the balance
        return true;
    }


}