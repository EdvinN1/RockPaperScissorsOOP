package org.example;

public class SaveRound {
    private String userName;
    private String opponentName;
    private String userChoice;
    private String opponentChoice;
    private String roundResult;

    public SaveRound(String userName, String opponentName, String userChoice, String opponentChoice, String roundResult) {
        this.userName = userName;
        this.opponentName = opponentName;
        this.userChoice = userChoice;
        this.opponentChoice = opponentChoice;
        this.roundResult = roundResult;
    }

    @Override
    public String toString() {
        return "SaveRound{" +
                "userName='" + userName + '\'' +
                ", opponentName='" + opponentName + '\'' +
                ", userChoice='" + userChoice + '\'' +
                ", opponentChoice='" + opponentChoice + '\'' +
                ", roundResult='" + roundResult + '\'' +
                '}';
    }
}
