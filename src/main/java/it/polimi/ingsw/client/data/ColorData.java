package it.polimi.ingsw.client.data;

import it.polimi.ingsw.client.PrintAssistant;

public enum ColorData {
    GRAY,
    PURPLE,
    RED,
    BLUE,
    YELLOW,
    WHITE;

    public String toColor(){
        String s="";
        switch(this){
            case GRAY:
                s= PrintAssistant.ANSI_CYAN_BACKGROUND;
                break;
            case YELLOW:
                s=PrintAssistant.ANSI_YELLOW_BACKGROUND;
                break;
            case BLUE:
                s=PrintAssistant.ANSI_BLUE_BACKGROUND;
                break;
            case RED:
                s=PrintAssistant.ANSI_RED_BACKGROUND;
                break;
            case PURPLE:
                s=s=PrintAssistant.ANSI_PURPLE_BACKGROUND;
                break;
            case WHITE:
                s=PrintAssistant.ANSI_WHITE_BACKGROUND;
                break;
        }
        return s;
    }


}