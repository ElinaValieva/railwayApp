package com.elina.railwayApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXIST(1, "User already was registered. Try another e-mail or sign in."),
    TICKET_ALREADY_BOOKED(2, "You book ticket on this yet."),
    TRAIN_WAS_ARRIVED(3, "Train was arrived or will arrive after 10 minutes."),
    NULL_ELEMENTS(4, "Wrong parameters, not found."),
    WRONG_PARAMETERS_FOR_SCHEDULE(5, "Wrong parameters for schedule. Try to check date or stations."),
    PARSE_EXCEPTION(6, "Wrong date, can't parse."),
    IO_EXCEPTION(7, "File not found."),
    MAIL_EXCEPTION(8, "Wrong e-mail. Can't send letter on e-mail box.");

    private int code;
    private String reason;

    public String getMessage() {
        return String.format("[CODE]:[" + code + "], [MESSAGE]: " + reason);
    }
}