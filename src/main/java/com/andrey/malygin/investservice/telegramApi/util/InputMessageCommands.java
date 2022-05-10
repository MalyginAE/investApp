package com.andrey.malygin.investservice.telegramApi.util;

public enum InputMessageCommands {//TODO доделать
    START("/start"), DESCRIPTION("/descriptionBot"), PURCHASE("/purchase"), MESSSAGETOANDREY("/messageToAndrey"), CURRENTBALANCE("/currentBalance");
    final String command;

    InputMessageCommands(String command) {
        this.command = command;
    }


    public String getCommand() {
        return command;
    }
}
