package iss.workshop.myapplication.model;

import android.hardware.usb.UsbRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Request {

    public int RequestID;
    public int  RequestStatus;
    public LocalDateTime RequestDate;
    public int RequestBy;
    public int ModifiedBy;
    public String Comment;
    public int RequestType;
    public int ParentRequestID;
    public LocalDateTime CollectionTime;
    public int RetrievalID;

    public User ModifiedByUser;
    public User RequestByUser;
    public List<RequestDetails> RequestDetails;
    public Retrieval Retrieval;

    public  Request(){}
    public  Request(JSONObject jsonObject)
    {
        ConvertModelObject(jsonObject);
    }

    public static Request ConvertModelObject(JSONObject jsonObject)
    {
        Request b = new Request();
        try {
            b.RequestID = jsonObject.getInt("requestID");
            b.RequestStatus = jsonObject.getInt("requestStatus");
            b.RequestBy = jsonObject.getInt("requestBy");
            b.ModifiedBy = jsonObject.getInt("modifiedBy");
            b.RequestType = jsonObject.getInt("requestType");
           // b.ParentRequestID = jsonObject.getInt("parentRequestID");
           // b.RetrievalID = jsonObject.getInt("retrievalID");
          //  b.Comment = jsonObject.getString("Comment");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
          //  b.RequestDate = LocalDateTime.parse(jsonObject.getString("requestDate"), formatter);
          //  b.CollectionTime= LocalDateTime.parse(jsonObject.getString("collectionTime"), formatter);
            b.ModifiedByUser= new User();
            b.RequestByUser=new User();
            b.RequestDetails=new ArrayList<RequestDetails>();
            b.Retrieval=new Retrieval();

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return b;
    }


    public int getRequestID() {return RequestID; }

    public void setRequestID(int requestID) { RequestID = requestID;  }

    public void setRequestStatus(int requestStatus) { RequestStatus = requestStatus; }

    public LocalDateTime getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        RequestDate = requestDate;
    }

    public int getRequestBy() {
        return RequestBy;
    }

    public void setRequestBy(int requestBy) {
        RequestBy = requestBy;
    }

    public int getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getRequestType() {   return RequestType;  }

    public void setRequestType(int requestType) {RequestType = requestType; }

    public int getParentRequestID() {
        return ParentRequestID;
    }

    public void setParentRequestID(int parentRequestID) {
        ParentRequestID = parentRequestID;
    }

    public LocalDateTime getCollectionTime() {
        return CollectionTime;
    }

    public void setCollectionTime(LocalDateTime collectionTime) {
        CollectionTime = collectionTime;
    }

    public int getRetrievalID() {
        return RetrievalID;
    }

    public void setRetrievalID(int retrievalID) {
        RetrievalID = retrievalID;
    }


}
