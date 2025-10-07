package application;

import application.model.entities.Reservetion;
import application.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/mm/yyyy): ");
            Date checkin = sdf1.parse(sc.next());
            System.out.println("Check-out date (dd/mm/yyyy): ");
            Date checkout = sdf1.parse(sc.next());

            Reservetion reservetion = new Reservetion(number,checkin, checkout);
            System.out.println("Reservation:" + reservetion);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.println("Check-in data (dd/mm/yyyy): ");
            checkin = sdf1.parse(sc.next());
            System.out.println("Check-out data (dd/mm/yyyy): ");
            checkout = sdf1.parse(sc.next());

            reservetion.updateDate(checkin, checkout);
            System.out.println("Resevation: " + reservetion);
        }catch (ParseException e){
            System.out.println("Invalid date format");
        }catch (DomainException e ){
            System.out.println("Error in reservation " + e.getMessage());
        }catch (RuntimeException e ){
            System.out.println("Unexpected error");
        }

        sc.close();

    }
}
