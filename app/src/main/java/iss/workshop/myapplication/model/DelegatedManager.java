package iss.workshop.myapplication.model;

import java.time.LocalDateTime;

public class DelegatedManager {
    public int DelegatedManagerID;
    public LocalDateTime FromDate;
    public LocalDateTime ToDate;
    public int UserID;

    public LocalDateTime getFromDate() {
        return FromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        FromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return ToDate;
    }

    public void setToDate(LocalDateTime toDate) {
        ToDate = toDate;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }
}
