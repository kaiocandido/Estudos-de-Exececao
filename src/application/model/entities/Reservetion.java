package application.model.entities;

import application.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservetion {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sfd1 = new SimpleDateFormat("dd/MM/yyyy");

    public Reservetion(){}

    public Reservetion(Integer roomNumber, Date checkin, Date checkout) throws DomainException{
        if (!checkout.after(checkin)){
            throw  new DomainException("Check-out date must be after");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void updateDate(Date checkin, Date checkou) throws DomainException{
        Date now = new Date();
        if (checkin.before(now) || checkou.before(now)){
            throw new DomainException("Reservation date must be after check-in date");
        }
        if (!checkout.after(checkin)){
            throw  new DomainException("Check-out date must be after");
        }
        this.checkin = checkin;
        this.checkout = checkou;
    }

    @Override
    public String toString() {
        return "Romm " + roomNumber +
                ", check-in " +
                checkin + sfd1.format(checkin) +
                ", checkout=" + sfd1.format(checkout)+
                ", " + duration() + "nigths";
    }
}
