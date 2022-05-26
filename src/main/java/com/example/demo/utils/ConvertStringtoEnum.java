package com.example.demo.utils;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.SecondOrderEvents;
import lombok.experimental.UtilityClass;

import static com.example.demo.enums.OrderEvents.*;

@UtilityClass
public class ConvertStringtoEnum {

    public static OrderEvents orderEvents (String value){

        switch (value) {
            case "CONFIRMED_PAYMENT":
                return CONFIRMED_PAYMENT;
            case "INVOICE_ISSUED":
                return INVOICE_ISSUED;
            case "CANCEL":
                return CANCEL;
            case "SHIP":
                return SHIP;
            case "DELIVER":
                return DELIVER;
            default:
                return null;
        }
    }

    public static SecondOrderEvents SecondOrderEvents (String value){

        switch (value) {
            case "CONFIRMED_PAYMENT":
                return SecondOrderEvents.CONFIRMED_PAYMENT;
            case "INVOICE_ISSUED":
                return SecondOrderEvents.INVOICE_ISSUED;
            case "CANCEL":
                return SecondOrderEvents.CANCEL;
            case "SHIP":
                return SecondOrderEvents.SHIP;
            case "DELIVER":
                return SecondOrderEvents.DELIVER;
            default:
                return null;
        }
    }
}
