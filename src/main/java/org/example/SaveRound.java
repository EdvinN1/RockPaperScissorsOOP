package org.example;

public class SaveRound {
    private String userName;
    private String opponentName;
    private String userChoice;
    private String opponentChoice;
    private String roundResult;
    private String endResult;


    public SaveRound(String userName, String opponentName, String userChoice, String opponentChoice, String roundResult, String endResult) {
        this.userName = userName;
        this.opponentName = opponentName;
        this.userChoice = userChoice;
        this.opponentChoice = opponentChoice;
        this.roundResult = roundResult;
        this.endResult = endResult;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void setOpponentChoice(String opponentChoice) {
        this.opponentChoice = opponentChoice;
    }

    public void setRoundResult(String roundResult) {
        this.roundResult = roundResult;
    }

    public void setEndResult(String endResult) {
        this.endResult = endResult;
    }

    @Override
    public String toString() {
        return "SaveRound{" +
                "userName='" + userName + '\'' +
                ", opponentName='" + opponentName + '\'' +
                ", userChoice='" + userChoice + '\'' +
                ", opponentChoice='" + opponentChoice + '\'' +
                ", roundResult='" + roundResult + '\'' +
                ", endResult='" + endResult + '\'' +
                '}';
    }
}
