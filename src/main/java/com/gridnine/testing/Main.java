package com.gridnine.testing;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args){
            List<Flight> flights = FlightBuilder.createFlights();
            Scanner in = new Scanner(new InputStreamReader(System.in));
            FlightSortable flightSortable = new FlightSorted();
            while(true) {
                System.out.print("Выберите сортировку по правилу, указав команду:\n" +
                        "1. Исключения перелётов из общего списка до текущего момента времени. \n" +
                        "2. Исключения сегментов из общего списка с датой прилёта раньше даты вылета. \n" +
                        "3. Исключения перелётов из общего списка с проведённым на земле временем свыше двух часов. \n" +
                        "4. Команда для завершения программы. \n" +
                        "\n   Введите команду: ");
                int input = in.nextInt();
                if (input==1) {
                    System.out.println("\n Из общего списка исключены перелеты до текущего момента времени: \n");
                    Flight.printList(flightSortable.departureBeforeRequestedDateExclude(flights, LocalDateTime.now()));
                }
                if (input==2) {
                    System.out.println("\n Из общего списка исключены сегменты с датой прилёта раньше даты вылета: \n ");
                    Flight.printList(flightSortable.arrivalBeforeDepartureExclude(flights));
                }
                if (input==3) {
                    System.out.println("\n Из общего списка исключены перелёты с проведённым на земле временем свыше двух часов: \n");
                    Flight.printList(flightSortable.TimeMoreThanTwoHoursExclude(flights));
                } if (input==4) {
                    System.out.println("\n Завершение программы.");
                    in.close();
                    return;
                }
            }
        }
    }
